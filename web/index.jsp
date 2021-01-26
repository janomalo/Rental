

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es"> 

    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" data-integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="icon" href="https://getbootstrap.com/favicon.ico">
        <!-- Bootstrap core CSS -->
        <link href="style/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="style/signin.css" rel="stylesheet">  <!-- Minified Bootstrap CSS -->
        <!-- Minified JS library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Minified Bootstrap JS -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Agregadas para el datepicker -->
        <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>

        <title>RENTAL</title>


    </head> 

    <body class="text-center">

        <div id="header">
            <%@include file="vistas/menu.jsp"%>
        </div>

        <div id="body">

            <%                //terminar de ver la redireccion
                String vista = (String) request.getAttribute("vista");

                if (vista == null) {
            %><%@include file="vistas/home.jsp"%><%
            } else {
                switch (vista) {
                    case "home":
            %><%@include file="vistas/admin.jsp"%><%
                    break;
                case "login":
            %><%@include file="vistas/login.jsp"%><%
                    break;
                    case "reserva":
            %><%@include file="vistas/reserva.jsp"%><%
                    break;
                     case "carrito":
            %><%@include file="vistas/carrito.jsp"%><%
                    break;
                    case "listartemporadas":
            %><%@include file="vistas/listarTemporadas.jsp"%><%                    break;
                case "edittemporada":
            %><%@include file="vistas/editTemporada.jsp"%><%                    break;
                case "error":
            %><%@include file="vistas/error.jsp"%><%
                    break;
                case "listarusuarios":
            %><%@include file="vistas/listar.jsp"%><%                    break;
                case "addusuario":
            %><%@include file="vistas/addUsuario.jsp"%><%
                    break;
                case "editarusuario":
            %><%@include file="vistas/edit.jsp"%><%                    break;
                case "roles":
            %><%@include file="vistas/roles.jsp"%><%                    break;
                case "editrol":
            %><%@include file="vistas/editRol.jsp"%><%                    break;
                case "listarproductos":
            %><%@include file="vistas/listarProductos.jsp"%><%                    break;
                case "addproducto":
            %><%@include file="vistas/addProducto.jsp"%><%                    break;
                case "editproducto":
            %><%@include file="vistas/editProducto.jsp"%><%                    break;
                case "listarcategorias":
            %><%@include file="vistas/categorias.jsp"%><%                    break;
                
            case "editcategoria":
            %><%@include file="vistas/editCategoria.jsp"%><%     
                break;
            case "listarReservas":
            %><%@include file="vistas/listarReservas.jsp"%><%
                    break;
            case "listarReservasUsuario":
            %><%@include file="vistas/listarReservasUsuario.jsp"%><%     
                break;
           
            default:
            %><%@include file="vistas/home.jsp"%><%
                            break;
                    }

                }%>
        </div> 
        <div id="footer"  class="position-relative">
            <%@include file="vistas/pie.jsp" %>
        </div>

        <%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" data-integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> --%>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" data-integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" data-integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>      




    </body>


</html>