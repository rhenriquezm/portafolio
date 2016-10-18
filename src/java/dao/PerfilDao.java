package dao;

import java.util.ArrayList;
import modelo.Perfil;
import modelo.Usuario;

public interface PerfilDao {
    
    public ArrayList<Perfil> getAll();

    public Perfil getPerfil(Perfil per);

    public void insert(Perfil per);

    public void delete(Perfil per);
    
    public void deleteById(int id);

    public void update(Perfil per);
   
    public Perfil getById(int id);

    
}