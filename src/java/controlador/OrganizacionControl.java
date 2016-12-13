/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.Organizacion;
import dao.OrganizacionDao;
import dao.impl.OrganizacionDaoImpl;
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
public class OrganizacionControl {

    private short idOrg;
    private Organizacion organizacion;

    public OrganizacionControl() {
        this.idOrg = 0;
        this.organizacion = new Organizacion();
    }

    public short getIdorg() {
        return idOrg;
    }

    public void setIdorg(short idOrg) {
        this.idOrg = idOrg;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    //Personalizados....
    public void ingresarOrga() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            OrganizacionDao orgDao = new OrganizacionDaoImpl();
            boolean ingresado = orgDao.insert(organizacion);
            if (ingresado) {
                LimpiarIngresarOrga();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Organizacion ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Organizacion no ha podido ser ingresada"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarOrga() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            OrganizacionDao morgDao = new OrganizacionDaoImpl();
            Organizacion morg = morgDao.getById(getIdorg());
            morg.setNomOrg(getOrganizacion().getNomOrg());
            morg.setRutOrg(getOrganizacion().getRutOrg());
            morg.setRubroOrg(getOrganizacion().getRubroOrg());
            morg.setCorreoOrg(getOrganizacion().getCorreoOrg());
            morg.setFonoOrg(getOrganizacion().getFonoOrg());
            boolean modificar = morgDao.update(morg);
            if (modificar) {
                LimpiarIngresarOrga();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel modificado exitosamente"));
            } else {
              
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }

    }

    public void eliminarOrga() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            OrganizacionDao orgDao = new OrganizacionDaoImpl();
            boolean eliminado = orgDao.deleteById(this.idOrg);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Organizacion eliminada exitosamente"));

            } else if (this.idOrg == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione una Organizacion"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR AL ELIMINAR!", "Organizacion en Uso"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }

    }

    public List<SelectItem> mostrarOrga() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            OrganizacionDao orgDao = new OrganizacionDaoImpl();
            ArrayList<SelectItem> orgnes = new ArrayList<>();
            for (Organizacion organizacion : orgDao.getAll()) {
                orgnes.add(new SelectItem(organizacion.getIdOrg(), organizacion.getNomOrg()));
            }
            if (orgnes.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Organizaciones en el sistema"));

            } else {
                return orgnes;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioOrga() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            OrganizacionDao orgaDao = new OrganizacionDaoImpl();
            this.organizacion = orgaDao.getById(this.idOrg);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
    }

    public void LimpiarIngresarOrga() {
        organizacion.setNomOrg(null);
        organizacion.setRutOrg(null);
        organizacion.setRubroOrg(null);
        organizacion.setCorreoOrg(null);
        organizacion.setFonoOrg(null);
        organizacion.setIdOrg((short)0);
        setIdorg((short)0);
    }

}
