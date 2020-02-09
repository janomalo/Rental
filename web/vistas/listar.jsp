
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Interfaces.IUsuarioDao"%>
<%@page import="ModeloDaoImpl.UsuarioDaoImpl" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" data-integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <div  class="container-xl">
            <h1>GESTION DE USUARIOS PARA ADMIN</h1> 
             <a href="Controlador?accion=add">Agregar Nuevo</a> 
             <a > Buscar</a>
            <table class="table">
                
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th> 
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>TELEFONO</th>
                        <th>DIRECCION</th>
                        <th>EMAIL</th>
                        <th>USER</th>
                        <th>HABILITADO(S=1/N=0)</th>
                        <%--<th>FECHA REGISTRO</th> --%>
                        <th>ACCIONES</th>
                                                  
                    </tr>
                </thead>
                <%
                   
                    UsuarioDaoImpl dao= new UsuarioDaoImpl();
                    List<Usuario> list=dao.listar();
                    Iterator<Usuario> iter=list.iterator();
                   Usuario usu= null;
                    while(iter.hasNext()){
                        usu=iter.next();
                    
                                    
                %>
                <tbody>
                    
                    <tr>
                        <td> <%= usu.getId() %></td>
                      <td> <%= usu.getDni() %></td>
                       <td> <%= usu.getNombres()%></td>
                       <td> <%= usu.getApellidos()%></td>
                       <td>  <%= usu.getTelefono()%></td>
                       <td> <%= usu.getDireccion()%></td>
                       <td> <%= usu.getEmail() %> </td>
                       <td> <%= usu.getUsuario()%> </td>
                       <td> <%= usu.getHabilitado() %> </td>
                       
                       
                       <%-- <td> <%= usu.getFecha_registro()%> </td> --%>
                       <td>
                           <a class="btn btn-dark"  href="Controlador?accion=editar&id=<%= usu.getId()%>">Editar</a>
                           <a class="btn btn-danger" href="Controlador?accion=delete&id=<%= usu.getId()%>">Remove</a>
                       </td>
                        
                        
                        
                    </tr>
                    <%
                    }
                    
                    %>
                </tbody>
                
                               
                
            </table> 
                
              
                <a class="btn btn-success" href="index.jsp"> Volver</a>
        </div>
                
                
                 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" data-integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" data-integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" data-integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
