
import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class SessionControl{
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

    public void iniciarSesion(){
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        
    }
    
    
}