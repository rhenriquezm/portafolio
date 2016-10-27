package dao.impl;

import POJO.SistOper;
import POJO.Usuario;
import dao.UsuarioDao;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDaoImpl implements UsuarioDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Usuario> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(Usuario.class);
            ArrayList<Usuario> users = (ArrayList<Usuario>) criteria.list();
            this.transaction.commit();
            return users;
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

    @Override
    public Usuario getUsuario(Usuario us) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Usuario us) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(us);
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
    public boolean delete(Usuario us) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Usuario us) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getByUserPass(String nombreUsuario, String contrasena) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            //Recordar que los nombres de las entidades y campos corresponden a los pojos 
            String sql = "FROM Usuario WHERE userUsuario=:userUsuario and passUsuario=:passUsuario";
            Query query = session.createQuery(sql);
            query.setParameter("userUsuario", nombreUsuario);
            query.setParameter("passUsuario", contrasena);
            this.transaction.commit();
            return (Usuario) query.uniqueResult();
        } catch (Exception e) {
            if (this.transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }

}
