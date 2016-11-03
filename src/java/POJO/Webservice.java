package POJO;
// Generated 03-11-2016 5:17:04 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Webservice generated by hbm2java
 */
public class Webservice  implements java.io.Serializable {


     private short idWebservice;
     private String nomWebservice;
     private String protWebservice;
     private Set sistemas = new HashSet(0);

    public Webservice() {
    }

	
    public Webservice(short idWebservice, String nomWebservice, String protWebservice) {
        this.idWebservice = idWebservice;
        this.nomWebservice = nomWebservice;
        this.protWebservice = protWebservice;
    }
    public Webservice(short idWebservice, String nomWebservice, String protWebservice, Set sistemas) {
       this.idWebservice = idWebservice;
       this.nomWebservice = nomWebservice;
       this.protWebservice = protWebservice;
       this.sistemas = sistemas;
    }
   
    public short getIdWebservice() {
        return this.idWebservice;
    }
    
    public void setIdWebservice(short idWebservice) {
        this.idWebservice = idWebservice;
    }
    public String getNomWebservice() {
        return this.nomWebservice;
    }
    
    public void setNomWebservice(String nomWebservice) {
        this.nomWebservice = nomWebservice;
    }
    public String getProtWebservice() {
        return this.protWebservice;
    }
    
    public void setProtWebservice(String protWebservice) {
        this.protWebservice = protWebservice;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }




}


