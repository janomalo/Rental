
package ModeloDaoImpl;


import Config.Conexion;
import Interfaces.IUsuarioDao;
import Modelo.Usuario;
import  java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class UsuarioDaoImpl implements IUsuarioDao{
    
     // Instancias la clase que hemos creado anteriormente
     Conexion SQL = new Conexion();
// Llamas al método que tiene la clase y te devuelve una conexión
 Connection conn = SQL.conectar();
 Usuario u=new Usuario();

    @Override
    public boolean save(Usuario usu) {
        boolean save=false;
              
        String sSQL="INSERT INTO usuarios(id,dni,rol_id,nombres,apellidos,telefono,email,password,fecha_registro,direccion) VALUES(NULL,'"+usu.getDni()+"','"+usu.getRol()+"','"+usu.getNombres()+"','"+usu.getApellidos()+"','"+usu.getTelefono()+"','"+usu.getEmail()+"',SHA1('"+usu.getPassword()+"'),CURDATE(),'"+usu.getDireccion()+"')";
                      
        try {
            PreparedStatement ps=conn.prepareStatement(sSQL);
            ps.executeUpdate();
            save=true;
            conn.close();
                       
        } catch (Exception e) {
            System.out.println("Error al agregar un usuario");
            e.printStackTrace();
            }
               
              
        return save;
    }

    @Override
    public List<Usuario> listar() {
     
// Query que usarás para hacer lo que necesites
         String sSQL ="SELECT * FROM usuarios";
        List<Usuario> listaUsuarios= new ArrayList<>();
        
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sSQL);
            while(rs.next()){
                Usuario usu= new Usuario();
                usu.setId(rs.getInt("id"));
                usu.setDni(rs.getString("dni"));
                usu.setNombres(rs.getString("nombres"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setTelefono(rs.getString("telefono"));
                usu.setDireccion(rs.getString("direccion"));
                usu.setEmail(rs.getString("email"));
                //u.setFecha_registro(rs.getDate("fecha_registro"));
                listaUsuarios.add(usu);
            }
            stm.close();
            rs.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Error:Clase UsuarioDaoImpl,metodo obtener");
            e.printStackTrace();
        }
   
                return listaUsuarios;
   
    
    }

    @Override
    public boolean edit(Usuario u) {

        String sSQL="UPDATE usuarios SET dni='"+u.getDni()+"',nombres='"+u.getNombres()+"',apellidos='"+u.getApellidos()+"',telefono='"+u.getTelefono()+"',email='"+u.getEmail()+"',password=SHA1('"+u.getPassword()+"'),direccion='"+u.getDireccion()+"' WHERE id="+u.getId();
            try {
            PreparedStatement ps= conn.prepareStatement(sSQL);
            ps.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    
    
    return false;
    }

    @Override
    public boolean delete(Usuario u) {
        String sSQL="DELETE FROM usuarios WHERE id="+u.getId();
        
         try {
             PreparedStatement ps=conn.prepareStatement(sSQL);
             ps.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    return false;
    }

    @Override
    public Usuario list(int id) {
      String sSQL ="SELECT * FROM usuarios WHERE id="+id;
        
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sSQL);
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setDni(rs.getString("dni"));
                u.setNombres(rs.getString("dni"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                //u.setFecha_registro(rs.getDate("fecha_registro"));
              }
          stm.close();
            rs.close();
            
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
   
                return u;
   
    
    }





}