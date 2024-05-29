/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author User
 */
public class Factura {
    
    private int idFact;
    private int idUsua;
    private String  fecha;
    private int totalPagar;

    public int getIdFact() {
        return idFact;
    }

    public void setIdFact(int idFact) {
        this.idFact = idFact;
    }

    public int getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(int idUsua) {
        this.idUsua = idUsua;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Factura{" + "idFact=" + idFact + ", idUsua=" + idUsua + ", fecha=" + fecha + ", totalPagar=" + totalPagar + '}';
    }
    
    
    
}
