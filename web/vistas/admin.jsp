<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
        
        <div>
            
            <a class="btn btn-danger" href="Controlador?accion=listar"> Listar Usuarios</a> <br>
            <a class="btn btn-danger" href="ControladorProducto?accion=listar"> Listar Productos</a> <br>
            <a href="welcome.jps"> WELCOME</a>
            
            
       </div>
        
                   </body>
</html>
