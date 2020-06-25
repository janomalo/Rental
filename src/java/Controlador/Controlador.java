/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Logic.Login;
import Logic.UsuarioControler;
import Modelo.Usuario;
import ModeloDaoImpl.UsuarioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
public class Controlador extends HttpServlet {

    String listar = "/vistas/listar.jsp";
    String add = "/vistas/add.jsp";
    String edit = "/vistas/edit.jsp";
    String index = "index.jsp";
    Usuario usu = new Usuario();
    UsuarioDaoImpl dao = new UsuarioDaoImpl();
    int r;
    int view;

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
        /*String accion=request.getParameter("accion");
        if(accion.equals("Ingresar")){
                String usuario=request.getParameter("user");
                String pass=request.getParameter("password");
                usu.setUsuario(usuario);
                usu.setPassword(pass);
                r=dao.validar(usu);
                if(r==1){
                    HttpSession session = request.getSession(true);	    
                    session.setAttribute("user",usuario); 
                       
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);
                }
        } else{
         
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }*/
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
            // int idusu=Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idusu", request.getParameter("id"));
// captura id de fila seleccionada cuando se hace click en editar.
           // acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            System.out.println("pasa por aca");

            Integer id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtdni");
            String nombres = request.getParameter("txtnombres");
            String apellidos = request.getParameter("txtapellidos");
            String telefono = request.getParameter("txttelefono");
            String email = request.getParameter("txtemail");
            String password = request.getParameter("txtpassword");
            String direccion = request.getParameter("txtdireccion");
            String usuario = request.getParameter("txtusuario");

            String h = request.getParameter("txthabilitado");
            int hab = Integer.parseInt(h);

            usu.setId(id);
            usu.setDni(dni);
            usu.setNombres(nombres);
            usu.setApellidos(apellidos);
            usu.setTelefono(telefono);
            usu.setEmail(email);
            usu.setPassword(password);
            usu.setDireccion(direccion);
            usu.setUsuario(usuario);
            usu.setHabilitado(hab);

            dao.edit(usu);
            //acceso = listar;
            

        } else if (action.equalsIgnoreCase("delete")) {
            UsuarioControler usuctrl = new UsuarioControler();// creo controlador de persona de LOGIC
            String id = request.getParameter("id");
            int id1 = Integer.parseInt(id);
            usu.setId(id1);
            usuctrl.delete(usu);
            String vista="listarusuarios";
                request.setAttribute("vista", vista);
           // acceso = listar;

        } /*else if (action.equalsIgnoreCase("signin")) {
            String vista="login";
            request.setAttribute("vista", vista);
            
            
            //acceso = signin;

        }*/
        request.getRequestDispatcher("index.jsp").forward(request, response);
       // vista.forward(request, response);

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
        //response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Agregar")){
              UsuarioControler usuctrl = new UsuarioControler();// creo controlador de persona de LOGIC
            String dni = request.getParameter("dni");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String direccion = request.getParameter("direccion");
            String usuario = request.getParameter("usuario");
            String h = request.getParameter("habilitado");
            int hab = Integer.parseInt(h);

            usu.setRol(2);
            usu.setDni(dni);
            usu.setNombres(nombres);
            usu.setApellidos(apellidos);
            usu.setTelefono(telefono);
            usu.setEmail(email);
            usu.setPassword(password);
            usu.setDireccion(direccion);
            usu.setUsuario(usuario);
            usu.setHabilitado(hab);

           
            usuctrl.save(usu);// debe ir a logic y cruzar capas grabar usuario,
            //acceso = listar;
            String vista="listarusuarios";
                request.setAttribute("vista", vista);
            
                
                
                }
request.getRequestDispatcher("index.jsp").forward(request, response);
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
