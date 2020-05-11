/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logic.Login;
import Logic.UsuarioControler;
import Modelo.Usuario;
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
@WebServlet({ "/Signin", "/signin", "/signIn", "/SignIn", "/SIGNIN" })
public class Signin extends HttpServlet {

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
            out.println("<title>Servlet Signin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Signin at " + request.getContextPath() + "</h1>");
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
   
        // String accion = request.getParameter("accion");
        //if (accion.equalsIgnoreCase("Ingresar")) {
            Login ctrl = new Login(); // lo creo para ir a logic y despues  dao
           UsuarioControler usuctrl = new UsuarioControler();// creo controlador de persona de LOGIC
            
            String u = request.getParameter("user");
            String pass = request.getParameter("password");
            Usuario usu= new Usuario();
            
            usu.setUsuario(u);
            usu.setPassword(pass);
            Usuario usu1=ctrl.validate(usu); // 
            
            if(usu1.getId()!=0){
               request.getSession().setAttribute("usuario", usu1);
               
               request.setAttribute("listaUsuarios",usuctrl.getAll()); //obtengo todos los usuarios
                String vista="home";
                request.setAttribute("vista", vista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                String vista="error";
                     request.getRequestDispatcher("vistas/errorlogin.jsp").forward(request, response);
            }
                
        //} else if(accion.equalsIgnoreCase("Salir")){
              
            
                
                
                }
        
        
        
        
        
        
        
        
        
        
        
    }

    

