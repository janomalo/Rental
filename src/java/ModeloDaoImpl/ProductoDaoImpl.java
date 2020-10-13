/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.Conexion;
import Config.FactoryConexion;

import Modelo.Producto;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
public class ProductoDaoImpl  {

    // Instancias la clase que hemos creado anteriormente
// Llamas al método que tiene la clase y te devuelve una conexión
    private Producto p = new Producto();

    
    public void save(Producto p) {
        PreparedStatement stmt = null;
        ResultSet keyResultSet = null;

        //String sSQL="INSERT INTO productos(id,categoria_id,nombre,descripcion,stock,precio,estado) VALUES(NULL,'"+p.getCategoria_id()+"','"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getStock()+"','"+p.getPrecio()+"','"+p.getEstado()+"')";
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("INSERT INTO productos(id,categoria_id,nombre,descripcion,stock,precio,estado) VALUES(NULL,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setInt(1, p.getCategoria_id());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getDescripcion());
            stmt.setInt(4, p.getStock());
            stmt.setFloat(5, p.getPrecio());
            stmt.setInt(6, p.getEstado());
            stmt.executeUpdate();
            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                p.setId(keyResultSet.getInt(1));
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

   
    public List<Producto> listar() {
        Statement stmt = null;
        ResultSet rs = null;
// Query que usarás para hacer lo que necesites
        String sSQL = "SELECT * FROM productos";
        List<Producto> listaProductos = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery(sSQL);
            if (rs != null) {
                while (rs.next()) {
                    Producto pro = new Producto();
                    //setear datos productos a objeto pro y agregara lista
                    pro.setId(rs.getInt("id"));
                    pro.setCategoria_id(rs.getInt("categoria_id"));
                    pro.setNombre(rs.getString("nombre"));
                    pro.setDescripcion(rs.getString("descripcion"));
                    pro.setStock(rs.getInt("stock"));
                    pro.setPrecio(rs.getFloat("precio"));
                    pro.setEstado(rs.getInt("estado"));
                    pro.setFoto(rs.getBinaryStream("foto"));

                    //u.setFecha_registro(rs.getDate("fecha_registro"));
                    listaProductos.add(pro);
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

        return listaProductos;

    }

    public void listarImg(int idP, HttpServletResponse response) {
        //manejo de imagen
        Statement stmt = null;
        ResultSet rs = null;
        String sSql = "select * from productos where id=" + idP;
        //declarar variables para manejo de imagen
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            outputStream = response.getOutputStream();
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery(sSql);
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {

        }

    }

   
    public Producto list(int id) {
        Statement stmt = null;
        ResultSet rs = null;
        String sSQL = "SELECT * FROM productos WHERE id=" + id;
        Producto p = new Producto();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery(sSQL);
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setCategoria_id(rs.getInt("categoria_id"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setStock(rs.getInt("stock"));
                p.setPrecio(rs.getFloat("precio"));
                p.setEstado(rs.getInt("estado"));//u.setFecha_registro(rs.getDate("fecha_registro"));
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
        return p;

    }

    
    public boolean edit(Producto p) {
        //Al listar pass y volver a guardarla 
        PreparedStatement stmt = null;
        //String sSQL=String.format("UPDATE usuarios SET dni='"+u.getDni()+"',nombres='"+u.getNombres()+"',apellidos='"+u.getApellidos()+"',telefono='"+u.getTelefono()+"',email='"+u.getEmail()+"',password=SHA1('"+u.getPassword()+"'),direccion='"+u.getDireccion()+"',usuario='"+u.getUsuario()+"',habilitado='"+u.getHabilitado()+"' WHERE id="+u.getId());
        int resultado;
        boolean boleano = false;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("UPDATE productos SET categoria_id=?,nombre=?,descripcion=?,stock=?,precio=?,estado=? WHERE id=?");
            stmt.setInt(1, p.getCategoria_id());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getDescripcion());
            stmt.setInt(4, p.getStock());
            stmt.setFloat(5, p.getPrecio());
            stmt.setInt(6, p.getEstado());
            stmt.setInt(7, p.getId());
            resultado=stmt.executeUpdate();
            if(resultado>0){
                boleano=true;
            }
            
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

   
    public void delete(Producto p) {
        PreparedStatement stmt = null;

        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM productos WHERE id=?");
            stmt.setInt(1, p.getId());
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
}
