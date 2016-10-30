/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.TipoServ;
import POJO.TipoServidor;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface TipoServidorDao {
    
    public ArrayList<TipoServidor> getAll() throws Exception;
   
    public TipoServidor getById(short id) throws Exception;
    
}
