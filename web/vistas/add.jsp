
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingrese los datos!</h1>
        <div>
            <form action="Controlador" >
                Dni <input type="text" name="dni"><br>
                Nombres <input type="text" name="nombres"><br>
                Apellidos <input type="text" name="apellidos"><br>
                Teléfono <input type="text" name="telefono"><br>
                Email <input type="text" name="email"><br>
                Direccion <input type="text" name="direccion"> <br>
                Contraseña <input type="password" name="password"><br>
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input type="submit" value="Agregar" name="accion">
            </form>
            
            
            
            
            
        </div>
        
    </body>
</html>
