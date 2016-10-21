/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.WSDao;
import dao.impl.WSDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.Webservice;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class WSControl {

    private int id;
    private Webservice ws;
    private ArrayList<SelectItem> listaWS;

    public WSControl() {
        this.id = 0;
        this.ws = new Webservice();
        this.listaWS = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Webservice getWs() {
        return ws;
    }

    public void setWs(Webservice ws) {
        this.ws = ws;
    }

    public ArrayList<SelectItem> getListaWS() {
        return listaWS;
    }

    public void setListaWS(ArrayList<SelectItem> listaWS) {
        this.listaWS = listaWS;
    }

    //personalizados.
    public void ingresarWS() {
        WSDao wsDao = new WSDaoImpl();
        wsDao.insert(ws);
        String nom = ws.getNomWebservice();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente"));
    }

    public void modificarWS() {
        WSDao wsDao = new WSDaoImpl();
        Webservice wbs = wsDao.getById(id);
        wbs.setNomWebservice(wbs.getNomWebservice());
        wbs.setProtWebservice(wbs.getProtWebservice());
        wsDao.update(wbs);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));
    }

    public void eliminarWS() {
        WSDao wsDao = new WSDaoImpl();
        wsDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));

    }

    public void cambioWS() {
        WSDao wsDao = new WSDaoImpl();
        ws = wsDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        WSDao wsDao = new WSDaoImpl();
        for (Webservice webService : wsDao.getAll()) {
            listaWS.add(new SelectItem(webService.getIdWebservice(),webService.getNomWebservice()));
        }
        return listaWS;
    }
    
    public void resetLista(){
        listaWS.clear();
    }
    
    public void reset(){
        this.ws.setNomWebservice(null);
        this.ws.setProtWebservice(null);
        
    }

}
