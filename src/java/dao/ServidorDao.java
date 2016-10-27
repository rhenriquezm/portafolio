/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Servidor;
import POJO.Usuario;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface ServidorDao  {
    
    public ArrayList<Servidor> getAll() throws Exception;

    public boolean insert(Servidor se) throws Exception;

    public boolean delete(Servidor se) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(Servidor se) throws Exception;
   
    public Servidor getById(short id) throws Exception;
    
}
