

<%@page import="Modelo.Temporada"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Temporada</title>
    </head>
    <body>
             
        <%
           Temporada t= (Temporada) request.getAttribute("temporada");
                         
        
        %>
         <h1>Editar Temporada</h1>
         <div class="container col-lg-8">
             <form action="Temporadas"  class="form-text" method="POST">
                <input  type="hidden"  name="txtid"  value="<%=t.getId() %>">
                DESCRIPCION <input type="text"   class="form-control" name="txtdescripcion" value="<%=t.getDescripcion() %>"><br>
                FECHA DESDE <input  type="text" class="form-control" name="txtfdesde" value="<%=t.getFecha_desde() %>"><br>
                 FECHA HASTA <input type="text" class="form-control" name="txtfhasta" value="<%=t.getFecha_hasta() %>"><br>
                  PRECIO <input type="text" class="form-control" name="txtprecio" value="<%=t.getPrecio() %>"><br>
                           
                             
                <%-- Fecha <input type="date" name="fecha"> --%>
                <input  class=" btn btn-success" type="submit" value="update" name="accion">
                <a class="btn btn-danger" href="Temporadas?accion=listar"> Volver</a>
            </form>
          </div>
        
    </body>


</html>
