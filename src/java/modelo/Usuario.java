package modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    private int idUsuario;
    private String userUsuario;
    private String passUsuario;
    private int rutUsuario;
    private char dvUsuario;
    private String nomUsuario;
    private String apelPUsuario;
    private String apelMUsuario;
    private char sexoUsuario;
    private String correoUsuario;
    private int fonoUsuario;
    private int idPerfil;
    private int idUniTrab; //Unidad de Trabajo

    public int getIdUsuario() {
        return idUsuario;
    }

    private void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserUsuario() {
        return userUsuario;
    }

    public void setUserUsuario(String userUsuario) {
        this.userUsuario = userUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public int getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(int rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public char getDvUsuario() {
        return dvUsuario;
    }

    public void setDvUsuario(char dvUsuario) {
        this.dvUsuario = dvUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getApelPUsuario() {
        return apelPUsuario;
    }

    public void setApelPUsuario(String apelPUsuario) {
        this.apelPUsuario = apelPUsuario;
    }

    public String getApelMUsuario() {
        return apelMUsuario;
    }

    public void setApelMUsuario(String apelMUsuario) {
        this.apelMUsuario = apelMUsuario;
    }

    public char getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(char sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getFonoUsuario() {
        return fonoUsuario;
    }

    public void setFonoUsuario(int fonoUsuario) {
        this.fonoUsuario = fonoUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdUniTrab() {
        return idUniTrab;
    }

    public void setIdUniTrab(int idUniTrab) {
        this.idUniTrab = idUniTrab;
    }
}