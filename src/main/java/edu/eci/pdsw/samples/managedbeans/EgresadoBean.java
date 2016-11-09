/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.services.ExcepcionServicios;
import edu.eci.pdsw.samples.services.Servicios;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2106088
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="beanEgresado")

@SessionScoped
public class EgresadoBean {
    private long cedula;
    private String tipo_identificacion;
    private String nombre;
    private int fecha_grado=2015;
    private int periodo_grado=1;
    private String cargo;
    private String carrera; 
    private String direccion_vivienda;
    private String nombreEmpresa;
    private String direccion_empresa;
    private int telefono_oficina;
    private int telefono_fijo;
    private long celular;
    private String email;
    //base de datos

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
    

   

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int  getFecha_grado() {
        return fecha_grado;
    }

    public void setFecha_grado(int fecha_grado) {
        this.fecha_grado = fecha_grado;
    }

    public int getPeriodo_grado() {
        return periodo_grado;
    }

    public void setPeriodo_grado(int periodo_grado) {
        this.periodo_grado = periodo_grado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDireccion_vivienda() {
        return direccion_vivienda;
    }

    public void setDireccion_vivienda(String direccion_vivienda) {
        this.direccion_vivienda = direccion_vivienda;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public int getTelefono_oficina() {
        return telefono_oficina;
    }

    public void setTelefono_oficina(int telefono_oficina) {
        this.telefono_oficina = telefono_oficina;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }
    
    public void enviarSolicitud (){
        Egresado egr = new Egresado(cedula, tipo_identificacion, nombre, fecha_grado, periodo_grado, cargo, carrera, direccion_vivienda, nombreEmpresa, direccion_empresa, telefono_oficina, telefono_fijo, celular, email);
        java.sql.Date fecha = new java.sql.Date(java.util.Calendar.getInstance().getTime().getTime());
        Solicitud sol = new Solicitud(fecha,egr.getCedula(), egr.getCedula_tipo(),"estudiante");
        try {
            Servicios.getInstance().enviarSolicitudEgresado(egr,sol);
        } catch (ExcepcionServicios ex) {
            Logger.getLogger(EstudianteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
