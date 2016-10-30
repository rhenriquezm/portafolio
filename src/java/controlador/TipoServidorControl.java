/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.CarServ;
import POJO.TipoServ;
import POJO.TipoServidor;
import dao.TipoServDao;
import dao.TipoServidorDao;
import dao.impl.TipoServDaoImpl;
import dao.impl.TipoServidorDaoImpl;
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
public class TipoServidorControl {
    
    private short idTipoServidor;
    private TipoServidor tiposervidor;
    private ArrayList<SelectItem> listaTipoServidor;
    private ArrayList<CarServ> listaComp;

    public TipoServidorControl() {
        this.tiposervidor = new TipoServidor();
        this.idTipoServidor = 0;
        this.listaTipoServidor = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }

    public short getIdTipoServidor() {
        return idTipoServidor;
    }

    public void setIdTipoServidor(short idTipoServidor) {
        this.idTipoServidor = idTipoServidor;
    }

    public TipoServidor getTiposervidor() {
        return tiposervidor;
    }

    public void setTiposervidor(TipoServidor tiposervidor) {
        this.tiposervidor = tiposervidor;
    }

    public ArrayList<SelectItem> getListaTipoServidor() {
        return listaTipoServidor;
    }

    public void setListaTipoServidor(ArrayList<SelectItem> listaTipoServidor) {
        this.listaTipoServidor = listaTipoServidor;
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
          TipoServidorDao tipoDao = new TipoServidorDaoImpl();
          for (TipoServidor tipoServidor : tipoDao.getAll()) {
              listaTipoServidor.add(new SelectItem(tipoServidor.getIdTipoServ(), tipoServidor.getNomTipoServ()));
          }
           if (listaTipoServidor.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Tipo Servidores en el sistema"));
            } else {
                return listaTipoServidor;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Tipo Servidores" + ex.getMessage()));
        
        }
        return null;
    }
    
    public void buscarTipoServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          TipoServidorDao tipoServDao = new TipoServidorDaoImpl();
          tiposervidor = tipoServDao.getById(idTipoServidor);
          }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaTipoServidor.clear();
    }
    
}
