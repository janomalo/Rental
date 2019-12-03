<%-- 
    Document   : edit
    Created on : 23-oct-2019, 21:29:29
    Author     : Alejandro
--%>

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
            
            UsuarioDaoImpl dao= new UsuarioDaoImpl();
            int id=Integer.parseInt((String)request.getAttribute("idusu"));
            Usuario u= new Usuario();
            u=(Usuario)dao.list(id);
                         
        
        %>
         <h1>Modificar Usuario</h1>
        <div>
            <form action="Controlador" >
                <input  type="hidden"  name="txtid"  value="<%=u.getId() %>">
                Dni <input type="text" name="txtdni" value="<%=u.getDni() %>"><br>
                Nombres <input type="text" name="txtnombres" value="<%=u.getNombres() %>"><br>
                Apellidos <input type="text" name="txtapellidos" value="<%=u.getApellidos() %>"><br>
                Teléfono <input type="text" name="txttelefono" value="<%=u.getTelefono() %>"><br>
                Email <input type="text" name="txtemail" value="<%=u.getEmail()%>"><br>
                Direccion <input type="text" name="txtdireccion"  value="<%=u.getDireccion() %>"> <br>
                Contraseña <input type="password" name="txtpassword" value="<%=u.getPassword() %>"><br>
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input type="submit" value="Actualizar" name="accion">
            </form>
            
            
            
            
            
        </div>
        
    </body>
</html>
