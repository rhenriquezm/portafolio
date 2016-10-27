/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.LengDesSist;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface LengDesSistDao {

    public ArrayList<LengDesSist> getAll() throws Exception;

    public boolean insert(LengDesSist lds) throws Exception;

    public boolean delete(LengDesSist lds) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(LengDesSist lds) throws Exception;

    public LengDesSist getById(short id) throws Exception;
}
