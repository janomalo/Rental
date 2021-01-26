/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.ListaProducto;

import Modelo.Reserva;
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
public class ReservaDaoImpl {

    /*
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
    }*/
 /*
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
    }*/

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
    public ArrayList<Reserva> getAll() {
       Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from reservas");
            if (rs != null) {
                while (rs.next()) {
                    Reserva r = new Reserva();
                    r.setId(rs.getInt("id"));
                    r.setTemporada_id(rs.getInt("temporada_id"));
                    r.setUsuario_id(rs.getInt("usuario_id"));
                    r.setPrecio(rs.getDouble("precio"));
                   r.setFecha_reserva(rs.getTimestamp("fecha_reserva"));
                   r.setFecha_desde(rs.getTimestamp("fecha_desde"));
                   r.setCantidad_dias(rs.getInt("cantidad_dias"));
                   r.setEstado(rs.getString("estado"));
                    reservas.add(r);
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

        return reservas;
    }
    
    
    
    public int add(Reserva r) {
        int resultado = 0;
        PreparedStatement stmt = null;
        ResultSet keyResultSet = null;
        try {
            stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "insert into reservas(id,temporada_id,usuario_id,precio,fecha_reserva,cantidad_dias,fecha_desde) VALUES(NULL,?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, r.getTemporada_id());
            stmt.setInt(2, r.getUsuario_id());
            stmt.setDouble(3,r.getPrecio());
            stmt.setDate(4, (new java.sql.Date(r.getFecha_reserva().getTime())));
            stmt.setInt(5, r.getCantidad_dias());
            stmt.setDate(6, (new java.sql.Date(r.getFecha_desde().getTime())));
            resultado=stmt.executeUpdate();

            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                //usar keyresult para guardar reserva id autogenerado
                // c.setId(keyResultSet.getInt(1));
                
                for (ListaProducto detalle : r.getDetalle()) {
                    stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                    "insert into lista_productos(id,reserva_id,producto_id,cantidad,subtotal) VALUES(NULL,?,?,?,?)");
                    stmt.setInt(1, keyResultSet.getInt(1));
                    stmt.setInt(2, detalle.getProducto_id());
                    stmt.setInt(3,detalle.getCantidad());
                    stmt.setDouble(4,detalle.getSubtotal());
                    resultado=stmt.executeUpdate();
                    
                }
                
                
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
        return resultado;
    }
    /*
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
     */

    public List<Reserva> getAllbyID(int idusuarioreserva) {
      Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = new ArrayList<>();
        int idusu=idusuarioreserva;
        

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from reservas where usuario_id="+idusu);                      
            
            
            if (rs != null) {
                while (rs.next()) {
                    Reserva r = new Reserva();
                    r.setId(rs.getInt("id"));
                    r.setTemporada_id(rs.getInt("temporada_id"));
                    r.setUsuario_id(rs.getInt("usuario_id"));
                    r.setPrecio(rs.getDouble("precio"));
                   r.setFecha_reserva(rs.getTimestamp("fecha_reserva"));
                   r.setFecha_desde(rs.getTimestamp("fecha_desde"));
                   r.setCantidad_dias(rs.getInt("cantidad_dias"));
                   r.setEstado(rs.getString("estado"));
                    reservas.add(r);
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

        return reservas;

    }

    

}
