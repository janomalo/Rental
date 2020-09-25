<%-- 
    Document   : edit
    Created on : 23-oct-2019, 21:29:29
    Author     : Alejandro
--%>

<%@page import="Logic.UsuarioControler"%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDaoImpl.UsuarioDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        
        
        <%
           Usuario u= (Usuario)session.getAttribute("usuedit");
                         
        
        %>
         <h1>Editar Usuario</h1>
         <div class="container col-lg-8">
             <form action="Controlador"  class="form-text" method="POST">
                <input  type="hidden"  name="txtid"  value="<%=u.getId() %>">
                DNI <input type="text"   class="form-control" name="txtdni" value="<%=u.getDni() %>"><br>
                NOMBRES <input type="text" class="form-control" name="txtnombres" value="<%=u.getNombres() %>"><br>
                APELLIDOS <input type="text" class="form-control" name="txtapellidos" value="<%=u.getApellidos() %>"><br>
                TELÉFONO <input type="text" class="form-control" name="txttelefono" value="<%=u.getTelefono() %>"><br>
                EMAIL <input type="text" class="form-control" name="txtemail" value="<%=u.getEmail()%>"><br>
                DIRECCIÓN <input type="text" class="form-control" name="txtdireccion"  value="<%=u.getDireccion() %>"> <br>
                USUARIO <input type="text" class="form-control" name="txtusuario"  value="<%=u.getUsuario()%>"> <br>
               
                <input type="radio"  name="txthabilitado" value="1" required="">Habilitar
                <input type="radio" name="txthabilitado" value="0" required="">Deshabiltiar<br>
               <%-- <div class="form-group">
                    <label class="col-lg-8 control-label">Estado</label>
                    <div class="col-lg-auto">
                        <select  class="form-control" name="habilitado">
                            <option  value="1">Habilitar</option>
                            <option  value="0">Deshabilitar</option>
                        </select>
                    </div>
            </div> --%>
               
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input  class=" btn btn-success" type="submit" value="Actualizar" name="accion">
                <a class="btn btn-danger" href="Controlador?accion=listarusuarios"> Volver</a>
            </form>
          </div>
        
    </body>
</html>
