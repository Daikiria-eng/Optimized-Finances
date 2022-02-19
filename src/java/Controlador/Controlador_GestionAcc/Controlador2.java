package Controlador.Controlador_GestionAcc;

import Modelo.Gestion_Acciones.*;
import java.io.IOException;
import static java.lang.System.out;
import java.io.PrintWriter;
/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 *
 * @author user
 */
//@WebServlet("/Controlador2")
public class Controlador2 extends HttpServlet {
    AccionesJDBC acc_op = new AccionesJDBC();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "Ingresar meta":{
                Acciones acc=new Acciones();
                String tipo_accion=request.getParameter("tipo_accion");
                String titulo=request.getParameter("titulo");
                String meta_valor=request.getParameter("meta_valor");
                String fecha=request.getParameter("meta_fecha");
                
                acc.setTipo_Acciones(tipo_accion);
                acc.setId_usuario((String) request.getSession().getAttribute("id_usuario"));
                acc.setTitulo(titulo);
                acc.setValor(meta_valor);
                acc.setFecha_Final(fecha);
                try {
                    if(acc_op.insertar_meta(acc))
                        response.sendRedirect("metas_Objetivos.jsp");
                    else
                        response.sendRedirect("ppal.jsp");
                } catch (Exception e) {
                    System.out.println("Error: insertarndo meta: controlador2:\n"+e);
                }
                break;
            }
            case "Ingresar gasto":{
                Acciones acc=new Acciones();
                String tipo_accion=request.getParameter("tipo_accion");
                String titulo=request.getParameter("titulo");
                String meta_valor=request.getParameter("meta_valor");
                String fecha=request.getParameter("fecha_gasto");
                
                acc.setTipo_Acciones(tipo_accion);
                acc.setTitulo(titulo);
                acc.setValor(meta_valor);
                acc.setFecha_Final(fecha);
                acc.setId_usuario((String) request.getSession().getAttribute("id_usuario"));
                try {
                    if(acc_op.insertar_gasto(acc))
                        response.sendRedirect("metas_Objetivos.jsp");
                    else
                        response.sendRedirect("ppal.jsp");
                } catch (Exception e) {
                    System.out.println("Error: insertando gasto: controlador2:\n"+e);
                }
                break;
            }
            
            case "Ingresar ahorro":{
                Acciones acc=new Acciones();
                String tipo_accion=request.getParameter("tipo_accion");
                String titulo=request.getParameter("titulo");
                String meta_valor=request.getParameter("meta_valor");
                String fecha_inicio=request.getParameter("ahorro_fecha");
                String fecha_final=request.getParameter("ahorro_fecha_final");
                
                acc.setTipo_Acciones(tipo_accion);
                acc.setTitulo(titulo);
                acc.setValor(meta_valor);
                acc.setFecha_Inicio(fecha_inicio);
                acc.setFecha_Final(fecha_final);
                acc.setId_usuario((String) request.getSession().getAttribute("id_usuario"));
                try {
                    if(acc_op.insertar_ahorro(acc))
                        response.sendRedirect("metas_Objetivos.jsp");
                    else
                        response.sendRedirect("ppal.jsp");
                } catch (Exception e) {
                    System.out.println("Error: insertando ahorro: controlador2:\n"+e);
                }
                break;
            }
            
            case "Eliminar meta":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                if(acc_op.eliminar_meta(acc))
                    response.sendRedirect("metas_Objetivos.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            
            case "Eliminar gasto":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                if(acc_op.eliminar_gasto(acc))
                    response.sendRedirect("metas_Objetivos.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            
            case "Eliminar ahorro":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                if(acc_op.eliminar_ahorro(acc))
                    response.sendRedirect("metas_Objetivos.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            
            case "Modificar meta":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                acc.setTitulo((String) request.getParameter("titulo"));
                acc.setValor((String) request.getParameter("precio"));
                acc.setFecha_Final((String) request.getParameter("fecha_final"));
                
                if(acc_op.modificar_meta(acc))
                    response.sendRedirect("ver_acciones.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            case "Modificar gasto":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                acc.setTitulo((String) request.getParameter("titulo"));
                acc.setValor((String) request.getParameter("precio"));
                acc.setFecha_Final((String) request.getParameter("fecha_final"));
                
                if(acc_op.modificar_gasto(acc))
                    response.sendRedirect("ver_acciones.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            case "Modificar ahorro":{
                Acciones acc=new Acciones();
                String id_accion=(String) request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                acc.setTitulo((String) request.getParameter("titulo"));
                acc.setValor((String) request.getParameter("precio"));
                acc.setFecha_Inicio((String) request.getParameter("fecha_inicio"));
                acc.setFecha_Final((String) request.getParameter("fecha_final"));
                
                if(acc_op.modificar_ahorro(acc))
                    response.sendRedirect("ver_acciones.jsp");
                else
                    response.sendRedirect("ppal.jsp");
                break;
            }
            default:
                //throw new AssertionError();
                break;
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