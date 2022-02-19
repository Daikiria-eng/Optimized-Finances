<%-- 
    Document   : sumario
    Created on : 16/02/2022, 10:09:06 p. m.
    Author     : daykiria
--%>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDateTime"%>
<!DOCTYPE html>

<%
    DateTimeFormatter dtf_s=DateTimeFormatter.ofPattern("MMMM");
    DateTimeFormatter dtf_n=DateTimeFormatter.ofPattern("MM");
    String mes_actual_n=dtf_n.format(LocalDateTime.now());
    String mes_actual_s=dtf_s.format(LocalDateTime.now());
    
    String[][] metas_v=(String[][]) request.getSession().getAttribute("vector_metas"),
        ahorros_v=(String[][]) request.getSession().getAttribute("vector_ahorros"),
        gastos_v=(String[][]) request.getSession().getAttribute("vector_gastos");
    
    int sumario_metas=0,
        sumario_ahorros=0,
        sumario_gastos=0,
        total=0;
    
    if(metas_v!=null){
        for(int i=0;i<metas_v.length;i++){
            String fecha_c=metas_v[i][3];
            String[] mes_c=fecha_c.split("-");
            if(mes_c[1].equals(mes_actual_n)){
                sumario_metas+=Integer.valueOf(metas_v[i][2]);
            }
        }
    }else{
        sumario_metas=0;
    }
    if(gastos_v!=null){
        for(int i=0;i<gastos_v.length;i++){
            String fecha_c=gastos_v[i][3];
            String[] mes_c=fecha_c.split("-");
            if(mes_c[1].equals(mes_actual_n)){
                sumario_gastos+=Integer.valueOf(gastos_v[i][2]);
            }
        }
    }else{
        sumario_gastos=0;
    }
    if(ahorros_v!=null){
        for(int i=0;i<ahorros_v.length;i++){
            String fecha_c=ahorros_v[i][4];
            String[] mes_c=fecha_c.split("-");
            if(mes_c[1].equals(mes_actual_n)){
                sumario_ahorros+=Integer.valueOf(ahorros_v[i][2]);
            }
        }
    }else{
        sumario_gastos=0;
    }
    total=sumario_metas+sumario_gastos;
%>
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
            <h1 id="month">Mes: <%out.print(mes_actual_s);%></h1>
            <div id="stats">
                <div id="stats_titles">
                    <h2>Gastos totales: </h2>
                    <h2>Inversión total en metas: </h2>
                    <h2>Total en ahorros: </h2>
                    <hr/>
                    <h2>Total:</h2>
                    <hr/>
                    <h2>Slario actual: </h2>
                </div>
                <div id="stats_values">
                    <h2><%out.print(sumario_gastos);%></h2>
                    <h2><%out.print(sumario_metas);;%></h2>
                    <h2><%out.print(sumario_ahorros);%></h2>
                    <hr/>
                    <h2><%out.print(total);%></h2>
                    <hr/>
                    <h2>${sessionScope.salario_actual}</h2>
                </div>
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>
