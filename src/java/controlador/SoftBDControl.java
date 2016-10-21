/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SoftBdDao;
import dao.impl.SoftBdDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import POJO.SoftBd;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class SoftBDControl {

	private SoftBd sbd;
	private int id;
	private ArrayList<SelectItem> listaSBD;

    public SoftBDControl() {
        this.sbd = new SoftBd();
        this.id = 0;
        this.listaSBD = new ArrayList<>();
    }

    public SoftBd getSbd() {
        return sbd;
    }

    public void setSbd(SoftBd sbd) {
        this.sbd = sbd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SelectItem> getListaSBD() {
        return listaSBD;
    }

    public void setListaSBD(ArrayList<SelectItem> listaSBD) {
        this.listaSBD = listaSBD;
    }

	//PERSONALIZADOS.

	public void ingresarSBD(){
		SoftBdDao sbdDao = new SoftBdDaoImpl();
		sbdDao.insert(sbd);
		String nomb = sbd.getNomSoftBd();
		reset();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(nomb + " " + "agregado exitosamente"));
	}

	public void eliminarSBD(){
		SoftBdDao sbdDao = new SoftBdDaoImpl();
		sbdDao.deleteById(id);
		resetLista();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Eliminado exitosamente"));

	}

	public void modificarSBD(){
		SoftBdDao sbdDao = new SoftBdDaoImpl();
		SoftBd sbd = sbdDao.getById(id);
		sbd.setNomSoftBd(sbd.getNomSoftBd());
		sbd.setEmpSoftBd(sbd.getEmpSoftBd());
		sbd.setVerSoftBd(sbd.getVerSoftBd());
		sbdDao.update(sbd);
		resetLista();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + id + " " + "Modificado exitosamente"));

	}

	public void cambioSDB(){
		SoftBdDao sbdDao = new SoftBdDaoImpl();
		sbd = sbdDao.getById(id);
	}

	public List<SelectItem> listarTodo(){
		SoftBdDao sbdDao = new SoftBdDaoImpl();
		for (SoftBd softBD : sbdDao.getAll()) {
			listaSBD.add(new SelectItem(softBD.getIdSoftBd(), softBD.getNomSoftBd()));
		}
		return listaSBD;
	}

	public void resetLista(){
		listaSBD.clear();
	}

	public void reset(){
		this.sbd.setNomSoftBd(null);
		this.sbd.setEmpSoftBd(null);
		this.sbd.setVerSoftBd(null);
	}
    
}
