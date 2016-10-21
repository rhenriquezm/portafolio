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

    public ArrayList<Organizacion> getAll();

    public void insert(Organizacion org);

    public void delete(Organizacion org);

    public void deleteById(int id);

    public void update(Organizacion org);

    public Organizacion getById(int id);

}
