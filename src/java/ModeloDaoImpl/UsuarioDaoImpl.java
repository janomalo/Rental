package ModeloDaoImpl;

//import Config.Conexion;
import Config.FactoryConexion;


import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl {

    public static Usuario login(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public boolean edit(Usuario u) {
        //Al listar pass y volver a guardarla 
        PreparedStatement stmt = null;
        //String sSQL=String.format("UPDATE usuarios SET dni='"+u.getDni()+"',nombres='"+u.getNombres()+"',apellidos='"+u.getApellidos()+"',telefono='"+u.getTelefono()+"',email='"+u.getEmail()+"',password=SHA1('"+u.getPassword()+"'),direccion='"+u.getDireccion()+"',usuario='"+u.getUsuario()+"',habilitado='"+u.getHabilitado()+"' WHERE id="+u.getId());
        int resultado;
        boolean boleano = false;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE usuarios SET dni=?,nombres=?,apellidos=?,telefono=?,email=?,direccion=?,usuario=?,habilitado=? WHERE id=?");
            stmt.setString(1, u.getDni());
            stmt.setString(2, u.getNombres());
            stmt.setString(3, u.getApellidos());
            stmt.setString(4, u.getTelefono());
            stmt.setString(5, u.getEmail());
            stmt.setString(6, u.getDireccion());
            stmt.setString(7, u.getUsuario());
            stmt.setInt(8, u.getHabilitado());
            stmt.setInt(9, u.getId());
            resultado=stmt.executeUpdate();
            if(resultado>0){
                boleano=true;
            }
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

        return boleano;
    }

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

    public Usuario list(int id) { // seria como getbyusu
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
        if (u != null) {
            return u;
        } else {
            u = null;
            return u;
        }

    }

    public Usuario validar(Usuario u) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = new Usuario();

        try {

            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("SELECT * FROM usuarios WHERE usuario=? and password=?");
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getPassword());
            rs = stmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    usu.setId(rs.getInt("id"));
                    usu.setUsuario(rs.getString("usuario"));
                    usu.setNombres(rs.getString("nombres"));
                    usu.setRol(rs.getInt("rol_id"));
                    usu.setApellidos(rs.getString("apellidos"));
                    usu.setEmail(rs.getString("email"));
                    usu.setHabilitado(rs.getInt("habilitado"));
                    

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        }
        return usu;
    }

    public int getidbyDni(int dni) {
        int id=0;      
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "select id from usuarios where dni=?"
            );
            stmt.setInt(1, dni);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                id = rs.getInt("id");               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        }
       
        return id;
    }

    public int getRolbyId(int idusuario) {
         int rol=0;      
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "select rol_id from usuarios where id=?"
            );
            stmt.setInt(1, idusuario);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                rol = rs.getInt("rol_id");               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        }
       
        return rol;
    }

}
