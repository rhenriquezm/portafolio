
package dao;

import POJO.NivSens;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface NivSensDao {
    
    public ArrayList<NivSens> getAll();

    public void insert(NivSens ns);

    public void delete(NivSens ns);
    
    public void deleteById(int id);

    public void update(NivSens ns);
   
    public NivSens getById(int id);
}
