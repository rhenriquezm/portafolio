/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.NivSeg;
import POJO.NivSens;
import POJO.Organizacion;
import POJO.Perfil;
import POJO.Proveedor;
import POJO.Servidor;
import POJO.SistOper;
import POJO.Sistema;
import POJO.SoftBd;
import POJO.Usuario;
import POJO.Webservice;
import dao.NivSegDao;
import dao.NivSensDao;
import dao.OrganizacionDao;
import dao.PerfilDao;
import dao.ProveedorDao;
import dao.SistOperDao;
import dao.SistemaDao;
import dao.SoftBdDao;
import dao.UsuarioDao;
import dao.WebServiceDao;
import dao.impl.NivSegDaoImpl;
import dao.impl.NivSensDaoImpl;
import dao.impl.OrganizacionDaoImpl;
import dao.impl.PerfilDaoImpl;
import dao.impl.ProveedorDaoImpl;
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
import javax.jws.WebService;

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
    private short idOrganizacion;
    

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
        this.idOrganizacion = 0;
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

    public short getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(short idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
    
    

    //Personalizados...
    public void ingresarSistema() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            SistemaDao sisDao = new SistemaDaoImpl();            
            //Tenemos que traer los objetos para llenar esta tabla y poder hacer bien el insert
            //1)Instanciamos el objetoDao X
//OJOACA            ServidorDao servidorDao = new ServidorDaoImpl();
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
 //OJOACA           Servidor servidor = servidorDao.getById(getIdServidor());
            Usuario usuario = usuarioDao.getById(getIdUsuario());
            NivSeg nivseg = nivsegDao.getById(getIdNivSeg());
            NivSens nivsens = nivsensDao.getById(getIdNivSens());
            SistOper sistoper = sistoperDao.getById(getIdSistOper());
            Proveedor proveedor = proveedorDao.getById(getIdProveedor());
            SoftBd softbd = softbdDao.getById(getIdSoftBd());
            WebService webservice = (WebService) webserviceDao.getById(getIdWebservice());
            Organizacion organizacion = organizacionDao.getById(getIdOrganizacion());          
            //3) Modificamos el objeto que hasta el momento es null por el nuevo objeto que fuimos a busacr
            getSistema().setUsuario(usuario);
  //OJOACA          getSistema().setServidor(servidor);
            getSistema().setNivSeg(nivseg);
            getSistema().setNivSens(nivsens);
            getSistema().setSistOper(sistoper);
            getSistema().setProveedor(proveedor);
            getSistema().setSoftBd(softbd);
            getSistema().setWebservice((Webservice) webservice);
            getSistema().setOrganizacion(organizacion);
            
                    
            
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
            msis.setServidor(getSistema().getServidor());
            msis.setUsuario(getSistema().getUsuario());
            msis.setNivSeg(getSistema().getNivSeg());
            msis.setNivSens(getSistema().getNivSens());
            msis.setSistOper(getSistema().getSistOper());
            msis.setProveedor(getSistema().getProveedor());
            msis.setSoftBd(getSistema().getSoftBd());
            msis.setWebservice(getSistema().getWebservice());
            msis.setOrganizacion(getSistema().getOrganizacion());
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
            this.sistema = csisDao.getById(this.IdSist);

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresarSistema() {
        sistema.setNomSist(null);
        sistema.setServidor(null);
        sistema.setUsuario(null);
        sistema.setNivSeg(null);
        sistema.setNivSens(null);
        sistema.setSistOper(null);
        sistema.setProveedor(null);
        sistema.setSoftBd(null);
        sistema.setWebservice(null);
        sistema.setOrganizacion(null);
    }

//    public List<SelectItem> mostrarOrga() {
//        try {
//            OrganizacionDao orgDao = new OrganizacionDaoImpl();
//            ArrayList<SelectItem> orgnes = new ArrayList<>();
//            for (Organizacion organizacion : orgDao.getAll()) {
//                orgnes.add(new SelectItem(organizacion.getIdOrg(), organizacion.getNomOrg()));
//            }
//            return orgnes;
//
//        } catch (Exception e) {
//        }
//        return null;
//
//    }
//
//    public ArrayList<SelectItem> mostrarWebservice() {
//        try {
//            WebServiceDao webserviceDao = new WebServiceDaoImpl();
//            ArrayList<SelectItem> wss = new ArrayList<>();
//            for (Webservice webservice : webserviceDao.getAll()) {
//                wss.add(new SelectItem(webservice.getIdWebservice(), webservice.getNomWebservice()));
//            }
//            return wss;
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    public List<SelectItem> mostrarSoftBd() {
//        try {
//            SoftBdDao lsofDao = new SoftBdDaoImpl();
//            ArrayList<SelectItem> softwares = new ArrayList<>();
//            for (SoftBd softbd : lsofDao.getAll()) {
//                softwares.add(new SelectItem(softbd.getIdSoftBd(), softbd.getNomSoftBd()));
//            }
//            return softwares;
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    public List<SelectItem> mostrarProveedor() {
//        try {
//            ProveedorDao lprovDao = new ProveedorDaoImpl();
//            ArrayList<SelectItem> proveedores = new ArrayList<>();
//            for (Proveedor proveedor : lprovDao.getAll()) {
//                proveedores.add(new SelectItem(proveedor.getIdProv(), proveedor.getNomProv()));
//            }
//            return proveedores;
//
//        } catch (Exception e) {
//        }
//        return null;
//
//    }
//
//    public List<SelectItem> mostrarSistOper() {
//        try {
//            SistOperDao lsoDao = new SistOperDaoImpl();
//            ArrayList<SelectItem> sistoperativos = new ArrayList<>();
//            for (SistOper sistoper : lsoDao.getAll()) {
//                sistoperativos.add(new SelectItem(sistoper.getIdSo(), sistoper.getDesSo()));
//            }
//            return sistoperativos;
//
//        } catch (Exception e) {
//        }
//        return null;
//
//    }
//
//    public List<SelectItem> mostrarNivSens() {
//
//        try {
//            NivSensDao nssDao = new NivSensDaoImpl();
//            ArrayList<SelectItem> nivelesen = new ArrayList<>();
//            for (NivSens nivsens : nssDao.getAll()) {
//                nivelesen.add(new SelectItem(nivsens.getIdNivSens(), nivsens.getDescNivSens()));
//            }
//            return nivelesen;
//
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    public List<SelectItem> mostrarNivSeg() {
//        try {
//            NivSegDao nsegDao = new NivSegDaoImpl();
//            ArrayList<SelectItem> niveles = new ArrayList<>();
//            for (NivSeg nivseg : nsegDao.getAll()) {
//                niveles.add(new SelectItem(nivseg.getIdNivSeg(), nivseg.getDescNivSeg()));
//            }
//            return niveles;
//
//        } catch (Exception e) {
//        }
//        return null;
//    }
//
//    public ArrayList<SelectItem> mostrarPerfiles() {
//
//        try {
//            PerfilDao perfilDao = new PerfilDaoImpl();
//            ArrayList<SelectItem> perfiles = new ArrayList<>();
//            for (Perfil perfil : perfilDao.getAll()) {
//                perfiles.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
//            }
//            return perfiles;
//        } catch (Exception ex) {
//
//        }
//        return null;
//
//    }
}
