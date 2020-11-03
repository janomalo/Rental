
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <div  class="container-fluid col-8">
            <h1>Categorias</h1> 
            <form action="Categorias" method="POST" id="my_formcategoria" class="form-text"></form>
            <table class="table">

                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>NOMBRES</th> 
                        <th>ESTADO</th>
                        <th>ACCIONES</th>

                    </tr>
                </thead>
                <%
                    //llama metodo getall y trae lisa de usuario
                    List<Categoria> listcate = (List<Categoria>) request.getAttribute("listacategorias");
                    Iterator<Categoria> itercat = listcate.iterator();

                    Categoria cat = null;
                    while (itercat.hasNext()) {
                        cat = itercat.next();


                %>
                <tbody>

                    <tr class="text-center">
                        <td> <%= cat.getId()%></td>
                        <td> <%= cat.getNombre() %></td>
                        <td> <%= cat.getEstado() %></td>

                        <td>
                            <a class="btn btn-dark "  href="Categorias?accion=edit&id=<%= cat.getId()%>" >Editar </a>

                            <a  class="btn btn-danger" href="Categorias?accion=delete&id=<%= cat.getId()%>">Eliminar</a> 
                            <!-- Button trigger modal -->



                        </td>



                    </tr>
                    <%
                        }

                    %>
                    <tr class="text-center">

                        <td> ID</td>
                        <td> <input type="text" class="form-control" name="txtnombre" form="my_formcategoria" placeholder="Nombre" required/></td>
                        <td> <input type="text" class="form-control" name="txtestado" form="my_formcategoria" placeholder="Estado" required /></td>
                        
                        <td> 
                            <input  class=" btn btn-success" type="submit" value="Agregar" name="accion" form="my_formcategoria">
                        </td>
                    </tr>
                </tbody>



            </table> 



        </div>


    </body>
</html>
