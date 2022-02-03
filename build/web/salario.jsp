<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/salary.css">
        <title>Document</title>
    </head>
    <body>
        <div id="form_salary">
            <form id="salary" method="POST" action="Controlador">
                <label for="input_salary">Su salario: $</label>
                <input 
                    type="number" id="input_salary" 
                    placeholder="Ingrese su salario" 
                    name="valor" 
                />
                <label for="salary_days">Ingrese el per�odo de su salario en días</label>
                <input 
                    type="number" id="salary_days"
                    placeholder="Ingrese período de pago"
                    name="periodo"
                />
                <input 
                    type="submit" name="accion" 
                    value="Anotado"
                />
            </form>
        </div>
    </body>
</html>