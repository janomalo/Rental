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

                    List<Producto> listpro = (List<Producto>) request.getAttribute("listaproductos");
                    Iterator<Producto> iterp = listpro.iterator();
                    Producto pro = null;
                    while (iterp.hasNext()) {
                        pro = iterp.next();

                %>
                <tbody>

                    <tr>

                        <%--<td> <%= usu.getId() %></td> --%>
                        <td><%= pro.getId()%> </td>
                        <td><%= pro.getCategoria_id()%> </td>
                        <td> <%= pro.getNombre()%> </td>
                        <td> <%= pro.getDescripcion()%> </td>
                        <td> <%= pro.getStock()%> </td>
                        <td> <%= pro.getPrecio()%> </td>
                        <td> <%= pro.getEstado()%> </td>

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
    </body>
</html>
