
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingrese los datos!</h1>
        <div  class="container col-lg-6">
            <form action="Controlador"  method="POST" class="form-horizontal"    >
            
            <div class="form-group">
                    <label class="col-lg-8 control-label">Dni</label>
                    <div class="col-lg-auto">
                       
                    <input type="text" class="form-control" name="dni" required="" placeholder="Dni"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Nombres</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="nombres" required="" placeholder="Nombre"/>
                    </div>
                    
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Apellidos</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="apellidos" required="" placeholder="Apellidos"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Teléfono</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="telefono" required="" placeholder="Teléfono"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Email</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="email" required="" placeholder="Email"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Dirección</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="direccion" required="" placeholder="Dirección"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Usuario</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="usuario" required="" placeholder="Usuario"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Contraseña</label>
                    <div class="col-lg-auto">
                        <input type="password" class="form-control" name="password" required="" placeholder="Contraseña"/>
                    </div>
            </div>

            <div class="form-group">
                    <label class="col-lg-8 control-label">Estado</label>
                    <div class="col-lg-auto">
                        <select  class="form-control" name="habilitado">
                            <option  value="1">Habilitar</option>
                            <option  value="0">Deshabilitar</option>
                        </select>
                    </div>
            </div>
                <%-- <input type="hidden" name="fecha" value="CURDATE"> --%>

            <div class="form-group">
                    <div class="col-lg-auto">
                        <input class=" btn btn-success" type="submit" value="Agregar" name="accion">
                        <a class="btn btn-danger" href="Controlador?accion=listar"> Cancelar</a>
                    </div>
            </div>
           
            </form>
      

        </div>
    </body>
</html>
