/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logic.RolControler;
import Modelo.Rol;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "Roles", urlPatterns = {"/Roles"})
public class Roles extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      private RolControler rolctrl;
    
    
    
    
    public Roles() {
        
      rolctrl= new RolControler();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Roles</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Roles at " + request.getContextPath() + "</h1>");
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
        
          //String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Agregar")) {
            
        } else if (action.equalsIgnoreCase("editar")) {
            int idrol= Integer.parseInt(request.getParameter("id"));                    
           Rol r = rolctrl.getById(idrol);
           HttpSession session = request.getSession();
           session.setAttribute("rol", r);
         
          String vista="editrol";
            
            request.setAttribute("vista", vista);
// captura id de fila seleccionada cuando se hace click en editar.
           // acceso = edit;
        }else if(action.equalsIgnoreCase("Actualizar")){
            RolControler rolctrl = new RolControler();
           Integer id = Integer.parseInt(request.getParameter("txtidrol"));
           String nombre = request.getParameter("txtnamerol");
           
           Rol r= new Rol();
           r.setId(id);
           r.setNombre(nombre);
           
           if(rolctrl.update(r)== true){
               
            String vista="roles";
            request.setAttribute("vista", vista);
                       
           }else{
            String vista="erroredit";
            request.setAttribute("vista", vista);
            
            }
            
        
        
        }
        
        
        
        
        
           request.getRequestDispatcher("index.jsp").forward(request, response);
        
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
