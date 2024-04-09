package es.deusto.spq.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ViajeJDO {

    @PrimaryKey
    int id = 0;
    String origen = null;
    String destino = null;
    int distancia = 0;
    int tiempoEstimado = 0;
    
    @Persistent(mappedBy="viajeJDO", dependentElement="true")
    ConductorJDO conductor = new ConductorJDO(null, null, null, null);

    public ViajeJDO(int id, String origen, String destino, int distancia, int tiempoEstimado, ConductorJDO conductor) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
        this.conductor = conductor;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public ConductorJDO getConductor() {
        return conductor;
    }

    public void setConductor(ConductorJDO conductor) {
        this.conductor = conductor;
    }

    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", distancia=" + distancia +
                ", tiempoEstimado=" + tiempoEstimado +
                ", conductor=" + conductor +
                '}';
    }
    
}