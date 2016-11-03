/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.ContGar;
import POJO.Garantia;
import POJO.Servidor;
import dao.ContGarDao;
import dao.GarantiaDao;
import dao.ServidorDao;
import dao.impl.ContGarDaoImpl;
import dao.impl.GarantiaDaoImpl;
import dao.impl.ServidorDaoImpl;
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
public class GarantiaControl {

    private Garantia garantia;
    private short idGarantia;
    private short idServidor;
    private short idContGar;

    public GarantiaControl() {
        this.garantia = new Garantia();
        this.idServidor = 0;
        this.idContGar = 0;

    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public short getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(short idGarantia) {
        this.idGarantia = idGarantia;
    }

    public short getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(short idServidor) {
        this.idServidor = idServidor;
    }

    public short getIdContGar() {
        return idContGar;
    }

    public void setIdContGar(short idContGar) {
        this.idContGar = idContGar;
    }

    //personalizados...
    public void ingresarGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            GarantiaDao garDao = new GarantiaDaoImpl();

            ServidorDao servidorDao = new ServidorDaoImpl();
            ContGarDao contgarDao = new ContGarDaoImpl();

            Servidor servidor = servidorDao.getById(getIdServidor());
            ContGar contgar = contgarDao.getById(getIdContGar());

            
            getGarantia().setContGar(contgar);

            boolean ingresado = garDao.insert(getGarantia());
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            GarantiaDao mgarDao = new GarantiaDaoImpl();
            Garantia mgar = mgarDao.getById(getIdGarantia());
            
            ContGarDao contDao = new ContGarDaoImpl();

            mgar.setContGar(contDao.getById(mgar.getContGar().getIdCont()));
            mgar.setNomGar(getGarantia().getNomGar());
            mgar.setFechaGar(getGarantia().getFechaGar());
            mgar.setFechaCadGar(getGarantia().getFechaCadGar());
            boolean modificar = mgarDao.update(mgar);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            GarantiaDao egarDao = new GarantiaDaoImpl();
            boolean eliminado = egarDao.deleteById(this.idGarantia);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema eliminado exitosamente"));

            } else if (this.idGarantia == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            GarantiaDao lgarDao = new GarantiaDaoImpl();
            ArrayList<SelectItem> garantias = new ArrayList<>();
            for (Garantia garantia : lgarDao.getAll()) {
                garantias.add(new SelectItem(garantia.getIdGar(), garantia.getNomGar()));
            }
            if (garantias.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Sistema Ingresados en el sistema"));

            } else {
                return garantias;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            GarantiaDao cgarDao = new GarantiaDaoImpl();
            this.garantia = cgarDao.getById(this.idGarantia);
            setIdContGar(this.garantia.getContGar().getIdCont());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresar() {
        garantia.setNomGar(null);
        garantia.setContGar(null);
        garantia.setFechaGar(null);
        garantia.setFechaCadGar(null);
        setIdContGar((short)0);

    }

}
