let nav=`
    <a href="ppal.jsp">
        <img id="logo" src="images/ozf_logo.png" alt="logo" />
    </a>
    <input id="nav_deploy" type="checkbox" />
    <ul>
        <a href="usuario.jsp"><li>Dinero</li></a>
        <a href="metas_Objetivos.jsp"><li>Egresos</li></a>
        <a href="consejos.jsp"><li>Consejos</li></a>
    </ul>
    <a href="usuario.jsp"><img id="user_img" src="images/user_img.png" alt="user" /></a>
`;
let nav_bar=document.querySelector('nav');
nav_bar.innerHTML+=nav;