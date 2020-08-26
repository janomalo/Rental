

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
        <h1>Editar Rol</h1>
         <%
           //Rol rol=(Rol)request.getParameter("rol");
                //recuperar datos del ro y mostrar
        
        %>
        <form>
                    <input  type="hidden"  name="txtid"  value="<%=rol.getId() %>">
                DNI <input type="text"   class="form-control" name="txtdni" value="<%=u.getDni() %>"><br>
                <input  class=" btn btn-success" type="submit" value="Actualizar" name="accion">
                <a class="btn btn-danger" href="index.jsp"> Volver</a>
                
        </form>
    </body>
</html>
