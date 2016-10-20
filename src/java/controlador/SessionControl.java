package controlador;

import POJO.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import javax.faces.application.FacesMessage;
//import javax.faces.application.NavigationHandler;
import javax.faces.bean.SessionScoped;
//import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class SessionControl {

    private String nombreUsuario;
    private String password;
    private String perfil = "ADMIN";
    //Atributos de la vista index.xhtml

//    private HttpSession httpSession;
//    private RequestContext requestContext;
//    public SessionControl() {
//        HttpSession miSesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        miSesion.setMaxInactiveInterval(1200);
//    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void iniciarSesion() {
        //String response = " ";
        //String perfil = "";
        //setPassword(Encrypt.sha512(getPassword()));
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            if (getPerfil().equals("ADMIN")) {
                UsuarioDao usuarioDao = new UsuarioDaoImpl();
                Usuario usuario = usuarioDao.getByUserPass(getNombreUsuario(), getPassword());
                if (usuario != null) {
                    System.out.println("AAAAAAAAAAAAAAAA");
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario existe"));

                } else {
                    System.out.println("BBBBBBBBBBBBBBBB");
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no existe"));
                }
            }
        } catch (Exception e) {
        }

    }
//    public void cerrarSesion() {
//        httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        httpSession.invalidate();
//        context = FacesContext.getCurrentInstance();
//        NavigationHandler nh = context.getApplication().getNavigationHandler();
//        nh.handleNavigation(context, null, "logout");
//
//    }
}
