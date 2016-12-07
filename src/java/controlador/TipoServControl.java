/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.TipoServ;
import dao.TipoServDao;
import dao.impl.TipoServDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author ricardo
 */
@ViewScoped
@ManagedBean
public class TipoServControl {

    private short idTipoServ;
    private TipoServ tiposerv;

    public TipoServControl() {
        this.tiposerv = new TipoServ();
        this.idTipoServ = 0;
    }

    public short getIdTipoServ() {
        return idTipoServ;
    }

    public void setIdTipoServ(short idTipoServ) {
        this.idTipoServ = idTipoServ;
    }

    public TipoServ getTiposerv() {
        return tiposerv;
    }

    public void setTiposerv(TipoServ tiposerv) {
        this.tiposerv = tiposerv;
    }

    public void ingresarTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tsDao = new TipoServDaoImpl();
            boolean ingresado = tsDao.insert(getTiposerv());
            if (ingresado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Tipo Servidor ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Tipo Servidor no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }

    }

    public void modificarTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tsDao = new TipoServDaoImpl();
            TipoServ ts = tsDao.getById(getIdTipoServ());
            ts.setDescTipo(getTiposerv().getDescTipo());
            ts.setPassAdmin(getTiposerv().getPassAdmin());
            ts.setUsBd(getTiposerv().getUsBd());
            ts.setPassBd(getTiposerv().getPassBd());
            boolean modificar = tsDao.update(ts);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Tipo Servidor modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Tipo Servidor no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }

    }

    public void eliminarTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tsDao = new TipoServDaoImpl();
            boolean eliminado = tsDao.deleteById(this.idTipoServ);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Tipo Servidor eliminado exitosamente"));

            } else if (this.idTipoServ == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Tipo Servidor"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Tipo Servidor no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> listarTodo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tipoDao = new TipoServDaoImpl();
            ArrayList<SelectItem> listaTipoServ = new ArrayList();
            for (TipoServ tipoServ : tipoDao.getAll()) {
                listaTipoServ.add(new SelectItem(tipoServ.getIdTipoServ(), tipoServ.getDescTipo()));
            }
            if (listaTipoServ.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Tipo Servidores en el sistema"));
            } else {
                return listaTipoServ;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Tipo Servidores" + ex.getMessage()));

        }
        return null;
    }

    public void buscarTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tipoServDao = new TipoServDaoImpl();
            tiposerv = tipoServDao.getById(idTipoServ);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void cambioTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            TipoServDao tsDao = new TipoServDaoImpl();
            this.tiposerv = tsDao.getById(getIdTipoServ());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }

    }

    public void limpiarIngresar() {
        tiposerv.setDescTipo(null);
        tiposerv.setPassAdmin(null);
        tiposerv.setUsBd(null);
        tiposerv.setPassBd(null);

    }

}
