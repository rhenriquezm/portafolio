/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.WSDao;
import java.util.ArrayList;
import POJO.Webservice;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class WSDaoImpl implements WSDao{
    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Webservice> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Webservice.class);
        ArrayList<Webservice> services = (ArrayList<Webservice>) criteria.list();
        session.close();
        return services;
    }

    @Override
    public void insert(Webservice ws) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ws);
        this.transaction.commit();
    }

    @Override
    public void delete(Webservice ws) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Webservice wbSrv = (Webservice) session.load(Webservice.class, id);
        this.session.delete(wbSrv);
        this.transaction.commit();
    }

    @Override
    public void update(Webservice ws) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Webservice webServ = (Webservice) session.load(Webservice.class, ws.getIdWebservice());
        webServ.setNomWebservice(ws.getNomWebservice());
        webServ.setProtWebservice(ws.getProtWebservice());
        webServ.setSistemas(ws.getSistemas());
        session.update(webServ);
        this.transaction.commit();   
    }

    @Override
    public Webservice getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = " FROM Webservice WHERE idWebservice=:idWebservice";
        Query query = session.createQuery(sql);
        query.setParameter("idWebservice", id);
        this.transaction.commit(); 
        return (Webservice) query.uniqueResult();
    }
    
}
