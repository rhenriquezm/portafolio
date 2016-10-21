package controlador;

import dao.NivSensDao;
import dao.impl.NivSensDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.NivSens;

@ViewScoped
@ManagedBean
public class NSensControl {

    private NivSens ns;
    private int id;
    private ArrayList<SelectItem> listaNS;

    public NSensControl() {
        this.ns = new NivSens();
        this.listaNS = new ArrayList<>();
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaNS() {
        return listaNS;
    }

    public void setListaNS(ArrayList<SelectItem> listaNS) {
        this.listaNS = listaNS;
    }

    public NivSens getNs() {
        return ns;
    }

    public void setNs(NivSens ns) {
        this.ns = ns;
    }

    //Metodo Perso...
    public void ingresarNS() {
        NivSensDao nsDao = new NivSensDaoImpl();
        nsDao.insert(ns);
        String nomb = ns.getDescNivSens();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nomb + " " + "agregado exitosamente"));

    }
    
    public void eliminarNS() {
        NivSensDao nsDao = new NivSensDaoImpl();
        nsDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));

    }

    public void modificarNS() {
        NivSensDao nsDao = new NivSensDaoImpl();
        NivSens nSens = nsDao.getById(id);
        nSens.setDescNivSens(ns.getDescNivSens());
        nsDao.update(nSens);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));
    }
    
    public void cambioNS() {
        NivSensDao nsDao = new NivSensDaoImpl();
        ns = nsDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        NivSensDao nsDao = new  NivSensDaoImpl();
        for ( NivSens nivelSeg : nsDao.getAll()) {
            listaNS.add(new SelectItem(nivelSeg.getIdNivSens(), nivelSeg.getDescNivSens()));
        }
        return listaNS;
    }
    
    public void resetLista() {
        listaNS.clear();
    }
    
    public void reset() {
        this.ns.setDescNivSens(null);
    }
}
    
