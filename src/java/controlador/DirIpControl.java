/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.DirIp;
import dao.DirIpDao;
import dao.impl.DirIpDaoImpl;
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
public class DirIpControl {

    private DirIp dirip;
    private short idDirIp;

    public DirIpControl() {
        this.dirip = new DirIp();
        this.idDirIp = 0;
    }

    public DirIp getDirip() {
        return dirip;
    }

    public void setDirip(DirIp dirip) {
        this.dirip = dirip;
    }

    public short getIdDirIp() {
        return idDirIp;
    }

    public void setIdDirIp(short idDirIp) {
        this.idDirIp = idDirIp;
    }
    
    //Personalizados

    public void ingresarDirIp() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DirIpDao idipDao = new DirIpDaoImpl();
            boolean ingresado = idipDao.insert(dirip);
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Direccion IP ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Direccion IP no ha podido ser ingresada"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarDirIp() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DirIpDao mdipDao = new DirIpDaoImpl();
            DirIp mdip = mdipDao.getById(getIdDirIp());
            mdip.setDirIp(getDirip().getDirIp());
            boolean modificar = mdipDao.update(mdip);
            if (modificar) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Direccion IP modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Direccion IP no ha podido ser modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarDirIp() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DirIpDao edipDao = new DirIpDaoImpl();
            boolean eliminado = edipDao.deleteById(this.idDirIp);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Direccion IP eliminada exitosamente"));

            } else if (this.idDirIp == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione una Direccion IP"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Direccion IP no ha podido ser eliminada exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public void cambioDirIp() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DirIpDao cdipDao = new DirIpDaoImpl();
            this.dirip = cdipDao.getById(this.idDirIp);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }
    

    public List<SelectItem> mostrarDirIp() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            DirIpDao ldipDao = new DirIpDaoImpl();
            ArrayList<SelectItem> direcciones = new ArrayList<>();
            for (DirIp dirip : ldipDao.getAll()) {
                direcciones.add(new SelectItem(dirip.getIdDir(), dirip.getDirIp()));
            }
            if (direcciones.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Direcciones IP en el sistema"));

            } else {
                return direcciones;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void LimpiarIngresar() {
        dirip.setDirIp(null);
        dirip.setIdDir((short)0);
        setIdDirIp((short)0);
    }

    
}
