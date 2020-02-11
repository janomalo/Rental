<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingrese los datos!</h1>
        <div class="container">
            <form action="Controlador" >
                Dni <input type="text" name="dni" required=""><br>
                Nombres <input type="text" name="nombres"><br>
                Apellidos <input type="text" name="apellidos"><br>
                Teléfono <input type="text" name="telefono"><br>
                Email <input type="text" name="email"><br>
                Direccion <input type="text" name="direccion"> <br>
                Usuario <input type="text" name="usuario"> <br>
                Contraseña <input type="password" name="password"><br>
                <input type="radio" name="habilitado" value="1">Habilitar(1)
                <input type="radio" name="habilitado" value="0">Deshabiltiar(0)<br>
                <%-- <input type="hidden" name="fecha" value="CURDATE"> --%>
                <input class=" btn btn-success" type="submit" value="Agregar" name="accion">
               <a class="btn btn-success" href="Controlador?accion=listar"> Volver</a>
            </form>
            
            <%--  
                       <form class="form-horizontal" style="margin:0 auto">
  <div class="form-group">
    <label class="col-lg-8 control-label">Nombres</label>
    <div class="col-lg-4">
      <input type="text" class="form-control" name="nombre" />
    </div>
  </div>

  <div class="form-group">
    <label class="col-lg-8 control-label">Apellidos</label>
    <div class="col-lg-4">
      <input type="text" class="form-control" name="apellido" />
    </div>
  </div>

  <div class="form-group">
    <label class="col-lg-8 control-label">Correo Electrónico</label>
    <div class="col-lg-4">
      <input type="text" class="form-control" name="email" />
    </div>
  </div>

  <div class="form-group">
    <label class="col-lg-8 control-label">Teléfono Celular</label>
    <div class="col-lg-4">
      <input type="text" class="form-control" name="telefono_cel" />
    </div>
  </div>

  <div class="form-group">
    <div class="">
      <button type="submit" class="btn btn-success left">Registrarse</button>
    </div>
  </div>

</form>
            
            --%>
            
            
            
        </div>
        
    </body>
</html>
