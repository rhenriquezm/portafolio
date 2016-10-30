/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import POJO.CarServ;
import POJO.SalaServ;
import dao.CarServidorDao;
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
public class CarServidorDaoImpl implements CarServidorDao {
    
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<CarServ> getAll() throws Exception  {

        try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CarServ.class);
        ArrayList<CarServ> lis = (ArrayList<CarServ>) criteria.list();
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
    public CarServ getById(short id) throws Exception  {
        try {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM CarServ WHERE idCarServ=:idCarServ";
        Query query = session.createQuery(sql);
        query.setParameter("idCarServ", id);
        this.transaction.commit();
        return (CarServ)query.uniqueResult();
    } catch (Exception ex) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
            System.out.println("Error" + ex.getMessage());
        }
        return null;
    }
    
}
