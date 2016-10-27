/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Proveedor;
import dao.ProveedorDao;
import dao.ProveedorDao;
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
public class ProveedorDaoImpl implements ProveedorDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Proveedor> getAll() throws Exception {

        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Proveedor.class);
        ArrayList<Proveedor> lis = (ArrayList<Proveedor>) criteria.list();
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
    public Proveedor getPerfil(Proveedor pro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Proveedor pro) throws Exception {
        try {
          this.session = HibernateUtil.getSessionFactory().openSession();
          this.transaction = this.session.beginTransaction();
          this.session.save(pro);
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
    public boolean delete(Proveedor pro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Proveedor pro) throws Exception {
        try {
        this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaction =session.beginTransaction();
            Proveedor prov = (Proveedor) session.load(Proveedor.class,pro.getIdProv());
            prov.setNomProv(pro.getNomProv());
            prov.setFonoProv(pro.getFonoProv());
            prov.setCorreoProv(pro.getCorreoProv());
            session.update(prov);
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
    public boolean deleteById(short id) throws Exception {
        try {
          this.session = HibernateUtil.getSessionFactory().openSession();
          this.transaction = session.beginTransaction();
          Proveedor prov = (Proveedor) session.load(Proveedor.class, id);
          this.session.delete(prov);
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
    public Proveedor getById(short id) throws Exception {
        try {
          this.session = HibernateUtil.getSessionFactory().openSession();
          this.transaction = this.session.beginTransaction();
          String sql = "  FROM Proveedor WHERE idProv=:idProv";
          Query query = session.createQuery(sql);
          query.setParameter("idProv", id);
          this.transaction.commit();
        return (Proveedor)query.uniqueResult();
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }
    
}
