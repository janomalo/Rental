<%-- 
    Document   : listarReservasUsuario
    Created on : 25/01/2021, 22:07:30
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
        <title>Mis Reservas</title>
    </head>
    <body>
         <div  class="container-fluid">
            <h1>Mis Reservas </h1> 
            <table class="table">

                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>TEMPORADA</th> 
                        <th>USUARIO</th>
                        
                        <th>FECHA RESERVA</th>
                        <th>FECHA DESDE</th>
                        <th>CANTIDAD DIAS</th>
                        <th>PRECIO</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>

                    </tr>
                </thead>
                <% //Usar JSP individual o mostrar todo en una pagina listar reservas?
                    //llama metodo getall y trae lisa de usuario
                    List<Reserva> listreservausuario = (List<Reserva>) request.getAttribute("reservas");
                    Iterator<Reserva> iterReservausuario = listreservausuario.iterator();
                    SimpleDateFormat formato1usu = new SimpleDateFormat("yyyy-MM-dd");

                    Reserva reservausu = null;
                    while (iterReservausuario.hasNext()) {
                        reservausu = iterReservausuario.next();


                %>
                <tbody>

                    <tr class="text-center">
                        <td> <%= reservausu.getId()%></td>
                        <td> <%= reservausu.getTemporada_id() %></td>
                        <td> <%= reservausu.getUsuario_id() %></td>
                       
                        <td> <%= formato1usu.format( reservausu.getFecha_reserva())  %></td>
                        <td> <%= formato1usu.format(reservausu.getFecha_desde() )%></td>
                        <td> <%= reservausu.getCantidad_dias() %></td>
                         <td> <%= reservausu.getPrecio() %></td>
                        <td> <%= reservausu.getEstado() %></td>

                        <%-- <% if (usu.getHabilitado() == 0) {%>
                        <td>NO </td>
                        <% } else {%>
                        <td>SI </td>
                        <% }%> --%>
                        <%-- <td> <%= usu.getFecha_registro()%> </td> --%>
                         <td>
                            <a  class="btn btn-outline-info" href="">Detalles</a> 
                            <a  class="btn btn-danger" href="">Cancelar</a> 
                            <!-- Button trigger modal -->




                    </tr>
                    <%
                        }

                    %>
                </tbody>



            </table> 


           <a class="btn btn-success" href="index.jsp"> Volver</a> 
             </div>   
    </body>
</html>
