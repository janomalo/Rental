/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Modelo.Producto;
import ModeloDaoImpl.ProductoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      String listar="/vistas/listarProductos.jsp";
      String add="/vistas/addProducto.jsp";
        String edit="/vistas/editProducto.jsp";
        String reserva="/vistas/Reserva.jsp";
          Producto pro= new Producto();
    //UsuarioDaoImpl dao=new UsuarioDaoImpl();
     ProductoDaoImpl dao=new ProductoDaoImpl();
     List<Producto> productos= new ArrayList<>();
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        
        
        
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
        String action=request.getParameter("accion");
        
         if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        } else if (action.equalsIgnoreCase("add")) {
          acceso=add;
            
        } else if (action.equalsIgnoreCase("Agregar")) {
           Integer categoria= Integer.parseInt(request.getParameter("categoria"));
           String nombre=request.getParameter("nombre");
           String descripcion= request.getParameter("descripcion");
           Integer stock=Integer.parseInt(request.getParameter("stock"));
           Float precio=Float.parseFloat(request.getParameter("precio"));
           Integer estado=Integer.parseInt(request.getParameter("estado"));
           
           pro.setCategoria_id(categoria);
           pro.setNombre(nombre);
           pro.setDescripcion(descripcion);
           pro.setStock(stock);
           pro.setPrecio(precio);
           pro.setEstado(estado);
           
           dao.save(pro);
           acceso=listar;
        }
        else if (action.equalsIgnoreCase("editar")) {
          // int idusu=Integer.parseInt(request.getParameter("id"));
          request.setAttribute("idpro",request.getParameter("id"));          
// captura id de fila seleccionada cuando se hace click en editar.
            acceso=edit;
        }
        else if (action.equalsIgnoreCase("Actualizar")) {
            System.out.println("pasa por aca ACTUALIZAR");
            
            Integer id=Integer.parseInt(request.getParameter("txtid"));
            Integer categoria= Integer.parseInt(request.getParameter("txtcategoriaid"));
            String nombre=request.getParameter("txtnombre");
            String descripcion=request.getParameter("txtdescripcion");
            Integer stock=Integer.parseInt(request.getParameter("txtstock"));
            Float precio=Float.parseFloat(request.getParameter("txtprecio"));                                
            String h= request.getParameter("txthabilitado");
            int hab= Integer.parseInt(h) ;
            
            pro.setId(id);
            pro.setCategoria_id(categoria);
            pro.setNombre(nombre);
            pro.setDescripcion(descripcion);
            pro.setStock(stock);
            pro.setPrecio(precio);
            pro.setEstado(hab);                     
            
            dao.edit(pro);
            acceso=listar;
                       
        }
        else if(action.equalsIgnoreCase("delete")){
             String id= request.getParameter("id");
             int id1= Integer.parseInt(id);
             pro.setId(id1);
             dao.delete(pro);
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
    
    public List<Producto> getall(){
        return dao.listar();
    }

}
