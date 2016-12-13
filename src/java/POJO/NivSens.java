package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * NivSens generated by hbm2java
 */
public class NivSens  implements java.io.Serializable {


     private short idNivSens;
     private String descNivSens;
     private Set sistemas = new HashSet(0);

    public NivSens() {
    }

	
    public NivSens(short idNivSens, String descNivSens) {
        this.idNivSens = idNivSens;
        this.descNivSens = descNivSens;
    }
    public NivSens(short idNivSens, String descNivSens, Set sistemas) {
       this.idNivSens = idNivSens;
       this.descNivSens = descNivSens;
       this.sistemas = sistemas;
    }
   
    public short getIdNivSens() {
        return this.idNivSens;
    }
    
    public void setIdNivSens(short idNivSens) {
        this.idNivSens = idNivSens;
    }
    public String getDescNivSens() {
        return this.descNivSens;
    }
    
    public void setDescNivSens(String descNivSens) {
        this.descNivSens = descNivSens;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }




}


