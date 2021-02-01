<%-- 
    Document   : Reserva
    Created on : 18/02/2020, 20:43:45
    Author     : Alejandro
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>
   
    </head>
    <body>
         
        <h1>RESERVA</h1>
      
        <div class="container mt-2">
            <div>
          
            <button class="btn-danger">${contador} ELEMENTOS</button>
        </div>
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
                            <a  href="ControladorReserva?accion=AgregarReserva&id=${p.getId()}" class="btn btn-outline-info">Agregar a Reserva </a>
                            <a  href="ControladorReserva?accion=Reservar&id=${p.getId()}" class="btn btn-danger">Reservar</a>
                        </div>
                    </div>
                </div>
                            
                </c:forEach>
                
            </div>

        </div>

      


        
    </body>
</html>
