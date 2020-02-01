/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public interface IProductoDao {
    
    public void save(Producto producto);
    public List<Producto> listar();
    public Producto list(int id);
    public boolean edit(Producto producto);
    public void delete(Producto producto);
    
}
