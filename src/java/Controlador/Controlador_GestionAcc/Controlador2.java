package Controlador.Controlador_GestionAcc;

import Modelo.Gestion_Acciones.*;
import java.io.IOException;
import static java.lang.System.out;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        String accion = request.getParameter("accion_M");
        
        switch (accion) {            
            case "Registrar":{
                Acciones acc = new Acciones();
                String opc1 = request.getParameter("opciones1");
                String des = request.getParameter("descripcion");
                String opc2 = request.getParameter("opciones2");
                String fecha1 = request.getParameter("fecha_Ini");
                String fecha2 = request.getParameter("fecha_Fin");
                String id_usuario=(String) request.getSession().getAttribute("id_usuario");
                String valor=request.getParameter("valor");
                
                acc.setTipo_Acciones(opc1);
                acc.setDescripcion(des);
                acc.setTipo_Gasto(opc2);
                acc.setFecha_Inicio(fecha1);
                acc.setFecha_Final(fecha2);
                acc.setId_usuario(id_usuario);
                acc.setValor(valor);
                try{
                    acc_op.insert(acc);
                    response.sendRedirect("metas_Objetivos.jsp");
                }catch (Exception err){
                    System.out.println("Error registrando acciones: "+err);
                }
                out.println("End");
                break;
            }

            case "Eliminar":{
                Acciones acc = new Acciones();
                System.out.println("Eliminar");
                String id_accion=request.getParameter("id_accion");
                acc.setId_Acciones(id_accion);
                if(acc_op.eliminar_accion(acc)){
                    response.sendRedirect("ver_acciones.jsp");                    
                }else{
                    response.sendRedirect("ppal.jsp");
                }
                break;
            }

            case "Modificar":{
                Acciones acc=new Acciones();
                String id_accion=request.getParameter("id_accion");
                request.getSession().setAttribute("id_accion_v",id_accion);
                response.sendRedirect("modificar_objetivo_meta.jsp");
                break;
            }
            
            case "Confirmar":{
                Acciones acc = new Acciones();
                String opc1 = request.getParameter("opciones1");
                String des = request.getParameter("descripcion");
                String opc2 = request.getParameter("opciones2");
                String fecha1 = request.getParameter("fecha_Ini");
                String fecha2 = request.getParameter("fecha_Fin");
                //String id_usuario=(String) request.getSession().getAttribute("id_usuario");
                String valor=request.getParameter("valor");                
                
                acc.setTipo_Acciones(opc1);
                acc.setDescripcion(des);
                acc.setTipo_Gasto(opc2);
                acc.setFecha_Inicio(fecha1);
                acc.setFecha_Final(fecha2);
                //acc.setId_usuario(id_usuario);
                acc.setValor(valor);
                acc.setId_Acciones((String)
                    request.getSession().getAttribute("id_accion_v"));
                try{
                    if(acc_op.actualizar_acciones(acc)){
                        request.getSession().removeAttribute("id_accion_v");
                        request.getSession().removeAttribute("vector_acciones");
                        response.sendRedirect("ver_acciones.jsp");
                    }else{
                        request.getSession().removeAttribute("id_accion_v");
                        request.getSession().removeAttribute("vector_acciones");
                        response.sendRedirect("ppal.jsp");
                    }
                }catch (Exception err){
                    System.out.println("Error registrando acciones: "+err);
                }
                out.println("End");
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
