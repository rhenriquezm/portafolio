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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class ProveedorControl {

    private short idProv;
    private Proveedor proveedor;

    public ProveedorControl() {
        this.idProv = 0;
        this.proveedor = new Proveedor();
    }

    public short getIdProv() {
        return idProv;
    }

    public void setIdProv(short idProv) {
        this.idProv = idProv;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    //Personalizados
    public void ingresarProveedor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ProveedorDao iprovDao = new ProveedorDaoImpl();
            boolean ingresado = iprovDao.insert(proveedor);
            if (ingresado) {
                LimpiarIngresarProveedor();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }

    }

    public void modificarProveedor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ProveedorDao mprovDao = new ProveedorDaoImpl();
            Proveedor mprov = mprovDao.getById(getIdProv());
            mprov.setNomProv(getProveedor().getNomProv());
            mprov.setCorreoProv(getProveedor().getCorreoProv());
            mprov.setFonoProv(getProveedor().getFonoProv());
            boolean modificar = mprovDao.update(mprov);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarProveedor() {

        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ProveedorDao eprovDao = new ProveedorDaoImpl();
            boolean eliminado = eprovDao.deleteById(this.idProv);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Proveedor eliminado exitosamente"));

            } else if (this.idProv == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Proveedor"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Proveedor no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }

    }

    public List<SelectItem> mostrarProveedor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ProveedorDao lprovDao = new ProveedorDaoImpl();
            ArrayList<SelectItem> proveedores = new ArrayList<>();
            for (Proveedor proveedor : lprovDao.getAll()) {
                proveedores.add(new SelectItem(proveedor.getIdProv(), proveedor.getNomProv()));
            }
            if (proveedores.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Proveedor Ingresados en el sistema"));

            } else {
                return proveedores;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;

    }

    public void cambioProveedor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ProveedorDao cprovDao = new ProveedorDaoImpl();
            this.proveedor = cprovDao.getById(this.idProv);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresarProveedor() {
        proveedor.setNomProv(null);
        proveedor.setCorreoProv(null);
        proveedor.setFonoProv(null);
    }

}
