/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.NivSens;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface NivSensDao {

    public ArrayList<NivSens> getAll() throws Exception;

    public boolean insert(NivSens nsen) throws Exception;

    public boolean delete(NivSens nsen) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(NivSens nsen) throws Exception;

    public NivSens getById(short id) throws Exception;

}
