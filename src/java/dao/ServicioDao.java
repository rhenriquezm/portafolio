/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import POJO.Servicio;
import java.util.ArrayList;

/**
 *
 * @author shelob
 */
public interface ServicioDao {
    
    public ArrayList<Servicio> getAll() throws Exception;

    public boolean insert(Servicio serv) throws Exception;

    public boolean delete(Servicio serv) throws Exception;

    public boolean deleteById(short id) throws Exception;

    public boolean update(Servicio serv) throws Exception;

    public Servicio getById(short id) throws Exception;
}
