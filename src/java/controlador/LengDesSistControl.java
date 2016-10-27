/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.LengDesSist;
import dao.LengDesSistDao;
import dao.impl.LengDesSistDaoImpl;
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
public class LengDesSistControl {
    private LengDesSist lengdessist;
    private short idLengSist;

    public LengDesSistControl() {
        this.lengdessist = new LengDesSist();
        this.idLengSist = 0;
    }

    public LengDesSist getLengdessist() {
        return lengdessist;
    }

    public void setLengdessist(LengDesSist lengdessist) {
        this.lengdessist = lengdessist;
    }

    public short getIdLengSist() {
        return idLengSist;
    }

    public void setIdLengSist(short idLengSist) {
        this.idLengSist = idLengSist;
    }

    

    public void ingresarLengDes() {
    	 FacesContext context = FacesContext.getCurrentInstance();
        try {
            LengDesSistDao ldsDao = new LengDesSistDaoImpl();
            boolean ingresado = ldsDao.insert(lengdessist);
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Lenguaje ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Lenguaje no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarLengDes() {
    	 FacesContext context = FacesContext.getCurrentInstance();
        try {
            LengDesSistDao ldDao = new LengDesSistDaoImpl();
            LengDesSist ld = ldDao.getById(getIdLengSist());
            ld.setNomLengDes(getLengdessist().getNomLengDes());
            boolean modificar = ldDao.update(ld);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Lenguaje modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Lenguaje no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }

    }

    public void eliminarLengDes() {
        FacesContext context = FacesContext.getCurrentInstance();
    	try {
            LengDesSistDao ldsDao = new LengDesSistDaoImpl();
            boolean eliminado = ldsDao.deleteById(this.idLengSist);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Lenguaje eliminado exitosamente"));

            } else if (idLengSist == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Lenguaje"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Lenguaje no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }

    }


    public List<SelectItem> mostrarLengDes() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            LengDesSistDao lndsDao = new LengDesSistDaoImpl();
            ArrayList<SelectItem> lenguajes = new ArrayList<>();
            for (LengDesSist lengdessist : lndsDao.getAll()) {
                lenguajes.add(new SelectItem(lengdessist.getIdLengSist(), lengdessist.getNomLengDes()));
            }
            if (lenguajes.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Lenguajes en el sistema"));

            } else {
                return lenguajes;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;

    }

    public void cambioLengDes() {
    	FacesContext context = FacesContext.getCurrentInstance();
        try {
            LengDesSistDao ldsDao = new LengDesSistDaoImpl();
            this.lengdessist = ldsDao.getById(this.idLengSist);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }

    }
    
    public void LimpiarIngresar(){
        lengdessist.setNomLengDes(null);
    }
}
