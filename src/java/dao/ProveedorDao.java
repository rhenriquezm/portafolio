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
 * @author shelob
 */
public interface ProveedorDao {

	public ArrayList<Proveedor> getAll() throws Exception;

    public boolean insert(Proveedor prov) throws Exception;

    public boolean delete(Proveedor prov) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(Proveedor prov) throws Exception;

    public Proveedor getById(short id) throws Exception;
    
}
