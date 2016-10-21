/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import POJO.LengDesSist;

/**
 *
 * @author shelob
 */
public interface LengDesSistDao {
    
    public ArrayList<LengDesSist> getAll();

    public void insert(LengDesSist ld);

    public void delete(LengDesSist ld);
    
    public void deleteById(int id);

    public void update(LengDesSist ld);
   
    public LengDesSist getById(int id);
}
