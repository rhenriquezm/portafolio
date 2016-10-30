/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.TipoServ;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface TipoServDao {
    
    public ArrayList<TipoServ> getAll() throws Exception;
   
    public TipoServ getById(short id) throws Exception;
    
}
