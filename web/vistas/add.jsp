
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingrese los datos!</h1>
        <div class="container">
            <form action="Controlador"  method="POST" class="form-horizontal" style="margin:0 auto" >

                <div class="form-group">
                    <label class="col-lg-8 control-label">Dni</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="dni" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Nombres</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="nombres" required=""/>
                    </div>
                    
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Apellidos</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="apellidos" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Teléfono</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="telefono" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Email</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="email" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Direccion</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="direccion" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Usuario</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" name="usuario" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Contraseña</label>
                    <div class="col-lg-4">
                        <input type="password" class="form-control" name="password" required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Estado</label>
                    <div class="col-lg-4">
                        <select  class="form-control" name="habilitado">
                            <option  value="1">Habilitar</option>
                            <option  value="0">Deshabilitar</option>
                        </select>
                    </div>
                </div>
                <%-- <input type="hidden" name="fecha" value="CURDATE"> --%>

                <div class="form-group">
                    <div class="col-lg-4">
                        <input class=" btn btn-success" type="submit" value="Agregar" name="accion">
                        <a class="btn btn-danger" href="Controlador?accion=listar"> Cancelar</a>
                    </div>
                </div>
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
