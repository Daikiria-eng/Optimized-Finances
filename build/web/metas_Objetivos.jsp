<%-- 
    Document   : metas_Objetivos
    Created on : 31/01/2022, 12:23:39 p. m.
    Author     : julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    if(request.getSession().getAttribute("usuario")==null){ 
        response.sendRedirect("Index.jsp");
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
        <title>Metas u objetivos</title>
    </head>
    <body>
        <nav></nav>
        <section>
            <center><h1>Sus egresos</h1></center>
            <div id="deploy_things">
                <button id="btn_goal">Meta</button>
                <button id="btn_expend">Gasto</button>
                <button id="btn_saving">Ahorro</button>
            </div>
            <div id="actions">
                <form mehod="POST" action="Controlador2" class="action" id="goals">
                    <div class="labels">
                        <label for="title_goal">
                            Título de la meta
                        </label>
                        <label for="price_goal">
                            Precio de la meta
                        </label>
                        <label for="date_goal">
                            Fecha de la meta
                        </label>
                    </div>
                    <div class="inputs">
                        <input 
                            type="hidden"
                            value="meta"
                            name="tipo_accion"
                        />
                        <input
                            id="title_goal"
                            type="text" 
                            class="goal_title" 
                            name="titulo"
                            placeholder="Título de la meta"
                        />
                        <input 
                            id="price_goal"
                            type="number" 
                            class="goal_price"
                            placeholder="Ingrese el valor de la meta"
                            name="meta_valor"
                        />
                        <input 
                            id="date_goal"
                            type="date"
                            class="goal_date"
                            value=""
                            name="meta_fecha"
                        />
                        <input 
                            type="submit"
                            name="accion"
                            value="Ingresar meta"
                        />
                    </div>
                </form>
                <form mehod="POST" action="Controlador2" class="action" id="expend">
                    <div class="labels">
                        <label for="title_expend">
                            Título del gasto
                        </label>
                        <label for="price_expend">
                            Precio del gasto
                        </label>
                        <label for="date_expend">
                            Fecha del gasto
                        </label>
                    </div>
                    <div class="inputs">
                        <input 
                            type="hidden"
                            value="gasto"
                            name="tipo_accion"
                        />
                        <input
                            id="title_expend"
                            type="text" 
                            class="expend_title" 
                            name="titulo"
                            placeholder="Título del gasto"
                        />
                        <input 
                            id="price_expend"
                            type="number" 
                            class="expend_price"
                            placeholder="Ingrese el valor del gasto"
                            name="meta_valor"
                        />
                        <input
                            type="date" name="fecha_gasto"
                            id="date_expend"
                            class="expend_date"
                        />
                        <input 
                            type="submit"
                            name="accion"
                            value="Ingresar gasto"
                        />
                    </div>
                </form>
                <form mehod="POST" action="Controlador2" class="action" id="saving">
                    <div class="labels">
                        <label for="title_saving">
                            Título del ahorro
                        </label>
                        <label for="price_saving">
                            Precio del ahorro
                        </label>
                        <label for="date_saving">
                            Fecha del ahorro
                        </label>
                        <label for="date_saving_end">
                            Fecha final del ahorro
                        </label>
                    </div>
                    <div class="inputs">
                        <input 
                            type="hidden"
                            value="ahorro"
                            name="tipo_accion"
                        />
                        <input
                            id="title_saving"
                            type="text" 
                            class="saving_title" 
                            name="titulo"
                            placeholder="Título del ahorro"
                        />
                        <input 
                            id="price_saving"
                            type="number" 
                            class="saving_price"
                            placeholder="Ingrese el valor del ahorro"
                            name="meta_valor"
                        />
                        <input 
                            id="date_saving"
                            type="date"
                            class="saving_date"
                            value=""
                            name="ahorro_fecha"
                        />
                        <input 
                            id="date_saving_end"
                            type="date"
                            class="saving_date_end"
                            value=""
                            name="ahorro_fecha_final"
                        />
                        <input 
                            type="submit"
                            name="accion"
                            value="Ingresar ahorro"
                        />
                    </div>
                </form>                
            </div>
        </section>
        <script>
            let actions=document.querySelector('#actions');
            let goals=document.querySelector('#goals');
            let expends=document.querySelector('#expend');
            let saving=document.querySelector('#saving');

            let btn_expend=document.querySelector('#btn_expend');
            let btn_saving=document.querySelector('#btn_saving');
            let btn_goal=document.querySelector('#btn_goal');
            let body=document.querySelector('body');
            let section=document.querySelector('section');

            btn_expend.addEventListener('click',()=>{
                if(expends.style.display=="none"){
                    expends.style.display="flex";
                    window.addEventListener('click', (event)=>{
                        if(event.target==body
                            || event.target==expends
                            || evet.target==section){
                            expends.style.display="none";
                        }
                    });
                }else{
                    expends.style.display="none";
                }
            });
            btn_goal.addEventListener('click',()=>{
                if(goals.style.display=="none"){
                    goals.style.display="flex";
                    window.addEventListener('click', (event)=>{
                        if(event.target==body
                            || event.target==goals
                            || evet.target==section){
                            goals.style.display="none";
                        }
                    });
                }else{
                    goals.style.display="none";
                }
            });
            btn_saving.addEventListener('click',()=>{
                if(saving.style.display=="none"){
                    saving.style.display="flex";
                    window.addEventListener('click', (event)=>{
                        if(event.target==body
                            || event.target==saving
                            || evet.target==section){
                            saving.style.display="none";
                        }
                    });
                }else{
                    saving.style.display="none";
                };
            });
        </script>
        <script src="js/nav_bar.js"></script>
    </body>
</html>