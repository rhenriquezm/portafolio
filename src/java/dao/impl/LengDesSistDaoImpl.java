/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.LengDesSistDao;
import java.util.ArrayList;
import POJO.LengDesSist;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class LengDesSistDaoImpl implements LengDesSistDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<LengDesSist> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(LengDesSist.class);
        ArrayList<LengDesSist> lenguajes = (ArrayList<LengDesSist>) criteria.list();
        session.close();
        return lenguajes;
    }

    @Override
    public void insert(LengDesSist ld) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ld);
        this.transaction.commit();
    }

    @Override
    public void delete(LengDesSist ld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        LengDesSist lengDes = (LengDesSist) session.load(LengDesSist.class, id);
        this.session.delete(lengDes);
        this.transaction.commit();
    }

    @Override
    public void update(LengDesSist ld) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        LengDesSist lengDes = (LengDesSist) session.load(LengDesSist.class, ld.getIdLengSist());
        lengDes.setNomLengDes(ld.getNomLengDes());
        session.update(lengDes);
        this.transaction.commit();
    }

    @Override
    public LengDesSist getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM LengDesSist WHERE idLengSist=:idLengSist";
        Query query = session.createQuery(sql);
        query.setParameter("idLengSist", id);
        this.transaction.commit();
        return (LengDesSist)query.uniqueResult();
    }

}
