/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProveedorDao;
import dao.impl.ProveedorDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.Proveedor;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class ProvControl {

    private int id;
    private Proveedor pr;
    private ArrayList<SelectItem> listaProv;

    public ProvControl() {
        this.id = 0;
        this.pr = new Proveedor();
        this.listaProv = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getPr() {
        return pr;
    }

    public void setPr(Proveedor pr) {
        this.pr = pr;
    }

    public ArrayList<SelectItem> getListaProv() {
        return listaProv;
    }

    public void setListaProv(ArrayList<SelectItem> listaProv) {
        this.listaProv = listaProv;
    }

    //Personalizados
    public void ingresarProv() {
        ProveedorDao prDao = new ProveedorDaoImpl();
        prDao.insert(pr);
        String nom = pr.getNomProv();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente"));

    }

    public void modificarProv() {
        ProveedorDao prDao = new ProveedorDaoImpl();
        Proveedor prov = prDao.getById(id);
        prov.setNomProv(pr.getNomProv());
        prov.setCorreoProv(pr.getCorreoProv());
        prov.setFonoProv(pr.getFonoProv());
        prDao.update(prov);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));

    }

    public void eliminarProv() {
        ProveedorDao prDao = new ProveedorDaoImpl();
        prDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));
    }

    public void cambioProv() {
        ProveedorDao prDao = new ProveedorDaoImpl();
        pr = prDao.getById(id);

    }

    public List<SelectItem> listarTodo() {
        ProveedorDao prDao = new ProveedorDaoImpl();
        for (Proveedor proveedor : prDao.getAll()) {
            listaProv.add(new SelectItem(proveedor.getIdProv(), proveedor.getNomProv()));
        }
        return listaProv;
    }

    public void resetLista() {
        listaProv.clear();
    }

    public void reset() {
        this.pr.setNomProv(null);
        this.pr.setCorreoProv(null);
        this.pr.setFonoProv(null);
    }

}
