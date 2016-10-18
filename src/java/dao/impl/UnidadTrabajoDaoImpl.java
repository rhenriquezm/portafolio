package dao.impl;

import dao.UnidadTrabajoDao;
import java.util.ArrayList;
import modelo.UnidadTrabajo;
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

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UnidadTrabajo.class);
        ArrayList<UnidadTrabajo> lis = (ArrayList<UnidadTrabajo>) criteria.list();
        session.close();
        return lis;

    }

    @Override
    public UnidadTrabajo getPerfil(UnidadTrabajo ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(UnidadTrabajo ut) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(ut);
        this.transaction.commit();
    }

    @Override
    public void delete(UnidadTrabajo ut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UnidadTrabajo ut) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        UnidadTrabajo uTrab = (UnidadTrabajo) session.load(UnidadTrabajo.class, ut.getIdUniTrab());
        uTrab.setNomUnidTrab(ut.getNomUnidTrab());
        session.update(uTrab);
        this.transaction.commit();
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        UnidadTrabajo unTrab = (UnidadTrabajo) session.load(UnidadTrabajo.class, id);
        this.session.delete(unTrab);
        this.transaction.commit();
    }

    @Override
    public UnidadTrabajo getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM UnidadTrabajo WHERE idUniTrab=:idUniTrab";
        Query query = session.createQuery(sql);
        query.setParameter("idUniTrab", id);
        this.transaction.commit();
        return (UnidadTrabajo) query.uniqueResult();
    }

}
