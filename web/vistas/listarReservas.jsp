<%-- 
    Document   : Reserva
    Created on : 11/02/2020, 20:37:42
    Author     : Alejandro
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Reserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Reservas</title>
    </head>
    <body>
       
        <div  class="container-fluid">
            <h1>RESERVAS </h1> 
            <table class="table table-striped">

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
                <%
                    //llama metodo getall y trae lisa de usuario
                    List<Reserva> listreserva = (List<Reserva>) request.getAttribute("reservas");
                    Iterator<Reserva> iterReserva = listreserva.iterator();
                    SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");

                    Reserva res = null;
                    while (iterReserva.hasNext()) {
                        res = iterReserva.next();


                %>
                <tbody>

                    <tr class="text-center">
                        <td> <%= res.getId()%></td>
                        <td> <%= res.getTemporada_id() %></td>
                        <td> <%= res.getUsuario_id() %></td>
                        <td> <%= res.getPrecio() %></td>
                        <td> <%= formato1.format( res.getFecha_reserva())  %></td>
                        <td> <%= formato1.format(res.getFecha_desde() )%></td>
                        <td> <%= res.getCantidad_dias() %></td>
                        <td> <%= res.getEstado() %></td>

                        <%-- <% if (usu.getHabilitado() == 0) {%>
                        <td>NO </td>
                        <% } else {%>
                        <td>SI </td>
                        <% }%> --%>
                        <%-- <td> <%= usu.getFecha_registro()%> </td> --%>
                        <td>
                            <a class="btn btn-success"  href="ControladorReserva?accion=RevisarReserva&id=<%= res.getId() %>" > Revisar </a> 

                            <a  class="btn btn-dark" href="ControladorReserva?accion=EditarReserva&id=<%= res.getId() %>">Editar</a> 
                            
                            <%--
                              <a  class="btn btn-danger" href="ControladorReserva?accion=EliminarReserva&id=<%= res.getId() %>">Elminiar</a>   --%>
                            
                            <!-- Button trigger modal -->




                    </tr>
                    <%
                        }

                    %>
                </tbody>



            </table> 


            <%-- <a class="btn btn-success" href="index.jsp"> Volver</a> --%>
        </div>

    </body>
</html>
