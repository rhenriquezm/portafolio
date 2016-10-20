package controlador;

import POJO.Perfil;
import POJO.UnidadTrabajo;
import POJO.Usuario;
import dao.PerfilDao;
import dao.UnidadTrabajoDao;
import dao.UsuarioDao;
import dao.impl.PerfilDaoImpl;
import dao.impl.UnidadTrabajoDaoImpl;
import dao.impl.UsuarioDaoImpl;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ViewScoped
@ManagedBean
public class UsuarioControl {

    private Usuario usuario;
    private ArrayList<SelectItem> sexo;

    public UsuarioControl() {
        this.usuario = new Usuario();
        this.sexo = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        this.sexo.add(new SelectItem('M', "Masculino"));
        this.sexo.add(new SelectItem('F', "Femenino"));
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<SelectItem> getSexo() {
        return sexo;
    }

    public void setSexo(ArrayList<SelectItem> sexo) {
        this.sexo = sexo;
    }
    
    // Metodos personalizados
    public void ingresarUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            boolean ingresado = usuarioDao.insert(this.usuario);
            if (ingresado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no ha sido ingresado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar Usuario " + ex.getMessage()));
        }
    }

    public ArrayList<SelectItem> mostrarPerfiles() {

        try {
            PerfilDao perfilDao = new PerfilDaoImpl();
            ArrayList<SelectItem> perfiles = new ArrayList<>();
            for (Perfil perfil : perfilDao.getAll()) {
                perfiles.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
            }
            return perfiles;
        } catch (Exception ex) {

        }
        return null;

    }

    public ArrayList<SelectItem> mostrarUniTrabs() {
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            ArrayList<SelectItem> uniTrabs = new ArrayList<>();
            for (UnidadTrabajo unidadTrabajo : utDao.getAll()) {
                uniTrabs.add(new SelectItem(unidadTrabajo.getIdUniTrab(), unidadTrabajo.getNomUniTrab()));
            }
            return uniTrabs;
        } catch (Exception e) {
        }
        return null;
    }
}
