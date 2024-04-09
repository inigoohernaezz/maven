package es.deusto.spq.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ConductorJDO {
    @PrimaryKey
    String dni = null;
    String email = null;
    String nombre = null;
    ViajeJDO viajeJDO = null;

	@Persistent(mappedBy="conductorJDO", dependentElement="true")
    CamionJDO camion = new CamionJDO(null, null, null, 0, 0, 0, null);

    // Constructor
    public ConductorJDO(String nombre, String dni,String email, CamionJDO camion) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.camion = camion;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CamionJDO getCamion() {
        return camion;
    }

    public void setCamion(CamionJDO camion) {
        this.camion = camion;
    }

    public String toString() {
        return "Conductor{" +
                "dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", camion=" + camion +
                '}';
    }
}