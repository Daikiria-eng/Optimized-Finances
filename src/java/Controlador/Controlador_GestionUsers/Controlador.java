package Controlador.Controlador_GestionUsers;

import Modelo.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    UsuarioJDBC persona_OP = new UsuarioJDBC();
    Usuario persona = new Usuario();
    int r = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");

        switch (accion) {

//            case "Ver Datos":
//            case "Atras": {
//                request.getRequestDispatcher("Form.jsp").forward(request, response);
//            }
//            break;
//            case "Salir": {
//                request.getRequestDispatcher("sign_in.jsp").forward(request, response);
//            }
//            break;
            
//            case "Listar": {
//                List<Persona> datos;
//                datos = persona_OP.select();
//                request.setAttribute("datos", datos);
//                request.getRequestDispatcher("Form.jsp").forward(request, response);
//            }
//            break;

            case "Registrate":{
                Usuario p = new Usuario();
                String nom = request.getParameter("nombres");
                String correo = request.getParameter("correo");
                String clave = request.getParameter("clave");
                
                p.setNombres(nom);
                p.setCorreo(correo);
                p.setClave(clave);
                try{
                    persona_OP.insert(p);
                    response.sendRedirect("Login.jsp");
                }catch (Exception err){
                    System.out.println("ERror: "+err);
                }
                out.println("<script>alert(`Registro Exitoso`)</script>");
                //request.getRequestDispatcher("Login.jsp").forward(request, response);
                break;
            }
            
            case "Iniciar":{
                Usuario p=new Usuario();
                String correo=request.getParameter("correo");
                String clave=request.getParameter("clave");
                p.setCorreo(correo);
                p.setClave(clave);
                try {                    
                    String[] user_name=persona_OP.iniciar(p);
                    if(user_name!=null) {
                        request.getSession().setAttribute("usuario", user_name[1]);
                        request.getSession().setAttribute("id_usuario", user_name[0]);
                        if(persona_OP.validar_salario(user_name)){
                            response.sendRedirect("ppal.jsp");
                        }else response.sendRedirect("salario.jsp");
                    }else out.print("Bad!");
                } catch (Exception e) {
                    System.out.println("error: "+e);
                }
                /*try{
                    if(persona_OP.iniciar(p)){ 
                        response.sendRedirect("ppal.jsp");
                    }
                    else response.sendRedirect("Login.jsp");
                }catch(IOException | ClassNotFoundException err){
                    System.out.println("Error al iniciar: "+err);
                }*/

                break;
            }
            case "Anotado":{
                String valor=request.getParameter("valor");
                String periodo=request.getParameter("periodo");
                String id_usuario=(String) request.getSession().getAttribute("id_usuario");                
                System.out.println(valor+"\t"+periodo+"\t"+id_usuario);
                if(persona_OP.salario(valor,periodo,id_usuario)){
                    response.sendRedirect("ppal.jsp");
                }else response.sendRedirect("Login.jsp");
            }
//            case "Editar":
//            {
//                String id = request.getParameter("id");
//                Usuario pe = persona_OP.listarID(id);
//                request.setAttribute("persona", pe);
//                request.getRequestDispatcher("update.jsp").forward(request, response);
//                
//            }
//            break;
//            case "Actualizar":
//            {
//                String id = request.getParameter("id");
//                String nom = request.getParameter("nombre");
//                String apell = request.getParameter("apellido");
//                String correo = request.getParameter("correo");
//                String clave = request.getParameter("contra");
//                
//                persona.setIdCliente(id);
//                persona.setNombre(nom);
//                persona.setApellido(apell);
//                persona.setCorreo(correo);
//                persona.setClave(clave);
//                
//                persona_OP.update(persona);
//               request.getRequestDispatcher("sign_in.jsp").forward(request, response);
//               
//            }
//             break;
             
//            case "Eliminar":
//            {
//                String id = request.getParameter("id");
//                persona.setIdCliente(id);
//                persona_OP.delete(persona);
//                request.getRequestDispatcher("sign_in.jsp").forward(request, response);
//            }
//            break;
//            default:
//                throw new AssertionError();
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
