package controlador;

import dao.PerfilDao;
import dao.UnidadTrabajoDao;
import dao.UsuarioDao;
import dao.impl.PerfilDaoImpl;
import dao.impl.UnidadTrabajoDaoImpl;
import dao.impl.UsuarioDaoImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.Perfil;
import modelo.UnidadTrabajo;
import modelo.Usuario;

@ViewScoped
@ManagedBean
public class UsuarioControl {
    
    private Usuario usuario;
    

    public UsuarioControl() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // Metodos personalizados
    
    public void ingresarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarioDao.insert(this.usuario);
    }
    
    public ArrayList<SelectItem> mostrarPerfiles(){
        PerfilDao perfilDao = new PerfilDaoImpl();
        ArrayList<SelectItem> perfiles = new ArrayList<>();
        for (Perfil perfil : perfilDao.getAll()) {
            perfiles.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
        }
        return perfiles;
    }
    
    public ArrayList<SelectItem> mostrarUniTrabs(){
        UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
        ArrayList<SelectItem> uniTrabs = new ArrayList<>();
        for (UnidadTrabajo unidadTrabajo : utDao.getAll()) {
            uniTrabs.add(new SelectItem(unidadTrabajo.getIdUniTrab(), unidadTrabajo.getNomUnidTrab()));
        }
        return uniTrabs;
    }
}