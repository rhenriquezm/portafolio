/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServicioDao;
import dao.impl.ServicioDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.Servicio;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class SrvcioControl {

    private int id;
    private Servicio ser;
    private ArrayList<SelectItem> listaSer;

    public SrvcioControl() {
        this.id = 0;
        this.ser = new Servicio();
        this.listaSer = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicio getSer() {
        return ser;
    }

    public void setSer(Servicio ser) {
        this.ser = ser;
    }

    public ArrayList<SelectItem> getListaSer() {
        return listaSer;
    }

    public void setListaSer(ArrayList<SelectItem> listaSer) {
        this.listaSer = listaSer;
    }

    //Personalizados
    public void ingresarServicio() {
        ServicioDao serDao = new ServicioDaoImpl();
        serDao.insert(ser);
        String nom = ser.getNomServicio();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente"));
    }

    public void modificarServicio() {
        ServicioDao serDao = new ServicioDaoImpl();
        Servicio srvcio = serDao.getById(id);
        srvcio.setNomServicio(ser.getNomServicio());
        srvcio.setSistema(ser.getSistema());
        serDao.update(srvcio);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("modificado exitosamente"));
    }

    public void eliminarServicio() {
        ServicioDao serDao = new ServicioDaoImpl();
        serDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminada exitosamente"));
    }

    public void cambioServicio() {
        ServicioDao serDao = new ServicioDaoImpl();
        ser = serDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        ServicioDao serDao = new ServicioDaoImpl();
        for (Servicio servicio : serDao.getAll()) {
            listaSer.add(new SelectItem(servicio.getIdServicio(), servicio.getNomServicio()));
        }
        return listaSer;
    }

    public void reset() {
        this.ser.setNomServicio(null);
    }

    public void resetLista() {
        listaSer.clear();
    }

}
