<%-- 
    Document   : metas_Objetivos
    Created on : 31/01/2022, 12:23:39 p. m.
    Author     : julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/metas_Objetivos.css">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <title>JSP Page</title>
    </head>
    <body>
        <nav></nav>
        <div id="log_actions">

        </div>
        <section>
            <center><h1>Metas y Objetivos</h1></center>
            <form action="Controlador2" method="POST">
                <label for="list_MO">
                    Escoga una opción
                </label>
                <input 
                    list="opcion_MO" required 
                    name="opciones1" id="list_MO"
                    placeholder="Meta u objetivo? Despliegue opciones"
                />
                    <datalist id="opcion_MO">
                        <option value="Meta">
                        <option value="Gasto necesario">
                        <option value="Objetivo">
                    </datalist>

                <label for="name">Descripción:</label>
                <input 
                    type="text" id="name" name="descripcion" required
                    minlength="5" maxlength="198" size="20"
                    placeholder="Ingrese una descripción al egreso"
                />

                <label for="name">Tipo de accion</label>
                <input 
                    list="opcion_Gasto" 
                    required name="opciones2"
                    placeholder="Gasto o ahorro? Despliegue opciones"
                />
                    <datalist id="opcion_Gasto">
                        <option value="Gasto">
                        <option value="Ahorro">
                    </datalist>
                <label for="goal_cost">Valor</label>
                <input 
                    type="number" name="valor"
                    id="goal_cost" placeholder="valor de la acción"
                />
                <label for="start">Fecha Inicial:</label>
                <input 
                    type="date" id="start" name="fecha_Ini"
                    value="2022-01-01"
                    min="2022-01-01" max="2025-12-31"
                    disabled="true"
                />

                <label for="start">Fecha Final:</label>
                <input 
                    type="date" id="start" name="fecha_Fin"
                    value="2022-01-01"
                    min="2022-01-01" max="2025-12-31" required
                />
                <input 
                    type="submit" value="Registrar"
                    name="accion_M" 
                />
                <hr style="background-color: grey;height: 2px;width: 100%;border-style: double;"/>
            </form>
            <a href="ver_acciones.jsp"><button>Ver acciones</button></a>
        </section>        
        <script src="js/nav_bar.js"></script>
    </body>
</html>