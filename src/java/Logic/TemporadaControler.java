/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Categoria;
import Modelo.Temporada;
import ModeloDaoImpl.TemporadaDaoImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class TemporadaControler {
    
    TemporadaDaoImpl dao;
    public TemporadaControler() {
        
        dao= new TemporadaDaoImpl();
        
    }

    
    
    
    
    public ArrayList<Temporada> getAll() {
        return dao.getAll();
    }

    public Temporada getById(int idcategoria) {
       return dao.getById(idcategoria);
    }

    public void delete(Temporada tem) {
        dao.remove(tem);
    }

    public boolean update(Temporada tem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
