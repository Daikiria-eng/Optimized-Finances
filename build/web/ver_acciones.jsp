<%-- 
    Document   : ver_acciones
    Created on : Feb 7, 2022, 5:53:12 PM
    Author     : user
--%>

<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Gestion_Acciones.*"%>
<%
    if(request.getSession().getAttribute("usuario")==null){ 
        response.sendRedirect("Index.jsp");
    }
    AccionesJDBC acc_op=new AccionesJDBC();
    Usuario u=new Usuario();
    u.setIdCliente((String) request.getSession().getAttribute("id_usuario"));
    String[][] metas_v=acc_op.get_metas(u);
    String[][] ahorros_v=acc_op.get_ahorros(u);
    String[][] gastos_v=acc_op.get_gastos(u);
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
                <center><h2 class="title_action" id="title_goals">Metas</h2></center>
                <center><h2 class="title_action" id="title_expends">Gastos</h2></center>
                <center><h2 class="title_action" id="title_savings">Ahorros</h2></center>
                <div class="actions" id="goals">
                    <%
                        if(metas_v==null){
                            out.print("<h3>Aún no has regitrado ninguna meta</h3>");
                        }else{
                            for (int i=0;i<metas_v.length;i++){
                    %>                        
                                <form class="action_form">
                                    <div class="labels">
                                        <label>Titulo</label>
                                        <label>Precio</label>
                                        <label>Fecha final</label>
                                    </div>
                                    <div class="inputs">
                                        <input type="hidden" name="id_accion" value="<%out.print(metas_v[i][0]);%>"/>
                                        <input type="text" value="<%out.print(metas_v[i][1]);%>"/>
                                        <input type="number" value="<%out.print(metas_v[i][2]);%>"/>
                                        <input type="date" value="<%out.print(metas_v[i][3]);%>"/>
                                        <div class="submits">
                                            <input class="delete_action" type="submit" value="Eliminar"/>
                                            <input type="submit" value="Modificar"/>
                                        </div>
                                    </div>
                                </form>
                    <%                                
                            }
                        }
                    %>
                </div>
                <div class="actions" id="expends">
                    <%
                        if(gastos_v==null){
                            out.print("<h3>Aún no has regitrado ninguna meta</h3>");
                        }else{
                            for (int i=0;i<gastos_v.length;i++){
                    %>                        
                                <form class="action_form">
                                    <div class="labels">
                                        <label>Titulo</label>
                                        <label>Precio</label>
                                        <label>Fecha final</label>
                                    </div>
                                    <div class="inputs">
                                        <input type="hidden" name="id_accion" value="<%out.print(gastos_v[i][0]);%>"/>
                                        <input type="text" value="<%out.print(gastos_v[i][1]);%>"/>
                                        <input type="number" value="<%out.print(gastos_v[i][2]);%>"/>
                                        <input type="date" value="<%out.print(gastos_v[i][3]);%>"/>
                                        <div class="submits">
                                            <input class="delete_action" type="submit" value="Eliminar"/>
                                            <input type="submit" value="Modificar"/>
                                        </div>
                                    </div>
                                </form>
                    <%                                
                            }
                        }
                    %>
                </div>
                <div class="actions" id="savings">
                    <%
                        if(ahorros_v==null){
                            out.print("<h3>Aún no has regitrado ninguna meta</h3>");
                        }else{
                            for (int i=0;i<ahorros_v.length;i++){
                    %>                        
                                <form class="action_form">
                                    <div class="labels">
                                        <label>Titulo</label>
                                        <label>Precio</label>
                                        <label>Fecha de inicio</label>
                                        <label>Fecha final</label>
                                    </div>
                                    <div class="inputs">
                                        <input type="hidden" name="id_accion" value="<%out.print(ahorros_v[i][0]);%>"/>
                                        <input type="text" value="<%out.print(ahorros_v[i][1]);%>"/>
                                        <input type="number" value="<%out.print(ahorros_v[i][2]);%>"/>
                                        <input type="date" value="<%out.print(ahorros_v[i][3]);%>"/>
                                        <input type="date" value="<%out.print(ahorros_v[i][4]);%>"/>
                                        <div class="submits">
                                            <input class="delete_action" type="submit" value="Eliminar"/>
                                            <input type="submit" value="Modificar"/>
                                        </div>
                                    </div>
                                </form>
                    <%                                
                            }
                        }
                    %>
                </div>
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>