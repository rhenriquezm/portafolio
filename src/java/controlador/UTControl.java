//Rodrigo Ignacio Henriquez Moreno
package controlador;

import POJO.UnidadTrabajo;
import dao.UnidadTrabajoDao;
import dao.impl.UnidadTrabajoDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ViewScoped
@ManagedBean
public class UTControl {

    //Atributos
    private short id;
    private UnidadTrabajo ut;

    //Constructor sin parametros
    public UTControl() {
        this.ut = new UnidadTrabajo();
        this.id = 0;
    }
    
    //Getters and Setters
    
    public UnidadTrabajo getUt() {
        return ut;
    }

    public void setUt(UnidadTrabajo ut) {
        this.ut = ut;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    //Metodos Personalizados
    
    public ArrayList<UnidadTrabajo> todo(){
        try {
            
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            ArrayList<UnidadTrabajo> todos = utDao.getAll();
            if(!todos.isEmpty()){
                return todos;
            }else{
                return null;
            }
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar" + ex.getMessage()));
        }
        return null;
    }
    
    
    public void ingresarUTrabajo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            boolean ingresado = utDao.insert(this.ut);
            if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "UT ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "UT no ha sido ingresada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar" + ex.getMessage()));
        }

    }

    public List<SelectItem> mostrarUTs() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            ArrayList<SelectItem> listaUT = new ArrayList<>();
            for (UnidadTrabajo unidadTrabajo : utDao.getAll()) {
                listaUT.add(new SelectItem(unidadTrabajo.getIdUniTrab(), unidadTrabajo.getNomUniTrab()));
            }
            if (listaUT.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen UTs en el sistema"));
            } else {
                return listaUT;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar UTS" + ex.getMessage()));
        
        }
        return null;
    }

    public void eliminarUTrabajo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            boolean eliminado = utDao.deleteById(id);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "UT eliminada exitosamente"));
            } else if (this.id == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione UT "));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR!", " Unidad de Trabajo en Uso"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar" + ex.getMessage()));
        }
    }

    public void modificarUTrabajo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            UnidadTrabajo uTrab = utDao.getById(id);
            uTrab.setNomUniTrab(ut.getNomUniTrab());
            boolean modificado = utDao.update(uTrab);
            if (modificado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "UT modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "UT no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }

    }

    public void buscarUTrabajo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            ut = utDao.getById(id);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void limpiarIngresar() {
        ut.setNomUniTrab(null);
        ut.setIdUniTrab((short)0);
        setId((short)0);
    }

    public void cambioUT() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            this.ut = utDao.getById(this.id);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }
    
    
}
