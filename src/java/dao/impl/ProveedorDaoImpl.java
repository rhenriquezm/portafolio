/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ProveedorDao;
import java.util.ArrayList;
import POJO.Proveedor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class ProveedorDaoImpl implements ProveedorDao{

    private Session session;
    private Transaction transaction;
    
    @Override
    public ArrayList<Proveedor> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Proveedor.class);
        ArrayList<Proveedor> proveedores = (ArrayList<Proveedor>) criteria.list();
        session.close();
        return proveedores;
    }

    @Override
    public void insert(Proveedor pr) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(pr);
        this.transaction.commit();
    }

    @Override
    public void delete(Proveedor pr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Proveedor prov = (Proveedor) session.load(Proveedor.class, id);
        this.session.delete(prov);
        this.transaction.commit();
    }

    @Override
    public void update(Proveedor pr) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Proveedor prov = (Proveedor) session.load(Proveedor.class, pr.getIdProv());
        prov.setNomProv(prov.getNomProv());
        prov.setCorreoProv(pr.getCorreoProv());
        prov.setFonoProv(pr.getFonoProv());
        session.update(prov);
        this.transaction.commit();
    }

    @Override
    public Proveedor getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Proveedor WHERE idProv=:idProv";
        Query query = session.createQuery(sql);
        query.setParameter("idProv", id);
        this.transaction.commit();
        return (Proveedor) query.uniqueResult();
    }
    
}
