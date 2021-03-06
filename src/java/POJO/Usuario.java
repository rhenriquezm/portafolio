package POJO;
// Generated 06-12-2016 23:27:57 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private short idUsuario;
     private Perfil perfil;
     private UnidadTrabajo unidadTrabajo;
     private String userUsuario;
     private String passUsuario;
     private String rutUsuario;
     private String nomUsuario;
     private String patUsuario;
     private String matUsuario;
     private char sexoUsuario;
     private String correoUsuario;
     private Integer fonoUsuario;
     private Set servidors = new HashSet(0);
     private Set sistemas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(short idUsuario, String userUsuario, String passUsuario, String rutUsuario, char dvUsuario, String nomUsuario, String patUsuario, String matUsuario, char sexoUsuario, String correoUsuario, Integer fonoUsuario) {
        this.idUsuario = idUsuario;
        this.userUsuario = userUsuario;
        this.passUsuario = passUsuario;
        this.rutUsuario = rutUsuario;
        this.nomUsuario = nomUsuario;
        this.patUsuario = patUsuario;
        this.matUsuario = matUsuario;
        this.sexoUsuario = sexoUsuario;
        this.correoUsuario = correoUsuario;
        this.fonoUsuario = fonoUsuario;
    }
    public Usuario(short idUsuario, Perfil perfil, UnidadTrabajo unidadTrabajo, String userUsuario, String passUsuario, String rutUsuario, char dvUsuario, String nomUsuario, String patUsuario, String matUsuario, char sexoUsuario, String correoUsuario, Integer fonoUsuario, Set servidors, Set sistemas) {
       this.idUsuario = idUsuario;
       this.perfil = perfil;
       this.unidadTrabajo = unidadTrabajo;
       this.userUsuario = userUsuario;
       this.passUsuario = passUsuario;
       this.rutUsuario = rutUsuario;
       this.nomUsuario = nomUsuario;
       this.patUsuario = patUsuario;
       this.matUsuario = matUsuario;
       this.sexoUsuario = sexoUsuario;
       this.correoUsuario = correoUsuario;
       this.fonoUsuario = fonoUsuario;
       this.servidors = servidors;
       this.sistemas = sistemas;
    }
   
    public short getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public UnidadTrabajo getUnidadTrabajo() {
        return this.unidadTrabajo;
    }
    
    public void setUnidadTrabajo(UnidadTrabajo unidadTrabajo) {
        this.unidadTrabajo = unidadTrabajo;
    }
    public String getUserUsuario() {
        return this.userUsuario;
    }
    
    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }
    public String getPassUsuario() {
        return this.passUsuario;
    }
    
    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
    public String getRutUsuario() {
        return this.rutUsuario;
    }
    
    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
   
    public String getNomUsuario() {
        return this.nomUsuario;
    }
    
    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }
    public String getPatUsuario() {
        return this.patUsuario;
    }
    
    public void setPatUsuario(String patUsuario) {
        this.patUsuario = patUsuario;
    }
    public String getMatUsuario() {
        return this.matUsuario;
    }
    
    public void setMatUsuario(String matUsuario) {
        this.matUsuario = matUsuario;
    }
    public char getSexoUsuario() {
        return this.sexoUsuario;
    }
    
    public void setSexoUsuario(char sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }
    public String getCorreoUsuario() {
        return this.correoUsuario;
    }
    
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }
    public Integer getFonoUsuario() {
        return this.fonoUsuario;
    }
    
    public void setFonoUsuario(Integer fonoUsuario) {
        this.fonoUsuario = fonoUsuario;
    }
    public Set getServidors() {
        return this.servidors;
    }
    
    public void setServidors(Set servidors) {
        this.servidors = servidors;
    }
    public Set getSistemas() {
        return this.sistemas;
    }
    
    public void setSistemas(Set sistemas) {
        this.sistemas = sistemas;
    }




}


