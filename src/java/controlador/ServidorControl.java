/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.Rack;
import POJO.Servidor;
import dao.CarServidorDao;
import dao.ProveedorDao;
import dao.RackDao;
import dao.SalaServDao;
import dao.ServidorDao;
import dao.SistOperDao;
import dao.TipoServDao;
import dao.TipoServidorDao;
import dao.UsuarioDao;
import dao.impl.CarServidorDaoImpl;
import dao.impl.ProveedorDaoImpl;
import dao.impl.RackDaoImpl;
import dao.impl.SalaServDaoImpl;
import dao.impl.ServidorDaoImpl;
import dao.impl.SistOperDaoImpl;
import dao.impl.TipoServDaoImpl;
import dao.impl.TipoServidorDaoImpl;
import dao.impl.UsuarioDaoImpl;
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
public class ServidorControl {
    
    private short idServ;
    private short idRack;
    private short idSalaServ;
    private short idUsuario;
    private short idProv;
    private short idCarServ;
    private short idSistOper;
    private short idTipoServ;
    private short idTipoServidor;
    private Servidor serv;
    private ArrayList<SelectItem> listaServ;
    private ArrayList<Servidor> listaComp;

    public ServidorControl() {
        
        this.serv = new Servidor();
        this.idRack = 0;
        this.listaServ = new ArrayList<>();
        this.listaComp = new ArrayList<>();
    }

    public short getIdServ() {
        return idServ;
    }

    public void setIdServ(short idServ) {
        this.idServ = idServ;
    }

    public short getIdRack() {
        return idRack;
    }

    public void setIdRack(short idRack) {
        this.idRack = idRack;
    }

    public short getIdSalaServ() {
        return idSalaServ;
    }

    public void setIdSalaServ(short idSalaServ) {
        this.idSalaServ = idSalaServ;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public short getIdProv() {
        return idProv;
    }

    public void setIdProv(short idProv) {
        this.idProv = idProv;
    }

    public short getIdCarServ() {
        return idCarServ;
    }

    public void setIdCarServ(short idCarServ) {
        this.idCarServ = idCarServ;
    }

    public short getIdSistOper() {
        return idSistOper;
    }

    public void setIdSistOper(short idSistOper) {
        this.idSistOper = idSistOper;
    }

    public short getIdTipoServ() {
        return idTipoServ;
    }

    public void setIdTipoServ(short idTipoServ) {
        this.idTipoServ = idTipoServ;
    }

    public short getIdTipoServidor() {
        return idTipoServidor;
    }

    public void setIdTipoServidor(short idTipoServidor) {
        this.idTipoServidor = idTipoServidor;
    }

    public Servidor getServ() {
        return serv;
    }

    public void setServ(Servidor serv) {
        this.serv = serv;
    }

    public ArrayList<SelectItem> getListaServ() {
        return listaServ;
    }

    public void setListaServ(ArrayList<SelectItem> listaServ) {
        this.listaServ = listaServ;
    }

    public ArrayList<Servidor> getListaComp() {
        return listaComp;
    }

    public void setListaComp(ArrayList<Servidor> listaComp) {
        this.listaComp = listaComp;
    }
    
    //Metodos Personalizados
    
    public void ingresarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ServidorDao servDao = new ServidorDaoImpl();
          SalaServDao salaDao = new SalaServDaoImpl();
          RackDao rackDao = new RackDaoImpl();
          UsuarioDao usuarioDao = new UsuarioDaoImpl();
          ProveedorDao iprovDao = new ProveedorDaoImpl();
          TipoServDao tipoDao = new TipoServDaoImpl();
          TipoServidorDao tipoSDao = new TipoServidorDaoImpl();
          CarServidorDao carDao = new CarServidorDaoImpl();
          SistOperDao msoDao = new SistOperDaoImpl();
          
          this.serv.setRack(rackDao.getById(getIdRack()));
          this.serv.setSalaServ(salaDao.getById(getIdSalaServ()));
          this.serv.setCarServ(carDao.getById(getIdCarServ()));
          this.serv.setSistOper(msoDao.getById(getIdSistOper()));
          this.serv.setUsuario(usuarioDao.getById(getIdUsuario()));
          this.serv.setProveedor(iprovDao.getById(getIdProv()));
          this.serv.setTipoServ(tipoDao.getById(getIdTipoServ()));
          this.serv.setTipoServidor(tipoSDao.getById(getIdTipoServidor()));
          
          
           boolean ingresado = servDao.insert(this.serv);
          if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servidor ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servidor no ha sido ingresada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar" + ex.getMessage()));
        }
    }

    public List<SelectItem> listarTodo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ServidorDao servDao = new ServidorDaoImpl();
          for (Servidor servidor : servDao.getAll()) {
              listaServ.add(new SelectItem(servidor.getIdServ(), servidor.getNomServ()));
          }
          if (listaServ.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Servidor en el sistema"));
            } else {
                return listaServ;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Proveedores" + ex.getMessage()));
        
        }
        return null;
    }

    public void eliminarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServidorDao servDao = new ServidorDaoImpl();
            boolean eliminado = servDao.deleteById(idServ);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servidor eliminada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servidor no ha sido eliminada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar" + ex.getMessage()));
        }
    }

    public void modificarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ServidorDao servDao = new ServidorDaoImpl();
          Servidor servidor = servDao.getById(idServ);
          servidor.setNomServ(serv.getNomServ());
          servidor.setMarcaServ(serv.getMarcaServ());
          servidor.setModeloServ(serv.getModeloServ());
          boolean modificado = servDao.update(servidor);
          if (modificado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servidor modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servidor no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }
    }

    public void buscarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ServidorDao servDao = new ServidorDaoImpl();
          serv = servDao.getById(idServ);
          }
         catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void resetLista() {
        listaServ.clear();
    }

    public void reset() {
        this.serv.setNomServ(null);
    }

    public void cambioServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
          ServidorDao servDao = new ServidorDaoImpl();
          serv = servDao.getById(idServ);
          } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }
    
    public void limpiarIngresar() {
        this.serv.setNomServ(null);
        this.serv.setMarcaServ(null);
        this.serv.setModeloServ(null);
    }
    
    
    
}
