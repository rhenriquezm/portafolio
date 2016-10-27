/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Webservice;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface WebServiceDao {
    
    public ArrayList<Webservice> getAll() throws Exception;
    public boolean insert (Webservice ws) throws Exception;
    public boolean delete (Webservice ws) throws Exception;
    public boolean deleteById (short id) throws Exception;
    public boolean update (Webservice ws) throws Exception;
    public Webservice getById(short id) throws Exception;
}
