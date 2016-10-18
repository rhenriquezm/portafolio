package controlador;

import dao.UnidadTrabajoDao;
import dao.impl.UnidadTrabajoDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import modelo.UnidadTrabajo;

@ViewScoped
@ManagedBean
public class UTControl {

    //Atributos
    private int id;
    private UnidadTrabajo ut;
    private ArrayList<SelectItem> listaUT;
    private ArrayList<UnidadTrabajo> listaComp;

    //Constructor sin parametros
    public UTControl() {
        this.ut = new UnidadTrabajo();
        this.id = 0;
        this.listaUT = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        resetLista();
    }

    //Getters and Setters
    
    public UnidadTrabajo getUt() {
        return ut;
    }

    public void setUt(UnidadTrabajo ut) {
        this.ut = ut;
    }

    public List<SelectItem> getListaUT() {
        return listaUT;
    }

    public void setListaUT(ArrayList<SelectItem> listaUT) {
        this.listaUT = listaUT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<UnidadTrabajo> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<UnidadTrabajo> listaComp) {
        this.listaComp = listaComp;
    }

    //Metodos Personalizados
    
    public void ingresarUTrabajo() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        utDao.insert(ut);
        String nomb = ut.getNomUnidTrab();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nomb + " " + "agregada exitosamente"));
    }

    public List<SelectItem> listarTodo() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        for (UnidadTrabajo unidadTrabajo : utDao.getAll()) {
            listaUT.add(new SelectItem(unidadTrabajo.getIdUniTrab(), unidadTrabajo.getNomUnidTrab()));
        }
        return listaUT;
    }

    public void eliminarUTrabajo() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        utDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminada exitosamente"));
    }

    public void modificarUTrabajo() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        UnidadTrabajo uTrab = utDao.getById(id);
        uTrab.setNomUnidTrab(ut.getNomUnidTrab());
        utDao.update(uTrab);
        resetLista();
    }

    public void busarUTrabajo() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        ut = utDao.getById(id);

    }

    public void resetLista() {
        listaUT.clear();
    }

    public void reset() {
        this.ut.setNomUnidTrab(null);
    }

    public void cambioUT() {
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        ut = utDao.getById(id);
    }
    
    public ArrayList<UnidadTrabajo> listaCompleta(){
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        listaComp = utDao.getAll();
        return listaComp;
    }
}
