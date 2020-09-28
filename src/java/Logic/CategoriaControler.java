/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Categoria;
import ModeloDaoImpl.CategoriaDaoImpl;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class CategoriaControler {

     CategoriaDaoImpl dao;
    public CategoriaControler() {
        dao= new CategoriaDaoImpl();
    }
    
    
    

    public List<Categoria> getAll() {
        
        return dao.getAll();
    }

    public Categoria getById(int idcategoria) {
       
        return dao.getById(idcategoria);
    }

    public boolean update(Categoria cat) {
       return dao.update(cat);
    }

    public void delete(Categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save(Categoria cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
