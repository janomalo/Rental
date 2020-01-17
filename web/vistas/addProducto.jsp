
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Producto</title>
    </head>
    <body>
        
        <div class="container">
                <h1>Ingrese los datos</h1>
                <form action="ControladorProducto" class="form-horizontal" style="margin:0 auto">
         
                <div class="form-group">
                    <label class="col-lg-8 control-label">Categoria</label>
                     <div class="col-lg-4">
                        <select  class="form-control" name="categoria">
                             <option  value="1">Ski</option>
                    
                             <option  value="2">Snowboard</option>
                             <option  value="2">General</option>
                                                         
                         </select>
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
                
                <div class="form-group">
                     <label class="col-lg-8 control-label">Habilitar</label>
                      <div class="col-lg-4">
                      <select  class="form-control" name="habilitado">
                             <option  value="1">Habilitar</option>
                             <option  value="0">Deshabilitar</option>
                       </select>
                      </div>
                </div>
                              
                <%-- Fecha <input type="date" name="fecha"> --%>
                              
                <div class="form-group">
                <div class="col-lg-4">
                    <button type="submit" class="btn btn-success left" name="accion" >Agregar</button>
                    <a class="btn btn-success" href="index.jsp"> Volver</a>
                     </div>
                </div>
               
            </form>
            
 
            
            
            
        </div>
    </body>
</html>
