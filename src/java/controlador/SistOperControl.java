/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.SistOper;
import dao.SistOperDao;
import dao.impl.SistOperDaoImpl;
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
public class SistOperControl {
    
    private short idSo;
    private SistOper sistoper;

    public SistOperControl() {
        this.idSo = 0;
        this.sistoper = new SistOper();
    }

    public short getIdSo() {
        return idSo;
    }

    public void setIdSo(short idSo) {
        this.idSo = idSo;
    }

    public SistOper getSistoper() {
        return sistoper;
    }

    public void setSistoper(SistOper sistoper) {
        this.sistoper = sistoper;
    }
    
    //Personalizados...
    
    public void ingresarSistOper() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistOperDao isoDao = new SistOperDaoImpl();
            boolean ingresado = isoDao.insert(sistoper);
            if (ingresado) {
                LimpiarIngresarSistOper();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema Operativo ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema Operativo no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarSistOper() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistOperDao msoDao = new SistOperDaoImpl();
            SistOper mso = msoDao.getById(getIdSo());
            mso.setDesSo(getSistoper().getDesSo());
            boolean modificar = msoDao.update(mso);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema Operativo modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema Operativo no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarSistOper() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistOperDao esoDao = new SistOperDaoImpl();
            boolean eliminado = esoDao.deleteById(this.idSo);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema Operativo eliminado exitosamente"));

            } else if (this.idSo == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema Operativo"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema Operativo no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarSistOper() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistOperDao lsoDao = new SistOperDaoImpl();
            ArrayList<SelectItem> sistoperativos = new ArrayList<>();
            for (SistOper sistoper : lsoDao.getAll()) {
                sistoperativos.add(new SelectItem(sistoper.getIdSo(), sistoper.getDesSo()));
            }
            if (sistoperativos.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Sistema Operativo Ingresados en el sistema"));

            } else {
                return sistoperativos;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioSistOper() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistOperDao csoDao = new SistOperDaoImpl();
            this.sistoper = csoDao.getById(this.idSo);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    
    public void LimpiarIngresarSistOper(){
        sistoper.setDesSo(null);
    }
    
    
    
}
