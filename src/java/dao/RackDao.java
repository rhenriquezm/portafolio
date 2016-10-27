/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Rack;
import java.util.ArrayList;


/**
 *
 * @author ricardo
 */
public interface RackDao {
    public ArrayList<Rack> getAll() throws Exception;

    public Rack getPerfil(Rack ra) throws Exception;

    public boolean insert(Rack ra) throws Exception;

    public boolean delete(Rack ra) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(Rack ra)throws Exception;
   
    public Rack getById(short id) throws Exception;
}
