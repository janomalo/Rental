/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.Conexion;
import Interfaces.IProductoDao;
import Modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class ProductoDaoImpl implements IProductoDao {

    // Instancias la clase que hemos creado anteriormente
     
// Llamas al método que tiene la clase y te devuelve una conexión
     
    private Producto p=new Producto();
    
    
    
    @Override
    public boolean save(Producto p) {
        Conexion SQL = new Conexion();
       Connection conn = SQL.conectar();
        boolean save=false;
              
        String sSQL="INSERT INTO productos(id,categoria_id,nombre,descripcion,stock,precio,estado) VALUES(NULL,'"+p.getCategoria_id()+"','"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getStock()+"','"+p.getPrecio()+"','"+p.getEstado()+"')";
                      
        try {
            PreparedStatement ps=conn.prepareStatement(sSQL);
            ps.executeUpdate();
            save=true;
            conn.close();
            ps.close();
                       
        } catch (Exception e) {
            System.out.println("Error al agregar un producto");
            e.printStackTrace();
            } 
              
        return save;

    }

    @Override
    public List<Producto> listar() {
Conexion SQL = new Conexion();
       Connection conn = SQL.conectar();
         
// Query que usarás para hacer lo que necesites
         String sSQL ="SELECT * FROM productos";
        List<Producto> listaProductos= new ArrayList<>();
        
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sSQL);
            while(rs.next()){
                Producto pro= new Producto();
                //setear datos productos a objeto pro y agregara lista
                pro.setId(rs.getInt("id"));
                pro.setCategoria_id(rs.getInt("categoria_id"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setEstado(rs.getInt("estado"));
                
                //u.setFecha_registro(rs.getDate("fecha_registro"));
                listaProductos.add(pro);
            }
            stm.close();
            rs.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error:Clase UsuarioDaoImpl,metodo obtener");
            e.printStackTrace();
        }
   
                return listaProductos;
   




    }

    @Override
    public Producto list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
