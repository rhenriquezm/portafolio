/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Garantia;
import dao.GarantiaDao;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class GarantiaDaoImpl implements GarantiaDao{

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Garantia> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(Garantia.class);
            ArrayList<Garantia> gara = (ArrayList<Garantia>) criteria.list();
            this.transaction.commit();
            return gara;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Garantia ga) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(ga);
            this.transaction.commit();
            this.session.close();
            return true;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Garantia ga) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Garantia dgara = (Garantia) session.load(Garantia.class, id);
            this.session.delete(dgara);
            this.transaction.commit();
            return true;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Garantia ga) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Garantia ugara = (Garantia) session.load(Garantia.class, ga.getIdGar());
            ugara.setContGar(ga.getContGar());
            ugara.setServidor(ga.getServidor());
            ugara.setNomGar(ga.getNomGar());
            ugara.setFechaGar(ga.getFechaGar());
            ugara.setFechaCadGar(ga.getFechaCadGar());
            session.update(ugara);
            this.transaction.commit();
            return true;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }

    @Override
    public Garantia getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM Garantia WHERE idGar=:idGar";
            Query query = session.createQuery(sql);
            query.setParameter("idGar", id);
            this.transaction.commit();
            return (Garantia) query.uniqueResult();

        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
    
}
