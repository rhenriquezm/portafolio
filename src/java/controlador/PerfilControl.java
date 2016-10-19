package controlador;

import dao.PerfilDao;
import dao.impl.PerfilDaoImpl;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.Perfil;

@ViewScoped
@ManagedBean
public class PerfilControl {

    private Perfil perfil;
    private int idPerfil;
    private ArrayList<SelectItem> listaParcial;

    public PerfilControl() {
        this.perfil = new Perfil();
        this.idPerfil = 0;
        this.listaParcial = new ArrayList<>();
    }
    
    @PostConstruct
    public void init(){
        resetLista();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public ArrayList<SelectItem> getListaParcial() {
        return listaParcial;
    }

    public void setListaParcial(ArrayList<SelectItem> listaParcial) {
        this.listaParcial = listaParcial;
    }
    
    // Metodos Personalizados
    public void ingresarPerfil() {
        PerfilDao perfilDao = new PerfilDaoImpl();
        perfilDao.insert(perfil);       
    }

    public void eliminarPerfil() {
        PerfilDao perfilDao = new PerfilDaoImpl();
        perfilDao.deleteById(idPerfil);
    }

    public ArrayList<SelectItem> mostrarPerfiles() {
        PerfilDao perfilDao = new PerfilDaoImpl();
        ArrayList<Perfil> perfilesComp = perfilDao.getAll();

        for (Perfil perfil : perfilesComp) {
            listaParcial.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
        }
        
        return listaParcial;
    }
    
    public void cambioPerfil(){
        PerfilDao perDao = new PerfilDaoImpl();
        perfil = perDao.getById(idPerfil);
    }
    
    public void modificarPerfil(){
        PerfilDao perDao = new PerfilDaoImpl();
        Perfil per = perDao.getById(idPerfil);
        per.setNomPerfil(perfil.getNomPerfil());
        per.setDescPerfil(perfil.getDescPerfil());
        perDao.update(per);
        resetLista();
    }
    
    public void resetLista(){
        listaParcial.clear();
    }
}
