/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.SoftBd;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface SoftBdDao {
    
    public ArrayList<SoftBd> getAll() throws Exception;

    public boolean insert(SoftBd sbd) throws Exception;

    public boolean delete(SoftBd sbd) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(SoftBd sbd) throws Exception;

    public SoftBd getById(short id) throws Exception;
}
