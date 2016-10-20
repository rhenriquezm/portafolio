package POJO;
// Generated 20-10-2016 1:49:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private short idPerfil;
     private String nomPerfil;
     private String descPerfil;
     private Set usuarios = new HashSet(0);

    public Perfil() {
    }

	
    public Perfil(short idPerfil, String nomPerfil, String descPerfil) {
        this.idPerfil = idPerfil;
        this.nomPerfil = nomPerfil;
        this.descPerfil = descPerfil;
    }
    public Perfil(short idPerfil, String nomPerfil, String descPerfil, Set usuarios) {
       this.idPerfil = idPerfil;
       this.nomPerfil = nomPerfil;
       this.descPerfil = descPerfil;
       this.usuarios = usuarios;
    }
   
    public short getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(short idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNomPerfil() {
        return this.nomPerfil;
    }
    
    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }
    public String getDescPerfil() {
        return this.descPerfil;
    }
    
    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}

