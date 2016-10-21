
package dao;

import POJO.Servicio;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface ServicioDao {
    
    public ArrayList<Servicio> getAll();

    public ServicioDao getPerfil(Servicio ser);

    public void insert(Servicio ser);

    public void delete(Servicio ser);
    
    public void deleteById(int id);

    public void update(Servicio ser);
   
    public Servicio getById(int id);
}
