package controlador;

import POJO.Rack;
import POJO.SalaServ;
import dao.RackDao;
import dao.SalaServDao;
import dao.impl.RackDaoImpl;
import dao.impl.SalaServDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ViewScoped
@ManagedBean
public class RackControl {

    private short idRack;
    private short idSalaservidor;
    private Rack rack;

    public RackControl() {
        this.rack = new Rack();
        this.idRack = 0;
        this.idSalaservidor = 0;
    }

    public short getIdRack() {
        return idRack;
    }

    public void setIdRack(short idRack) {
        this.idRack = idRack;
    }

    public short getIdSalaservidor() {
        return idSalaservidor;
    }

    public void setIdSalaservidor(short idSalaservidor) {
        this.idSalaservidor = idSalaservidor;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    //Metodos Personalizados
    public void ingresarRack() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            SalaServDao salaDao = new SalaServDaoImpl();
            
            this.rack.setSalaServ(salaDao.getById(getIdSalaservidor()));
            
            boolean ingresado = rackDao.insert(this.rack);
            if (ingresado) {
                limpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Rack ingresada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Rack no ha sido ingresada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));
        }
    }

    public List<SelectItem> listarTodo() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            ArrayList<SelectItem> listaRack = new ArrayList<>();
            for (Rack ra : rackDao.getAll()) {
                listaRack.add(new SelectItem(ra.getIdRack(), ra.getNombreRack()));
            }
            if (listaRack.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO!", "No existen Rack en el sistema"));
            } else {
                return listaRack;
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al mostrar Proveedores" + ex.getMessage()));

        }
        return null;
    }

    public void eliminarRack() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            boolean eliminado = rackDao.deleteById(idRack);
            if (eliminado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Rack eliminada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Rack no ha sido eliminada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al eliminar" + ex.getMessage()));
        }
    }

    public void modificarRack() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            Rack ra = rackDao.getById(idRack);
            ra.setNombreRack(rack.getNombreRack());

            SalaServDao salaDao = new SalaServDaoImpl();
            SalaServ sala = salaDao.getById(idSalaservidor);
            ra.setSalaServ(sala);

            boolean modificado = rackDao.update(ra);
            
            if (modificado) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Rack modificada exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Rack no ha sido modificada exitosamente"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al modificar" + ex.getMessage()));
        }
    }
    
   

    public void buscarRack() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            rack = rackDao.getById(idRack);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al buscar" + ex.getMessage()));
        }

    }

    public void cambioRack() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            RackDao rackDao = new RackDaoImpl();
            rack = rackDao.getById(idRack);
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al cambiar" + ex.getMessage()));
        }
    }
    
    
    

    public void limpiarIngresar() {
        this.rack.setNombreRack(null);
        setIdSalaservidor((short)0);

    }

}
