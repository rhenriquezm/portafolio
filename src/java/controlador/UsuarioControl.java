package controlador;

import Converter.Encrypt;
import POJO.Perfil;
import POJO.UnidadTrabajo;
import POJO.Usuario;
import dao.PerfilDao;
import dao.UnidadTrabajoDao;
import dao.UsuarioDao;
import dao.impl.PerfilDaoImpl;
import dao.impl.UnidadTrabajoDaoImpl;
import dao.impl.UsuarioDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ViewScoped
@ManagedBean
public class UsuarioControl {

    private short idPerfil;
    private short idUsuario;
    private short idUniTrab;
    private Usuario usuario;

    private ArrayList<SelectItem> sexo;
    private ArrayList<SelectItem> perfiles;
    private ArrayList<SelectItem> unidadesTrabajo;

    public UsuarioControl() {
        this.usuario = new Usuario();
        this.sexo = new ArrayList<>();
        this.perfiles = new ArrayList<>();
        this.unidadesTrabajo = new ArrayList<>();
        this.idPerfil = 0;
        this.idUniTrab = 0;
    }

    @PostConstruct
    public void init() {
        this.sexo.add(new SelectItem('M', "Masculino"));
        this.sexo.add(new SelectItem('F', "Femenino"));
        this.sexo.add(new SelectItem('O', "Otro"));
        llenarSelectItems();

    }

    public void llenarSelectItems() {
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            PerfilDao perDao = new PerfilDaoImpl();

            for (UnidadTrabajo ut : utDao.getAll()) {
                this.perfiles.add(new SelectItem(ut.getIdUniTrab(), ut.getNomUniTrab()));
            }

            for (Perfil per : perDao.getAll()) {
                this.unidadesTrabajo.add(new SelectItem(per.getIdPerfil(), per.getNomPerfil()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<SelectItem> getSexo() {
        return sexo;
    }

    public void setSexo(ArrayList<SelectItem> sexo) {
        this.sexo = sexo;
    }

    public short getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(short idPerfil) {
        this.idPerfil = idPerfil;
    }

    public short getIdUniTrab() {
        return idUniTrab;
    }

    public void setIdUniTrab(short idUniTrab) {
        this.idUniTrab = idUniTrab;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<SelectItem> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(ArrayList<SelectItem> perfiles) {
        this.perfiles = perfiles;
    }

    public ArrayList<SelectItem> getUnidadesTrabajo() {
        return unidadesTrabajo;
    }

    public void setUnidadesTrabajo(ArrayList<SelectItem> unidadesTrabajo) {
        this.unidadesTrabajo = unidadesTrabajo;
    }

    // Metodos personalizados
    public void ingresarUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            PerfilDao pDao = new PerfilDaoImpl();
            this.usuario.setPerfil(pDao.getById(getIdPerfil()));
            this.usuario.setUnidadTrabajo(utDao.getById(getIdUniTrab()));
            this.usuario.setPassUsuario(Encrypt.sha512(getUsuario().getPassUsuario()));
            boolean ingresado = usuarioDao.insert(this.usuario);
            if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario ingresado exitosamente"));
            } else if (this.idPerfil == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Perfil "));
            } else if (this.idUniTrab == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Unidad de Trabajo"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no ha sido ingresado exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar Usuario " + ex.getMessage()));
        }
    }

    public List<SelectItem> mostrarUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UsuarioDao usDao = new UsuarioDaoImpl();
            ArrayList<SelectItem> usuarios = new ArrayList<>();
            for (Usuario usuario : usDao.getAll()) {
                usuarios.add(new SelectItem(usuario.getIdUsuario(), usuario.getNomUsuario()));
            }
            if (usuarios.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Usuarios Ingresados en el sistema"));

            } else {
                return usuarios;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al listar " + ex.getMessage()));
        }
        return null;
    }

    public ArrayList<SelectItem> mostrarPerfiles() {

        try {
            PerfilDao perfilDao = new PerfilDaoImpl();
            ArrayList<SelectItem> perfiles = new ArrayList<>();
            for (Perfil perfil : perfilDao.getAll()) {
                perfiles.add(new SelectItem(perfil.getIdPerfil(), perfil.getNomPerfil()));
            }
            return perfiles;
        } catch (Exception ex) {

        }
        return null;

    }

    public ArrayList<SelectItem> mostrarUniTrabs() {
        try {
            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            ArrayList<SelectItem> uniTrabs = new ArrayList<>();
            for (UnidadTrabajo unidadTrabajo : utDao.getAll()) {
                uniTrabs.add(new SelectItem(unidadTrabajo.getIdUniTrab(), unidadTrabajo.getNomUniTrab()));
            }
            return uniTrabs;
        } catch (Exception e) {
        }
        return null;
    }

    public void modificarUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            UsuarioDao usDao = new UsuarioDaoImpl();
            Usuario usu = usDao.getById(getIdUsuario());

            usu.setNomUsuario(usuario.getNomUsuario());
            usu.setPatUsuario(usuario.getPatUsuario());
            usu.setMatUsuario(usuario.getMatUsuario());
            usu.setRutUsuario(usuario.getRutUsuario());
            usu.setDvUsuario(usuario.getDvUsuario());
            usu.setSexoUsuario(usuario.getSexoUsuario());
            usu.setCorreoUsuario(usuario.getCorreoUsuario());
            usu.setFonoUsuario(usuario.getFonoUsuario());

            PerfilDao perDao = new PerfilDaoImpl();
            usu.setPerfil(perDao.getById(getIdPerfil()));

            UnidadTrabajoDao utDao = new UnidadTrabajoDaoImpl();
            usu.setUnidadTrabajo(utDao.getById(getIdUniTrab()));

            boolean modificado = usDao.update(usu);
            if (modificado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario modificada exitosamente"));
            } else if (this.idPerfil == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Perfil "));
            } else if (this.idUniTrab == 0) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Unidad de Trabajo"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }

    }

    public void cambioUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            UsuarioDao usDao = new UsuarioDaoImpl();
            setUsuario(usDao.getById(getIdUsuario()));
            setIdUniTrab(getUsuario().getUnidadTrabajo().getIdUniTrab());
            setIdPerfil(getUsuario().getPerfil().getIdPerfil());
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }

    public void eliminarUsuario() {
        try {
            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            boolean eliminado = usuarioDao.deleteById(this.idUsuario);
            if (eliminado) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Usuario eliminado exitosamente"));
            } else if (this.idUsuario == 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Seleccione Usuario"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Usuario no ha podido ser eliminado exitosamente"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar " + ex.getMessage()));
        }
    }

    public void limpiarIngresar() {
        usuario.setNomUsuario(null);
        usuario.setPatUsuario(null);
        usuario.setMatUsuario(null);
        usuario.setRutUsuario(null);
        usuario.setDvUsuario(Character.MIN_VALUE);
        usuario.setSexoUsuario(Character.MIN_VALUE);
        usuario.setCorreoUsuario(null);
        usuario.setFonoUsuario(null);
        usuario.setUserUsuario(null);
        usuario.setPassUsuario(null);
        usuario.setIdUsuario((short) 0);
        setIdUsuario((short)0);
        setIdPerfil((short) 0);
        setIdUniTrab((short) 0);

    }

}
