/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class CategoriaDaoImpl {

    public ArrayList<Categoria> getAll() {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from categorias");
            if (rs != null) {
                while (rs.next()) {
                    Categoria c = new Categoria();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setEstado(rs.getInt("estado"));
                    categorias.add(c);
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

        return categorias;
    }

    public Categoria getById(int id) {
        Categoria c = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "select * from categorias where id=?"
            );
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setEstado(rs.getInt("estado"));
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

        return c;
    }

   /* public Rol getByDesc(Rol rolToSearch) {
        Rol r = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "select * from rol where nombre=?"
            );
            stmt.setString(1, rolToSearch.getNombre());
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                r = new Rol();
                r.setId(rs.getInt("id"));
                r.setNombre(rs.getString("nombre"));
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

        return r;
    }*/

    

    public void add(Categoria c) {
        PreparedStatement stmt = null;
        ResultSet keyResultSet = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "insert into categorias(id,nombre,estado) VALUES(NULL,?,?)",
                            PreparedStatement.RETURN_GENERATED_KEYS );
            stmt.setString(1, c.getNombre());
            stmt.setInt(2, c.getEstado());
            stmt.executeUpdate();

            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                c.setId(keyResultSet.getInt(1));
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

    public void remove(Categoria c) {
        PreparedStatement stmt = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().
                    prepareStatement(
                            "delete from categorias where id=?");
            stmt.setInt(1, c.getId());
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
