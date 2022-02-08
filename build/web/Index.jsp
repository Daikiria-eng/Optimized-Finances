<%
    if(request.getSession().getAttribute("usuario")!=null){
        response.sendRedirect("ppal.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="https://kit.fontawesome.com/79e0e4992e.js"
      crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="Styles/styles.css" />
    <title>Optimized Finances</title>
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

    <form action="Controlador" method="POST" class="formulario">
      <h1>Optimized Finances</h1>
      <h2>Regístrate</h2>

      <div class="container">

        <div class="input-container">
          <i class="fas fa-user icon"></i>
          <input name="nombres" type="text" placeholder="Ingrese su Nombre Completo"  required/>
        </div>

        <div class="input-container">
            <i class="fas fa-envelope icon"></i>
          <input name="correo" type="email" placeholder="Ingrese su Correo"  required/>
        </div>

        <div class="input-container">
            <i class="fas fa-lock icon"></i>
          <input name="clave" type="password" placeholder="Ingrese su Contraseña"  required/>
        </div>

        <input name="accion" type="submit" value="Registrate" class="button">
        <p>Ya tienes una cuenta? <a class="link" href="Login.jsp">Iniciar Sesión</a></p>

      </div>
      
    </form>
  </body>
</html>

