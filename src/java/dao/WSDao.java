/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Webservice;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface WSDao {

    public ArrayList<Webservice> getAll();

    public void insert(Webservice ws);

    public void delete(Webservice ws);

    public void deleteById(int id);

    public void update(Webservice ws);

    public Webservice getById(int id);

}
