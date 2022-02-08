<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="Styles/salary.css">
        <title>Indique su salario</title>
    </head>
    <body>
        <div id="form_salary">
            <form id="salary" method="POST" action="Controlador3">
                <label for="input_salary">Su salario: $</label>
                <input 
                    type="number" id="input_salary" 
                    placeholder="Ingrese su salario" 
                    name="valor" 
                    required
                />
                <label for="salary_days">
                    Ingrese el período de su salario en días
                </label>
                <input 
                    type="number" id="salary_days"
                    placeholder="Ingrese período de pago"
                    name="periodo"
                    required
                />
                <label for="current_salary_in">
                    Ingrese su salario actual
                </label>
                <input 
                    type="number" id="current_salary_in"
                    placeholder="$ su salario actual"
                    name="salario_actual"
                    required
                />
                <input 
                    type="submit" name="accion" 
                    value="Anotado"
                />
            </form>
        </div>
    </body>
</html>
