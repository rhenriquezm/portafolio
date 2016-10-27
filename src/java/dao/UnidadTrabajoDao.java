package dao;

import POJO.UnidadTrabajo;
import java.util.ArrayList;

public interface UnidadTrabajoDao {

    public ArrayList<UnidadTrabajo> getAll() throws Exception;

    public UnidadTrabajo getPerfil(UnidadTrabajo ut) throws Exception;

    public boolean insert(UnidadTrabajo ut) throws Exception;

    public boolean delete(UnidadTrabajo ut) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(UnidadTrabajo ut) throws Exception;

    public UnidadTrabajo getById(short id) throws Exception;
    

}
