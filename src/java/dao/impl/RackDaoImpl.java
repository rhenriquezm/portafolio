/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;


import POJO.Rack;
import dao.RackDao;
import dao.RackDao;
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
public class RackDaoImpl implements RackDao{
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Rack> getAll() throws Exception {

        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rack.class);
        ArrayList<Rack> lis = (ArrayList<Rack>) criteria.list();
        session.close();
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
    public Rack getPerfil(Rack ra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean  insert(Rack ra) throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ra);
        this.transaction.commit();
        return true;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
}

    @Override
    public boolean  delete(Rack ra) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean  update(Rack ra) throws Exception {
       
        try {
        this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaction =session.beginTransaction();
            Rack rack = (Rack) session.load(Rack.class,ra.getIdRack());
            rack.setNombreRack(ra.getNombreRack());
            session.update(rack);
            this.transaction.commit();
            return true;
        }catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean  deleteById(short id) throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Rack rack = (Rack) session.load(Rack.class, id);
        this.session.delete(rack);
        this.transaction.commit();
        return true;
    } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return false;
    }

    @Override
    public Rack getById(short id) throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Rack WHERE idRack=:idRack";
        Query query = session.createQuery(sql);
        query.setParameter("idRack", id);
        this.transaction.commit();
        return (Rack)query.uniqueResult();
    } catch (Exception ex) 
   {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }

    
    
}
