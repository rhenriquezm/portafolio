
package dao;

import java.util.ArrayList;
import POJO.SistOper;

/**
 *
 * @author shelob
 */
public interface SistOperDao {
    
    public ArrayList<SistOper> getAll();

    public void insert(SistOper so);

    public void delete(SistOper so);
    
    public void deleteById(int id);

    public void update(SistOper so);
   
    public SistOper getById(int id);
    
}
