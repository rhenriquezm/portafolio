/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.LengDesSist;
import dao.LengDesSistDao;
import dao.impl.LengDesSistDaoImpl;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class LengDesControl {

    private int id;
    private LengDesSist ld;
    private ArrayList<SelectItem> listaLd;

    public LengDesControl() {
        this.id = 0;
        this.ld = new LengDesSist();
        this.listaLd = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LengDesSist getLd() {
        return ld;
    }

    public void setLd(LengDesSist ld) {
        this.ld = ld;
    }

    public ArrayList<SelectItem> getListaLd() {
        return listaLd;
    }

    public void setListaLd(ArrayList<SelectItem> listaLd) {
        this.listaLd = listaLd;
    }

    //Personalizados.
    public void ingresarLengDesSist() {
        LengDesSistDao ldDao = new LengDesSistDaoImpl();
        ldDao.insert(ld);
        String nom = ld.getNomLengDes();
        reset();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nom + " " + "agregado exitosamente"));
    }

    public void modificarLengDesSist() {
        LengDesSistDao ldDao = new LengDesSistDaoImpl();
        LengDesSist leng = ldDao.getById(id);
        leng.setNomLengDes(ld.getNomLengDes());
        ldDao.update(leng);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("modificado exitosamente"));
    }

    public void eliminarLengDesSist() {
        LengDesSistDao ldDao = new LengDesSistDaoImpl();
        ldDao.deleteById(id);
        resetLista();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminada exitosamente"));
    }

    public void cambioLengDesSist() {
        LengDesSistDao ldDao = new LengDesSistDaoImpl();
        ld = ldDao.getById(id);
    }

    public List<SelectItem> listarTodo() {
        LengDesSistDao ldDao = new LengDesSistDaoImpl();
        for (LengDesSist lengDes : ldDao.getAll()) {
            listaLd.add(new SelectItem(lengDes.getIdLengSist(), lengDes.getNomLengDes()));
        }
        return listaLd;
    }

    public void reset() {
        this.ld.setNomLengDes(null);
    }

    public void resetLista() {
        listaLd.clear();
    }

}
