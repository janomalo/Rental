<%-- 
    Document   : listarProductos
    Created on : 12-dic-2019, 20:27:18
    Author     : Alejandro
--%>



<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDaoImpl.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" data-integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <title>GESTIÓN DE PRODUCTOS </title>
    </head>
    <body>
        
        
        <div class="container-fluid">
            <h1>GESTIÓN DE PRODUCTOS</h1>
             
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
                   
                   
                     List<Producto> listpro= (List<Producto>)request.getAttribute("listaproductos");
                    Iterator<Producto> iterp=listpro.iterator();
                    Producto pro=null;
                    while(iterp.hasNext()){
                        pro=iterp.next();
                   
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
                           <a class="btn btn-danger" href="ControladorProducto?accion=delete&id=<%= pro.getId()%>">Eliminar</a>
                       </td>
                        
                       
                        
                    </tr>
                    <%
                   }
                    
                    %>
                </tbody>
                
                               
                
            </table> 
             
                    <%-- <a class="btn btn-success" href="index.jsp"> Volver</a> --%>
                       
        </div>
                     <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" data-integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" data-integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" data-integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
