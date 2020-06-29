
<%@page import="Logic.UsuarioControler"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Interfaces.IUsuarioDao"%>
<%@page import="ModeloDaoImpl.UsuarioDaoImpl" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GESTIÓN DE USUARIOS</title>
        
    </head>
    <body>
        <div  class="container-fluid">
            <h1>GESTIÓN DE USUARIOS </h1> 
            <table class="table">
                
                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>DNI</th> 
                        <th>NOMBRES</th>
                        <th>APELLIDOS</th>
                        <th>TELEFONO</th>
                        <th>DIRECCION</th>
                        <th>EMAIL</th>
                        <th>USER</th>
                        <th>HABILITADO</th>
                        <%--<th>FECHA REGISTRO</th> --%>
                        <th>ACCIONES</th>
                                                  
                    </tr>
                </thead>
                <%
                   
                   UsuarioControler usucon= new UsuarioControler(); //llamar a la capa logica y que vaya pasando los datos
                   List<Usuario> list=usucon.getAll(); //llama metodo getall y trae lisa de usuario
                   Iterator<Usuario> iter=list.iterator();
                    
                   Usuario usu= null;
                    while(iter.hasNext()){
                        usu=iter.next();
                    
                                    
                %>
                <tbody>
                    
                    <tr class="text-center">
                        <td> <%= usu.getId() %></td>
                      <td> <%= usu.getDni() %></td>
                       <td> <%= usu.getNombres()%></td>
                       <td> <%= usu.getApellidos()%></td>
                       <td>  <%= usu.getTelefono()%></td>
                       <td> <%= usu.getDireccion()%></td>
                       <td> <%= usu.getEmail() %> </td>
                       <td> <%= usu.getUsuario()%> </td>
                       <td> <%= usu.getHabilitado() %> </td>
                       
                       
                       <%-- <td> <%= usu.getFecha_registro()%> </td> --%>
                       <td>
                           <a class="btn btn-dark "  href="Controlador?accion=editar&id=<%= usu.getId()%>" >Editar </a>
                           <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter">Eliminar  </button>
                           <%-- <a  class="btn btn-danger" href="Controlador?accion=delete&id=<%= usu.getId()%>">Er</a> --%>
                                 <!-- Button trigger modal -->


    <!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Eliminar Usuario</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ¡¡Esta a punto de eliminar un Usuario!!!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <a class="btn btn-danger" href="Controlador?accion=delete&id=<%= usu.getId()%>">Eliminar</a>
      </div>
    </div>
  </div>
</div>
                       </td>
                        
                        
                        
                    </tr>
                    <%
                    }
                    
                    %>
                </tbody>
                
                               
                
            </table> 
          
              
              <%-- <a class="btn btn-success" href="index.jsp"> Volver</a> --%>
        </div>
                
                
    </body>
</html>
