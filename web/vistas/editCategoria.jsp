<%-- 
    Document   : editCategoria
    Created on : 24/09/2020, 21:26:16
    Author     : Alejandro
--%>

<%@page import="Modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Categoria</title>
    </head>
    <body>
        
        
        <%
           Categoria c= (Categoria) request.getAttribute("categoria");
                         
        
        %>
         <h1>Editar Usuario</h1>
         <div class="container col-lg-8">
             <form action="Categorias"  class="form-text" method="POST">
                <input  type="hidden"  name="txtid"  value="<%=c.getId() %>">
                NOMBRES <input type="text"   class="form-control" name="txtnombre" value="<%=c.getNombre() %>"><br>
                ESTADO <input type="text" class="form-control" name="txtestado" value="<%=c.getEstado() %>"><br>
                           
                             
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input  class=" btn btn-success" type="submit" value="update" name="accion">
                <a class="btn btn-danger" href="Categorias?accion=listar"> Volver</a>
            </form>
          </div>
        
    </body>
</html>
