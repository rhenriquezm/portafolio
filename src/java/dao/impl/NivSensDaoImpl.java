/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.NivSens;
import dao.NivSensDao;
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
public class NivSensDaoImpl implements NivSensDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<NivSens> getAll() throws Exception {
    	try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(NivSens.class);
            ArrayList<NivSens> nis = (ArrayList<NivSens>) criteria.list();
            this.transaction.commit();
            return nis;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(NivSens nsen) throws Exception {
    	try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(nsen);
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
    public boolean delete(NivSens nsen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
    	try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            NivSens nss = (NivSens) session.load(NivSens.class, id);
            this.session.delete(nss);
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
    public boolean update(NivSens nsen) throws Exception {
    	 try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            NivSens nisn = (NivSens) session.load(NivSens.class, nsen.getIdNivSens());
            nisn.setDescNivSens(nsen.getDescNivSens());
            session.update(nisn);
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
    public NivSens getById(short id) throws Exception {
    	try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM NivSens WHERE idNivSens=:idNivSens";
            Query query = session.createQuery(sql);
            query.setParameter("idNivSens", id);
            this.transaction.commit();
            return (NivSens) query.uniqueResult();
            
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null; 
    }

}
