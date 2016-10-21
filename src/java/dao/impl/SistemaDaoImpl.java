package dao.impl;

import dao.SistemaDao;
import java.util.ArrayList;
import POJO.Sistema;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author shelob
 */
public class SistemaDaoImpl implements SistemaDao {

    private Session session;
    private Transaction transaction;

    @Override
    public ArrayList<Sistema> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Sistema.class);
        ArrayList<Sistema> sistemas = (ArrayList<Sistema>) criteria.list();
        session.close();
        return sistemas;
    }

    @Override
    public Sistema getPerfil(Sistema sis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Sistema sis) {
        session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        this.session.save(sis);
        this.transaction.commit();
    }

    @Override
    public void delete(Sistema sis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = session.beginTransaction();
        Sistema sist = (Sistema) session.load(Sistema.class, id);
        this.session.delete(sist);
        this.transaction.commit();
    }

    @Override
    public void update(Sistema sis) {
        this.transaction = session.beginTransaction();
        Sistema sist = (Sistema) session.load(Sistema.class, sis.getIdSist());
        sist.setNomSist(sis.getNomSist());
        sist.setServidor(sist.getServidor());
        sist.setUsuario(sist.getUsuario());
        sist.setNivSeg(sist.getNivSeg());
        sist.setNivSens(sist.getNivSens());
        sist.setSistOper(sist.getSistOper());
        sist.setSoftBd(sist.getSoftBd());
        sist.setProveedor(sist.getProveedor());
        sist.setServicios(sist.getServicios());
        sist.setWebservice(sist.getWebservice());
        sist.setOrganizacion(sist.getOrganizacion());
        session.update(sist);
        this.transaction.commit();

    }

    @Override
    public Sistema getById(int id) {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction = this.session.beginTransaction();
        String sql = "  FROM Sistema WHERE idSist=:idSist";
        Query query = session.createQuery(sql);
        query.setParameter("idSist", id);
        this.transaction.commit();
        return (Sistema) query.uniqueResult();
    }

}
