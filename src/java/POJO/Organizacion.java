package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Organizacion generated by hbm2java
 */
public class Organizacion  implements java.io.Serializable {


     private short idOrg;
     private String nomOrg;
     private String rutOrg;
     private String rubroOrg;
     private String correoOrg;
     private Integer fonoOrg;
     private Set sistemas = new HashSet(0);

    public Organizacion() {
    }

	
    public Organizacion(short idOrg, String nomOrg, String rutOrg, String rubroOrg, String correoOrg, Integer fonoOrg) {
        this.idOrg = idOrg;
        this.nomOrg = nomOrg;
        this.rutOrg = rutOrg;
        this.rubroOrg = rubroOrg;
        this.correoOrg = correoOrg;
        this.fonoOrg = fonoOrg;
    }
    public Organizacion(short idOrg, String nomOrg, String rutOrg, String rubroOrg, String correoOrg, Integer fonoOrg, Set sistemas) {
       this.idOrg = idOrg;
       this.nomOrg = nomOrg;
       this.rutOrg = rutOrg;
       this.rubroOrg = rubroOrg;
       this.correoOrg = correoOrg;
       this.fonoOrg = fonoOrg;
       this.sistemas = sistemas;
    }
   
    public short getIdOrg() {
        return this.idOrg;
    }
    
    public void setIdOrg(short idOrg) {
        this.idOrg = idOrg;
    }
    public String getNomOrg() {
        return this.nomOrg;
    }
    
    public void setNomOrg(String nomOrg) {
        this.nomOrg = nomOrg;
    }
    public String getRutOrg() {
        return this.rutOrg;
    }
    
    public void setRutOrg(String rutOrg) {
        this.rutOrg = rutOrg;
    }
    public String getRubroOrg() {
        return this.rubroOrg;
    }
    
    public void setRubroOrg(String rubroOrg) {
        this.rubroOrg = rubroOrg;
    }
    public String getCorreoOrg() {
        return this.correoOrg;
    }
    
    public void setCorreoOrg(String correoOrg) {
        this.correoOrg = correoOrg;
    }
    public Integer getFonoOrg() {
        return this.fonoOrg;
    }
    
    public void setFonoOrg(Integer fonoOrg) {
        this.fonoOrg = fonoOrg;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }




}


