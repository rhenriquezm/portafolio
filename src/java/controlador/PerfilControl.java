package controlador;

import POJO.Perfil;
import dao.PerfilDao;
import dao.impl.PerfilDaoImpl;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ViewScoped
@ManagedBean
public class PerfilControl {

    private Perfil perfil;
    private short idPerfil;

    public PerfilControl() {
        this.perfil = new Perfil();
        this.idPerfil = 0;
    }


    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public short getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(short idPerfil) {
        this.idPerfil = idPerfil;
    }

    // Metodos Personalizados
    public void ingresarPerfil() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            PerfilDao perfilDao = new PerfilDaoImpl();
            boolean ingresado = perfilDao.insert(perfil);
            if (ingresado) {
                //limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Perfil ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Perfil no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));
        }
    }     

    public void eliminarPerfil() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            PerfilDao perfilDao = new PerfilDaoImpl();
            boolean eliminado = perfilDao.deleteById(this.idPerfil);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Perfil eliminado exitosamente"));
            } else if (this.idPerfil == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un perfil"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Perfil no ha podido ser eliminado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));
        }
    }

    public ArrayList<SelectItem> mostrarPerfiles() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            PerfilDao perfilDao = new PerfilDaoImpl();
            ArrayList<SelectItem> perfiles = new ArrayList<>();
            for (Perfil perfil : perfilDao.getAll()) {
                perfiles.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
            }
            if (perfiles.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen perfiles en el sistema"));
            } else {
                return perfiles;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioPerfil() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            PerfilDao perDao = new PerfilDaoImpl();
            this.perfil = perDao.getById(this.idPerfil);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }

    }

    public void modificarPerfil() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            PerfilDao perDao = new PerfilDaoImpl();
            Perfil per = perDao.getById(idPerfil);
            per.setNomPerfil(perfil.getNomPerfil());
            per.setDescPerfil(perfil.getDescPerfil());
            boolean modificar = perDao.update(per);
            if (modificar) {
                //limpiarLista();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Perfil modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Perfil no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));
        }
    }
    
    //Limpiar formulario INGRESAR
    public void limpiarIngresar() {
        perfil.setNomPerfil(null);
        perfil.setDescPerfil(null);
    }
}
