package dao;

import POJO.Usuario;
import java.util.ArrayList;

public interface UsuarioDao {
       
    public ArrayList<Usuario> getAll() throws Exception;

    public Usuario getUsuario(Usuario us) throws Exception;

    public boolean insert(Usuario us) throws Exception;

    public boolean delete(Usuario us) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(Usuario us) throws Exception;
   
    public Usuario getById(short id) throws Exception;
    
    public Usuario getByUserPass(String nombreUsuario, String contrasena) throws Exception;
    
}
