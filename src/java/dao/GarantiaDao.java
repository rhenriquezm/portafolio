/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Garantia;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface GarantiaDao {
    public ArrayList<Garantia> getAll() throws Exception;

    public boolean insert(Garantia ga) throws Exception;

    public boolean delete(Garantia ga) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(Garantia ga) throws Exception;

    public Garantia getById(short id) throws Exception;
}
