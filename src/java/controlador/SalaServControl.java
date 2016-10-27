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
public class SalaServControl {
    
    private short idSalaServidor;
    private SalaServ salaser;
    private ArrayList<SelectItem> listaSalaServ;
    private ArrayList<SalaServ> listaComp;
    
    public SalaServControl() {
        this.salaser = new SalaServ();
        this.idSalaServidor = 0;
        this.listaSalaServ = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        resetLista();
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

    public ArrayList<SelectItem> getListaSalaServ() {
        return listaSalaServ;
    }

    public void setListaSalaServ(ArrayList<SelectItem> listaSalaServ) {
        this.listaSalaServ = listaSalaServ;
    }

    public ArrayList<SalaServ> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<SalaServ> listaComp) {
        this.listaComp = listaComp;
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

    public List<SelectItem> listarTodo() {
         FacesContext context = FacesContext.getCurrentInstance();
        try {
          SalaServDao salaDao = new SalaServDaoImpl();
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
          boolean modificado = salaDao.update(salaServidor);
          if (modificado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sala Servidor modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "ala Servidor no ha sido modificada exitosamente"));
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
          }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaSalaServ.clear();
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
        this.salaser.setNomSalaServ(null);
    }
    
    
    
}
