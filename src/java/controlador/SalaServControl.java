/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.SalaServ;
import dao.SalaServDao;
import dao.impl.SalaServDaoImpl;
import java.util.ArrayList;
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
public class SalaServControl {

    private short idSalaServidor;
    private SalaServ salaser;

    public SalaServControl() {
        this.salaser = new SalaServ();
        this.idSalaServidor = 0;
    }

    //Getters and Setters
    public short getIdSalaServidor() {
        return idSalaServidor;
    }

    public void setIdSalaServidor(short idSalaServidor) {
        this.idSalaServidor = idSalaServidor;
    }

    public SalaServ getSalaser() {
        return salaser;
    }

    public void setSalaser(SalaServ salaser) {
        this.salaser = salaser;
    }

    //Metodos Personalizados
    public void ingresarSalaServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            boolean ingresado = salaDao.insert(salaser);
            if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sala Servidor ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sala Servidor no ha sido ingresada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar" + ex.getMessage()));
        }
    }

    public ArrayList<SelectItem> mostrarSalas() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            ArrayList<SelectItem> listaSalaServ = new ArrayList<>();
            for (SalaServ salaServidor : salaDao.getAll()) {
                listaSalaServ.add(new SelectItem(salaServidor.getIdSalaServ(), salaServidor.getNomSalaServ()));
            }
            if (listaSalaServ.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Sala Servidores en el sistema"));
            } else {
                return listaSalaServ;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Sala Servidores" + ex.getMessage()));

        }
        return null;
    }

    public void eliminarSalaServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            boolean eliminado = salaDao.deleteById(idSalaServidor);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sala Servidor eliminada exitosamente"));
            } else if (this.idSalaServidor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Sala por favor "));  
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sala Servidor no ha sido eliminada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar" + ex.getMessage()));
        }
    }

    public void modificarSalaServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            SalaServ salaServidor = salaDao.getById(idSalaServidor);
            salaServidor.setNomSalaServ(salaser.getNomSalaServ());
            salaServidor.setNumero(salaser.getNumero());
            salaServidor.setPiso(salaser.getPiso());
            boolean modificado = salaDao.update(salaServidor);
            if (modificado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sala Servidor modificada exitosamente"));  
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sala Servidor no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }
    }

    public void buscarSalaServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            salaser = salaDao.getById(idSalaServidor);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }


    public void reset() {
        this.salaser.setNomSalaServ(null);
    }

    public void cambioSalaServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SalaServDao salaDao = new SalaServDaoImpl();
            salaser = salaDao.getById(idSalaServidor);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }

    public void limpiarIngresar() {
        salaser.setNomSalaServ(null);
        salaser.setNumero(0);
        salaser.setPiso(0);
        salaser.setIdSalaServ((short)0);
        setIdSalaServidor((short)0);
    }

}
