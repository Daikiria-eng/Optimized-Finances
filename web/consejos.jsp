<%-- 
    Document   : Consejos
    Created on : 18/02/2022, 11:44:12 p. m.
    Author     : daykiria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Gestion_Consejos.ListaConsejos"%>
<%
    if(request.getSession().getAttribute("usuario")==null){
        response.sendRedirect("Index.jsp");
    }
    ListaConsejos lc=new ListaConsejos();
    String[][] consejos=lc.importar_consejos();
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/sumario.css">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <title>Sumario de egresos</title>
    </head>
    <body>
        <nav></nav>
        <div id="corpse">
            <h1>Sumario</h1>
            <br/>
            <h1 id="month">Mes: </h1>
            <div id="stats">
                <%
                    for(int i=0;i<consejos.length;i++){
                    
                %>
                    <div id="stats_titles">
                        <h2>TItulo:</h2>
                        <h2>Consejo: </h2>

                    </div>
                    <div id="stats_values">
                        <h2><%out.print(consejos[i][0]);%></h2>
                        <h2><%out.print(consejos[i][1]);;%></h2>

                    </div>
                        <br/>
                <%
                        
                    }
                %>
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>
