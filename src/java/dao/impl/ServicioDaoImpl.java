/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Servicio;
import dao.ServicioDao;
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
public class ServicioDaoImpl implements ServicioDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Servicio> getAll() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(Servicio.class);
            ArrayList<Servicio> ser = (ArrayList<Servicio>) criteria.list();
            this.transaction.commit();
            return ser;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Servicio serv) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(serv);
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
    public boolean delete(Servicio serv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Servicio dserv = (Servicio) session.load(Servicio.class, id);
            this.session.delete(dserv);
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
    public boolean update(Servicio serv) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Servicio userv = (Servicio) session.load(Servicio.class, serv.getIdServicio());
            userv.setNomServicio(serv.getNomServicio());
            session.update(userv);
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
    public Servicio getById(short id) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM Servicio WHERE idServicio=:idServicio";
            Query query = session.createQuery(sql);
            query.setParameter("idServicio", id);
            this.transaction.commit();
            return (Servicio) query.uniqueResult();

        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

}
