

<%@page import="Modelo.Rol"%>
<%@page import="Logic.RolControler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Rol</title>
    </head>
    <body>
        <div class="container col-10">
        <h1>Editar Rol</h1>
         <%
           
           Rol r= (Rol)session.getAttribute("rol");
        
        %>
        <form action="Roles"  class="form-text">
                <input  type="hidden"  name="txtidrol"  value="<%= r.getId() %>">
                Descripción <input type="text"   class="form-control" name="txtnamerol" value="<%=r.getNombre() %>"><br>
                <input  class=" btn btn-success" type="submit" value="Actualizar" name="accion">
                <a class="btn btn-danger" href="index.jsp"> Volver</a>
                
        </form>
                
                </div>
    </body>
</html>
