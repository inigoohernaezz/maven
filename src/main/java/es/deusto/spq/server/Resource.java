package es.deusto.spq.server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;


import es.deusto.spq.pojo.Conductor;
import es.deusto.spq.server.jdo.ConductorJDO;
import es.deusto.spq.pojo.Camion;
import es.deusto.spq.server.jdo.CamionJDO;
import es.deusto.spq.pojo.Trailer;
import es.deusto.spq.server.jdo.TrailerJDO;



import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private int cont = 0;
	private PersistenceManager pm=null;
	private Transaction tx=null;

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}


	@POST
@Path("/registerCamion")
public Response registrarCamion(Camion camion_nuevo) {
    try {   
        tx.begin();
        logger.info("Comprobando si ya está creado ese camión: '{}'", camion_nuevo.getMatricula());
        CamionJDO camion = null;
        try {
            camion = pm.getObjectById(CamionJDO.class, camion_nuevo.getMatricula());
        } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
            logger.info("Exception launched: {}", jonfe.getMessage());
        }
        
        if (camion != null) {
            logger.info("El camión ya está creado: {}", camion);
        } else {
            logger.info("Creando camión: {}", camion_nuevo);
            // Crear una instancia de TrailerJDO para asociar al camión
            TrailerJDO trailerJDO = new TrailerJDO(camion_nuevo.getTrailer().getMatricula(), 
													camion_nuevo.getTrailer().getMarca(),
													camion_nuevo.getTrailer().getModelo(),
													camion_nuevo.getTrailer().getCargaMaxima(),
													camion_nuevo.getTrailer().getTipo());
            
											// Crear una instancia de CamionJDO para persistir en la base de datos
            camion = new CamionJDO(camion_nuevo.getMatricula(), 
                                   camion_nuevo.getMarca(),
                                   camion_nuevo.getModelo(),
                                   camion_nuevo.getPotencia(),
                                   camion_nuevo.getAutonomia(),
                                   camion_nuevo.getCargaMaxima(),
                                   trailerJDO);
            pm.makePersistent(camion);                     
            logger.info("Camión creado: {}", camion);
        }
        tx.commit();
        return Response.ok().build();
    } catch (Exception e) {
        if (tx.isActive()) {
            tx.rollback();
        }
        logger.error("Error al registrar el camión: {}", e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity("Error al registrar el camión")
                       .build();
    }
}


	@POST
@Path("/registerConductor")
public Response registrarConductor(Conductor conductor_nuevo) {
    try {   
        tx.begin();
        logger.info("Comprobando si ya existe el conductor: '{}'", conductor_nuevo.getDni());
        ConductorJDO conductor = null;
        try {
            conductor = pm.getObjectById(ConductorJDO.class, conductor_nuevo.getDni());
        } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
            logger.info("Exception launched: {}", jonfe.getMessage());
        }
        logger.info("User: {}", conductor);
        if (conductor != null) {
            logger.info("Conductor ya creado: {}", conductor);
        } else {
            logger.info("Creando Conductor: {}", conductor_nuevo);
            // Crear una instancia de ConductorJDO para persistir en la base de datos
            CamionJDO camionJDO = new CamionJDO(conductor_nuevo.getCamion().getMatricula(), 
                                                conductor_nuevo.getCamion().getMarca(),
                                                conductor_nuevo.getCamion().getModelo(),
                                                conductor_nuevo.getCamion().getPotencia(),
                                                conductor_nuevo.getCamion().getAutonomia(),
                                                conductor_nuevo.getCamion().getCargaMaxima(), 
												null); // Deberías establecer el trailer correctamente
            conductor = new ConductorJDO(conductor_nuevo.getNombre(), conductor_nuevo.getDni(), 
                                         conductor_nuevo.getEmail(), camionJDO);
            pm.makePersistent(conductor);                     
            logger.info("Conductor creado: {}", conductor);
        }
        tx.commit();
        return Response.ok().build();
    } catch (Exception e) {
        if (tx.isActive()) {
            tx.rollback();
        }
        logger.error("Error al registrar el conductor: {}", e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity("Error al registrar el conductor")
                       .build();
    }
}


}






