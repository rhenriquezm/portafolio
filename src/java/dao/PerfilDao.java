package dao;

import POJO.Perfil;
import java.util.ArrayList;

public interface PerfilDao {
    
    public ArrayList<Perfil> getAll() throws Exception;

    public Perfil getPerfil(Perfil per) throws Exception;

    public boolean insert(Perfil per) throws Exception;

    public boolean delete(Perfil per) throws Exception;
    
    public boolean deleteById(int id) throws Exception;

    public boolean update(Perfil per) throws Exception;
   
    public Perfil getById(int id) throws Exception;

    
}