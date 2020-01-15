
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
        <h1>Ingrese los del datos nuevo producto</h1>
        <div class="container">
            <form action="Controlador" class="form-horizontal" >
         
                <div class="form-group">
                    <label class="col-lg-8 control-label">Categoria</label>
                     <div class="col-lg-4">
                         <input type="text" class="form-control" name="categoria"  required=""/>
                    </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Nombre</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="nombre" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Descripción</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="descripcion" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Stock</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="stock" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Precio</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="precio" />
                      </div>
                </div>
             
              
                <input type="radio" name="habilitado" value="1">Habilitar(1)
                <input type="radio" name="habilitado" value="0">Deshabiltiar(0)<br>
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input class=" btn btn-success" type="submit" value="Agregar" name="accion">
               <a class="btn btn-success" href="index.jsp"> Volver</a>
            </form>
            
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
            
            
            
        </div>
    </body>
</html>
