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
        
        <div>
            
            <a href="Controlador?accion=listar"> Listar Usuario</a> <br>
            <a href="Controlador?accion=add">Agregar Usuario</a> <br>
            <a>Editar Usuario</a><br>
            
            
       </div>
    </body>
</html>
