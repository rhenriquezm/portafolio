/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.Webservice;
import dao.WebServiceDao;
import dao.impl.WebServiceDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ViewScoped
@ManagedBean
public class WebserviceControl {

    private Webservice webservice;
    private short idWebservice;

    public WebserviceControl() {
        this.webservice = new Webservice();
        this.idWebservice = 0;
    }

    public Webservice getWebservice() {
        return webservice;
    }

    public void setWebservice(Webservice webservice) {
        this.webservice = webservice;
    }

    public short getIdWebservice() { 
        return idWebservice;
    }

    public void setIdWebservice(short idWebservice) {
        this.idWebservice = idWebservice;
    }

    //Personalizados...
    public void ingresarWebservice() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WebServiceDao webserviceDao = new WebServiceDaoImpl();
            boolean ingresado = webserviceDao.insert(webservice);
            if (ingresado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Webservice ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Webservice no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }

    }

    public void modificarWebservice() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WebServiceDao wsDao = new WebServiceDaoImpl();
            Webservice ws = wsDao.getById(getIdWebservice());
            ws.setNomWebservice(getWebservice().getNomWebservice()); 
            ws.setProtWebservice(getWebservice().getProtWebservice());
            
            boolean modificar = wsDao.update(ws);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Webservice modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Webservice no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }

    }

    public void eliminarWebservice() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WebServiceDao webserviceDao = new WebServiceDaoImpl();
            boolean eliminado = webserviceDao.deleteById(this.idWebservice);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Webservice eliminado exitosamente"));

            } else if (this.idWebservice == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Webservice"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Webservice no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public ArrayList<SelectItem> mostrarWebservice() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WebServiceDao webserviceDao = new WebServiceDaoImpl();
            ArrayList<SelectItem> wss = new ArrayList<>();
            for (Webservice webservice : webserviceDao.getAll()) {
                wss.add(new SelectItem(webservice.getIdWebservice(), webservice.getNomWebservice()));
            }
            if (wss.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Webservice en el sistema"));

            } else {
                return wss;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioWebservice() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            WebServiceDao wsDao = new WebServiceDaoImpl();
            this.webservice = wsDao.getById(getIdWebservice());
            System.out.println("AAAAAAAAAAAAAAAAAAA: "  + this.webservice.getNomWebservice());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }

    }

    public void limpiarIngresar(){
     webservice.setNomWebservice(null);
     webservice.setProtWebservice(null);
    }

}
