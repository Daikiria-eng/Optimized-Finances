<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Styles/styles.css">
    <script
      src="https://kit.fontawesome.com/79e0e4992e.js"
      crossorigin="anonymous"
    ></script>
    <title>Inicie Sesión</title>
</head>
<body>

    <header class="header">
        <div class="container1">
          <div class="logo">
            <h1>
              Optimized Finances
            </h1>
          </div>
          <!-- <nav class="menu">
            <a href="#">Inicio</a>
            <a href="#">Holi</a>
            <a href="#">Azucar</a>
            <a href="#">Aguapanela</a>
          </nav> -->
        </div>
      </header>

    <form  method="POST" action="Controlador" class="formulario">
        <h1>Iniciar Sesión</h1>  
        <div class="container">
            <div class="input-container">
                <i class="fas fa-envelope icon"></i>
                <input type="email" name="correo" placeholder="Ingrese su Correo" required />
            </div>  
            <div class="input-container">
                <i class="fas fa-lock icon"></i>
                <input type="password" name="clave" placeholder="Ingrese su Contraseña" required />
            </div>  
            <input type="submit" name="accion" value="Iniciar" class="button" />
            <p>No tienes una cuenta? <a class="link" href="Index.jsp">Registrate</a></p>  
        </div>  
    </form>
</body>
</html>