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
public class ListaProducto {
    int item;
    int reserva_id;
    int producto_id;
    int cantidad;
    double subtotal;
    double precio;
    String nombre;
    String descripcion;
    String detalle_reserva;
    
    public ListaProducto() {
    }

    public ListaProducto(int item, int reserva_id, int producto_id, int cantidad, double subtotal, double precio, String nombre, String descripcion, String detalle_reserva) {
        this.item = item;
        this.reserva_id = reserva_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.detalle_reserva = detalle_reserva;
    }

    public String getDetalle_reserva() {
        return detalle_reserva;
    }

    public void setDetalle_reserva(String detalle_reserva) {
        this.detalle_reserva = detalle_reserva;
    }

   

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

   

    
    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
    
}