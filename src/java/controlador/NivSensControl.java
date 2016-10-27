/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.NivSens;
import dao.NivSensDao;
import dao.impl.NivSensDaoImpl;
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
public class NivSensControl {

    private NivSens nivsens;
    private short idNivSens;

    public NivSensControl() {
        this.nivsens = new NivSens();
        this.idNivSens = 0;
    }

    public NivSens getNivsens() {
        return nivsens;
    }

    public void setNivsens(NivSens nivsens) {
        this.nivsens = nivsens;
    }

    public short getIdNivSens() {
        return idNivSens;
    }

    public void setIdNivSens(short idNivSens) {
        this.idNivSens = idNivSens;
    }
    
    public void ingresarNivSens() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSensDao nssDao = new NivSensDaoImpl();
            boolean ingresado = nssDao.insert(nivsens);
            if (ingresado) {
                LimpiarIngresarNivSens();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarNivSens() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSensDao nivseDao = new NivSensDaoImpl();
            NivSens ns = nivseDao.getById(getIdNivSens());
            ns.setDescNivSens(getNivsens().getDescNivSens());
            boolean modificar = nivseDao.update(ns);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarNivSens() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSensDao nivsenDao = new NivSensDaoImpl();
            boolean eliminado = nivsenDao.deleteById(this.idNivSens);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel eliminado exitosamente"));

            } else if (this.idNivSens == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Nivel"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarNivSens() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSensDao nssDao = new NivSensDaoImpl();
            ArrayList<SelectItem> nivelesen = new ArrayList<>();
            for (NivSens nivsens : nssDao.getAll()) {
                nivelesen.add(new SelectItem(nivsens.getIdNivSens(), nivsens.getDescNivSens()));
            }
            if (nivelesen.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Nivel en el sistema"));

            } else {
                return nivelesen;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioNivSens() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSensDao nsDao = new NivSensDaoImpl();
            this.nivsens = nsDao.getById(this.idNivSens);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    
    public void LimpiarIngresarNivSens(){
        nivsens.setDescNivSens(null);
    }
    
}
