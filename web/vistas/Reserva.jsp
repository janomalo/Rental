<%-- 
    Document   : Reserva
    Created on : 18/02/2020, 20:43:45
    Author     : Alejandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" data-integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="icon" href="https://getbootstrap.com/favicon.ico">
        <!-- Bootstrap core CSS -->
        <link href="style/bootstrap.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="style/signin.css" rel="stylesheet">

    </head>
    <body>
        
        <div class="container mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                    <div  class="card">
                        <div  class="card-header text-center">
                            <label  > ${p.getNombre()}</label>
                        </div>
                        <div class="card-body">
                            <i> ${p.getPrecio()}</i>
                            <img  src="ControladorImg?id=${p.getId()}" width="200" height="200">
                        </div>
                        <div class="card-footer text-center">
                            <label>${p.getDescripcion()}</label><br>
                            <a  href="#" class="btn btn-outline-info">Agregar a Reserva</a>
                            <a  href="#" class="btn btn-danger">Reservar</a>
                        </div>
                    </div>
                </div>
                    
                </c:forEach>
                
            </div>

        </div>






        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" data-integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" data-integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" data-integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>      

    </body>
</html>
