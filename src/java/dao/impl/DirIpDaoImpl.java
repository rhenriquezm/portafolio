/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.DirIp;
import dao.DirIpDao;
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
public class DirIpDaoImpl implements DirIpDao{
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<DirIp> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(DirIp.class);
            ArrayList<DirIp> gdip = (ArrayList<DirIp>) criteria.list();
            this.transaction.commit();
            this.session.close();
            return gdip;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(DirIp dip) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(dip);
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
    public boolean delete(DirIp dip) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            DirIp ddip = (DirIp) session.load(DirIp.class, id);
            this.session.delete(ddip);
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
    public boolean update(DirIp dip) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            DirIp udip = (DirIp) session.load(DirIp.class, dip.getIdDir());
            udip.setDirIp(dip.getDirIp());
            session.update(udip);
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
    public DirIp getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM DirIp WHERE idDir=:idDir";
            Query query = session.createQuery(sql);
            query.setParameter("idDir", id);
            this.transaction.commit();
            return (DirIp) query.uniqueResult();
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
    
}
