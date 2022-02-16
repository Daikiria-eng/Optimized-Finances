<%-- 
    Document   : ppal
    Created on : Jan 19, 2022, 7:54:46 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user_name=(String)request.getSession().getAttribute("usuario");
    if(request.getSession().getAttribute("usuario")==null){ 
        response.sendRedirect("Index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <link rel="stylesheet" href="Styles/ppal.css">
        <title>Utilidades</title>
    </head>
    <body>
        <nav></nav>
        <div class="main">
            <div class="utilities" id="user_utilities">
                <h2>${sessionScope.usuario}</h2 ><br/>
                <ol id="user_items">
                    <a href="metas_Objetivos.jsp"><li>Egresos</li></a>
                    <a href="stadisticas.jsp"><li>Estadísticas</li></a>
                    <a href="consejos.jsp"><li>Consejos</li></a>
                    <hr/>
                    <a href="usuario.jsp"><li>Ver perfil</li></a>
                    <hr/>
                    <a href="${pageContext.request.contextPath}/Logout"><li>Cerrar sesión</li></a>
                </ol>
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>