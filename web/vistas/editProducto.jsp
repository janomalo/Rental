
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDaoImpl.ProductoDaoImpl"%>
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
        
        
        <%
            
            ProductoDaoImpl dao= new ProductoDaoImpl();
            int id=Integer.parseInt((String)request.getAttribute("idpro"));
            Producto p= new Producto();
            p=dao.list(id);
                         
        
        %>
        <div class="container">
        <h1>Editar Producto</h1>
        </div>
        <div class="container">
            
            <form action="ControladorProducto" method="POST" class="form-horizontal" style="margin:0 auto" >
                <input  type="hidden"  name="txtid"  value="<%=p.getId() %>">
                <div class="form-group">
                    <label class="col-lg-8 control-label">Categoria</label>
                     <div class="col-lg-4">
                         <input type="text" class="form-control" name="txtcategoriaid" value="<%=p.getCategoria_id()%>" required=""/>
                    </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Nombre</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="txtnombre" value="<%=p.getNombre()%>" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Descripción</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="txtdescripcion" value="<%=p.getDescripcion()%>" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Stock</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="txtstock" value="<%=p.getStock()%>" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="col-lg-8 control-label">Precio</label>
                      <div class="col-lg-4">
                     <input type="text" class="form-control" name="txtprecio" value="<%=p.getPrecio()%>" />
                      </div>
                </div>
                                    
                      <input type="radio" name="txthabilitado" value="1" required="">Habilitar(1)
                      <input type="radio" name="txthabilitado" value="0"  required="">Deshabiltiar(0)<br>
                
                <%-- Fecha <input type="date" name="fecha"> --%>
                
                
                <div class="form-group">
                <div class="">
                    <input type="submit" class="btn btn-success left" name="accion" value="Actualizar" >
                    <a class="btn btn-success" href="listarProductos.jsp"> Volver</a>
                     </div>
                </div>
               
            </form>
            
            
            
        </div>
        
    </body>
</html>
