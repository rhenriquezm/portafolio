/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.OrganizacionDao;
import dao.impl.OrganizacionDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.Organizacion;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class OrgControl {

    private Organizacion org;
    private int id;
    private ArrayList<SelectItem> listaOrg;

    public OrgControl() {
        this.org = new Organizacion();
        this.id = 0;
        this.listaOrg = new ArrayList<>();
    }

    public Organizacion getOrg() {
        return org;
    }

    public void setOrg(Organizacion org) {
        this.org = org;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaOrg() {
        return listaOrg;
    }

    public void setListaOrg(ArrayList<SelectItem> listaOrg) {
        this.listaOrg = listaOrg;
    }

    public void ingresarOrg() {
        OrganizacionDao orgDao = new OrganizacionDaoImpl();
        orgDao.insert(org);
        String nom = org.getNomOrg();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente"));
    }

    public void modificarOrg() {
        OrganizacionDao orgDao = new OrganizacionDaoImpl();
        Organizacion orga = orgDao.getById(id);
        orga.setNomOrg(orga.getNomOrg());
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));
    }

    public void eliminarOrg() {
        OrganizacionDao orgDao = new OrganizacionDaoImpl();
        orgDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));
    }

    public void cambioOrg() {
        OrganizacionDao orgDao = new OrganizacionDaoImpl();
        org = orgDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        OrganizacionDao orgDao = new OrganizacionDaoImpl();
        for (Organizacion organizacion : orgDao.getAll()) {
            listaOrg.add(new SelectItem(organizacion.getIdOrg(), organizacion.getNomOrg()));
        }
        return listaOrg;
    }

    public void resetLista() {
        listaOrg.clear();
    }

    public void reset() {
        org.setNomOrg(null);
    }

}
