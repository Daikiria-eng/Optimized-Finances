package Controlador.Controlador_GestionSalario;

import Modelo.Gestion_Salario.Salario;
import Modelo.Gestion_Salario.SalarioJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class Controlador3 extends HttpServlet {
    SalarioJDBC salario_op=new SalarioJDBC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        switch (accion) {

            case "Anotado": {
                Salario s = new Salario();
                String valor = request.getParameter("valor");
                String periodo = request.getParameter("periodo");
                String salario_actual=request.getParameter("salario_actual");
                String id_usuario = (String) request.getSession().getAttribute("id_usuario");
                s.setValor(valor);
                s.setPeriodo(periodo);
                s.setId_usuario(id_usuario);
                s.setActual(salario_actual);
                boolean sw=false;
                System.out.println(valor + "\t" + periodo + "\t" + id_usuario + "\t" + salario_actual);
                try {
                    if (salario_op.insertar_salario(s)) {
                        response.sendRedirect("ppal.jsp");
                        request.getSession().setAttribute("salario_actual", salario_actual);
                        //request.getSession().setAttribute("salario_valor", s.getValor());
                        sw=true;
                    } else {
                        response.sendRedirect("salario.jsp");
                    }
                } catch (Exception e) {
                    System.out.println("Error al insertar salario:\n" + e);
                }
                //response.sendRedirect("ppal.jsp");
                break;
            }
        }
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
