/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.CarServ;
import POJO.TipoServ;
import dao.CarServidorDao;
import dao.TipoServDao;
import dao.impl.CarServidorDaoImpl;
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
    private ArrayList<SelectItem> listaTipoServ;
    private ArrayList<CarServ> listaComp;

    public TipoServControl() {
        this.tiposerv = new TipoServ();
        this.idTipoServ = 0;
        this.listaTipoServ = new ArrayList<>();
        this.listaComp = new ArrayList<>();
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

    public ArrayList<SelectItem> getListaTipoServ() {
        return listaTipoServ;
    }

    public void setListaTipoServ(ArrayList<SelectItem> listaTipoServ) {
        this.listaTipoServ = listaTipoServ;
    }

    public ArrayList<CarServ> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<CarServ> listaComp) {
        this.listaComp = listaComp;
    }

    

    
    
    public List<SelectItem> listarTodo() {
         FacesContext context = FacesContext.getCurrentInstance();
        try {
          TipoServDao tipoDao = new TipoServDaoImpl();
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
          }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaTipoServ.clear();
    }
    
}
