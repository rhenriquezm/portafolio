package modelo;

import java.io.Serializable;

public class UnidadTrabajo implements Serializable{
    private int idUniTrab;
    private String nomUnidTrab;

    public int getIdUniTrab() {
        return idUniTrab;
    }

    private void setIdUniTrab(int idUniTrab) {
        this.idUniTrab = idUniTrab;
    }

    public String getNomUnidTrab() {
        return nomUnidTrab;
    }

    public void setNomUnidTrab(String nomUnidTrab) {
        this.nomUnidTrab = nomUnidTrab;
    }

}
