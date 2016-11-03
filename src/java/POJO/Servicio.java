package POJO;
// Generated 03-11-2016 5:17:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio  implements java.io.Serializable {


     private short idServicio;
     private String nomServicio;
     private Set sistemas = new HashSet(0);

    public Servicio() {
    }

	
    public Servicio(short idServicio, String nomServicio) {
        this.idServicio = idServicio;
        this.nomServicio = nomServicio;
    }
    public Servicio(short idServicio, String nomServicio, Set sistemas) {
       this.idServicio = idServicio;
       this.nomServicio = nomServicio;
       this.sistemas = sistemas;
    }
   
    public short getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(short idServicio) {
        this.idServicio = idServicio;
    }
    public String getNomServicio() {
        return this.nomServicio;
    }
    
    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }




}


