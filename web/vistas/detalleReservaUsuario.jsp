<%-- 
    Document   : detalleReservaUsuario
    Created on : 28/02/2021, 16:37:13
    Author     : Alejandro
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.ListaProducto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form method="POST" action="ControladorReserva" id="my_formRevisarDetalle" class="form-text"></form>


        <%
            //llama metodo getall y trae lisa de usuario
            Reserva rusuario = (Reserva) request.getAttribute("resChecked");
            List<ListaProducto> listprodureservausuario = rusuario.getDetalle();
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");


        %>
        <div class="container-fluid">
            <div class="tab-content">
                <h3> Datos Reserva </h3>

                <table class="table">

                    <thead>
                        <tr class="text-center">
                            <th>ID</th>
                            <th>TEMPORADA</th> 
                            <th>USUARIO</th>
                            <th>PRECIO</th>
                            <th>FECHA RESERVA</th>
                            <th>FECHA DESDE</th>
                            <th>CANTIDAD DIAS</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>

                        </tr>
                    </thead>

                    <tbody>

                        <tr class="text-center">
                            <td> <%= rusuario.getId()%></td>
                            <td> <%= rusuario.getTemporada_id()%></td>
                            <td> <%= rusuario.getUsuario_id()%></td>
                            <td> <%= rusuario.getPrecio()%></td>
                            <td> <%= formatofecha.format(rusuario.getFecha_reserva())%></td>
                            <td> <%= formatofecha.format(rusuario.getFecha_desde())%></td>
                            <td> <%= rusuario.getCantidad_dias()%></td>
                            <td> <%= rusuario.getEstado()%></td>
                            <td>
                                
                              <input  class="btn btn-danger" value="Cancelar" type="submit"  name="accion" form="my_formRevisarDetalle">
                             

                            </td>       


                        </tr>

                    </tbody>
                </table> 

            </div>

            <div >
                <h3> Detalle Reserva</h3>
                <table class="table table-striped">
                    <thead>
                    <th>ITEM</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>PRECIO</th>
                    <th>SUBTOTAL</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>DETALLE</th>


                    </thead>
                    <%
                       
                        Iterator<ListaProducto> iterListaProductosResUsuario = listprodureservausuario.iterator();

                        ListaProducto listapru = null; //lista productos reserva usuario
                        while (iterListaProductosResUsuario.hasNext()) {
                            listapru = iterListaProductosResUsuario.next();
                    %>

                    <tbody>
                        <tr>
                            <td><%=listapru.getItem()%></td>
                            <td><%=listapru.getProducto_id()%></td>
                            <td><%=listapru.getCantidad()%></td>
                            <td><%= listapru.getPrecio()%></td>
                            <td><%=listapru.getSubtotal()%></td>
                            <td><%= listapru.getNombre()%></td>
                            <td><%= listapru.getDescripcion()%></td>
                            <td><%= listapru.getDetalle_reserva()%></td>


                        </tr>
                                     




                    </tbody>
                    <% } %>
                </table>

                <div  >
                    <h4>Aclaraciones</h4>
                    <input type="text" class="form-control " id ="comentarios" name="comentarios" placeholder=""  style="height:100px;text-align:center" form="my_formRevisarDetalle" required="">


                </div>                              


            </div>

        </div>    

    </body>
</html>
