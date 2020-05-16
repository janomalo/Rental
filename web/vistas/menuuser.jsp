<%-- 
    Document   : menuuser
    Created on : 08/03/2020, 22:03:40
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" >RENTAL usuario</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <%String usu2 = (String) session.getAttribute("usuario");%>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="index.jsp">Home </a>
                    </li>

                    <li class="nav-item  dropdown active">
                        <div class="dropdown">
                            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuReservas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Reservas
                            </button>
                            <div class="dropdown-menu " >
                                <a class="dropdown-item" href="ControladorVista?accion=signin" >Nueva Reserva</a>
                                <a class="dropdown-item" href="ControladorVista?accion=temporada" >Temporadas</a>
                            </div>
                        </div>
                    </li>

                    <li class="nav-item">
                        <%-- <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="ControladorProducto?accion=listar" target="myframe">Productos</a>--%>
                        <div class="dropdown">
                            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuProductos" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Productos
                            </button>
                            <div class="dropdown-menu " >
                                <a class="dropdown-item" href="#">Lista Productos</a>
                            </div>
                        </div>
                    </li>
                    <%-- <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li> --%>
                </ul>
                <div class="dropdown">

                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%=usu2%>
                    </button>
                    <div class="dropdown-menu " >
                        <a class="dropdown-item" href="Controlador?accion=listar" >Mi perfil</a>
                        <a class="dropdown-item" href="ControladorVista?accion=signin" >Salir</a>
                        <%-- <form action="ControladorVista"  method="POST">
                            <button name="accion" value="signin" class="dropdown-item">Salir</button>

                        </form>--%>

                    </div>
                </div>
            </div>
          </nav>
    </body>
</html>
