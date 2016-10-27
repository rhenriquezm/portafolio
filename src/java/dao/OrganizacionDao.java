/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Organizacion;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface OrganizacionDao {

    public ArrayList<Organizacion> getAll() throws Exception;

    public boolean insert(Organizacion org) throws Exception;

    public boolean delete(Organizacion org) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(Organizacion org) throws Exception;

    public Organizacion getById(short id) throws Exception;
}
