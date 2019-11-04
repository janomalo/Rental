
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Usuario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDao implements CRUD{
    
Conexion cn = new Conexion();
Connection con;
PreparedStatement ps;
ResultSet rs;
Usuario u=new Usuario();



    

    @Override
    public List listar() {
        ArrayList<Usuario> list=new ArrayList<>();
        String sql="select * from usuarios";
        try {
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario usu=new  Usuario();
               
                
                
            }
        } catch (Exception e) {
        }
    return list;
    }
    
    

    @Override
    public Usuario list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
