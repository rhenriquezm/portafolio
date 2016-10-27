/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface ProveedorDao {
    
    public ArrayList<Proveedor> getAll() throws Exception;

    public Proveedor getPerfil(Proveedor pro) throws Exception;

    public boolean insert(Proveedor pro) throws Exception;

    public boolean delete(Proveedor pro) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(Proveedor pro) throws Exception;
   
    public Proveedor getById(short id) throws Exception;
    
}
