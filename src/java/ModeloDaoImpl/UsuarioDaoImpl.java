
package ModeloDaoImpl;


import Config.Conexion;
import Interfaces.IUsuarioDao;
import Modelo.Usuario;
import  java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

 
public class UsuarioDaoImpl implements IUsuarioDao{

    @Override
    public boolean save(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
       // Instancias la clase que hemos creado anteriormente
       Conexion SQL = new Conexion();
// Llamas al método que tiene la clase y te devuelve una conexión
 Connection conn = SQL.conectar();
// Query que usarás para hacer lo que necesites
         String sSQL ="SELECT * FROM usuarios";
        
        List<Usuario> listaUsuarios= new ArrayList<>();
        
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sSQL);
            while(rs.next()){
                Usuario u= new Usuario();
                u.setId(rs.getInt("id"));
                u.setDni(rs.getString("dni"));
                u.setNombres(rs.getString("dni"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setFecha_registro(rs.getDate("fecha_registro"));
                listaUsuarios.add(u);
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
    public boolean edit(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }





}