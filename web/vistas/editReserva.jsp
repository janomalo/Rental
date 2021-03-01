<%-- 
    Document   : editReserva
    Created on : 13/02/2020, 20:21:42
    Author     : Alejandro
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Modelo.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Reserva</title>
        <script type="text/javascript">
  $(function () {
    $('#datetime').datepicker({
      dateFormat: "yy-mm-dd 00:00:00.0"
    });
    $('#datetime1').datepicker({
      dateFormat: "yy-mm-dd 00:00:00.0"
    })
  });
  
 </script>
    </head>
    <body>
        <h1>Editar Reserva</h1>
        <form method="POST" action="ControladorReserva" id="my_formRevisar" class="form-text"></form>


        <%
            //llama metodo getall y trae lisa de usuario
            Reserva reditar = (Reserva) request.getAttribute("reditar");           
            SimpleDateFormat formatoreservaedit = new SimpleDateFormat("yyyy-MM-dd");


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
                            <td> <%= reditar.getId()%></td>
                            <td> <%= reditar.getTemporada_id()%></td>
                            <td> <%= reditar.getUsuario_id()%></td>
                            <td> <%= reditar.getPrecio()%></td>
                            <td> <%= formatoreservaedit.format(reditar.getFecha_reserva())%></td>
                            <td> <input type="text" class="form-control" name="txtfdesde"  id="datetime" value="<%= formatoreservaedit.format(reditar.getFecha_reserva())%>"></td>
                            
                            <td> <input value="<%= reditar.getCantidad_dias()%>">  </td>
                            <td> <%= reditar.getEstado()%></td>
                            <td>
                               
                                <input  class="btn btn-success" value="Guardar" type="submit"  name="accion" form="my_formRevisar">
                               <input  class="btn btn-danger" value="Cancelar" type="submit"  name="accion" form="my_formRevisar">
                             

                            </td>       


                        </tr>

                    </tbody>
                </table> 

            </div>

           

        </div>    

        
    </body>
</html>
