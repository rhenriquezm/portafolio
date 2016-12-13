package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Rack generated by hbm2java
 */
public class Rack  implements java.io.Serializable {


     private short idRack;
     private SalaServ salaServ;
     private String nombreRack;
     private Set servidors = new HashSet(0);

    public Rack() {
    }

	
    public Rack(short idRack, String nombreRack) {
        this.idRack = idRack;
        this.nombreRack = nombreRack;
    }
    public Rack(short idRack, SalaServ salaServ, String nombreRack, Set servidors) {
       this.idRack = idRack;
       this.salaServ = salaServ;
       this.nombreRack = nombreRack;
       this.servidors = servidors;
    }
   
    public short getIdRack() {
        return this.idRack;
    }
    
    public void setIdRack(short idRack) {
        this.idRack = idRack;
    }
    public SalaServ getSalaServ() {
        return this.salaServ;
    }
    
    public void setSalaServ(SalaServ salaServ) {
        this.salaServ = salaServ;
    }
    public String getNombreRack() {
        return this.nombreRack;
    }
    
    public void setNombreRack(String nombreRack) {
        this.nombreRack = nombreRack;
    }
    public Set getServidors() {
        return this.servidors;
    }
    
    public void setServidors(Set servidors) {
        this.servidors = servidors;
    }




}


