/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.ContGar;
import dao.ContGarDao;
import dao.impl.ContGarDaoImpl;
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
public class ContGarControl {

    private ContGar contgar;
    private short idContGar;

    public ContGarControl() {
        this.contgar = new ContGar();
        this.idContGar = 0;
    }

    public ContGar getContgar() {
        return contgar;
    }

    public void setContgar(ContGar contgar) {
        this.contgar = contgar;
    }

    public short getIdContGar() {
        return idContGar;
    }

    public void setIdContGar(short idContGar) {
        this.idContGar = idContGar;
    }

    //Personalizados...
    public void ingresarContGar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ContGarDao cgDao = new ContGarDaoImpl();
            boolean ingresado = cgDao.insert(contgar);
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarContGar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ContGarDao cgDao = new ContGarDaoImpl();
            ContGar cgar = cgDao.getById(getIdContGar());
            cgar.setNomCont(getContgar().getNomCont());
            cgar.setCorreoCont(getContgar().getCorreoCont());
            cgar.setFonoCont(getContgar().getFonoCont());
            boolean modificar = cgDao.update(cgar);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarContGar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ContGarDao cgDao = new ContGarDaoImpl();
            boolean eliminado = cgDao.deleteById(this.idContGar);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Nivel eliminado exitosamente"));

            } else if (this.idContGar == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Nivel"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Nivel no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }

    }

    public void cambioContGar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ContGarDao cgDao = new ContGarDaoImpl();
            this.contgar = cgDao.getById(this.idContGar);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarContGar() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ContGarDao cgDao = new ContGarDaoImpl();
            ArrayList<SelectItem> contactos = new ArrayList<>();
            for (ContGar contgar : cgDao.getAll()) {
                contactos.add(new SelectItem(contgar.getIdCont(), contgar.getNomCont()));
            }
            if (contactos.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Niveles en el sistema"));

            } else {
                return contactos;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void LimpiarIngresar() {
        contgar.setNomCont(null);
        contgar.setCorreoCont(null);
        contgar.setFonoCont(0);

    }

}
