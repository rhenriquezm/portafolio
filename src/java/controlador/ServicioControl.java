/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.Servicio;
import POJO.Sistema;
import dao.ServicioDao;
import dao.SistemaDao;
import dao.impl.ServicioDaoImpl;
import dao.impl.SistemaDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class ServicioControl {

    private short idServicio;
    private Servicio servicio;

    public ServicioControl() {
        this.idServicio = 0;
        this.servicio = new Servicio();
    }

    public short getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(short idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    //Personalizados...
    public void ingresarServicio() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServicioDao iservDao = new ServicioDaoImpl();
            boolean ingresado = iservDao.insert(servicio);
            if (ingresado) {
                LimpiarIngresarServicio();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servicio ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servicio no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }

    }

    public void modificarServicio() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServicioDao sDao = new ServicioDaoImpl();
            Servicio mserv = sDao.getById(idServicio);
            mserv.setNomServicio(servicio.getNomServicio());
            boolean modificar = sDao.update(mserv);
            if (modificar) {
                LimpiarIngresarServicio();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servicio modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servicio no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarServicio() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServicioDao eservDao = new ServicioDaoImpl();
            boolean eliminado = eservDao.deleteById(this.idServicio);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servicio eliminado exitosamente"));

            } else if (this.idServicio == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Servicio"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR!", "Servicio en Uso"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarServicio() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServicioDao lservDao = new ServicioDaoImpl();
            ArrayList<SelectItem> servicios = new ArrayList<>();
            for (Servicio servicio : lservDao.getAll()) {
                servicios.add(new SelectItem(servicio.getIdServicio(), servicio.getNomServicio()));
            }
            if (servicios.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Servicio Ingresados en el sistema"));

            } else {
                return servicios;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioServicio() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServicioDao sDao = new ServicioDaoImpl();
            this.servicio = sDao.getById(this.idServicio);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresarServicio() {
        servicio.setNomServicio(null);
        servicio.setIdServicio((short)0);
        setIdServicio((short)0);
    }

}
