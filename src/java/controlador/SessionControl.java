package controlador;

import POJO.Usuario;
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class SessionControl {

    private String nombreUsuario;
    private String passUsuario;

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

    public void iniciarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            Usuario usuario = usuarioDao.getByUserPass(getNombreUsuario(), getPassUsuario());
            if (usuario != null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario existente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no existente"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
