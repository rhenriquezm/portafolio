package modelo;

import java.io.Serializable;

public class Perfil implements Serializable{

    private int idPerfil;
    private String nomPerfil;
    private String descPerfil;

    public int getIdPerfil() {
        return idPerfil;
    }

    private void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }

    public String getDescPerfil() {
        return descPerfil;
    }

    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }    
}