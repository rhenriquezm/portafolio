/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.OrganizacionDao;
import java.util.ArrayList;
import POJO.Organizacion;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class OrganizacionDaoImpl implements OrganizacionDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Organizacion> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Organizacion.class);
        ArrayList<Organizacion> organizaciones = (ArrayList<Organizacion>) criteria.list();
        session.close();
        return organizaciones;
    }

    @Override
    public void insert(Organizacion org) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(org);
        this.transaction.commit();
    }

    @Override
    public void delete(Organizacion org) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Organizacion organ = (Organizacion) session.load(Organizacion.class, id);
        this.session.delete(organ);
        this.transaction.commit();
    }

    @Override
    public void update(Organizacion org) {
        this.transaction = session.beginTransaction();
        Organizacion organ = (Organizacion) session.load(Organizacion.class,org.getIdOrg());
        organ.setNomOrg(org.getNomOrg());
        session.update(organ);
        this.transaction.commit();
    }

    @Override
    public Organizacion getById(int id) {
         this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Organizacion WHERE idOrga=:";
        Query query = session.createQuery(sql);
        query.setParameter("idOrg", id);
        this.transaction.commit();
        return (Organizacion)query.uniqueResult();
    }

}
