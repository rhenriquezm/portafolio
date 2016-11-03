/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Sistema;
import dao.SistemaDao;
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
public class SistemaDaoImpl implements SistemaDao{
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Sistema> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(Sistema.class);
            ArrayList<Sistema> sist = (ArrayList<Sistema>) criteria.list();
            this.transaction.commit();
            return sist;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Sistema sis) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(sis);
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
    public boolean delete(Sistema sis) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Sistema dsist = (Sistema) session.load(Sistema.class, id);
            this.session.delete(dsist);
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
    public boolean update(Sistema sis) throws Exception {
        try {
            
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Sistema usist = (Sistema) session.load(Sistema.class, sis.getIdSist());
            
            usist.setNomSist(sis.getNomSist());
            usist.setServidor(sis.getServidor());
            usist.setUsuario(sis.getUsuario());
            usist.setNivSeg(sis.getNivSeg());
            usist.setNivSens(sis.getNivSens());
            //sistemaoperativo
            usist.setSistOper(sis.getSistOper());
            usist.setProveedor(sis.getProveedor());
            usist.setSoftBd(sis.getSoftBd());
            usist.setOrganizacion(sis.getOrganizacion());          
            session.update(usist);
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
    public Sistema getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "FROM Sistema WHERE idSist=:idSist";
            Query query = session.createQuery(sql);
            query.setParameter("idSist", id);
            this.transaction.commit();
            return (Sistema) query.uniqueResult();

        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
    
}
