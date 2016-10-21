package controlador;

import dao.NivSegDao;
import dao.impl.NivSegDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.NivSeg;

@ViewScoped
@ManagedBean
public class NSegControl {

    private NivSeg ns;
    private int id;
    private ArrayList<SelectItem> listaNS;

    public NSegControl() {
        this.ns = new NivSeg();
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

    public NivSeg getNs() {
        return ns;
    }

    public void setNs(NivSeg ns) {
        this.ns = ns;
    }

    //Metodo Perso...
    public void ingresarNS() {
        NivSegDao nsDao = new NivSegDaoImpl();
        nsDao.insert(ns);
        String nomb = ns.getDescNivSeg();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nomb + " " + "agregado exitosamente"));

    }
    
    public void eliminarNS() {
        NivSegDao nsDao = new NivSegDaoImpl();
        nsDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));

    }

    public void modificarNS() {
        NivSegDao nsDao = new NivSegDaoImpl();
        NivSeg nSeg = nsDao.getById(id);
        nSeg.setDescNivSeg(ns.getDescNivSeg());
        nsDao.update(nSeg);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));
    }
    
    public void cambioNS() {
        NivSegDao nsDao = new NivSegDaoImpl();
        ns = nsDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        NivSegDao nsDao = new  NivSegDaoImpl();
        for ( NivSeg nivelSeg : nsDao.getAll()) {
            listaNS.add(new SelectItem(nivelSeg.getIdNivSeg(), nivelSeg.getDescNivSeg()));
        }
        return listaNS;
    }
    
    public void resetLista() {
        listaNS.clear();
    }
    
    public void reset() {
        this.ns.setDescNivSeg(null);
    }
}
    
