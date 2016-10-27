/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.Proveedor;
import dao.ProveedorDao;
import dao.impl.ProveedorDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class ProveedorControl {
    
    private short idProv;
    private Proveedor prov;
    private ArrayList<SelectItem> listaProv;
    private ArrayList<Proveedor> listaComp;

    public ProveedorControl() {
        this.idProv = 0;
        this.prov = new Proveedor();
        this.listaProv = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        resetLista();
    }

    public short getIdProv() {
        return idProv;
    }
    
    
    

    public void setIdProv(short idProv) {
        this.idProv = idProv;
    }

    

    public Proveedor getProv() {
        return prov;
    }

    public void setProv(Proveedor prov) {
        this.prov = prov;
    }

    public ArrayList<SelectItem> getListaProv() {
        return listaProv;
    }

    public void setListaProv(ArrayList<SelectItem> listaProv) {
        this.listaProv = listaProv;
    }

    public ArrayList<Proveedor> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<Proveedor> listaComp) {
        this.listaComp = listaComp;
    }

    
    
     //Metodos Personalizados
    
    public void ingresarProveedor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           ProveedorDao provDao = new ProveedorDaoImpl();
           boolean ingresado = provDao.insert(prov);
           if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha sido ingresada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar" + ex.getMessage()));
        }
    }

    public List<SelectItem> listarTodo() {
         FacesContext context = FacesContext.getCurrentInstance();
        try {
          ProveedorDao provDao = new ProveedorDaoImpl();
           for (Proveedor proveedor : provDao.getAll()) {
              listaProv.add(new SelectItem(proveedor.getIdProv(), proveedor.getNomProv()));
           }
         if (listaProv.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Proveedor en el sistema"));
            } else {
                return listaProv;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Proveedores" + ex.getMessage()));
        
        }
        return null;
    }

    public void eliminarProv() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ProveedorDao provDao = new ProveedorDaoImpl();
          boolean eliminado = provDao.deleteById(idProv);
          if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor eliminada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha sido eliminada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar" + ex.getMessage()));
        }
    }

    public void modificarProv() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
           ProveedorDao provDao = new ProveedorDaoImpl();
          Proveedor pro = provDao.getById(idProv);
          pro.setNomProv(prov.getNomProv());
          pro.setFonoProv(prov.getFonoProv());
          pro.setCorreoProv(prov.getCorreoProv());
          boolean modificado = provDao.update(pro);
          if (modificado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }

    }

    public void buscarProv() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ProveedorDao provDao = new ProveedorDaoImpl();
         prov = provDao.getById(idProv);
        }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaProv.clear();
    }

    public void reset() {
        this.prov.setNomProv(null);
    }

    public void cambioProv() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ProveedorDao provDao = new ProveedorDaoImpl();
          prov = provDao.getById(idProv);
          } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    
    }
    
  
    public void limpiarIngresar() {
        this.prov.setNomProv(null);
    }
    

  
    
}
