package dao;

import POJO.Perfil;
import java.util.ArrayList;

public interface PerfilDao {
    
    public ArrayList<Perfil> getAll() throws Exception;

    public Perfil getPerfil(Perfil per) throws Exception;

    public boolean insert(Perfil per) throws Exception;

    public boolean delete(Perfil per) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(Perfil per) throws Exception;
   
    public Perfil getById(short id) throws Exception;

    
}