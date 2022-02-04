<%-- 
    Document   : usuario
    Created on : Feb 3, 2022, 11:04:53 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombre=(String) request.getSession().getAttribute("usuario");
    String salario=(String) request.getSession().getAttribute("salario_valor");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Styles/nav_bar.css">
        <link rel="stylesheet" href="Styles/usuario.css">
        <title>Dinero</title>
    </head>
    <body>
        <nav></nav>
        <center><h1><%out.print(nombre);%></h1></center>
        <div id="corpse">
            <div id="menu">
                <ul>
                    <a href="${pageContext.request.contextPath}/Logout"><li>Cerrar sesión</li></a>
                    <hr/>
                    <li>Cambiar nombres</li>
                    <li>Cambiar salario</li>
                    <li id="delete" onclick="active();">Eliminar cuenta</li>
                    <form method="POST" action="Controlador" id="sure_delete">
                        <h4>¿Seguro que desea eliminar su cuenta?</h4>
                        <input 
                            type="submit" name="accion" 
                            id="dl_confirm" value="Eliminar" 
                        />
                        <input 
                            type="submit" name="accion"
                            id="dl_cancel" value="Cancelar"
                        />
                    </form>
                </ul>
            </div>
            <div id="user_stats">
                <div id="cash_div">
                    <h1 id="my_cash"><i>Su dinero: $</i><%out.print(salario);%><strong id="cash"></strong></h1>
                    <div id="prev_subtract_label">
                        <label for="prev_subtract">                    
                            <i class="arrow" id="prev_subtract_arrow"></i>
                        </label>
                        <h3 id="prev_subtract">Última resta:<br/>    de: $ <br/>    En: </h3>
                    </div>
                    <div id="next_subtract_div">
                        <label  for="next_subtract">
                            <i class="arrow" id="next_subtract_arrow"></i>
                        </label>
                        <h3 id="next_subtract">Próxima resta:<br/>   de: $ <br/>    En: </h3>                
                    </div>
                </div>
            </div>
        </div>
        <script>
            let div_dl=document.querySelector('#sure_delete');
            let cancel_btn=document.querySelector('#dl_cancel');
            let dl_btn=document.querySelector('#delete');
            dl_btn.addEventListener('click',()=>{
                if(div_dl.style.display=="none"){
                    div_dl.style.display="block";
                }else{
                    div_dl.style.display="none";
                }
            });
            cancel_btn.addEventListener('click',()=>{
                div_dl.style.display="none";
            });
        </script>
        <script src="js/nav_bar.js"></script>
    </body>
</html>