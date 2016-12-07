/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.TipoServ;
import dao.TipoServDao;
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
public class TipoServDaoImpl implements TipoServDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<TipoServ> getAll() throws Exception {

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(TipoServ.class);
            ArrayList<TipoServ> lis = (ArrayList<TipoServ>) criteria.list();
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
    public TipoServ getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "  FROM TipoServ WHERE idTipoServ=:idTipoServ";
            Query query = session.createQuery(sql);
            query.setParameter("idTipoServ", id);
            this.transaction.commit();
            return (TipoServ) query.uniqueResult();
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(TipoServ ts) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(ts);
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
    public boolean delete(TipoServ ts) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            TipoServ dts = (TipoServ) session.load(TipoServ.class, id);
            this.session.delete(dts);
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
    public boolean update(TipoServ ts) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            TipoServ uts = (TipoServ) session.load(TipoServ.class, ts.getIdTipoServ());
            uts.setDescTipo(ts.getDescTipo());
            uts.setPassAdmin(ts.getPassAdmin());
            uts.setUsBd(ts.getUsBd());
            uts.setPassBd(uts.getPassBd());
            session.update(uts);
            this.transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return false;
    }
}

