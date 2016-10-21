package dao.impl;

import dao.NivSegDao;
import java.util.ArrayList;
import POJO.NivSeg;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class NivSegDaoImpl implements NivSegDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<NivSeg> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NivSeg.class);
        ArrayList<NivSeg> niveles = (ArrayList<NivSeg>) criteria.list();
        session.close();
        return niveles;
    }

    @Override
    public void insert(NivSeg ns) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ns);
        this.transaction.commit();
    }

    @Override
    public void delete(NivSeg ns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        NivSeg nivSeg = (NivSeg) session.load(NivSeg.class, id);
        this.session.delete(nivSeg);
        this.transaction.commit();
    }

    @Override
    public void update(NivSeg ns) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        NivSeg nSeg = (NivSeg) session.load(NivSeg.class, ns.getIdNivSeg());
        nSeg.setDescNivSeg(ns.getDescNivSeg());
        session.update(nSeg);
        this.transaction.commit();
    }

    @Override
    public NivSeg getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM NivSeg WHERE idNivSeg=:idNivSeg";
        Query query = session.createQuery(sql);
        query.setParameter("idNivSeg", id);
        this.transaction.commit();
        return (NivSeg) query.uniqueResult();
    }

}
