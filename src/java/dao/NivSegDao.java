/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.NivSeg;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface NivSegDao {

    public ArrayList<NivSeg> getAll() throws Exception;

    public boolean insert(NivSeg nsg) throws Exception;

    public boolean delete(NivSeg nsg) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(NivSeg nsg) throws Exception;

    public NivSeg getById(short id) throws Exception;
}
