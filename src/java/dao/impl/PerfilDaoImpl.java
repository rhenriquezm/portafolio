package dao.impl;

import dao.PerfilDao;
import java.util.ArrayList;
import modelo.Perfil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PerfilDaoImpl implements PerfilDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Perfil> getAll() throws Exception {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Perfil.class);
            ArrayList<Perfil> per = (ArrayList<Perfil>) criteria.list();
            session.close();
            return per;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;

    }

    @Override
    public Perfil getPerfil(Perfil per) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Perfil per) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(per);
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
    public boolean delete(Perfil per) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Perfil per = (Perfil) session.load(Perfil.class, id);
            this.session.delete(per);
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
    public boolean update(Perfil per) throws Exception {

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            Perfil perf = (Perfil) session.load(Perfil.class, per.getIdPerfil());
            perf.setNomPerfil(per.getNomPerfil());
            perf.setDescPerfil(per.getDescPerfil());
            session.update(perf);
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
    public Perfil getById(int id) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            String sql = "  FROM Perfil WHERE idPerfil=:idPerfil";
            Query query = session.createQuery(sql);
            query.setParameter("idPerfil", id);
            this.transaction.commit();
            return (Perfil) query.uniqueResult();
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }
}
