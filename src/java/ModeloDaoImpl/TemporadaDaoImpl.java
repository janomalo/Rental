/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.Categoria;
import Modelo.Temporada;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
                    t.setFecha_desde(rs.getTimestamp("fecha_desde"));
                    t.setFecha_hasta(rs.getTimestamp("fecha_hasta"));
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
                t.setFecha_desde(rs.getTimestamp("fecha_desde"));
                t.setFecha_hasta(rs.getTimestamp("fecha_hasta"));
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
    
    public int getIDByFecha(Timestamp fecha1) {
       int idtemporada=0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
               
        
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "SELECT t.id  FROM temporadas AS t WHERE (? BETWEEN t.fecha_desde AND t.fecha_hasta)"
            );
            
            stmt.setDate(1,new java.sql.Date(fecha1.getTime()));
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
               idtemporada= rs.getInt("id");
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

        return idtemporada;

    }
    
    

    public boolean update(Temporada t) {
        PreparedStatement stmt = null;
        int resultado;
        boolean boleano = false;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "update temporadas set descripcion=?,fecha_desde=?,fecha_hasta=?,precio=? where id=?");
            stmt.setString(1, t.getDescripcion());
            stmt.setDate(2, (new java.sql.Date(t.getFecha_desde().getTime())));
            stmt.setDate(3, (new java.sql.Date(t.getFecha_hasta().getTime())));
            stmt.setFloat(4, t.getPrecio());
            stmt.setInt(5, t.getId());

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

    public void add(Temporada t) {
        PreparedStatement stmt = null;
        ResultSet keyResultSet = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "insert into temporadas (id,descripcion,fecha_desde,fecha_hasta,precio) VALUES(NULL,?,?,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );
            stmt.setString(1, t.getDescripcion());
            stmt.setDate(2, (new java.sql.Date(t.getFecha_desde().getTime())));
            stmt.setDate(3, (new java.sql.Date(t.getFecha_hasta().getTime())));
            stmt.setFloat(4, t.getPrecio());            
            stmt.executeUpdate();

            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                t.setId(keyResultSet.getInt(1));
            }
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

}
