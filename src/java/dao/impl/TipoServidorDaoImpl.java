/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.TipoServ;
import POJO.TipoServidor;
import dao.TipoServidorDao;
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
public class TipoServidorDaoImpl implements TipoServidorDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<TipoServidor> getAll() throws Exception  {

        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(TipoServidor.class);
        ArrayList<TipoServidor> lis = (ArrayList<TipoServidor>) criteria.list();
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
    public TipoServidor getById(short id) throws Exception  {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM TipoServidor WHERE idTipoServ=:idTipoServ";
        Query query = session.createQuery(sql);
        query.setParameter("idTipoServ", id);
        this.transaction.commit();
        return (TipoServidor)query.uniqueResult();
    } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }
    
}
