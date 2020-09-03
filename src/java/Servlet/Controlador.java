/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logic.Login;
import Logic.UsuarioControler;
import Modelo.Usuario;
import ModeloDaoImpl.UsuarioDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
  
    int r;
    int view;
    UsuarioControler usrctrl ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    
    

    public Controlador() {
        // creo controlador de persona de LOGIC
        this.usrctrl= new UsuarioControler(); 
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
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
        if (action.equalsIgnoreCase("listarusuarios")) {
             List<Usuario> list=usrctrl.getAll(); 
            HttpSession session = request.getSession();
           session.setAttribute("listausu", list);
            String vista="listarusuarios";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("editar")) {
           int id;
            id = Integer.parseInt(request.getParameter("id"));
            Usuario u= usrctrl.list(id);
             HttpSession session = request.getSession();
           session.setAttribute("usuedit", u);
            
            
            
            
            String vista="editarusuario";
            request.setAttribute("vista", vista);
            
            
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

            
            if(usrctrl.edit(usu)== true){
            String vista="listarusuarios";
            request.setAttribute("vista", vista);
            }else{
            String vista="erroredit";
            request.setAttribute("vista", vista);
            
            }

        } 
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

        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Agregar")){
              // creo controlador de persona de LOGIC
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

           
            usrctrl.save(usu);// debe ir a logic y cruzar capas grabar usuario,
            //acceso = listar;
            String vista="listarusuarios";
                request.setAttribute("vista", vista);
                          
                
        }else if (action.equalsIgnoreCase("Actualizar")) {
            System.out.println("pasa por aca");
            Integer id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("txtdni");
            String nombres = request.getParameter("txtnombres");
            String apellidos = request.getParameter("txtapellidos");
            String telefono = request.getParameter("txttelefono");
            String email = request.getParameter("txtemail");          
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
            usu.setDireccion(direccion);
            usu.setUsuario(usuario);
            usu.setHabilitado(hab);

            boolean valor= usrctrl.edit(usu);
            if( valor == true){
            String vista="listarusuarios";
            request.setAttribute("vista", vista);
            }else{
            String vista="erroredit";
            request.setAttribute("vista", vista);
            
            }

        } else if (action.equalsIgnoreCase("delete")) {
            
            int id1 = Integer.parseInt(request.getParameter("id"));
            usu.setId(id1);
            usrctrl.delete(usu);
            String vista="listarusuarios";
            request.setAttribute("vista", vista);;
           // acceso = listar;

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
