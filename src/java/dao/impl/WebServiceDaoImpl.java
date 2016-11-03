/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Webservice;
import dao.WebServiceDao;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *miraa
 * @author shelob
 */
public class WebServiceDaoImpl implements WebServiceDao{
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Webservice> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(Webservice.class);
            ArrayList<Webservice> ws = (ArrayList<Webservice>) criteria.list();
            this.transaction.commit();
            return ws;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Webservice ws) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(ws);
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
    public boolean delete(Webservice ws) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Webservice ws = (Webservice) session.load(Webservice.class, id);
            this.session.delete(ws);
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
    public boolean update(Webservice ws) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Webservice wsr = (Webservice) session.load(Webservice.class, ws.getIdWebservice());
            wsr.setNomWebservice(ws.getNomWebservice());
            wsr.setProtWebservice(ws.getProtWebservice());
            session.update(wsr);
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
    public Webservice getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM Webservice WHERE idWebservice=:idWebservice"; 
            Query query = session.createQuery(sql);
            query.setParameter("idWebservice", id);
            this.transaction.commit();
            return (Webservice) query.uniqueResult();
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null; 
    }
    
}
