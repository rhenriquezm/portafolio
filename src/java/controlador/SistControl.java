package controlador;

import dao.SistemaDao;
import dao.impl.SistemaDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.Sistema;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class SistControl {
    
    private int id;
    private Sistema sis;
    private ArrayList<SelectItem> listaSist;

    public SistControl() {
        this.id = 0;
        this.sis = new Sistema();
        this.listaSist = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sistema getSis() {
        return sis;
    }

    public void setSis(Sistema sis) {
        this.sis = sis;
    }

    public ArrayList<SelectItem> getListaSist() {
        return listaSist;
    }

    public void setListaSist(ArrayList<SelectItem> listaSist) {
        this.listaSist = listaSist;
    }
    
    //Personalizados
    
    public void ingresarSistema(){
        SistemaDao sisDao = new SistemaDaoImpl();
        sisDao.insert(sis);
        String nom = sis.getNomSist();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente")); 
    }
    
    public void modificarSistema(){
        SistemaDao sisDao = new SistemaDaoImpl();
        Sistema sist = sisDao.getById(id);
        sist.setNomSist(sis.getNomSist());
        sist.setNomSist(sis.getNomSist());
        sist.setServidor(sis.getServidor());
        sist.setUsuario(sis.getUsuario());
        sist.setNivSeg(sis.getNivSeg());
        sist.setNivSens(sis.getNivSens());
        sist.setSistOper(sis.getSistOper());
        sist.setSoftBd(sis.getSoftBd());
        sist.setProveedor(sis.getProveedor());
        sist.setServicios(sis.getServicios());
        sist.setWebservice(sis.getWebservice());
        sist.setOrganizacion(sis.getOrganizacion());
        sisDao.update(sist);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("modificado exitosamente"));            
    }
    
    public void eliminarSistema(){
        SistemaDao sisDao = new SistemaDaoImpl();
        sisDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminada exitosamente"));
     }
    
    public void cambioSistema(){
        SistemaDao sisDao = new SistemaDaoImpl();
        sis = sisDao.getById(id);
        
    }
    
    public List<SelectItem> listarTodo() {
        SistemaDao sisDao = new SistemaDaoImpl();
        for (Sistema sistema : sisDao.getAll() ) {
            listaSist.add(new SelectItem(sistema.getIdSist(),sistema.getNomSist()));
        }
        return listaSist;
    }
    
    public void reset() {
        sis.setNomSist(null);
    }

    public void resetLista() {
       listaSist.clear();
    }
}
