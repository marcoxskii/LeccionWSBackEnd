package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    private String cedula;
    private double consumo;
    private double deuda;

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public double getConsumo() {
        return consumo;
    }
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
    public double getDeuda() {
        return deuda;
    }
    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

 
}
