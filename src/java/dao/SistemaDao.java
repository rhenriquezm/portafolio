/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Sistema;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface SistemaDao {
    public ArrayList<Sistema> getAll() throws Exception;

    public boolean insert(Sistema sis) throws Exception;

    public boolean delete(Sistema sis) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(Sistema sis) throws Exception;

    public Sistema getById(short id) throws Exception;
}
