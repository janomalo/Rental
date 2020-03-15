<%@page import="javax.websocket.Session"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <%if (session.getAttribute("usuario") == null) {%>
        <%@include file="/vistas/menupublic.jsp"%>
        <%} else {
            String rol = String.valueOf(session.getAttribute("rol"));
            if (rol == null) {
                 %><%@include file="/vistas/menupublic.jsp"%><%
            } else {
                switch (rol) {
                    case "1":
                        %><%@include file="/vistas/menuadmin.jsp"%><%
                                        break;
                                    case "2":
                                        %><%@include file="/vistas/menuuser.jsp"%><%
                                         break;
                                     default:
                    %><%@include file="/vistas/menupublic.jsp"%>
        <%
                            break;
                    }

                }
            }
        %>
    </body>
</html>
