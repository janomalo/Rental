

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Rol"%>
<%@page import="Logic.RolControler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div  class="container-fluid col-8" >
        <h1>Roles</h1>
        
        <table  class="table" >
            <thead>
                <tr class="text-center">
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
                <%
                RolControler rolcon= new RolControler(); //llamar a la capa logica y que vaya pasando los datos
                   List<Rol> listroles = rolcon.getAll(); //llama metodo getall y trae lisa de roles
                   Iterator<Rol> iterol = listroles.iterator();
                    
                   //recuperar rol obtenido y pasar por while
                   Rol rol= null;
                    while(iterol.hasNext()){
                        rol=iterol.next();
                                   
                %>
            
            <tbody>
                <tr class="text-center">
                    
                    <td> <%=rol.getId()%></td>
                    <td> <%=rol.getNombre()%></td> 
                    <td>
                        <a class="btn btn-dark" href="Roles?accion=editar&id=<%= rol.getId()%>" >Editar</a>
                        <a class="btn btn-danger">Eliminar</a>
                        
                    </td>
                    
                </tr>
                <%
                }    
                %>
            </tbody>
            
            
            
            
        </table>
        
        </div>
    </body>
</html>
