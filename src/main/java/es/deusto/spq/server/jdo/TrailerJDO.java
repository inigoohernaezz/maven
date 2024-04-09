package es.deusto.spq.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import es.deusto.spq.pojo.*;

@PersistenceCapable
public class TrailerJDO {
    @PrimaryKey
	String matricula = null;
	String marca = null;
    String modelo = null;
    Tipo tipo = null;
    int cargaMaxima = 0;
    CamionJDO camionJDO = null;

	
    public TrailerJDO(String matricula, String marca, String modelo, int cargaMaxima, Tipo tipo) { //, Tipo tipo
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cargaMaxima = cargaMaxima;
        this.tipo = tipo;
    }
	

	//Getters y Setters

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

    public int getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public void setTipo(Tipo tipo) {
       this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
   }

    public String toString() {
        return "Trailer{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cargaMaxima=" + cargaMaxima +
                ", tipo=" + tipo +
                '}';
    }
}