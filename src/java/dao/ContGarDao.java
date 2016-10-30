/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import POJO.ContGar;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface ContGarDao {

    public ArrayList<ContGar> getAll() throws Exception;

    public boolean insert(ContGar cg) throws Exception;

    public boolean delete(ContGar cg) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(ContGar cg) throws Exception;

    public ContGar getById(short id) throws Exception;

}
