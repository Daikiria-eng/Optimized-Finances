<%-- 
    Document   : metas_Objetivos
    Created on : 31/01/2022, 12:23:39 p. m.
    Author     : julian
--%>

<%@page import="sun.awt.X11.XConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    if(request.getSession().getAttribute("usuario")==null){ 
        response.sendRedirect("Index.jsp");
    }
    String[][] actions_v=(String[][]) request.getSession().getAttribute("vector_acciones");
    for(int i=0;i<actions_v.length;i++){
        for(int j=0;j<actions_v[0].length;j++){
            System.out.println(" [ "+actions_v[i][j]+" ] ");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/metas_Objetivos.css">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <title>Modificar meta u objetivo</title>
    </head>
    <body>
        <nav></nav>
        <section>
            <center><h1>Modificar meta u objetivos</h1></center>
            <%
                for(int i=0;i<actions_v.length;i++){
                    if(actions_v[i][6].equals(request.getSession().getAttribute("id_accion_v"))){
            %>            
                        <form action="Controlador2" method="POST">
                            <label for="list_MO">
                                Escoga una opción
                            </label>
                            <input 
                                list="opcion_MO" required 
                                name="opciones1" id="list_MO"
                                value=<%out.print(actions_v[i][0]);%>
                                placeholder="Meta u objetivo? Despliegue opciones"
                            />
                                <datalist id="opcion_MO">
                                    <option value="Meta">
                                    <option value="Gasto necesario">
                                    <option value="Objetivo">
                                </datalist>

                            <label for="name">Descripción:</label>
                            <input
                                type="text" id="name" name="descripcion" 
                                value=<%out.print(actions_v[i][1]);%>
                                minlength="5" maxlength="198" size="20"
                                placeholder="Ingrese una descripción al egreso"
                                required
                            />

                            <label for="name">Tipo de accion</label>
                            <input 
                                list="opcion_Gasto" value=<%out.print(actions_v[i][2]);%>
                                name="opciones2"
                                placeholder="Gasto o ahorro? Despliegue opciones"
                                required 
                            />
                                <datalist id="opcion_Gasto">
                                    <option value="Gasto">
                                    <option value="Ahorro">
                                </datalist>
                            <label for="goal_cost">Valor</label>
                            <input 
                                type="number" name="valor"
                                value=<%out.print(actions_v[i][5]);%>
                                id="goal_cost" placeholder="valor de la acción"
                                required
                            />
                            <label for="start">Fecha Inicial:</label>
                            <input 
                                type="date" id="start" name="fecha_Ini"
                                value=<%out.print(actions_v[i][3]);%>
                                min="2022-01-01" max="2025-12-31"
                                disabled="true"
                            />

                            <label for="start">Fecha Final:</label>
                            <input 
                                type="date" id="start" name="fecha_Fin"
                                value=<%out.print(actions_v[i][4]);%>
                                min="2022-01-01" max="2025-12-31" required
                            />
                            <input 
                                type="submit" value="Confirmar"
                                name="accion_M" 
                            />
                            <hr style="background-color: grey;height: 2px;width: 100%;border-style: double;"/>
                        </form>
            <%
                            break;
                    }
                }
                /*request.getSession().removeAttribute("id_accion_v");
                request.getSession().removeAttribute("vector_acciones");*/
            %>
            <a href="ver_acciones.jsp"><button>Ver acciones</button></a>
        </section>        
        <script src="js/nav_bar.js"></script>
    </body>
</html>