/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.DirIp;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface DirIpDao {
    
    public ArrayList<DirIp> getAll() throws Exception;

    public boolean insert(DirIp dip) throws Exception;

    public boolean delete(DirIp dip) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(DirIp dip) throws Exception;

    public DirIp getById(short id) throws Exception;
}
