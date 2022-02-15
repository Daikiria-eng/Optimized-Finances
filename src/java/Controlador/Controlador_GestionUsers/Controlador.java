package Controlador.Controlador_GestionUsers;

import Modelo.*;
import Modelo.Gestion_Salario.*;
import java.io.IOException;
import java.io.PrintWriter;
/*import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author daykiria
 */
public class Controlador extends HttpServlet {
    
    UsuarioJDBC persona_OP = new UsuarioJDBC();
    Usuario persona = new Usuario();
    SalarioJDBC salario_op=new SalarioJDBC();
    
    int r = 0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
                String accion = request.getParameter("accion");

        switch (accion) {
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
                        request.getSession().setAttribute("usuario_correo", user_name[2]);
                        s.setId_usuario(user_name[0]);

                        try {
                            salario_v=salario_op.validar_salario(s);
                        } catch (Exception e) {
                            System.out.println("Error, no hay salario:\n"+e);
                        }

                        if(salario_v!=null){
                            request.getSession().setAttribute("salario_actual", salario_v[0]);
                            request.getSession().setAttribute("salario_periodo", salario_v[1]);
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
        }
        
        //response.sendRedirect("Index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
