/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.NivSeg;
import POJO.NivSens;
import POJO.Organizacion;
import POJO.Proveedor;
import POJO.Servidor;
import POJO.SistOper;
import POJO.Sistema;
import POJO.SoftBd;
import POJO.Usuario;
import dao.NivSegDao;
import dao.NivSensDao;
import dao.OrganizacionDao;
import dao.ProveedorDao;
import dao.ServidorDao;
import dao.SistOperDao;
import dao.SistemaDao;
import dao.SoftBdDao;
import dao.UsuarioDao;
import dao.WebServiceDao;
import dao.impl.NivSegDaoImpl;
import dao.impl.NivSensDaoImpl;
import dao.impl.OrganizacionDaoImpl;
import dao.impl.ProveedorDaoImpl;
import dao.impl.ServidorDaoImpl;
import dao.impl.SistOperDaoImpl;
import dao.impl.SistemaDaoImpl;
import dao.impl.SoftBdDaoImpl;
import dao.impl.UsuarioDaoImpl;
import dao.impl.WebServiceDaoImpl;
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
public class SistemaControl {

    private Sistema sistema;
    private short IdSist;
    private short idServidor;
    private short idUsuario;
    private short idNivSeg;
    private short idNivSens;
    private short idSistOper;
    private short idProveedor;
    private short idSoftBd;
    private short idWebservice;

    public SistemaControl() {
        this.sistema = new Sistema();
        this.IdSist = 0;
        this.idServidor = 0;
        this.idUsuario = 0;
        this.idNivSeg = 0;
        this.idNivSens = 0;
        this.idSistOper = 0;
        this.idProveedor = 0;
        this.idSoftBd = 0;
        this.idWebservice = 0;
    }

    public short getIdSist() {
        return IdSist;
    }

    public void setIdSist(short IdSist) {
        this.IdSist = IdSist;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public short getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(short idServidor) {
        this.idServidor = idServidor;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public short getIdNivSeg() {
        return idNivSeg;
    }

    public void setIdNivSeg(short idNivSeg) {
        this.idNivSeg = idNivSeg;
    }

    public short getIdNivSens() {
        return idNivSens;
    }

    public void setIdNivSens(short idNivSens) {
        this.idNivSens = idNivSens;
    }

    public short getIdSistOper() {
        return idSistOper;
    }

    public void setIdSistOper(short idSistOper) {
        this.idSistOper = idSistOper;
    }

    public short getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(short idProveedor) {
        this.idProveedor = idProveedor;
    }

    public short getIdSoftBd() {
        return idSoftBd;
    }

    public void setIdSoftBd(short idSoftBd) {
        this.idSoftBd = idSoftBd;
    }

    public short getIdWebservice() {
        return idWebservice;
    }

    public void setIdWebservice(short idWebservice) {
        this.idWebservice = idWebservice;
    }

    //Personalizados...
    public void ingresarSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao sisDao = new SistemaDaoImpl();
            //Tenemos que traer los objetos para llenar esta tabla y poder hacer bien el insert
            //1)Instanciamos el objetoDao X
            ServidorDao servidorDao = new ServidorDaoImpl();
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            NivSegDao nivsegDao = new NivSegDaoImpl();
            NivSensDao nivsensDao = new NivSensDaoImpl();
            SistOperDao sistoperDao = new SistOperDaoImpl();
            ProveedorDao proveedorDao = new ProveedorDaoImpl();
            SoftBdDao softbdDao = new SoftBdDaoImpl();
            WebServiceDao webserviceDao = new WebServiceDaoImpl();
            OrganizacionDao organizacionDao = new OrganizacionDaoImpl();
            //2) Instanciamos el objeto POJO y le asignamos un objeto que buscaremos a traves del ID que declaraste
            // al comiezo
            Usuario usuario = usuarioDao.getById(getIdUsuario());
            NivSeg nivseg = nivsegDao.getById(getIdNivSeg());
            NivSens nivsens = nivsensDao.getById(getIdNivSens());
            SistOper sistoper = sistoperDao.getById(getIdSistOper());
            Proveedor proveedor = proveedorDao.getById(getIdProveedor());
            SoftBd softbd = softbdDao.getById(getIdSoftBd());
            //WebService webservice = webserviceDao.getById(getIdWebservice());
            //3) Modificamos el objeto que hasta el momento es null por el nuevo objeto que fuimos a busacr
            getSistema().setUsuario(usuario);
            getSistema().setNivSeg(nivseg);
            getSistema().setNivSens(nivsens);
            getSistema().setSistOper(sistoper);
            getSistema().setProveedor(proveedor);
            getSistema().setSoftBd(softbd);
//            getSistema().setWebservice((Webservice) webservice);

            boolean ingresado = sisDao.insert(getSistema());
            if (ingresado) {
                LimpiarIngresarSistema();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

        }
    }

    public void modificarSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao msisDao = new SistemaDaoImpl();
            Sistema msis = msisDao.getById(getIdSist());

            msis.setNomSist(getSistema().getNomSist());

            
            UsuarioDao us = new UsuarioDaoImpl();
            msis.setUsuario(us.getById(getIdUsuario()));
            
            NivSegDao niv = new NivSegDaoImpl();
            msis.setNivSeg(niv.getById(getIdNivSeg()));
            
            NivSensDao nivS = new NivSensDaoImpl();
            msis.setNivSens(nivS.getById(getIdNivSens()));
            
            SistOperDao soDao = new SistOperDaoImpl();
            msis.setSistOper(soDao.getById(getIdSistOper()));
            
            ProveedorDao proDao = new ProveedorDaoImpl();
            msis.setProveedor(proDao.getById(getIdProveedor()));
            
            SoftBdDao softDao = new SoftBdDaoImpl();
            msis.setSoftBd(softDao.getById(getIdSoftBd()));
            
            boolean modificar = msisDao.update(msis);
            if (modificar) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema modificado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar " + ex.getMessage()));

        }
    }

    public void eliminarSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao esisDao = new SistemaDaoImpl();
            boolean eliminado = esisDao.deleteById(this.IdSist);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema eliminado exitosamente"));

            } else if (this.IdSist == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser eliminado exitosamente"));

            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));

        }
    }

    public List<SelectItem> mostrarSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao lsisDao = new SistemaDaoImpl();
            ArrayList<SelectItem> sistemas = new ArrayList<>();
            for (Sistema sistema : lsisDao.getAll()) {
                sistemas.add(new SelectItem(sistema.getIdSist(), sistema.getNomSist()));
            }
            if (sistemas.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Sistema Ingresados en el sistema"));

            } else {
                return sistemas;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public void cambioSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao csisDao = new SistemaDaoImpl();
            this.sistema = csisDao.getById(getIdSist());
            setIdNivSeg(this.sistema.getNivSeg().getIdNivSeg());
            setIdNivSens(this.sistema.getNivSens().getIdNivSens());
            setIdProveedor(this.sistema.getProveedor().getIdProv());
            setIdSistOper(this.sistema.getSistOper().getIdSo());
            setIdSoftBd(this.sistema.getSoftBd().getIdSoftBd());
            setIdUsuario(this.sistema.getUsuario().getIdUsuario());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresarSistema() {
        sistema.setNomSist(null);
        sistema.setUsuario(null);
        sistema.setNivSeg(null);
        sistema.setNivSens(null);
        sistema.setSistOper(null);
        sistema.setProveedor(null);
        sistema.setSoftBd(null);
        sistema.setWebservice(null);
    }

}
