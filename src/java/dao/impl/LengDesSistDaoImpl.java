/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.LengDesSist;
import dao.LengDesSistDao;
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
public class LengDesSistDaoImpl implements LengDesSistDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<LengDesSist> getAll() throws Exception {
      try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(LengDesSist.class);
            ArrayList<LengDesSist> lds = (ArrayList<LengDesSist>) criteria.list();
            this.transaction.commit();
            return lds;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(LengDesSist lds) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(lds);
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
    public boolean delete(LengDesSist lds) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            LengDesSist lengdes = (LengDesSist) session.load(LengDesSist.class, id);
            this.session.delete(lengdes);
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
    public boolean update(LengDesSist lds) throws Exception {
       try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            LengDesSist lengdes = (LengDesSist) session.load(LengDesSist.class, lds.getIdLengSist());
            lengdes.setNomLengDes(lds.getNomLengDes());
            session.update(lengdes);
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
    public LengDesSist getById(short id) throws Exception {
       try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM LengDesSist WHERE idLengSist=:idLengSist";
            Query query = session.createQuery(sql);
            query.setParameter("idLengSist", id);
            this.transaction.commit();
            return (LengDesSist) query.uniqueResult();
            
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null; 
    }
    
}
