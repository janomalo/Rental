/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Temporada {
    int id;
    String descripcion;
    Timestamp fecha_desde;
    String fecha_hasta;
    float precio;

    public Temporada() {
    }

    public Temporada(int id, String descripcion, Timestamp fecha_desde, String fecha_hasta, float precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_desde() {
        return fecha_desde;
    }

    public void setFecha_desde(Timestamp fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public String getFecha_hasta() {
        return fecha_hasta;
    }

    public void setFecha_hasta(String fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}
