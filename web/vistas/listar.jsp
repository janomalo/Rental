<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
    </head>
    <body>
        <div  class="container">
            <h1>Usuarios</h1> 
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
                
                <h1> FIN LISTAR</h1>
                <a class="btn btn-success" href="index.jsp"> Volver</a>
        </div>
    </body>
</html>
