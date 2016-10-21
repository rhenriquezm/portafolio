package dao.impl;

import dao.NivSensDao;
import java.util.ArrayList;
import POJO.NivSens;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class NivSensDaoImpl implements NivSensDao{
    
    private Session session;
    private Transaction transaction;
    
    @Override
    public ArrayList<NivSens> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NivSens.class);
        ArrayList<NivSens> niveles = (ArrayList<NivSens>) criteria.list();
        session.close();
        return niveles;
    }

    @Override
    public void insert(NivSens ns) {
         this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ns);
        this.transaction.commit();
    }

    @Override
    public void delete(NivSens ns) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        NivSens nivSens = (NivSens) session.load(NivSens.class, id);
        this.session.delete(nivSens);
        this.transaction.commit();
    }

    @Override
    public void update(NivSens ns) {
        this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaction =session.beginTransaction();
            NivSens nSens= (NivSens) session.load(NivSens.class,ns.getIdNivSens());
            nSens.setDescNivSens(ns.getDescNivSens());
            session.update(nSens);
            this.transaction.commit();
    }

    @Override
    public NivSens getById(int id) {
     this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM NivSeg WHERE idNivSens=:idNivSens";
        Query query = session.createQuery(sql);
        query.setParameter("idNivSens", id);
        this.transaction.commit();
        return (NivSens)query.uniqueResult();   
    }
    
}
