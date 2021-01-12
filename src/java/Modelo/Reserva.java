/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Reserva {
    int id;
    int temporada_id;
    int usuario_id;
    double precio;
    Timestamp fecha_desde;
    int cantidad_dias;
    Timestamp fecha_reserva;
    List<ListaProducto> detalle;
    
    public Reserva() {
    }

    public Reserva(int temporada_id, int usuario_id, double precio, Timestamp fecha_desde, int cantidad_dias, Timestamp fecha_reserva, List<ListaProducto> detalle) {
        this.temporada_id = temporada_id;
        this.usuario_id = usuario_id;
        this.precio = precio;
        this.fecha_desde = fecha_desde;
        this.cantidad_dias = cantidad_dias;
        this.fecha_reserva = fecha_reserva;
        this.detalle = detalle;
    }

    public List<ListaProducto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<ListaProducto> detalle) {
        this.detalle = detalle;
    }

     

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemporada_id() {
        return temporada_id;
    }

    public void setTemporada_id(int temporada_id) {
        this.temporada_id = temporada_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

   
    
    public Timestamp getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Timestamp fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public int getCantidad_dias() {
        return cantidad_dias;
    }

    public void setCantidad_dias(int cantidad_dias) {
        this.cantidad_dias = cantidad_dias;
    }

    public Timestamp getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Timestamp fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    
}
