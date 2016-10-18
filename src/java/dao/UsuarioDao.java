
package dao;

import java.util.ArrayList;
import modelo.Usuario;

public interface UsuarioDao {
       
    public ArrayList<Usuario> getAll();

    public Usuario getUsuario(Usuario us);

    public void insert(Usuario us);

    public void delete(Usuario us);
    
    public void deleteById(int id);

    public void update(Usuario us);
   
    public Usuario getById(int id);
    
}
