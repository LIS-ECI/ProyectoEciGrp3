/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.Solicitud;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2106088
 */
public class ServiciosDao extends Servicios {

    private SqlSession currentSession=null;
    Properties properties;
    DaoFactory daof;

    public ServiciosDao() {
        
        try {
            properties=new PropertiesLoader().readProperties("applicationconfig.properties");
        } catch (IOException ex) {
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        daof=DaoFactory.getInstance(properties);
        try{
            daof.beginSession();
        }
        catch(PersistenceException ex){
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Solicitud> consultarSolicitud() {
        //Hay que implementear
        return null;
    }

    @Override
    public void enviarSolicitudEstudiante(Estudiante est, Solicitud sol) throws ExcepcionServicios{

        try {
            daof.getDaoEstudiante().enviarSolicitudEstudiante(est, sol);
        } catch (PersistenceException ex) {
            
            Logger.getLogger(ServiciosDao.class.getName()).log(Level.SEVERE, null, ex);
            
        }

    }

}

class PropertiesLoader {

    public Properties readProperties(String fileName) throws IOException {
        InputStream input = null;
        Properties properties = new Properties();
        input = this.getClass().getClassLoader().getResourceAsStream(fileName);
        properties.load(input);
        return properties;
    }
}
