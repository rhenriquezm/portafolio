
package dao;

import POJO.Sistema;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface SistemaDao {

    public ArrayList<Sistema> getAll();

    public Sistema getPerfil(Sistema sis);

    public void insert(Sistema sis);

    public void delete(Sistema sis);

    public void deleteById(int id);

    public void update(Sistema sis);

    public Sistema getById(int id);
}
