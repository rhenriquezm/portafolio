package controlador;

import POJO.Usuario;
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class SesionControl {

    private String nombreUsuario;
    private String passUsuario;
    private Usuario us;

    
    private FacesContext faceContext;
    private HttpSession httpSession;
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void inciarSesion() {
        try {

            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            Usuario usuario = usuarioDao.getByUserPass(getNombreUsuario(), getPassUsuario());

            if (usuario != null) {

                httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", usuario);

                usuario.getPerfil().setNomPerfil(usuario.getPerfil().getNomPerfil().toLowerCase());
                setUs(usuario);

                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "Bienvenido"));
            
                
                FacesContext faceContext = FacesContext.getCurrentInstance();
                NavigationHandler nh = faceContext.getApplication().getNavigationHandler();
                nh.handleNavigation(faceContext, null, "iniciarSesion");
                
            } else {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario o Password incorrecto"));
            
            }

        } catch (Exception e) {
            
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL!", e.getMessage()));
            
        }

    }
    
    public void cerrarSesion() {
        httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        faceContext = FacesContext.getCurrentInstance();
        NavigationHandler nh = faceContext.getApplication().getNavigationHandler();
        nh.handleNavigation(faceContext, null, "cerrarSesion");

    }

}
