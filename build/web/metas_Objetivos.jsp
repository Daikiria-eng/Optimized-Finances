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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Metas y Objetivos</h1>
        <section>
            <form action="Controlador2" method="POST">

                <input list="opcion_MO" required name="opciones1">
                <datalist id="opcion_MO">
                    <option value="Meta">
                    <option value="Objetivo">
                </datalist>

                <label for="name">Descripción:</label>

                <input type="text" id="name" name="descripcion" required
                       minlength="10" maxlength="18" size="20">

                <input list="opcion_Gasto" required name="opciones2">
                <datalist id="opcion_Gasto">
                    <option value="Gasto">
                    <option value="Ahorro">
                </datalist>

                <label for="start">Fecha Inicial:</label>

                <input type="date" id="start" name="fecha_Ini"
                       value="2022-01-01"
                       min="2022-01-01" max="2025-12-31" required>

                <label for="start">Fecha Final:</label>

                <input type="date" id="start" name="fecha_Fin"
                       value="2022-01-01"
                       min="2022-01-01" max="2025-12-31" required>

                <input type="submit" name="accion_M" value="Registrar">

            </form>

        </section>
    </body>
</html>
