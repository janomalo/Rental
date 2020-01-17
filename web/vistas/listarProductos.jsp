<%-- 
    Document   : listarProductos
    Created on : 12-dic-2019, 20:27:18
    Author     : Alejandro
--%>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDaoImpl.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Productos</title>
    </head>
    <body>
        
        
        <div class="container">
            <h1>Productos</h1>
             
              <a href="ControladorProducto?accion=add">Agregar Nuevo</a> 
              <input type="text" value="Buscar"/>
              <a > Buscar</a>
            <table class="table">
                
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>CATEGORIA</th> 
                        <th>NOMBRE</th>
                        <th>DESCRIPCION</th>
                        <th>STOCK</th>
                        <th>PRECIO</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                           
                    </tr>
                </thead>
                <%
                   
                    ProductoDaoImpl dao= new ProductoDaoImpl();
                    List<Producto> list= dao.listar();
                    Iterator<Producto> iter=list.iterator();
                    Producto pro=null;
                    while(iter.hasNext()){
                        pro=iter.next();
                   
                %>
                <tbody>
                    
                    <tr>
                        
                        <%--<td> <%= usu.getId() %></td> --%>
                        <td><%= pro.getId() %> </td>
                        <td><%= pro.getCategoria_id() %> </td>
                        <td> <%= pro.getNombre() %> </td>
                        <td> <%= pro.getDescripcion() %> </td>
                        <td> <%= pro.getStock() %> </td>
                        <td> <%= pro.getPrecio() %> </td>
                        <td> <%= pro.getEstado() %> </td>
                       
                       <%-- <td> <%= usu.getFecha_registro()%> </td> --%>
                       <td>
                           <a class="btn btn-dark"  href="ControladorProducto?accion=editar&id=<%= pro.getId()%>">Editar</a>
                           <a class="btn btn-danger" href="ControladorProducto?accion=delete&id=<%= pro.getId()%>">Remove</a>
                       </td>
                        
                       
                        
                    </tr>
                    <%
                   }
                    
                    %>
                </tbody>
                
                               
                
            </table> 
                
              
                <a class="btn btn-success" href="index.jsp"> Volver</a>
            
            
            
            
            
            
        </div>
    </body>
</html>