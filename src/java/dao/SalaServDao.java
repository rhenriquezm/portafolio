/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.SalaServ;
import java.util.ArrayList;

/**
 *
 * @author ricardo
 */
public interface SalaServDao {
    
    public ArrayList<SalaServ> getAll() throws Exception;

    public boolean insert(SalaServ salaser) throws Exception;

    public boolean delete(SalaServ salaser) throws Exception;
    
    public boolean deleteById(short id) throws Exception;

    public boolean update(SalaServ salaser) throws Exception;
   
    public SalaServ getById(short id) throws Exception;
    
}
