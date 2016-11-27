/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.pdsw.samples.entities.Certificado;
import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.Servicios;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 3 Pdsw
 */
@ManagedBean(name = "beanIndex")

@SessionScoped
public class PrincipalBean implements Serializable {

    private String usuario;
    private String base="applicationconfig.properties";
    private String clave;
    private String validacion="";


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private int codigo=0;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
 *
 * Obtener la clave del usuario
 */
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValidacion() {
        try {
            validar();
        } catch (PersistenceException ex) {
            Logger.getLogger(PrincipalBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.validacion;
        
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
    
    public void validar() throws PersistenceException{
        
        validacion="";
        String nombre="";
        Certificado c=Servicios.getInstance(base).getCertificado(codigo);
        if (c==null){
            this.validacion="El Certificado No Es Válido";
        }
        else{
            Usuario u= Servicios.getInstance(base).getUsuario(c.getUsuario_nombre());
            if(u.getTipo().equals("Estudiante")){
                Estudiante est=Servicios.getInstance(base).consultarEstudiante(u.getCedula_numero(), u.getCedula_tipo());
                nombre= est.getNombre()+' '+est.getApellido();
            }
            else{
                Egresado egr=Servicios.getInstance(base).consultarEgresado(u.getCedula_numero(), u.getCedula_tipo());
                nombre= egr.getNombre()+' '+egr.getApellido();
            }
            Date fecha11 = new java.sql.Date(u.getFechaInicio().getTime());
                Date fecha22 = new java.sql.Date(u.getFechaFin().getTime());

            this.validacion="El Certificado Ingresado Pertenece a "+nombre+" identificado con "+u.getCedula_tipo()+" "+u.getCedula_numero()+" y cuya aficiacion va desde "+fecha11+" hasta "+fecha22;
            
        }
        
        
    }

}
