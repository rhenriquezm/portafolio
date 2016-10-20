package POJO;
// Generated 20-10-2016 1:49:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TipoServ generated by hbm2java
 */
public class TipoServ  implements java.io.Serializable {


     private short idTipoServ;
     private String descTipo;
     private String passAdmin;
     private String usBd;
     private String passBd;
     private Set servidors = new HashSet(0);

    public TipoServ() {
    }

	
    public TipoServ(short idTipoServ, String descTipo, String passAdmin, String usBd, String passBd) {
        this.idTipoServ = idTipoServ;
        this.descTipo = descTipo;
        this.passAdmin = passAdmin;
        this.usBd = usBd;
        this.passBd = passBd;
    }
    public TipoServ(short idTipoServ, String descTipo, String passAdmin, String usBd, String passBd, Set servidors) {
       this.idTipoServ = idTipoServ;
       this.descTipo = descTipo;
       this.passAdmin = passAdmin;
       this.usBd = usBd;
       this.passBd = passBd;
       this.servidors = servidors;
    }
   
    public short getIdTipoServ() {
        return this.idTipoServ;
    }
    
    public void setIdTipoServ(short idTipoServ) {
        this.idTipoServ = idTipoServ;
    }
    public String getDescTipo() {
        return this.descTipo;
    }
    
    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }
    public String getPassAdmin() {
        return this.passAdmin;
    }
    
    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }
    public String getUsBd() {
        return this.usBd;
    }
    
    public void setUsBd(String usBd) {
        this.usBd = usBd;
    }
    public String getPassBd() {
        return this.passBd;
    }
    
    public void setPassBd(String passBd) {
        this.passBd = passBd;
    }
    public Set getServidors() {
        return this.servidors;
    }
    
    public void setServidors(Set servidors) {
        this.servidors = servidors;
    }




}


