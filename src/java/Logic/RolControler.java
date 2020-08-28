/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Rol;
import ModeloDaoImpl.RolDaoImpl;
import java.util.ArrayList;

/**
 *
 * @author Cajaingros
 */
public class RolControler {

    RolDaoImpl dao;
    public RolControler() {
        
        dao= new RolDaoImpl();
    }
    
    public ArrayList<Rol> getAll() {
        return (ArrayList<Rol>) dao.getAll();
        
    }
    
    public Rol getById(int id){
    
        return dao.getById(id);
    }

    public boolean update(Rol r) {
       
        return dao.update(r);
       
    }
    
    
    
}
