/**
 * Very simple bean that authenticates the user via Apache Shiro, using JSF
 * @author Daniel Mascarenhas
 */
package edu.eci.pdsw.sample.bean.security;

import java.io.File;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "loginBean")
@SessionScoped
public class ShiroLoginBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ShiroLoginBean.class);

    private String username="";
    private String password="";
    private Boolean rememberMe;

    public ShiroLoginBean() {
        
    }

    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    
    /**
     * Try and authenticate the user
     * 
     * comentario
     */
    public void doLogin() {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), getPassword(), getRememberMe());
        
        try {
            subject.login(token);

            if (subject.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("admin/solicitud.xhtml");
            }
            else if(subject.hasRole("Usuario")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("usuario/PrincipalUsuario.xhtml");
            }
            else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("usuario/PrincipalUsuario.xhtml");
            }
        }
        catch (UnknownAccountException ex) {
            facesError("Unknown account");
            log.error(ex.getMessage(), ex);
        }
        catch (IncorrectCredentialsException ex) {
            facesError("Wrong password");
            log.error(ex.getMessage(), ex);
        }
        catch (LockedAccountException ex) {
            facesError("Locked account");
            log.error(ex.getMessage(), ex);
        }
        catch (AuthenticationException ex) {
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
        catch (IOException ex){
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
            
        }
        finally {
            token.clear();
        }
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
    }
}
