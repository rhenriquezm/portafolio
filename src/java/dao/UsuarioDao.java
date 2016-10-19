
package dao;

import java.util.ArrayList;
import modelo.Usuario;

public interface UsuarioDao {
       
    public ArrayList<Usuario> getAll() throws Exception;

    public Usuario getUsuario(Usuario us) throws Exception;

    public boolean insert(Usuario us) throws Exception;

    public boolean delete(Usuario us) throws Exception;
    
    public boolean deleteById(int id) throws Exception;

    public boolean update(Usuario us) throws Exception;
   
    public Usuario getById(int id) throws Exception;
    
}
