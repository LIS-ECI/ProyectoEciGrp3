/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.Date;

/**
 *
 * @author 2106088
 */
public class Solicitud {

    private Date fecha;
    private long cedula;
    private String tipo_cedula;
    private String tipo;
    private String estado; 

    public Solicitud(Date fecha, long cedula, String tipo_cedula, String tipo,String estado) {
        this.fecha = fecha;
        this.cedula = cedula;
        this.tipo_cedula = tipo_cedula;
        this.tipo = tipo;
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cedula
     */
    public long getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the tipo_cedula
     */
    public String getTipo_cedula() {
        return tipo_cedula;
    }

    /**
     * @param tipo_cedula the tipo_cedula to set
     */
    public void setTipo_cedula(String tipo_cedula) {
        this.tipo_cedula = tipo_cedula;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
