<%-- 
    Document   : ver_acciones
    Created on : Feb 7, 2022, 5:53:12 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Gestion_Acciones.*"%>
<%
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
        <link rel="stylesheet" href="Styles/see_actions.css">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <title>Egresos promagramados</title>
    </head>
    <body>
        <nav></nav>
        <div id="corpse">
            <h1>Egresos u objetivos programados</h1>
            <div id="print_cards">
                
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>