
package dao.impl;

import POJO.SalaServ;
import dao.SalaServDao;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author ricardo
 */
public class SalaServDaoImpl implements SalaServDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<SalaServ> getAll() throws Exception  {

        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SalaServ.class);
        ArrayList<SalaServ> lis = (ArrayList<SalaServ>) criteria.list();
        return lis;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;

    }

    @Override
    public boolean insert(SalaServ salaser)  throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(salaser);
        this.transaction.commit();
        this.session.close();
        return true;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(SalaServ salaser) throws Exception  {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SalaServ salaser) throws Exception  {
        try {
        this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaction =session.beginTransaction();
            SalaServ salaservidor = (SalaServ) session.load(SalaServ.class,salaser.getIdSalaServ());
            salaservidor.setNomSalaServ(salaser.getNomSalaServ());
            salaservidor.setNumero(salaser.getNumero());
            salaservidor.setPiso(salaser.getPiso());
            session.update(salaservidor);
            this.transaction.commit();
            this.session.close();
            return true;
        }  catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteById(short id) throws Exception  {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        SalaServ sala = (SalaServ) session.load(SalaServ.class, id);
        this.session.delete(sala);
        this.transaction.commit();
        this.session.close();
        return true;
    } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
    }

    @Override
    public SalaServ getById(short id) throws Exception  {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM SalaServ WHERE idSalaServ=:idSalaServ";
        Query query = session.createQuery(sql);
        query.setParameter("idSalaServ", id);
        this.transaction.commit();
        return (SalaServ)query.uniqueResult();
    } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }
    
}
