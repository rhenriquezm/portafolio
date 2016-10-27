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
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean
public class SesionControl {

    private String nomUsuario;
    private String passUsuario;
    private Usuario usuario;

    private FacesContext faceContext;
    private HttpSession httpSession;
    private RequestContext requestContext;

    public SesionControl() {
        HttpSession miSesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSesion.setMaxInactiveInterval(1200);
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            Usuario usua = usuarioDao.getByUserPass(getNomUsuario(), getPassUsuario());
            if (usua != null) {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", usua);
                usua.getPerfil().setNomPerfil(usua.getPerfil().getNomPerfil().toLowerCase());
                setUsuario(usua);

                faceContext = FacesContext.getCurrentInstance();
                NavigationHandler nh = faceContext.getApplication().getNavigationHandler();
                nh.handleNavigation(faceContext, null, "iniciarSesion");
                
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "Usuario o Password incorrecto!"));
                return "reintentar";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "ERROR";

    }

    public String cerrarSesion() {
        httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        return "cerrarSesion";

    }
}
