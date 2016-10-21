package dao.impl;

import dao.SistOperDao;
import java.util.ArrayList;
import POJO.SistOper;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class SistOperDaoImpl implements SistOperDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<SistOper> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SistOper.class);
        ArrayList<SistOper> sistemas = (ArrayList<SistOper>) criteria.list();
        session.close();
        return sistemas;
    }

    @Override
    public void insert(SistOper so) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(so);
        this.transaction.commit();
    }

    @Override
    public void delete(SistOper so) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        SistOper sisOper = (SistOper) session.load(SistOper.class, id);
        this.session.delete(sisOper);
        this.transaction.commit();
    }

    @Override
    public void update(SistOper so) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        SistOper sOperat = (SistOper) session.load(SistOper.class, so.getIdSo());
        sOperat.setDesSo(so.getDesSo());
        session.update(sOperat);
        this.transaction.commit();
    }

    @Override
    public SistOper getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM SistOper WHERE idSo=:idSo";
        Query query = session.createQuery(sql);
        query.setParameter("idSo", id);
        this.transaction.commit();
        return (SistOper) query.uniqueResult();
    }

}
