package controlador;

import POJO.Usuario;
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ViewScoped
@ManagedBean
public class SesionControl {

    private String nomUsuario;
    private String passUsuario;
    private Usuario usuario;

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
        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            Usuario usua = usuarioDao.getByUserPass(getNomUsuario(), getPassUsuario());
            
            if (usua != null) {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("usuario", usua);
                
                setUsuario(usua);

                return "/mantenedores/layout/dashboard";

//                        faceContext = FacesContext.getCurrentInstance();
//                        NavigationHandler nh = faceContext.getApplication().getNavigationHandler();
//                        nh.handleNavigation(faceContext, null, "dashboard");
            } else {
                return "/mantenedores/layout/dashboard";
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "login";

    }
}
