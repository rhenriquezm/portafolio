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

    public ArrayList<Proveedor> getAll();

    public void insert(Proveedor pr);

    public void delete(Proveedor pr);

    public void deleteById(int id);

    public void update(Proveedor pr);

    public Proveedor getById(int id);

}
