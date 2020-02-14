/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Reserva;
import ModeloDaoImpl.ReservaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControladorReserva", urlPatterns = {"/ControladorReserva"})
public class ControladorReserva extends HttpServlet {
    
     String listar="/vistas/listarReservas.jsp";
      String add="/vistas/addReserva.jsp";
        String edit="/vistas/editReserva.jsp";
          Reserva res= new Reserva();
    //UsuarioDaoImpl dao=new UsuarioDaoImpl();
     ReservaDaoImpl dao=new ReservaDaoImpl();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         String acceso="";
        String action= request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso=add;
            
        } else if (action.equalsIgnoreCase("Agregar")) {
            //String dni=request.getParameter("dni");
           
            
           // dao.save(usu);            
            acceso=listar;
        }
        else if (action.equalsIgnoreCase("editar")) {
            // int idusu=Integer.parseInt(request.getParameter("id"));
          request.setAttribute("idres",request.getParameter("id"));          
// captura id de fila seleccionada cuando se hace click en editar.
            acceso=edit;
        }
        else if (action.equalsIgnoreCase("Actualizar")) {
             System.out.println("pasa por aca");
            
          
            
            //dao.edit(usu);
            //acceso=listar;
                       
        }
        else if(action.equalsIgnoreCase("delete")){
            /*String id= request.getParameter("id");
             int id1= Integer.parseInt(id);
             usu.setId(id1);
             dao.delete(usu);*/
             acceso=listar;
           
            
        } 
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
       
        
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
