package controlador;

import dao.SistOperDao;
import dao.impl.SistOperDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.SistOper;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class SOControl {

    //ATRIBUTOS
    private int id;
    private SistOper so;
    private ArrayList<SelectItem> listaSO;

    //CONSTRUCTOR SIN PARAMETROS
    public SOControl() {
        this.id = 0;
        this.so = new SistOper();
        this.listaSO = new ArrayList<>();
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SistOper getSo() {
        return so;
    }

    public void setSo(SistOper so) {
        this.so = so;
    }

    public List<SelectItem> getListaSO() {
        return listaSO;
    }

    public void setListaSO(ArrayList<SelectItem> listaSO) {
        this.listaSO = listaSO;
    }

    //METODOS PERSONALIZADOS
    public void ingresarSO() {
        SistOperDao soDao = new SistOperDaoImpl();
        soDao.insert(so);
        String nomb = so.getDesSo();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nomb + " " + "agregado exitosamente"));
    }

    public void eliminarSO() {

        SistOperDao soDao = new SistOperDaoImpl();
        soDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));
    }

    public void modificarSO() {
        SistOperDao soDao = new SistOperDaoImpl();
        SistOper sOper = soDao.getById(id);
        sOper.setDesSo(so.getDesSo());
        soDao.update(sOper);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));
    }

    public void cambioSO() {
        SistOperDao soDao = new SistOperDaoImpl();
        so = soDao.getById(id);
    }
    
    public List<SelectItem> listarTodo() {
        SistOperDao soDao = new SistOperDaoImpl();
        for (SistOper sistemaOpe : soDao.getAll()) {
            listaSO.add(new SelectItem(sistemaOpe.getIdSo(), sistemaOpe.getDesSo()));
        }
        return listaSO;
    }

    

    public void reset() {
        so.setDesSo(null);
    }

    public void resetLista() {
        listaSO.clear();
    }

}
