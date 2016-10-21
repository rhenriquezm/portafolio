/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.SoftBdDao;
import java.util.ArrayList;
import POJO.SoftBd;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class SoftBdDaoImpl implements SoftBdDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<SoftBd> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(SoftBd.class);
        ArrayList<SoftBd> softwares = (ArrayList<SoftBd>) criteria.list();
        session.close();
        return softwares;
    }

    @Override
    public void insert(SoftBd sbd) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(sbd);
        this.transaction.commit();
    }

    @Override
    public void delete(SoftBd sbd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        SoftBd softBD = (SoftBd) session.load(SoftBd.class, id);
        this.session.delete(softBD);
        this.transaction.commit();
    }

    @Override
    public void update(SoftBd sbd) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        SoftBd softBD = (SoftBd) session.load(SoftBd.class, sbd.getIdSoftBd());
        softBD.setNomSoftBd(sbd.getNomSoftBd());
        softBD.setEmpSoftBd(sbd.getEmpSoftBd());
        softBD.setVerSoftBd(sbd.getVerSoftBd());
        session.update(softBD);
        this.transaction.commit();
    }

    @Override
    public SoftBd getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "FROM SoftBd where idSoftBd=:idSoftBd";
        Query query = session.createQuery(sql);
        query.setParameter("idSoftBd", id);
        this.transaction.commit();
        return (SoftBd) query.uniqueResult();
    }

}
