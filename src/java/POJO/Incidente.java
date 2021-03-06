package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1



/**
 * Incidente generated by hbm2java
 */
public class Incidente  implements java.io.Serializable {


     private short idIncidente;
     private Servidor servidor;
     private Sistema sistema;
     private UnidadTrabajo unidadTrabajo;
     private String probIncid;
     private String solIncid;
     private Short TInacIncid;
     private Character activoIncid;
     private String fechaSolucion;
     private String fechaProblema;
     private String horaProblema;
     private String horaSolucion;
     private String codigoSeg;

    public Incidente() {
    }

	
    public Incidente(short idIncidente, String probIncid) {
        this.idIncidente = idIncidente;
        this.probIncid = probIncid;
    }
    public Incidente(short idIncidente, Servidor servidor, Sistema sistema, UnidadTrabajo unidadTrabajo, String probIncid, String solIncid, Short TInacIncid, Character activoIncid, String fechaSolucion, String fechaProblema, String horaProblema, String horaSolucion, String codigoSeg) {
       this.idIncidente = idIncidente;
       this.servidor = servidor;
       this.sistema = sistema;
       this.unidadTrabajo = unidadTrabajo;
       this.probIncid = probIncid;
       this.solIncid = solIncid;
       this.TInacIncid = TInacIncid;
       this.activoIncid = activoIncid;
       this.fechaSolucion = fechaSolucion;
       this.fechaProblema = fechaProblema;
       this.horaProblema = horaProblema;
       this.horaSolucion = horaSolucion;
       this.codigoSeg = codigoSeg;
    }
   
    public short getIdIncidente() {
        return this.idIncidente;
    }
    
    public void setIdIncidente(short idIncidente) {
        this.idIncidente = idIncidente;
    }
    public Servidor getServidor() {
        return this.servidor;
    }
    
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
    public Sistema getSistema() {
        return this.sistema;
    }
    
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    public UnidadTrabajo getUnidadTrabajo() {
        return this.unidadTrabajo;
    }
    
    public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
        this.unidadTrabajo = unidadTrabajo;
    }
    public String getProbIncid() {
        return this.probIncid;
    }
    
    public void setProbIncid(String probIncid) {
        this.probIncid = probIncid;
    }
    public String getSolIncid() {
        return this.solIncid;
    }
    
    public void setSolIncid(String solIncid) {
        this.solIncid = solIncid;
    }
    public Short getTInacIncid() {
        return this.TInacIncid;
    }
    
    public void setTInacIncid(Short TInacIncid) {
        this.TInacIncid = TInacIncid;
    }
    public Character getActivoIncid() {
        return this.activoIncid;
    }
    
    public void setActivoIncid(Character activoIncid) {
        this.activoIncid = activoIncid;
    }
    public String getFechaSolucion() {
        return this.fechaSolucion;
    }
    
    public void setFechaSolucion(String fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }
    public String getFechaProblema() {
        return this.fechaProblema;
    }
    
    public void setFechaProblema(String fechaProblema) {
        this.fechaProblema = fechaProblema;
    }
    public String getHoraProblema() {
        return this.horaProblema;
    }
    
    public void setHoraProblema(String horaProblema) {
        this.horaProblema = horaProblema;
    }
    public String getHoraSolucion() {
        return this.horaSolucion;
    }
    
    public void setHoraSolucion(String horaSolucion) {
        this.horaSolucion = horaSolucion;
    }
    public String getCodigoSeg() {
        return this.codigoSeg;
    }
    
    public void setCodigoSeg(String codigoSeg) {
        this.codigoSeg = codigoSeg;
    }




}


