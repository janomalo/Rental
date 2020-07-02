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
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
            UsuarioControler usrctrl= new UsuarioControler();
            int id=Integer.parseInt((String)request.getAttribute("idusu"));
            Usuario u= new Usuario();
            u= usrctrl.list(id);
                         
        
        %>
         <h1>Editar Usuario</h1>
         <div class="container col-8">
             <form action="Controlador"  class="form-text">
                <input  type="hidden"  name="txtid"  value="<%=u.getId() %>">
                DNI <input type="text"   class="form-control" name="txtdni" value="<%=u.getDni() %>"><br>
                NOMBRES <input type="text" class="form-control" name="txtnombres" value="<%=u.getNombres() %>"><br>
                APELLIDOS <input type="text" class="form-control" name="txtapellidos" value="<%=u.getApellidos() %>"><br>
                TELÉFONO <input type="text" class="form-control" name="txttelefono" value="<%=u.getTelefono() %>"><br>
                EMAIL <input type="text" class="form-control" name="txtemail" value="<%=u.getEmail()%>"><br>
                DIRECCIÓN <input type="text" class="form-control" name="txtdireccion"  value="<%=u.getDireccion() %>"> <br>
                USUARIO <input type="text" class="form-control" name="txtusuario"  value="<%=u.getUsuario()%>"> <br>
                CONTRASEÑA <input type="password" class="form-control" name="txtpassword" value="<%=u.getPassword() %>"><br>
                <input type="radio"  name="txthabilitado" value="1" required="">Habilitar
                <input type="radio" name="txthabilitado" value="0" required="">Deshabiltiar<br>
               
               
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input  class="btn btn-success" type="submit" value="Actualizar" name="accion">
                <a class="btn btn-info" href="index.jsp"> Volver</a>
            </form>
          </div>
        
    </body>
</html>
