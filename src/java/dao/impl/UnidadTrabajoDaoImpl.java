package dao.impl;

import POJO.UnidadTrabajo;
import dao.UnidadTrabajoDao;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UnidadTrabajoDaoImpl implements UnidadTrabajoDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<UnidadTrabajo> getAll() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = this.session.createCriteria(UnidadTrabajo.class);
            ArrayList<UnidadTrabajo> lis = (ArrayList<UnidadTrabajo>) criteria.list();
            this.transaction.commit();
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
    public UnidadTrabajo getPerfil(UnidadTrabajo ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(UnidadTrabajo ut) {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(ut);
            this.transaction.commit();
            this.session.close();
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
    public boolean delete(UnidadTrabajo ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(UnidadTrabajo ut) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            UnidadTrabajo uTrab = (UnidadTrabajo) session.load(UnidadTrabajo.class, ut.getIdUniTrab());
            uTrab.setNomUniTrab(ut.getNomUniTrab());
            session.update(uTrab);
            this.transaction.commit();
            this.session.close();
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
            UnidadTrabajo unTrab = (UnidadTrabajo) session.load(UnidadTrabajo.class, id);
            this.session.delete(unTrab);
            this.transaction.commit();
            this.session.close();
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
    public UnidadTrabajo getById(short id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "  FROM UnidadTrabajo WHERE idUniTrab=:idUniTrab";
            Query query = session.createQuery(sql);
            query.setParameter("idUniTrab", id);
            this.transaction.commit();
            return (UnidadTrabajo) query.uniqueResult();
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }

}
