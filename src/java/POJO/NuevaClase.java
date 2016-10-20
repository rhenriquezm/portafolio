package POJO;


import org.hibernate.Session;
import util.HibernateUtil;

public class NuevaClase {

    Session session = null;

    public NuevaClase() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
