/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.NivSeg;
import dao.NivSegDao;
import dao.impl.NivSegDaoImpl;
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

public class NivSegControl {

    private NivSeg nivseg;
    private short idNivSeg;

    public NivSegControl() {
        this.idNivSeg = 0;
        this.nivseg = new NivSeg();
    }

    public NivSeg getNivseg() {
        return nivseg;
    }

    public void setNivseg(NivSeg nivseg) {
        this.nivseg = nivseg;
    }

    public short getIdNivSeg() {
        return idNivSeg;
    }

    public void setIdNivSeg(short idNivSeg) {
        this.idNivSeg = idNivSeg;
    }

    //Personalizados...
    public void ingresarNivSeg() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSegDao nsegDao = new NivSegDaoImpl();
            boolean ingresado = nsegDao.insert(nivseg);
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarNivSeg() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSegDao nivsegDao = new NivSegDaoImpl();
            NivSeg nseg = nivsegDao.getById(getIdNivSeg());
            nseg.setDescNivSeg(getNivseg().getDescNivSeg());
            boolean modificar = nivsegDao.update(nseg);
            if (modificar) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarNivSeg() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSegDao nsegDao = new NivSegDaoImpl();
            boolean eliminado = nsegDao.deleteById(this.idNivSeg);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel eliminado exitosamente"));

            } else if (this.idNivSeg == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Nivel"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR!", "Nivel de Seguridad en Uso"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public void cambioNivSeg() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSegDao nvsegDao = new NivSegDaoImpl();
            this.nivseg = nvsegDao.getById(this.idNivSeg);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }
    

    public List<SelectItem> mostrarNivSeg() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            NivSegDao nsegDao = new NivSegDaoImpl();
            ArrayList<SelectItem> niveles = new ArrayList<>();
            for (NivSeg nivseg : nsegDao.getAll()) {
                niveles.add(new SelectItem(nivseg.getIdNivSeg(), nivseg.getDescNivSeg()));
            }
            if (niveles.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Niveles en el sistema"));

            } else {
                return niveles;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void LimpiarIngresar() {
        nivseg.setDescNivSeg(null);
        nivseg.setIdNivSeg((short)0);
        setIdNivSeg((short)0);

    }

}
