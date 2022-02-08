package Controlador.Controlador_GestionUsers;

import Modelo.*;
import Modelo.Gestion_Salario.*;
import java.io.*;
//import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {

    UsuarioJDBC persona_OP = new UsuarioJDBC();
    Usuario persona = new Usuario();
    SalarioJDBC salario_op=new SalarioJDBC();
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
                Salario s=new Salario();
                String correo=request.getParameter("correo");
                String clave=request.getParameter("clave");
                //String[] salario_v={};
                String salario_v[]=new String[2];
                p.setCorreo(correo);
                p.setClave(clave);
                boolean user_auth=false;

                try {
                    String[] user_name=persona_OP.iniciar(p);
                    if(user_name!=null) {
                        request.getSession().setAttribute("id_usuario", user_name[0]);
                        request.getSession().setAttribute("usuario", user_name[1]);
                        System.out.print("Checkpoint on Controlador\t"+user_name[0]+"\t"+user_name[1]);
                        s.setId_usuario(user_name[0]);

                        try {
                            salario_v=salario_op.validar_salario(s);
                        } catch (Exception e) {
                            System.out.println("Error, no hay salario:\n"+e);
                        }

                        if(salario_v!=null){
                            System.out.print(salario_v[0]+"\t"+salario_v[1]);
                            request.getSession().setAttribute("salario_actual", salario_v[0]);
                            request.getSession().setAttribute("salario_periodo", salario_v[1]);
                            System.out.println("checkpoint");
                            response.sendRedirect("ppal.jsp");
                        }else{response.sendRedirect("salario.jsp");}
                    } else {response.sendRedirect(request.getContextPath()+"/Login.jsp");}
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error al iniciar sesión:\n"+e);
                }
                /*if(!user_auth){
                    response.sendRedirect(request.getContextPath()+"/Login.jsp");
                }*/   
                break;
            }

            
            case "Eliminar":{
                Usuario p=new Usuario();
                String id_usuario=(String) request.getSession().getAttribute("id_usuario");
                p.setIdCliente(id_usuario);
                if(persona_OP.eliminar_usuario(p))
                    request.getSession().removeAttribute("id_usuario");
                    request.getSession().removeAttribute("usuario");
                    request.getSession().invalidate();

                    response.sendRedirect(request.getContextPath()+"/Index.jsp");
                break;
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
