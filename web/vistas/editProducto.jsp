
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
    </head>
    <body>
        <div class="container">
        <h1>Editar Producto</h1>
        </div>
        <div class="container">
            
            <form action="Controlador" class="form-horizontal" style="margin:0 auto">
         
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
                
                
                <div class="form-group">
                <div class="">
                    <button type="submit" class="btn btn-success left" name="accion" >Agregar</button>
                    <a class="btn btn-success" href="index.jsp"> Volver</a>
                     </div>
                </div>
               
            </form>
            
            
            
        </div>
        
    </body>
</html>
