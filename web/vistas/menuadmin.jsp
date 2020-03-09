<%-- 
    Document   : menuadmin
    Created on : 08/03/2020, 22:03:52
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu admin</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" >RENTAL</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
           
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a style="margin-left: 10px;border: none" class="btn btn-outline-light" href="#">Home </a>
                    </li>
                    <li class="nav-item  dropdown active">
                        <div class="dropdown">
                            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuReservas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Reservas
                            </button>
                            <div class="dropdown-menu " >
                                <a class="dropdown-item" href="ControladorReserva?accion=reserva" target="myframe">Nueva Reserva</a>
                                <a class="dropdown-item" href="ControladorReserva?accion=listar" target="myframe">Lista Reservas</a>
                                <a class="dropdown-item" href="vistas/listarTemporadas.jsp" target="myframe">Temporadas</a>
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
                                <a class="dropdown-item" href="ControladorProducto?accion=add" target="myframe">Nuevo Producto</a>
                                <a class="dropdown-item" href="ControladorProducto?accion=listar" target="myframe">Lista Productos</a>
                                <a class="dropdown-item" href="vistas/Categorias.jsp" target="myframe">Categorias</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <button style="margin-left: 10px;border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuProductos" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Usuarios
                            </button>
                            <div class="dropdown-menu " >
                                <a class="dropdown-item" href="Controlador?accion=add" target="myframe">Nuevo Usuario</a>
                                <a class="dropdown-item" href="Controlador?accion=listar" target="myframe">Lista Usuarios</a>
                                <a class="dropdown-item" href="vistas/Roles.jsp" target="myframe">Roles</a>


                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a  class="nav-link" href="#"> <%= session.getAttribute("contador")%></a>

                    </li>

                    <%-- <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li> --%>
                </ul>

                <div class="dropdown">
                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= session.getAttribute("user")%>
                    </button>
                    <div class="dropdown-menu " >
                        <a class="dropdown-item" href="Controlador?accion=listar" target="myframe">Mi perfil</a>
                        <form action="Controlador"  method="POST">
                            <button name="accion" value="Salir" class="dropdown-item">Salir</button>

                        </form>

                    </div>
                </div>
            </div>
        </nav>
                    
    </body>

     </html>
                
