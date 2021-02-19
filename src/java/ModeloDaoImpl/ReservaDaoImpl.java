/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDaoImpl;

import Config.FactoryConexion;
import Modelo.ListaProducto;

import Modelo.Reserva;
import com.sun.xml.internal.bind.api.impl.NameConverter;
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
            }

            stmt = FactoryConexion.getInstancia().getConn().createStatement();
            rs = stmt.executeQuery("select * from lista_productos where reserva_id=" + idreserva);

            // pbtener lista productos con el id de a reserva.
            if (rs != null) {
                while (rs.next()) {
                    ListaProducto listpro = new ListaProducto();
                    listpro.setItem(rs.getInt("id"));
                    listpro.setReserva_id(rs.getInt("reserva_id"));
                    listpro.setProducto_id(rs.getInt("producto_id"));
                    listpro.setCantidad(rs.getInt("cantidad"));
                    listpro.setSubtotal(rs.getDouble("subtotal"));
                    listaproductos.add(listpro);

                }
            }

            for (ListaProducto l : listaproductos) {
                /*try {
                            
                        } catch (Exception e) {
                        }*/

                stmt = FactoryConexion.getInstancia().getConn().createStatement();
                rs = stmt.executeQuery("select * from productos where id=" + l.getProducto_id());

                if (rs.next()) {
                    int haystock = rs.getInt("stock") - l.getCantidad();
                    int estado = rs.getInt("estado");
                    if (haystock > 0) {
                        l.setPrecio(rs.getDouble("precio"));
                        l.setNombre(rs.getString("nombre"));
                        l.setDescripcion(rs.getString("descripcion"));
                        if (rs.getInt("estado") != 0) {
                            l.setDetalle_reserva("Producto Disponible");
                        } else {
                            l.setDetalle_reserva("Producto No Disponible");
                        }

                    } else {
                        l.setPrecio(rs.getDouble("precio"));
                        l.setNombre(rs.getString("nombre"));
                        l.setDescripcion(rs.getString("descripcion"));
                        l.setDetalle_reserva("No hay Stock Disponible");

                    }

                }
                r.setDetalle(listaproductos);

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

    public void aprobarReserva(Reserva raprobada) {
        //aprobar reserva , descontar stock y avisar al usuario cambiando estado reserva /correo con detalle
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        int resultado = 0;
        int con = 0;
        boolean boleano = false;
        List<ListaProducto> detalle = raprobada.getDetalle();
        try {
            //actualiza detalle de productos agregados a la reserva
            for (ListaProducto l : detalle) {

                stmt = FactoryConexion.getInstancia().getConn().createStatement();
                rs = stmt.executeQuery("select * from productos where id=" + l.getProducto_id());

                if (rs.next()) {
                    int haystock = rs.getInt("stock") - l.getCantidad();
                    int estado = rs.getInt("estado");
                    if (haystock > 0) {
                        if (estado != 0) {
                            l.setDetalle_reserva("Producto Disponible");
                            con = con + 1;
                            //guardar detalle en tabla lista productos 
                            pstmt = FactoryConexion.getInstancia().getConn().
                                    prepareStatement(
                                            "update lista_productos set detalle=? where id=?");
                            pstmt.setString(1, l.getDetalle_reserva());
                            pstmt.setInt(2, l.getItem());
                            pstmt.executeUpdate();

                        } else {
                            //guardar detalle en tabla lista productos de no aprobado
                            l.setDetalle_reserva("Producto No Disponible");
                            pstmt = FactoryConexion.getInstancia().getConn().
                                    prepareStatement(
                                            "update lista_productos set detalle=? where id=?");
                            pstmt.setString(1, l.getDetalle_reserva());
                            pstmt.setInt(2, l.getItem());
                            pstmt.executeUpdate();
                        }

                    } else {
                        l.setDetalle_reserva("No hay Stock Disponible");
                        //guardar detalle en tabla lista productos de no aprobado                        
                        pstmt = FactoryConexion.getInstancia().getConn().
                                prepareStatement(
                                        "update lista_productos set detalle=? where id=?");
                        pstmt.setString(1, l.getDetalle_reserva());
                        pstmt.setInt(2, l.getItem());
                        pstmt.executeUpdate();

                    }

                }

            }
             
            //si todos los productos hay stock y con estado disponible ,actualiza stock y cambia estado Reserva pendiente -> Aprobada
            if (con == detalle.size()) {

                //actualizar stock 
                for (ListaProducto l : detalle) {
                    stmt = FactoryConexion.getInstancia().getConn().createStatement();
                    rs = stmt.executeQuery("select * from productos where id=" + l.getProducto_id());
                    if (rs.next()) {
                        int stock = rs.getInt("stock") - l.getCantidad();

                        pstmt = FactoryConexion.getInstancia().getConn().
                                prepareStatement( "update productos set stock=? where id=?");
                        pstmt.setInt(1, stock);
                        pstmt.setInt(2, l.getProducto_id());
                        pstmt.executeUpdate();

                    }

                }

                raprobada.setEstado("Aprobada");
                pstmt = FactoryConexion.getInstancia().getConn().
                        prepareStatement(
                                "update reservas set estado=?,detalle=? where id=?");
                pstmt.setString(1, raprobada.getEstado());
                pstmt.setString(2, raprobada.getEstadodetalle());
                pstmt.setInt(3, raprobada.getId());
                resultado = pstmt.executeUpdate();//devuelve cantidad int de filas updateadas 

            } else {
                raprobada.setEstado("No Aprobada");

                pstmt = FactoryConexion.getInstancia().getConn().
                        prepareStatement(
                                "update reservas set estado=?,detalle=? where id=?");
                pstmt.setString(1, raprobada.getEstado());
                pstmt.setString(2, raprobada.getEstadodetalle());
                pstmt.setInt(3, raprobada.getId());

                resultado = pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if(pstmt != null){
                pstmt.close();
                }
                FactoryConexion.getInstancia().releaseConn();

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }

    }

}
