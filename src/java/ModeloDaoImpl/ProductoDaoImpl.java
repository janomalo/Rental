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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class ProductoDaoImpl implements IProductoDao {

    // Instancias la clase que hemos creado anteriormente
      Conexion SQL = new Conexion();
// Llamas al método que tiene la clase y te devuelve una conexión
   Connection conn = SQL.conectar();
    Producto p=new Producto();
    
    
    
    @Override
    public boolean save(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listar() {

         
// Query que usarás para hacer lo que necesites
         String sSQL ="SELECT * FROM productos";
        List<Producto> listaProductos= new ArrayList<>();
        
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sSQL);
            while(rs.next()){
                Producto pro= new Producto();
                //setear datos productos a objeto pro y agregara lista
                
                //u.setFecha_registro(rs.getDate("fecha_registro"));
                listaProductos.add(pro);
            }
            stm.close();
            rs.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error:Clase UsuarioDaoImpl,metodo obtener");
            e.printStackTrace();
        } finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
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
