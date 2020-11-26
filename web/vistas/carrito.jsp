<%-- 
    Document   : carrito
    Created on : 22/11/2020, 20:14:27
    Author     : Alejandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
    <body>
        <div class="container mt-4" >
            <div class="row">
                <div class="col-md-8">
                    <table  class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ITEM</th>
                                    <th>NOMBRES</th>
                                    <th>DESCRIPCIÓN</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>
                                    <th >ACCIÓN</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="car" items="${carrito}" >
                                 <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombre()}</td>
                                    <td>${car.getDescripcion()}
                                    
                                    </td>
                                    <td>${car.getPrecio()}</td>
                                    <td>
                                     
                                        <input type="number" id="Cantidad"  value="${car.getCantidad()}" class="form-control text-center" min="1"   >
                                    </td>
                                    <td>${car.getSubtotal()}</td>
                                    <td> 
                                        <input type="hidden" id="idp"  value="${car.getProducto_id()}">
                                        <a href="#" id="btnDelete">eliminar</a>
                                       
                                    </td>
                                    <td></td>
                                </tr>
                                
                            </c:forEach>
                               
                            </tbody>
                        </table>

                                  </div>
                <div class="col-md-4">
                    <div  class="card">
                        <div class="card-header">
                            <h3>Generar Reserva</h3>
                        </div>
                        <div class="card-body">
                            <label> Subtotal:</label>
                            <input type="text"  value="$.${totalPagar}0" readonly="" class="form-control">
                            <label>Total Pagar :</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                            
                        </div>
                        <div class="card-footer">
                            <a class="btn btn-info btn-block">Realizar Pago</a>
                            <a class="btn btn-danger btn-block"> Generar Reserva </a>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
         <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>  
         <script src="../js/funciones.js" type="text/javascript"></script>
    </body>
</html>
