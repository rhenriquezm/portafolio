/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import POJO.ContGar;
import POJO.Garantia;
import POJO.Servidor;
import dao.ContGarDao;
import dao.GarantiaDao;
import dao.ServidorDao;
import dao.impl.ContGarDaoImpl;
import dao.impl.GarantiaDaoImpl;
import dao.impl.ServidorDaoImpl;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author shelob
 */
@ViewScoped
@ManagedBean
public class GarantiaControl {

    private Garantia garantia;
    private short idServidor;
    private short idContGar;

    public GarantiaControl() {
        this.garantia = new Garantia();
        this.idServidor = 0;
        this.idContGar = 0;

    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public short getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(short idServidor) {
        this.idServidor = idServidor;
    }

    public short getIdContGar() {
        return idContGar;
    }

    public void setIdContGar(short idContGar) {
        this.idContGar = idContGar;
    }

    //personalizados...
    public void ingresarGarantia() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            GarantiaDao garDao = new GarantiaDaoImpl();

            ServidorDao servidorDao = new ServidorDaoImpl();
            ContGarDao contgarDao = new ContGarDaoImpl();
            //2) Instanciamos el objeto POJO y le asignamos un objeto que buscaremos a traves del ID que declaraste
            // al comiezo

            Servidor servidor = servidorDao.getById(getIdServidor());
            ContGar contgar = contgarDao.getById(getIdContGar());
            //3) Modificamos el objeto que hasta el momento es null por el nuevo objeto que fuimos a busacr
            getGarantia().setServidor(servidor);
            getGarantia().setContGar(contgar);

            boolean ingresado = garDao.insert(getGarantia());
            if (ingresado) {
                LimpiarIngresar();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EXITO!", "Sistema ingresado exitosamente"));
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!", "Sistema no ha podido ser ingresado"));
            }
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR FATAL!", "Ha ocurrido un error al ingresar " + ex.getMessage()));

            }
    }
}
