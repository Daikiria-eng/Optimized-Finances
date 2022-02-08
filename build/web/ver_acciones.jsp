<%-- 
    Document   : ver_acciones
    Created on : Feb 7, 2022, 5:53:12 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Gestion_Acciones.AccionesJDBC"%>
<%
    if(request.getSession().getAttribute("usuario")==null){ 
        response.sendRedirect("Index.jsp");
    }
    
    AccionesJDBC a=new AccionesJDBC();
    String empty="<h2>Aún no has registrado alguna acción<br/>O no tienes algún gasto pendiente</h2>";
    String id_usuario=(String) request.getSession().getAttribute("id_usuario");
    String[][] actions_v=a.getAcciones(id_usuario);
    request.getSession().setAttribute("vector_acciones", actions_v);
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
                <%if(actions_v!=null){
                    for(int i=0;i<actions_v.length;i++){%>
                        <form method="POST" action="Controlador2" class="log_actions_cards">
                            <input
                                type="hidden"
                                name="counter"
                                value=${i+1}
                            />
                            <input 
                                type="hidden"
                                value=<%out.print(actions_v[i][6]);%>
                                name="id_accion"
                            />
                            <div class="cards">
                                <div class="cards_labels">
                                    <label for="type_action">Tipo de acción</label>
                                    <label for="descrip">Descripción</label> 
                                    <label for="type_spend">Tipo de gasto</label> 
                                    <label for="start_date">Fecha de inicio</label> 
                                    <label for="last_date">Fecha final</label> 
                                    <label for="price">valor</label> 
                                </div>
                                <div class="cards_inputs">
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][0]);%>
                                        type="text" 
                                        name="tipo_accion"
                                        placholder=""
                                        class="input_action_m"
                                    />
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][1]);%>
                                        type="text" 
                                        name="descripcion"
                                        placholder=""
                                        class="input_action_m"
                                    />
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][2]);%>
                                        type="text" 
                                        name="tipo_gasto"
                                        placholder=""
                                        class="input_action_m"
                                    />
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][3]);%>
                                        type="date" 
                                        name="fecha_inicio"
                                        placholder=""
                                        class="input_action_m"
                                    />    
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][4]);%>
                                        type="date" 
                                        name="fecha_final"
                                        placholder=""
                                        class="input_action_m"
                                    />
                                    <input
                                        disabled
                                        value=<%out.print(actions_v[i][5]);%>
                                        type="number" 
                                        name="valor"
                                        placholder=""
                                        class="input_action_m"
                                    />
                                </div>
                                <input 
                                    type="submit" class="active_modify"
                                    name="accion_M"value="Modificar"
                                    id=<%out.print("btn_active_modify"+(i+1));%>
                                />
                                <input 
                                    type="submit" value="Confirmar"
                                    name="accion" class="modify_action"
                                    disabled
                                />
                                <input                      
                                    type="submit" name="accion_M"
                                    value="Eliminar" id="delete_card"
                                    class="delete_card_c"
                                />
                            </div>
                        </form>
                <%      System.out.println(i);
                    }
                }else{
                    out.print(empty);
                }%>
            </div>
        </div>
        <script src="js/nav_bar.js"></script>
    </body>
</html>