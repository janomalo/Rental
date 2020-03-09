package ModeloDaoImpl;

//import Config.Conexion;
import Config.FactoryConexion;

import Interfaces.IUsuarioDao;
import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl implements IUsuarioDao {

    public static Usuario login(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Instancias la clase que hemos creado anteriormente
    //  Conexion SQL = new Conexion();
// Llamas al método que tiene la clase y te devuelve una conexión
    //Connection conn = SQL.conectar();
// Usuario u=new Usuario();
    @Override
    public void save(Usuario usu) {
        //boolean save=false;
        PreparedStatement stmt = null;
        ResultSet keyResultSet = null;

        //String sSQL="INSERT INTO usuarios(id,dni,rol_id,nombres,apellidos,telefono,email,password,fecha_registro,direccion,usuario,habilitado) VALUES(NULL,'"+usu.getDni()+"','"+usu.getRol()+"','"+usu.getNombres()+"','"+usu.getApellidos()+"','"+usu.getTelefono()+"','"+usu.getEmail()+"',SHA1('"+usu.getPassword()+"'),CURDATE(),'"+usu.getDireccion()+"','"+usu.getUsuario()+"','"+usu.getHabilitado()+"')";
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO usuarios(id,dni,rol_id,nombres,apellidos,telefono,email,password,direccion,usuario,habilitado) VALUES(NULL,?,?,?,?,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, usu.getDni());
            stmt.setInt(2, usu.getRol());
            stmt.setString(3, usu.getNombres());
            stmt.setString(4, usu.getApellidos());
            stmt.setString(5, usu.getTelefono());
            stmt.setString(6, usu.getEmail());
            stmt.setString(7, usu.getPassword());
            //stmt.setString(8, usu.getFecha_registro());
            stmt.setString(8, usu.getDireccion());
            stmt.setString(9, usu.getUsuario());
            stmt.setInt(10, usu.getHabilitado());
            stmt.executeUpdate();
            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                usu.setId(keyResultSet.getInt(1));
            }

            //ps.executeUpdate();
            //save=true;
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (keyResultSet != null) {
                    keyResultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConexion.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Usuario> listar() {

        Statement stmt = null;
        ResultSet rs = null;
// Query que usarás para hacer lo que necesites
        String sSQL = "SELECT * FROM usuarios";
        List<Usuario> listaUsuarios = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery(sSQL);

            if (rs != null) {

                while (rs.next()) {
                    Usuario usu = new Usuario();
                    usu.setId(rs.getInt("id"));
                    usu.setDni(rs.getString("dni"));
                    usu.setNombres(rs.getString("nombres"));
                    usu.setApellidos(rs.getString("apellidos"));
                    usu.setTelefono(rs.getString("telefono"));
                    usu.setDireccion(rs.getString("direccion"));
                    usu.setEmail(rs.getString("email"));
                    usu.setUsuario(rs.getString("usuario"));
                    usu.setHabilitado(rs.getInt("habilitado"));
                    //u.setFecha_registro(rs.getDate("fecha_registro"));
                    listaUsuarios.add(usu);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            FactoryConexion.getInstancia().releaseConn();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return listaUsuarios;

    }

    @Override
    public boolean edit(Usuario u) {
        //Al listar pass y volver a guardarla 
        PreparedStatement stmt = null;
        //String sSQL=String.format("UPDATE usuarios SET dni='"+u.getDni()+"',nombres='"+u.getNombres()+"',apellidos='"+u.getApellidos()+"',telefono='"+u.getTelefono()+"',email='"+u.getEmail()+"',password=SHA1('"+u.getPassword()+"'),direccion='"+u.getDireccion()+"',usuario='"+u.getUsuario()+"',habilitado='"+u.getHabilitado()+"' WHERE id="+u.getId());

        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE usuarios SET dni=?,nombres=?,apellidos=?,telefono=?,email=?,password=?,direccion=?,usuario=?,habilitado=? WHERE id=?");
            stmt.setString(1, u.getDni());
            stmt.setString(2, u.getNombres());
            stmt.setString(3, u.getApellidos());
            stmt.setString(4, u.getTelefono());
            stmt.setString(5, u.getEmail());
            stmt.setString(6, u.getPassword());
            stmt.setString(7, u.getDireccion());
            stmt.setString(8, u.getUsuario());
            stmt.setInt(9, u.getHabilitado());
            stmt.setInt(10, u.getId());
            stmt.executeUpdate();
            //PreparedStatement ps= conn.prepareStatement(sSQL);
            //ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
            FactoryConexion.getInstancia().releaseConn();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void delete(Usuario u) {
        PreparedStatement stmt = null;

        //String sSQL="DELETE FROM usuarios WHERE id="+u.getId();
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM usuarios WHERE id=?");
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
            FactoryConexion.getInstancia().releaseConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Usuario list(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        String sSQL = "SELECT * FROM usuarios WHERE id=" + id;
        Usuario u = new Usuario();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setDni(rs.getString("dni"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setEmail(rs.getString("email"));
                u.setUsuario(rs.getString("usuario"));
                u.setHabilitado(rs.getInt("habilitado"));
                //u.setFecha_registro(rs.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            FactoryConexion.getInstancia().releaseConn();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return u;

    }

    @Override
    public Usuario validar(Usuario u) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sSql = "SELECT * FROM usuarios WHERE usuario=? and password=?";
        try {

            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(sSql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getPassword());
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    u.setUsuario(rs.getString("usuario"));
                    u.setNombres(rs.getNString("nombres"));
                    u.setRol(rs.getInt("rol_id"));
                    u.setApellidos(rs.getNString("apellidos"));
                    u.setEmail(rs.getNString("email"));
                    u.setHabilitado(rs.getInt("habilitado"));
                   

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            FactoryConexion.getInstancia().releaseConn();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return u;
    }

}





