/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.DirIp;
import POJO.Garantia;
import POJO.Proveedor;
import POJO.Rack;
import POJO.Servidor;
import POJO.SistOper;
import POJO.Usuario;
import dao.DirIpDao;
import dao.GarantiaDao;
import dao.ProveedorDao;
import dao.RackDao;
import dao.ServidorDao;
import dao.SistOperDao;
import dao.UsuarioDao;
import dao.impl.DirIpDaoImpl;
import dao.impl.GarantiaDaoImpl;
import dao.impl.ProveedorDaoImpl;
import dao.impl.RackDaoImpl;
import dao.impl.ServidorDaoImpl;
import dao.impl.SistOperDaoImpl;
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

    private Servidor serv;
    private short idServ;
    private short idUsuario;
    private short idProv;
    private short idSistOper;
    private short idRack;
    private short idIp;
    private short idGarantia;

    public ServidorControl() {
        this.serv = new Servidor();
        this.idServ = 0;
        this.idRack = 0;
        this.idUsuario = 0;
        this.idProv = 0;
        this.idSistOper = 0;
        this.idGarantia = 0;
        this.idIp = 0;

    }

    public short getIdIp() {
        return idIp;
    }

    public void setIdIp(short idIp) {
        this.idIp = idIp;
    }

    public short getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(short idGarantia) {
        this.idGarantia = idGarantia;
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

    public short getIdSistOper() {
        return idSistOper;
    }

    public void setIdSistOper(short idSistOper) {
        this.idSistOper = idSistOper;
    }

    public Servidor getServ() {
        return serv;
    }

    public void setServ(Servidor serv) {
        this.serv = serv;
    }

    //Metodos Personalizados
    public void ingresarServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServidorDao servDao = new ServidorDaoImpl();

            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            ProveedorDao iprovDao = new ProveedorDaoImpl();
            SistOperDao msoDao = new SistOperDaoImpl();
            RackDao rackDao = new RackDaoImpl();
            DirIpDao dipDao = new DirIpDaoImpl();
            GarantiaDao garDao = new GarantiaDaoImpl();

            this.serv.setRack(rackDao.getById(getIdRack()));
            this.serv.setSistOper(msoDao.getById(getIdSistOper()));
            this.serv.setUsuario(usuarioDao.getById(getIdUsuario()));
            this.serv.setProveedor(iprovDao.getById(getIdProv()));
            this.serv.setDirIp(dipDao.getById(getIdIp()));
            this.serv.setGarantia(garDao.getById(getIdGarantia()));

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
            ArrayList<SelectItem> listaServ = new ArrayList<>();
            for (Servidor servi : servDao.getAll()) {
                listaServ.add(new SelectItem(servi.getIdServ(), servi.getNomServ()));
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
            boolean eliminado = servDao.deleteById(this.idServ);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servidor eliminada exitosamente"));
            } else if (this.idServ == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Servidor "));
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
            Servidor servidor = servDao.getById(getIdServ());

            servidor.setNomServ(serv.getNomServ());
            servidor.setMarcaServ(serv.getMarcaServ());
            servidor.setModeloServ(serv.getModeloServ());
            servidor.setTamMemoria(serv.getTamMemoria());
            servidor.setTamDisco(serv.getTamDisco());
            servidor.setPassAdmin(serv.getPassAdmin());
            servidor.setUserBd(serv.getUserBd());
            servidor.setPassBd(serv.getPassBd());

            RackDao rackDao = new RackDaoImpl();
            servidor.setRack(rackDao.getById(getIdRack()));

            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            servidor.setUsuario(usuarioDao.getById(getIdUsuario()));

            ProveedorDao iprovDao = new ProveedorDaoImpl();
            servidor.setProveedor(iprovDao.getById(getIdProv()));

            SistOperDao msoDao = new SistOperDaoImpl();
            servidor.setSistOper(msoDao.getById(getIdSistOper()));

            DirIpDao dipDao = new DirIpDaoImpl();
            servidor.setDirIp(dipDao.getById(getIdIp()));

            GarantiaDao garDao = new GarantiaDaoImpl();
            servidor.setGarantia(garDao.getById(getIdGarantia()));

            boolean modificado = servDao.update(servidor);
            if (modificado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Servidor modificada exitosamente"));
            } else if (this.idUsuario == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Usuario"));
            } else if (this.idProv == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Proveedor"));
            } else if (this.idSistOper == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Sistema Operativo"));
            } else if (this.idRack == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Rack"));
            } else if (this.idIp == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Direccion IP"));
            } else if (this.idGarantia == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Garantia"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Servidor no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }
    }

    public void cambioServidor() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            ServidorDao servDao = new ServidorDaoImpl();
            setServ(servDao.getById(getIdServ()));
            setIdUsuario(getServ().getUsuario().getIdUsuario());
            setIdProv(getServ().getProveedor().getIdProv());
            setIdSistOper(getServ().getSistOper().getIdSo());
            setIdRack(getServ().getRack().getIdRack());
            setIdIp(getServ().getDirIp().getIdDir());
            setIdGarantia(getServ().getGarantia().getIdGar());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }

    public void limpiarIngresar() {
        serv.setNomServ(null);
        serv.setMarcaServ(null);
        serv.setModeloServ(null);
        serv.setTamMemoria(0);
        serv.setTamDisco(0);
        serv.setPassAdmin(null);
        serv.setUserBd(null);
        serv.setPassBd(null);
        setIdServ((short) 0);
        setIdUsuario((short) 0);
        setIdProv((short) 0);
        setIdSistOper((short) 0);
        setIdRack((short) 0);
        setIdIp((short) 0);
        setIdGarantia((short) 0);
        serv.setIdServ((short) 0);

    }

}
