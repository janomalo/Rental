/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.*;


public class Conexion {
    
    
   
    public static Connection conectar(){
        
        Connection con=null;
        
        String password=" ";
        String usuario="root";
        String url= "jdbc:mysql://localhost:3306/rental?user="+ usuario + "&password="+ password;
        try {
          con= DriverManager.getConnection(url);
          if(con != null){
              System.out.println("Conectado");
          }
            
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();            
            
        }
        return con;
    }
    public Connection getConnection(){
        Connection con = null;
        return con;
    }
    }

    
    
