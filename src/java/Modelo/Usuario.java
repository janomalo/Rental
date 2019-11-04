
package Modelo;

import java.util.Date;


public class Usuario {
    int id;
    String dni;
    String nombres;
    String apellidos;
    int telefono;
    String direccion;
    Date  fecha_registro;
    String password;

    public Usuario() {
    }

    public Usuario(int id, String dni, String nombres, String apellidos, int telefono, String direccion, Date fecha_registro, String password) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_registro = fecha_registro;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

   
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    

    public void setId(int id) {
        this.id = id;
    }
    

    
    
    
    
}

