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
            stmt.setDouble(3, r.getPrecio());
            stmt.setDate(4, (new java.sql.Date(r.getFecha_reserva().getTime())));
            stmt.setInt(5, r.getCantidad_dias());
            stmt.setDate(6, (new java.sql.Date(r.getFecha_desde().getTime())));
            resultado = stmt.executeUpdate();

            keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet != null && keyResultSet.next()) {
                //usar keyresult para guardar reserva id autogenerado
                // c.setId(keyResultSet.getInt(1));

                for (ListaProducto detalle : r.getDetalle()) {
                    stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
                            "insert into lista_productos(id,reserva_id,producto_id,cantidad,subtotal) VALUES(NULL,?,?,?,?)");
                    stmt.setInt(1, keyResultSet.getInt(1));
                    stmt.setInt(2, detalle.getProducto_id());
                    stmt.setInt(3, detalle.getCantidad());
                    stmt.setDouble(4, detalle.getSubtotal());
                    resultado = stmt.executeUpdate();

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

    public List<Reserva> getAllbyID(int idusuarioreserva) {
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Reserva> reservas = new ArrayList<>();
        int idusu = idusuarioreserva;

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from reservas where usuario_id=" + idusu);

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

    public Reserva chequearReserva(int idreserva) {
        Reserva r = new Reserva();
        Statement stmt = null;
        ResultSet rs = null;
        ListaProducto listpro = new ListaProducto();
        List<ListaProducto> listaproductos = new ArrayList<>();

        try {
            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from reservas where id=" + idreserva);

            if (rs != null) {
                while (rs.next()) {
                    r.setId(rs.getInt("id"));
                    r.setTemporada_id(rs.getInt("temporada_id"));
                    r.setUsuario_id(rs.getInt("usuario_id"));
                    r.setPrecio(rs.getDouble("precio"));
                    r.setFecha_reserva(rs.getTimestamp("fecha_reserva"));
                    r.setFecha_desde(rs.getTimestamp("fecha_desde"));
                    r.setCantidad_dias(rs.getInt("cantidad_dias"));
                    r.setEstado(rs.getString("estado"));

                }
                stmt = FactoryConexion.getInstancia().getConn().createStatement();
                rs = stmt.executeQuery("select * from lista_productos where reserva_id=" + idreserva);

                // pbtener lista productos con el id de a reserva.
                if (rs != null) {
                    while (rs.next()) {
                        listpro.setItem(rs.getInt("id"));
                        listpro.setReserva_id(rs.getInt("reserva_id"));
                        listpro.setProducto_id(rs.getInt("producto_id"));
                        listpro.setCantidad(rs.getInt("cantidad"));
                        listpro.setSubtotal(rs.getDouble("subtotal"));
                        listaproductos.add(listpro);

                    }

                    r.setDetalle(listaproductos);
                    for (ListaProducto detalle : r.getDetalle()) {
                        stmt = FactoryConexion.getInstancia().getConn().createStatement();
                        rs = stmt.executeQuery("select * from productos where id=" + detalle.getProducto_id());
                           //obtener la cantidad y comprarla con el stock, setear estado de detalle     
                    }

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

        return r;
    }

}
