package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Sistema generated by hbm2java
 */
public class Sistema  implements java.io.Serializable {


     private short idSist;
     private LengDesSist lengDesSist;
     private NivSeg nivSeg;
     private NivSens nivSens;
     private Organizacion organizacion;
     private Proveedor proveedor;
     private Servicio servicio;
     private Servidor servidor;
     private SistOper sistOper;
     private SoftBd softBd;
     private Usuario usuario;
     private Webservice webservice;
     private String nomSist;
     private String unIntResp;
     private String utIntResp;
     private String unExtResp;
     private Set incidentes = new HashSet(0);

    public Sistema() {
    }

	
    public Sistema(short idSist, String nomSist) {
        this.idSist = idSist;
        this.nomSist = nomSist;
    }
    public Sistema(short idSist, LengDesSist lengDesSist, NivSeg nivSeg, NivSens nivSens, Organizacion organizacion, Proveedor proveedor, Servicio servicio, Servidor servidor, SistOper sistOper, SoftBd softBd, Usuario usuario, Webservice webservice, String nomSist, String unIntResp, String utIntResp, String unExtResp, Set incidentes) {
       this.idSist = idSist;
       this.lengDesSist = lengDesSist;
       this.nivSeg = nivSeg;
       this.nivSens = nivSens;
       this.organizacion = organizacion;
       this.proveedor = proveedor;
       this.servicio = servicio;
       this.servidor = servidor;
       this.sistOper = sistOper;
       this.softBd = softBd;
       this.usuario = usuario;
       this.webservice = webservice;
       this.nomSist = nomSist;
       this.unIntResp = unIntResp;
       this.utIntResp = utIntResp;
       this.unExtResp = unExtResp;
       this.incidentes = incidentes;
    }
   
    public short getIdSist() {
        return this.idSist;
    }
    
    public void setIdSist(short idSist) {
        this.idSist = idSist;
    }
    public LengDesSist getLengDesSist() {
        return this.lengDesSist;
    }
    
    public void setLengDesSist(LengDesSist lengDesSist) {
        this.lengDesSist = lengDesSist;
    }
    public NivSeg getNivSeg() {
        return this.nivSeg;
    }
    
    public void setNivSeg(NivSeg nivSeg) {
        this.nivSeg = nivSeg;
    }
    public NivSens getNivSens() {
        return this.nivSens;
    }
    
    public void setNivSens(NivSens nivSens) {
        this.nivSens = nivSens;
    }
    public Organizacion getOrganizacion() {
        return this.organizacion;
    }
    
    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Servidor getServidor() {
        return this.servidor;
    }
    
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
    public SistOper getSistOper() {
        return this.sistOper;
    }
    
    public void setSistOper(SistOper sistOper) {
        this.sistOper = sistOper;
    }
    public SoftBd getSoftBd() {
        return this.softBd;
    }
    
    public void setSoftBd(SoftBd softBd) {
        this.softBd = softBd;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Webservice getWebservice() {
        return this.webservice;
    }
    
    public void setWebservice(Webservice webservice) {
        this.webservice = webservice;
    }
    public String getNomSist() {
        return this.nomSist;
    }
    
    public void setNomSist(String nomSist) {
        this.nomSist = nomSist;
    }
    public String getUnIntResp() {
        return this.unIntResp;
    }
    
    public void setUnIntResp(String unIntResp) {
        this.unIntResp = unIntResp;
    }
    public String getUtIntResp() {
        return this.utIntResp;
    }
    
    public void setUtIntResp(String utIntResp) {
        this.utIntResp = utIntResp;
    }
    public String getUnExtResp() {
        return this.unExtResp;
    }
    
    public void setUnExtResp(String unExtResp) {
        this.unExtResp = unExtResp;
    }
    public Set getIncidentes() {
        return this.incidentes;
    }
    
    public void setIncidentes(Set incidentes) {
        this.incidentes = incidentes;
    }




}


