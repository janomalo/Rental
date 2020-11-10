
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Agregar Producto</title>
    </head>
    <body>

        <div class="container  col-lg-6" >
            <h1>Ingrese los datos</h1>
            <form action="ControladorProducto"  method="POST" class="form-horizontal" style="margin:0 auto">
                <%
                    //llama metodo getall y trae lisa de usuario
                    List<Categoria> listcat = (List<Categoria>) request.getAttribute("listacategorias");
                    Iterator<Categoria> itercat1 = listcat.iterator();

                    Categoria cat1 = null;


                %>      
                <div class="form-group ">
                    <label class="col-lg-8 control-label">Categoria</label>
                    <div class="col-lg-auto">
                        <select  class="form-control" name="categoria">
                            <% while (itercat1.hasNext()) {
                                    cat1 = itercat1.next();
                                    if(cat1.getEstado()==1){
                            %>
                            <option  value="<%= cat1.getId()%>"><%= cat1.getNombre()%></option>
                            <%
                               } }

                            %>

                        </select>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-lg-8 control-label">Nombre</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="nombre" required=""/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-8 control-label">Descripción</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="descripcion" required="" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-8 control-label">Stock</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="stock" required=""/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-8 control-label">Precio</label>
                    <div class="col-lg-auto">
                        <input type="text" class="form-control" name="precio"  required=""/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-8 control-label">Estado</label>
                    <div class="col-lg-auto">
                        <select  class="form-control" name="estado">
                            <option  value="1">Habilitado</option>
                            <option  value="0">Deshabilitado</option>
                        </select>
                    </div>
                </div>

                <%-- Fecha <input type="date" name="fecha"> --%>

                <div class="form-group">
                    <div class="col-lg-auto">
                        <input type="submit" class="btn btn-success left" name="accion" value="Agregar" >
                        <a class="btn btn-success" href="ControladorProducto?accion=listar"> Volver</a>
                    </div>
                </div>

            </form>





        </div>
    </body>
</html>
