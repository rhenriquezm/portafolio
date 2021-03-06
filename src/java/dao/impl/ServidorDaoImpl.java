/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.Rack;
import POJO.Servidor;
import POJO.UnidadTrabajo;
import POJO.Usuario;
import dao.ServidorDao;
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
public class ServidorDaoImpl implements ServidorDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Servidor> getAll() throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            Criteria criteria = this.session.createCriteria(Servidor.class);
            ArrayList<Servidor> servidores = (ArrayList<Servidor>) criteria.list();
            this.transaction.commit();
            return servidores;
        } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Servidor se) throws Exception {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = this.session.beginTransaction();
            this.session.save(se);
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
    public boolean delete(Servidor se) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(short id) throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Servidor servidor = (Servidor) session.load(Servidor.class, id);
        this.session.delete(servidor);
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
    public boolean update(Servidor se) throws Exception {
        try {
            
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();
            
            Servidor servidor = (Servidor) session.load(Servidor.class, se.getIdServ());
            
            servidor.setNomServ(se.getNomServ());
            servidor.setMarcaServ(se.getMarcaServ());
            servidor.setModeloServ(se.getModeloServ());
            servidor.setTamMemoria(se.getTamMemoria());
            servidor.setTamDisco(se.getTamDisco());
            servidor.setPassAdmin(se.getPassAdmin());
            servidor.setUserBd(se.getUserBd());
            servidor.setPassBd(se.getPassBd());
            servidor.setUsuario(se.getUsuario());
            servidor.setProveedor(se.getProveedor());
            servidor.setSistOper(se.getSistOper());
            servidor.setRack(se.getRack());
            servidor.setDirIp(se.getDirIp());
            servidor.setGarantia(se.getGarantia());
                    
            session.update(servidor);
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
    public Servidor getById(short id) throws Exception {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Servidor WHERE idServ=:idServ";
        Query query = session.createQuery(sql);
        query.setParameter("idServ", id);
        this.transaction.commit();
        return (Servidor)query.uniqueResult();
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
