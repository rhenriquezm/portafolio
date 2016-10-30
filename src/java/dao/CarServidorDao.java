/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.CarServ;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface CarServidorDao {
    
    public ArrayList<CarServ> getAll() throws Exception;
   
    public CarServ getById(short id) throws Exception;
    
}
