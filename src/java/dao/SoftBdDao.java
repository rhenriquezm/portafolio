/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import POJO.SoftBd;
/**
 *
 * @author shelob
 */
public interface SoftBdDao {
    public ArrayList<SoftBd> getAll();

    public void insert(SoftBd sbd);

    public void delete(SoftBd sbd);
    
    public void deleteById(int id);

    public void update(SoftBd sbd);
   
    public SoftBd getById(int id);
}
