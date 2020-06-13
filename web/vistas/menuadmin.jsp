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
        
        <title>Menu Admin</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" >RENTAL admin</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">

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
                                <a class="dropdown-item" href="ControladorReserva?accion=reserva">Nueva Reserva</a>
                                <a class="dropdown-item" href="ControladorReserva?accion=listar" >Lista Reservas</a>
                                <a class="dropdown-item" href="vistas/listarTemporadas.jsp" >Temporadas</a>
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
                                <a class="dropdown-item" href="ControladorProducto?accion=add" >Nuevo Producto</a>
                                <a class="dropdown-item" href="ControladorProducto?accion=listar" >Lista Productos</a>
                                <a class="dropdown-item" href="vistas/Categorias.jsp" >Categorias</a>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="dropdown">
                            <button style="margin-left: 10px;border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuProductos" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Usuarios
                            </button>
                            <div class="dropdown-menu " >
                                <a class="dropdown-item" href="ControladorVista?accion=addusuario" >Nuevo Usuario</a>
                                <a class="dropdown-item" href="ControladorVista?accion=listarusuarios" >Lista Usuarios</a>
                                <a class="dropdown-item" href="vistas/Roles.jsp" >Roles</a>


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
                        <%= session.getAttribute("nombreusuario")%>
                    </button>
                    <div class="dropdown-menu " >
                        <a class="dropdown-item" href="Controlador?accion=listar" >Mi perfil</a>
                         <a class="dropdown-item" href="Signin?accion=signout" >Salir</a>
                        
                    </div>
                </div>
                    </div>
        </nav>
        
    
    </body>

     </html>
                
