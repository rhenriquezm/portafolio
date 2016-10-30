/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.CarServ;
import POJO.SalaServ;
import dao.CarServidorDao;
import dao.SalaServDao;
import dao.impl.CarServidorDaoImpl;
import dao.impl.SalaServDaoImpl;
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
public class CarServidorControl {
    
    private short idCarServidor;
    private CarServ carserv;
    private ArrayList<SelectItem> listaCarServ;
    private ArrayList<CarServ> listaComp;

    public CarServidorControl() {
        this.carserv = new CarServ();
        this.idCarServidor = 0;
        this.listaCarServ = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }
    

    public short getIdCarServidor() {
        return idCarServidor;
    }

    public void setIdCarServidor(short idCarServidor) {
        this.idCarServidor = idCarServidor;
    }

    public CarServ getCarserv() {
        return carserv;
    }

    public void setCarserv(CarServ carserv) {
        this.carserv = carserv;
    }

    public ArrayList<SelectItem> getListaCarServ() {
        return listaCarServ;
    }

    public void setListaCarServ(ArrayList<SelectItem> listaCarServ) {
        this.listaCarServ = listaCarServ;
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
          CarServidorDao carDao = new CarServidorDaoImpl();
          for (CarServ carServidor : carDao.getAll()) {
              listaCarServ.add(new SelectItem(carServidor.getIdCarServ(), carServidor.getSoServ()));
          }
           if (listaCarServ.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Caracteristicas Servidores en el sistema"));
            } else {
                return listaCarServ;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Caracteristicas Servidores" + ex.getMessage()));
        
        }
        return null;
    }
    
    public void buscarCarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          CarServidorDao carDao = new CarServidorDaoImpl();
          carserv = carDao.getById(idCarServidor);
          }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaCarServ.clear();
    }

}
