/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.SoftBd;
import dao.SoftBdDao;
import dao.impl.SoftBdDaoImpl;
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
public class SoftBdControl {
    
	private SoftBd softbd;
	private short idSoftBd;   

    public SoftBdControl() {
        this.softbd = new SoftBd();
        this.idSoftBd = 0;
    }

    public SoftBd getSoftbd() {
        return softbd;
    }

    public void setSoftbd(SoftBd softbd) {
        this.softbd = softbd;
    }

    public short getIdSoftBd() {
        return idSoftBd;
    }

    public void setIdSoftBd(short idSoftBd) {
        this.idSoftBd = idSoftBd;
    }
        
    //Personalizados...
     
     public void ingresarSoftBd() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SoftBdDao sofDao = new SoftBdDaoImpl();
            boolean ingresado = sofDao.insert(softbd);
            if (ingresado) {
                LimpiarIngresarSoftBd();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Software ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Software no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarSoftBd() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SoftBdDao msofDao = new SoftBdDaoImpl();
            SoftBd msof = msofDao.getById(getIdSoftBd());
            msof.setNomSoftBd(getSoftbd().getNomSoftBd());
            msof.setEmpSoftBd(getSoftbd().getEmpSoftBd());
            msof.setVerSoftBd(getSoftbd().getVerSoftBd());
            boolean modificar = msofDao.update(msof);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Software modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Software no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarSoftBd() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SoftBdDao esofDao = new SoftBdDaoImpl();
            boolean eliminado = esofDao.deleteById(this.idSoftBd);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Software eliminado exitosamente"));

            } else if (this.idSoftBd == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Software"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Software no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarSoftBd() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SoftBdDao lsofDao = new SoftBdDaoImpl();
            ArrayList<SelectItem> softwares = new ArrayList<>();
            for (SoftBd softbd : lsofDao.getAll()) {
                softwares.add(new SelectItem(softbd.getIdSoftBd(), softbd.getNomSoftBd()));
            }
            if (softwares.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Software Ingresados en el sistema"));

            } else {
                return softwares;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioSoftBd() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SoftBdDao csofDao = new SoftBdDaoImpl();
            this.softbd = csofDao.getById(this.idSoftBd);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    
    public void LimpiarIngresarSoftBd(){
        softbd.setNomSoftBd(null);
        softbd.setEmpSoftBd(null);
        softbd.setVerSoftBd(null);
    }
    
}   

