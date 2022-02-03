/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Controlador_GestionAcc;

import Modelo.Gestion_Acciones.*;
import java.io.*;
import static java.lang.System.out;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/Controlador2")
public class Controlador2 extends HttpServlet {

    AccionesJDBC acc_OP = new AccionesJDBC();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String accion = request.getParameter("accion_M");
        
        switch (accion) {
            
            case "Registrar":
                Acciones acc = new Acciones();
                String opc1 = request.getParameter("opciones1");
                String des = request.getParameter("descripcion");
                String opc2 = request.getParameter("opciones2");
                String fecha1 = request.getParameter("fecha_Ini");
                String fecha2 = request.getParameter("fecha_Fin");
                
                acc.setTipo_Acciones(opc1);
                acc.setDescripcion(des);
                acc.setTipo_Gasto(opc2);
                acc.setFecha_Inicio(fecha1);
                acc.setFecha_Final(fecha2);
                
                try{
                    acc_OP.insert(acc);
                    
                }catch (Exception err){
                    System.out.println("Error: "+err);
                }
                break;
            default:
                throw new AssertionError();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
