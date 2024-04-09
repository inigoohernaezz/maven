package es.deusto.spq.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class CamionJDO {

    @PrimaryKey
    String matricula = null;
    ConductorJDO conductorJDO = null;
    String marca = null;
    String modelo = null;
    int potencia = 0;
    int autonomia = 0;
    int cargaMaxima = 0;

    @Persistent(mappedBy="camionJDO", dependentElement="true")
    TrailerJDO trailer = new TrailerJDO(null, null, null, 0, null); //, null

    // Constructor
    public CamionJDO(String matricula, String marca, String modelo, int potencia, int autonomia, int cargaMaxima, TrailerJDO trailer) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.autonomia = autonomia;
        this.cargaMaxima = cargaMaxima;
        this.trailer = trailer;
    }

    // Getters y setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public TrailerJDO getTrailer() {
        return trailer;
    }

    public void setTrailer(TrailerJDO trailer) {
        this.trailer = trailer;
    }
}