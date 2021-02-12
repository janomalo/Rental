<%-- 
    Document   : RevisarReserva
    Created on : 27/01/2021, 21:57:02
    Author     : Alejandro
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.ListaProducto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Revisar Reserva</title>
    </head>
    <body>


        <%
            //llama metodo getall y trae lisa de usuario
            Reserva rusu = (Reserva) request.getAttribute("resChecked");
            List<ListaProducto> listprodureserva = rusu.getDetalle();
            SimpleDateFormat formatoreserva = new SimpleDateFormat("yyyy-MM-dd");


        %>
        <div>
            <div>
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
                            <td> <%= rusu.getId()%></td>
                            <td> <%= rusu.getTemporada_id()%></td>
                            <td> <%= rusu.getUsuario_id()%></td>
                            <td> <%= rusu.getPrecio()%></td>
                            <td> <%= formatoreserva.format(rusu.getFecha_reserva())%></td>
                            <td> <%= formatoreserva.format(rusu.getFecha_desde())%></td>
                            <td> <%= rusu.getCantidad_dias()%></td>
                            <td> <%= rusu.getEstado()%></td>
                            <td>
                                <a>Aprobar</a>
                                <a>Cancelar</a>

                            </td>       


                        </tr>

                    </tbody>
                </table> 

            </div>

            <div>
                <h3> Detalle Reserva</h3>
                <table class="table">
                    <thead>
                    <th>ITEM</th>
                    <th>PRODUCTO</th>
                    <th>CANTIDAD</th>
                    <th>PRECIO</th>
                    <th>SUBTOTAL</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>DETALLE</th>
                    <th>COMENTARIOS</th>

                    </thead>
                    <%
                       Iterator<ListaProducto> iterListaProductos = listprodureserva.iterator();
                   

                    ListaProducto lista = null;
                    while (iterListaProductos.hasNext()) {
                        lista = iterListaProductos.next();
                    %>

                    <tbody>
                        <tr>
                            <td><%=lista.getItem() %></td>
                            <td><%=lista.getProducto_id() %></td>
                            <td><%=lista.getCantidad() %></td>
                            <td><%= lista.getPrecio() %></td>
                            <td><%=lista.getSubtotal() %></td>
                            <td><%= lista.getNombre() %></td>
                            <td><%= lista.getDescripcion() %></td>
                            <td><%= lista.getDetalle_reserva() %></td>
                                                                              
                        </tr>
                              <% }%>               
                     



                    </tbody>
                   
                </table>



            </div>

        </div>    


    </body>
</html>
