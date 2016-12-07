/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.CarServ;
import dao.CarServidorDao;
import dao.impl.CarServidorDaoImpl;
import java.util.ArrayList;
import java.util.List;
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
public class CarServidorControl {

    private short idCarServidor;
    private CarServ carserv;

    public CarServidorControl() {
        this.carserv = new CarServ();
        this.idCarServidor = 0;
    }

    public short getIdCarServidor() {
        return idCarServidor;
    }

    public void setIdCarServidor(short idCarServidor) {
        this.idCarServidor = idCarServidor;
    }

    public CarServ getCarserv() {
        return carserv;
    }

    public void setCarserv(CarServ carserv) {
        this.carserv = carserv;
    }

    //Personalizados
    public void ingresarCarServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao csDao = new CarServidorDaoImpl();
            boolean ingresado = csDao.insert(carserv);
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Caracteristicas ingresadas exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Las caracteristicas no han podido ser ingresadas"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }

    }

    public void modificarCarServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao csDao = new CarServidorDaoImpl();
            CarServ ccar = csDao.getById(getIdCarServidor());
            ccar.setSoServ(getCarserv().getSoServ());
            ccar.setTamDiscServ(getCarserv().getTamDiscServ());
            ccar.setTamMemServ(getCarserv().getTamMemServ());
            boolean modificar = csDao.update(ccar);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Caracteristicas modificadas exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Las Caracteristicas no han podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarCarServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao csDao = new CarServidorDaoImpl();
            boolean eliminado = csDao.deleteById(this.idCarServidor);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Caracteristicas eliminadas exitosamente"));

            } else if (this.idCarServidor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Caracteristica"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Caracteristicas no han podido ser eliminadas exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }

    }

    public void cambioCarServ() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao cgDao = new CarServidorDaoImpl();
            this.carserv = cgDao.getById(this.idCarServidor);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }


    public List<SelectItem> listarTodo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao carDao = new CarServidorDaoImpl();
            ArrayList<SelectItem> listaCarServ = new ArrayList<>();
            for (CarServ carServidor : carDao.getAll()) {
                listaCarServ.add(new SelectItem(carServidor.getIdCarServ(), carServidor.getSoServ()));
            }
            if (listaCarServ.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Caracteristicas Servidores en el sistema"));
            } else {
                return listaCarServ;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Caracteristicas Servidores" + ex.getMessage()));

        }
        return null;
    }

    public void buscarCarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            CarServidorDao carDao = new CarServidorDaoImpl();
            carserv = carDao.getById(idCarServidor);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void LimpiarIngresar() {
        carserv.setSoServ(null);
        carserv.setTamDiscServ(0);
        carserv.setTamMemServ(0);
    }
}
