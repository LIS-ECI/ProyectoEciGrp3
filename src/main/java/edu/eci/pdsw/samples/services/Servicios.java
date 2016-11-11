/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Egresado;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import java.util.List;
import java.util.Set;



/**
 *
 * @author 2107641
 */
public abstract class Servicios {
    
    private static Servicios instance=new ServiciosDao();
    
    
    protected Servicios(){        

    }
    
    public static Servicios getInstance() throws RuntimeException{            
        return instance;
    }

    public abstract Estudiante consultarEstudiante(long identificacion,String tipo_identificacion);
    
    public abstract Egresado consultarEgresado(long identificacion,String tipo_identificacion);
   
    public abstract List<Solicitud> consultarSolicitud();
    
    
    public abstract void enviarSolicitudEstudiante(Estudiante est,Solicitud sol) throws ExcepcionServicios;
    
    public abstract void enviarSolicitudEgresado(Egresado egr,Solicitud sol) throws ExcepcionServicios;
    

}
