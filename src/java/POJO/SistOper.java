package POJO;
// Generated 20-10-2016 1:49:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * SistOper generated by hbm2java
 */
public class SistOper  implements java.io.Serializable {


     private short idSo;
     private String desSo;
     private Set sistemas = new HashSet(0);
     private Set servidors = new HashSet(0);

    public SistOper() {
    }

	
    public SistOper(short idSo, String desSo) {
        this.idSo = idSo;
        this.desSo = desSo;
    }
    public SistOper(short idSo, String desSo, Set sistemas, Set servidors) {
       this.idSo = idSo;
       this.desSo = desSo;
       this.sistemas = sistemas;
       this.servidors = servidors;
    }
   
    public short getIdSo() {
        return this.idSo;
    }
    
    public void setIdSo(short idSo) {
        this.idSo = idSo;
    }
    public String getDesSo() {
        return this.desSo;
    }
    
    public void setDesSo(String desSo) {
        this.desSo = desSo;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }
    public Set getServidors() {
        return this.servidors;
    }
    
    public void setServidors(Set servidors) {
        this.servidors = servidors;
    }




}

