/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
/**
 *
 * @author 2107641
 */
public class PrincipalBean {

    private String usuario;
    private String clave;
    private List<String> images;
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    @PostConstruct
    public void Cargar(){
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("imagen"+ i +".jpg");
        }
    }
    
    public List<String> getIMages(){
        return images;
        
    }

}
