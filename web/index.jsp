
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
     <title>RENTAL</title>
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
   </head> 

  <body class="text-center">
      <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" >RENTAL</a> 
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
                                <a class="dropdown-item" href="Controlador?accion=signin" >Nueva Reserva</a>
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
                                <a class="dropdown-item" href="#">Lista Productos</a>
                                
                               

                            </div>
                        </div>
                    </li>
                    

                    <%-- <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li> --%>
                </ul>

                <div class="dropdown">
                    
                    <a class="dropdown" style="color: #ffffff" href="Controlador?accion=signin" >Iniciar Sesión</a>
                    
                </div>

            </div>
                



            <%-- <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form> --%>



        </nav>
            <%-- <%@include file="vistas/menu.jsp"  %>
            <% switch(vista){
            case login:
                <%@include file="vistas/Login.jsp"  %>
            break;
            default:
                <%@include file="vistas/home.jsp"  %>
            break;
            }
            %>
            <%@include file="vistas/pie.jsp"  %>
            
        <%--class="m-4"  style="height: 550px
        class="embed-responsive embed-responsive-16by9"--%>

        <div class="embed-responsive embed-responsive-16by9"   >
            
            <!--iframe class="embed-responsive-item" name="myframe"  style="height:100% ;width:100%">
            
                 BIENVENIDOS            
            
            </iframe-->
        </div>
      
        <%--<div  class="container">
             <img class="mb-4" src="style/bootstrap-solid.html" alt="" width="72" height="72">
             <h1 class="h3 mb-3 font-weight-normal">Bienvenidos a RENTAL</h1>
        
                <a class="btn btn-lg btn-primary btn-block" href="Controlador?accion=signin" > LOGIN</a>
      
             <p class="mt-5 mb-3 text-muted">© 2019</p>
   
       </div> --%>
        
        
       
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" data-integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" data-integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" data-integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>      
</body>


</html>