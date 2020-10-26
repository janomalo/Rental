

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Temporada"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Temporadas</title>
    </head>
    <body>
        <div  class="container-fluid col-8">
            <h1>Temporadas</h1> 
            <table class="table">

                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>DESCRIPCION</th> 
                        <th>FECHA DESDE</th>
                        <th>FECHA HASTA</th>
                        <th>PRECIO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                    //llama metodo getall y trae lisa de usuario
                    List<Temporada> listtempo = (List<Temporada>) request.getAttribute("listatemporadas");
                    Iterator<Temporada> itertem = listtempo.iterator();
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                 
                    Temporada tem = null;
                    while (itertem.hasNext()) {
                        tem = itertem.next();


                %>
                <tbody>

                    <tr class="text-center">
                        <td> <%= tem.getId()%></td>
                        <td> <%= tem.getDescripcion()%></td>
                        <td> <%= formato.format(tem.getFecha_desde())%></td>
                        <td> <%= formato.format(tem.getFecha_hasta())%></td>
                        <td> <%= tem.getPrecio()%></td>

                        <td>
                            <a class="btn btn-dark "  href="Temporadas?accion=edit&id=<%= tem.getId()%>" >Editar </a>

                            <a  class="btn btn-danger" href="Temporadas?accion=delete&id=<%= tem.getId()%>">Eliminar</a> 
                            <!-- Button trigger modal -->



                        </td>



                    </tr>
                    <%
                        }

                    %>
                </tbody>



            </table> 



        </div>


    </body>
</html>
