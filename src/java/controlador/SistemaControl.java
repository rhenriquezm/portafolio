/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.LengDesSist;
import POJO.NivSeg;
import POJO.NivSens;
import POJO.Organizacion;
import POJO.Proveedor;
import POJO.Servicio;
import POJO.Servidor;
import POJO.SistOper;
import POJO.Sistema;
import POJO.SoftBd;
import POJO.Usuario;
import POJO.Webservice;
import dao.LengDesSistDao;
import dao.NivSegDao;
import dao.NivSensDao;
import dao.OrganizacionDao;
import dao.ProveedorDao;
import dao.ServicioDao;
import dao.ServidorDao;
import dao.SistOperDao;
import dao.SistemaDao;
import dao.SoftBdDao;
import dao.UnidadTrabajoDao;
import dao.UsuarioDao;
import dao.WebServiceDao;
import dao.impl.LengDesSistDaoImpl;
import dao.impl.NivSegDaoImpl;
import dao.impl.NivSensDaoImpl;
import dao.impl.OrganizacionDaoImpl;
import dao.impl.ProveedorDaoImpl;
import dao.impl.ServicioDaoImpl;
import dao.impl.ServidorDaoImpl;
import dao.impl.SistOperDaoImpl;
import dao.impl.SistemaDaoImpl;
import dao.impl.SoftBdDaoImpl;
import dao.impl.UnidadTrabajoDaoImpl;
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
    private short idOrganizacion;
    private short idLengDes;
    private short idServicio;

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
        this.idLengDes = 0;
        this.idServicio = 0;
    }

    public short getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(short idServicio) {
        this.idServicio = idServicio;
    }

    public short getIdSist() {
        return IdSist;
    }

    public void setIdSist(short IdSist) {
        this.IdSist = IdSist;
    }

    public short getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(short idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public short getIdLengDes() {
        return idLengDes;
    }

    public void setIdLengDes(short idLengDes) {
        this.idLengDes = idLengDes;
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

            ServidorDao servidorDao = new ServidorDaoImpl();
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            NivSegDao nivsegDao = new NivSegDaoImpl();
            NivSensDao nivsensDao = new NivSensDaoImpl();
            SistOperDao sistoperDao = new SistOperDaoImpl();
            ProveedorDao proveedorDao = new ProveedorDaoImpl();
            SoftBdDao softbdDao = new SoftBdDaoImpl();
            WebServiceDao webserviceDao = new WebServiceDaoImpl();
            OrganizacionDao organizacionDao = new OrganizacionDaoImpl();
            LengDesSistDao lengdesDao = new LengDesSistDaoImpl();
            ServicioDao servicioDao = new ServicioDaoImpl();

            this.sistema.setServidor(servidorDao.getById(getIdServidor()));
            this.sistema.setUsuario(usuarioDao.getById(getIdUsuario()));
            this.sistema.setNivSeg(nivsegDao.getById(getIdNivSeg()));
//            this.sistema.setNivSens(nivsensDao.getById(getIdNivSens()));
            this.sistema.setSistOper(sistoperDao.getById(getIdSistOper()));
            this.sistema.setProveedor(proveedorDao.getById(getIdProveedor()));
            this.sistema.setSoftBd(softbdDao.getById(getIdSoftBd()));
            this.sistema.setWebservice(webserviceDao.getById(getIdWebservice()));
            this.sistema.setOrganizacion(organizacionDao.getById(getIdOrganizacion()));
            this.sistema.setLengDesSist(lengdesDao.getById(getIdLengDes()));
            this.sistema.setServicio(servicioDao.getById(getIdServicio()));

            boolean ingresado = sisDao.insert(getSistema());
            if (ingresado) {
                LimpiarIngresarSistema();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema ingresado exitosamente"));
            } else if (this.idServidor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Servidor"));
            } else if (this.idUsuario == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Usuario"));
            } else if (this.idNivSeg == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Nivel de Seguridad"));
//            } else if (this.idNivSens == 0) {
//                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema"));
            } else if (this.idSistOper == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema Operativo"));
            } else if (this.idProveedor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Proveedor"));
            } else if (this.idSoftBd == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Software de BD"));
            } else if (this.idWebservice == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Web Service"));
            } else if (this.idOrganizacion == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione una Organizacion"));
            } else if (this.idLengDes == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Lenguaje de Desarrollo"));
            } else if (this.idServicio == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Servicio"));

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

            SistemaDao sisDao = new SistemaDaoImpl();
            Sistema sis = sisDao.getById(getIdSist());

            sis.setNomSist(sistema.getNomSist());
            sis.setUnIntResp(sistema.getUnIntResp());
            sis.setUtIntResp(sistema.getUtIntResp());
            sis.setUnExtResp(sistema.getUnExtResp());

            // Weon el if esta bien por que para poder buscar monos qls las weas deben ser disntas de cero (TODAS) y es asi
            //Sin embarhgo la weá se cae igual wn!!! NO ENTIENDO ya filo con la wea no nos ahoguemos
            //deja darle la ultima revisá
            
            if (getIdServidor() != 0 && getIdUsuario() != 0 && getIdNivSeg() != 0 && getIdSistOper() != 0
                    && getIdProveedor() != 0 && getIdSoftBd() != 0 && getIdWebservice() != 0
                    && getIdProveedor() != 0 && getIdSoftBd() != 0 && getIdWebservice() != 0
                    && getIdOrganizacion() != 0 && getIdLengDes() != 0 && getIdServicio() != 0) {//la tenia hecha esta wea ajkajakjkajka)

                System.out.println("ENTRO AQUÍ Y NO DEBERIAAAAAAAAAAAAAAAAAAA"); //No veo el log del glassfish nose qe xuxa
                // weon subelo tal cual y lo reviso acá
                
                ServidorDao servidorDao = new ServidorDaoImpl();
                sis.setServidor(servidorDao.getById(getIdServidor()));

                UsuarioDao usuarioDao = new UsuarioDaoImpl();
                sis.setUsuario(usuarioDao.getById(getIdUsuario()));

                NivSegDao nivsegDao = new NivSegDaoImpl();
                sis.setNivSeg(nivsegDao.getById(getIdNivSeg()));

                //NivSensDao nivsensDao = new NivSensDaoImpl();
                //this.sistema.setNivSens(nivsensDao.getById(getIdNivSens()));
                SistOperDao sistoperDao = new SistOperDaoImpl();
                sis.setSistOper(sistoperDao.getById(getIdSistOper()));

                ProveedorDao proveedorDao = new ProveedorDaoImpl();
                sis.setProveedor(proveedorDao.getById(getIdProveedor()));

                SoftBdDao softbdDao = new SoftBdDaoImpl();
                sis.setSoftBd(softbdDao.getById(getIdSoftBd()));

                WebServiceDao webserviceDao = new WebServiceDaoImpl();
                sis.setWebservice(webserviceDao.getById(getIdWebservice()));

                OrganizacionDao organizacionDao = new OrganizacionDaoImpl();
                sis.setOrganizacion(organizacionDao.getById(getIdOrganizacion()));

                LengDesSistDao lengdesDao = new LengDesSistDaoImpl();
                sis.setLengDesSist(lengdesDao.getById(getIdLengDes()));

                ServicioDao servicioDao = new ServicioDaoImpl();
                sis.setServicio(servicioDao.getById(getIdServicio()));
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Ingresar Datos COMBOBOBOBOBOX"));
            }
            boolean modificar = sisDao.update(sis);
            if (modificar) { // Calmao es que los errores son por que trae datos nulos, es ahi el error... va a buscar a la bd weas con id = 0 por eso se cae...  dejame pensar que podemos hacer
                LimpiarIngresarSistema();
                
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema modificado exitosamente"));
            } else if (this.idServidor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Servidor"));
            } else if (this.idUsuario == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Usuario"));
            } else if (this.idNivSeg == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Nivel de Seguridad"));
//            } else if (this.idNivSens == 0) {
//                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema"));
            } else if (this.idSistOper == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Sistema Operativo"));
            } else if (this.idProveedor == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Proveedor"));
            } else if (this.idSoftBd == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Software de BD"));
            } else if (this.idWebservice == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Web Service"));
            } else if (this.idOrganizacion == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione una Organizacion"));
            } else if (this.idLengDes == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Lenguaje de Desarrollo"));
            } else if (this.idServicio == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione un Servicio"));

            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser modificado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha  ocurrido un error al modificar " + ex.getMessage()));

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
            ArrayList<SelectItem> listaSis = new ArrayList<>();
            for (Sistema sistema : lsisDao.getAll()) {
                listaSis.add(new SelectItem(sistema.getIdSist(), sistema.getNomSist()));
            }
            if (listaSis.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Sistema Ingresados en el sistema"));

            } else {
                return listaSis;
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

            setSistema(csisDao.getById(getIdSist()));
            setIdServidor(getSistema().getServidor().getIdServ());
            setIdUsuario(getSistema().getUsuario().getIdUsuario());
            setIdNivSeg(getSistema().getNivSeg().getIdNivSeg());
            //setIdNivSens(getSistema().getNivSens().getIdNivSens)
            setIdSistOper(getSistema().getSistOper().getIdSo());
            setIdProveedor(getSistema().getProveedor().getIdProv());
            setIdSoftBd(getSistema().getSoftBd().getIdSoftBd());
            setIdWebservice(getSistema().getWebservice().getIdWebservice());
            setIdOrganizacion(getSistema().getOrganizacion().getIdOrg());
            setIdLengDes(getSistema().getLengDesSist().getIdLengSist());
            setIdServicio(getSistema().getServicio().getIdServicio());

        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));

        }
    }

    public void LimpiarIngresarSistema() {
        sistema.setIdSist((short) 0);
        sistema.setNomSist(null);
        sistema.setUnIntResp(null);
        sistema.setUtIntResp(null);
        sistema.setUnExtResp(null);
        setIdSist((short) 0);
        setIdServidor((short) 0);
        setIdUsuario((short) 0);
        setIdNivSeg((short) 0);
        //setIdNivSens((short)0);
        setIdSistOper((short) 0);
        setIdProveedor((short) 0);
        setIdSoftBd((short) 0);
        setIdWebservice((short) 0);
        setIdOrganizacion((short) 0);
        setIdLengDes((short) 0);
        setIdServicio((short) 0);
    }

}
