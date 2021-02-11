<%-- 
    Document   : RevisarReserva
    Created on : 27/01/2021, 21:57:02
    Author     : Alejandro
--%>

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
               
        <h1>Detalle Reserva</h1>
        <% 
        //llama metodo getall y trae lisa de usuario
          Reserva rusu = (Reserva) request.getAttribute("resChecked");
                   
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
                        <td> <%= rusu.getTemporada_id() %></td>
                        <td> <%= rusu.getUsuario_id() %></td>
                        <td> <%= rusu.getPrecio() %></td>
                        <td> <%= formatoreserva.format( rusu.getFecha_reserva())  %></td>
                        <td> <%= formatoreserva.format(rusu.getFecha_desde() )%></td>
                        <td> <%= rusu.getCantidad_dias() %></td>
                        <td> <%= rusu.getEstado() %></td>



                    </tr>
                    
                </tbody>
           </table> 
                
            </div>
            
            <div>
                <h3> Lista Productos</h3>
            
            
            
            
            </div>
            
        </div>    
        
                    
    </body>
</html>
