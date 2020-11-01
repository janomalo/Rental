

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
        <div  class="container-fluid col-8">
            <h1>Temporadas</h1> 
            <form action="Temporadas" method="POST" id="my_form" class="form-text"></form>
            <table class="table">

                <thead>
                    <tr class="text-center">
                        <th >ID</th>
                        <th style="width:20%">DESCRIPCION</th> 
                        <th style="width:20%">FECHA DESDE</th>
                        <th style="width:20%">FECHA HASTA</th>
                        <th style="width:20%">PRECIO</th>
                        <th style="width:20%">ACCIONES</th>
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
                    <tr class="text-center">

                        <td> ID</td>
                        <td> <input type="text" class="form-control" name="txtdescripcion" form="my_form" placeholder="Descripción" /></td>
                        <td> <input type="text" class="form-control" name="txtfdesde" form="my_form" placeholder="yyyy/mm/dd" id="datetime"/></td>
                        <td> <input type="text"  class="form-control" name="txtfhasta" form="my_form" placeholder="yyyy/mm/dd" id="datetime1" /></td>
                        <td> <input type="text" class="form-control" name="txtprecio" form="my_form" placeholder="Precio"  required/></td>
                        <td> 
                            <input  class=" btn btn-success" type="submit" value="Agregar" name="accion" form="my_form">
                        </td>
                    </tr>
                </tbody>

            </table> 
            <%-- <div  class="container-fluid col-8">
        <form method="POST" id="my_form" class="form-text">
            <table class=" table">
                <thead></thead>
                <tbody>
                    <tr class="text-center">

                                <td> ID</td>
                                <td> <input type="text" class="form-control" name="txt_descripcion" form="my_form" placeholder="Descripción" /></td>
                                <td> <input type="text" class="form-control" name="txt_fechadesde" form="my_form" placeholder="yyyy/mm/dd" /></td>
                                <td> <input type="text"  class="form-control" name="txt_fechahasta" form="my_form" placeholder="yyyy/mm/dd" /></td>
                                <td> <input type="text" class="form-control" name="txt_precio" form="my_form" placeholder="Precio" /></td>
                                <td> 
                                    <a class=" btn btn-success"  >Agregar</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>  
                </form>
            </div> --%>

        </div>


    </body>
</html>
