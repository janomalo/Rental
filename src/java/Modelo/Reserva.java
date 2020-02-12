/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alejandro
 */
public class Reserva {
    int id;
    int temporada_id;
    int usuario_id;
    float precio;
    String fecha_desde;
    int cantidad_dias;

    public Reserva() {
    }

    public Reserva(int id, int temporada_id, int usuario_id, float precio, String fecha_desde, int cantidad_dias) {
        this.id = id;
        this.temporada_id = temporada_id;
        this.usuario_id = usuario_id;
        this.precio = precio;
        this.fecha_desde = fecha_desde;
        this.cantidad_dias = cantidad_dias;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(String fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public int getCantidad_dias() {
        return cantidad_dias;
    }

    public void setCantidad_dias(int cantidad_dias) {
        this.cantidad_dias = cantidad_dias;
    }
    
    
    
    
    
}
