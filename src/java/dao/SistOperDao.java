/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.SistOper;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface SistOperDao {

    public ArrayList<SistOper> getAll() throws Exception;

    public boolean insert(SistOper so) throws Exception;

    public boolean delete(SistOper so) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(SistOper so) throws Exception;

    public SistOper getById(short id) throws Exception;
}
