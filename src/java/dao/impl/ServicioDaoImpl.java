
package dao.impl;

/**
 *
 * @author shelob
 */
import dao.ServicioDao;
import java.util.ArrayList;
import POJO.Servicio;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ServicioDaoImpl implements ServicioDao{
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Servicio> getAll() {
        
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Servicio.class);
        ArrayList<Servicio> servicios = (ArrayList<Servicio>) criteria.list();
        session.close();
        return servicios;
    }

    @Override
    public void insert(Servicio ser) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ser);
        this.transaction.commit();
    }
    

    @Override
    public void delete(Servicio ser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Servicio srvcio = (Servicio) session.load(Servicio.class, id);
        this.session.delete(srvcio);
        this.transaction.commit();
        
    }

    @Override
    public void update(Servicio ser) {
        
        this.transaction = session.beginTransaction();
            Servicio srvice = (Servicio) session.load(Servicio.class,ser.getIdServicio());
            srvice.setNomServicio(ser.getNomServicio());
            srvice.setSistema(ser.getSistema());
            session.update(srvice);
            this.transaction.commit();
    }

    @Override
    public Servicio getById(int id) {
        
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Servicio WHERE idServicio=:idServicio";
        Query query = session.createQuery(sql);
        query.setParameter("idServicio", id);
        this.transaction.commit();
        return (Servicio)query.uniqueResult();
    }

    @Override
    public ServicioDao getPerfil(Servicio ser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
