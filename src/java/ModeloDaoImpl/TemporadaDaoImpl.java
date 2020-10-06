/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.Categoria;
import Modelo.Temporada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class TemporadaDaoImpl {

    public ArrayList<Temporada> getAll() {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Temporada> temporadas = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from temporadas");
            if (rs != null) {
                while (rs.next()) {
                    Temporada t = new Temporada();
                    t.setId(rs.getInt("id"));
                    t.setDescripcion(rs.getString("descripcion"));
                    t.setFecha_desde(rs.getString("fecha_desde"));
                    t.setFecha_hasta(rs.getString("fecha_hasta"));
                    t.setPrecio(rs.getFloat("precio"));
                    temporadas.add(t);
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

        return temporadas;
    }

    public Temporada getById(int id) {
        Temporada t = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "select * from temporadas where id=?"
            );
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                t = new Temporada();
                t.setId(rs.getInt("id"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFecha_desde(rs.getString("fecha_desde"));
                t.setFecha_hasta(rs.getString("fecha_hasta"));
                 t.setPrecio(rs.getFloat("precio"));
                //fecha desde c.setEstado(rs.getInt("estado"));
                // fecha hastac.setEstado(rs.getInt("estado"));
                /// precio c.setEstado(rs.getInt("estado"));

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

        return t;

    }
public boolean update(Categoria c) {
        PreparedStatement stmt = null;
        int resultado;
        boolean boleano = false;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "update categorias set nombre=?,estado=? where id=?");
            stmt.setString(1, c.getNombre());
            stmt.setInt(2, c.getEstado());
            stmt.setInt(3, c.getId());
            resultado = stmt.executeUpdate(); //devuelve cantidad int de filas updateadas 
            if (resultado > 0) {
                boleano = true;
            } else {
                boleano = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                FactoryConexion.getInstancia().releaseConn();

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

        return boleano;
    }

    public void remove(Temporada t) {
        PreparedStatement stmt = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "delete from temporadas where id=?");
            stmt.setInt(1, t.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
    
    
    
    
    
    
    
}
