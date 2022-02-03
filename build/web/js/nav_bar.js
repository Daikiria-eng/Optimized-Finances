let nav=
    `<label for="nav_deploy"> 
        <a href="ppal.jsp">
            <img id="logo" src="images/of_logo.png" alt="logo" />
        </a>
        <input id="nav_deploy" type="checkbox" />
    </label>
    <ul>
        <a href="dinero.jsp"><li>Dinero</li></a>
        <a href="metas_Objetivos.jsp"><li>Egresos</li></a>
        <a href="consejos.jsp"><li>Consejos</li></a>
    </ul>
    <p>
        <a href="usuario.jsp"><img id="user_img" src="#" alt="user" /></a>
    </p>`;
let nav_bar=document.querySelector('nav');
nav_bar.innerHTML+=nav;