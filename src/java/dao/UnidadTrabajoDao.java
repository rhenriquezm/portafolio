package dao;

import java.util.ArrayList;
import java.util.List;
import modelo.UnidadTrabajo;

public interface UnidadTrabajoDao {

    public ArrayList<UnidadTrabajo> getAll();

    public UnidadTrabajo getPerfil(UnidadTrabajo ut);

    public void insert(UnidadTrabajo ut);

    public void delete(UnidadTrabajo ut);
    
    public void deleteById(int id);

    public void update(UnidadTrabajo ut);
   
    public UnidadTrabajo getById(int id);
    
}
