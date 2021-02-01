/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Modelo.Producto;
import ModeloDaoImpl.ProductoDaoImpl;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ProductoControler {
    ProductoDaoImpl dao;

    public ProductoControler() {
        dao= new ProductoDaoImpl();
    }

    public void save(Producto pro) {
        
        dao.save(pro);
    }
    public List<Producto> getAll() {
        return (List<Producto>) dao.listar();
        
    }
    public List<Producto> getAllDisponibles() {
        return (List<Producto>) dao.listarDisponibles();
        
    }
    
    public Producto list(int id){
    
        return dao.list(id);
    }
    
    public Boolean update(Producto p){
        return dao.edit(p);
    }

    public void delete(Producto pro) {
        dao.delete(pro);
    }
    
    
}
