/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logic.TemporadaControler;
import Modelo.Temporada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "Temporadas", urlPatterns = {"/Temporadas"})
public class Temporadas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    Temporada tem;
    TemporadaControler temctrl;
    
    public Temporadas() {
        this.tem=new Temporada();
        temctrl=new TemporadaControler();
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Temporadas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Temporadas at " + request.getContextPath() + "</h1>");
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
        
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            List<Temporada> listtemporadas = temctrl.getAll();
            request.setAttribute("listatemporadas", listtemporadas);
            String vista = "listartemporadas";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("add")) {
            String vista = "addtemporada";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("edit")) {
            int idtemporada = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idtem", request.getParameter("id"));
            tem = temctrl.getById(idtemporada);
            request.setAttribute("temporada", tem);
            String vista = "edittemporada";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            int id1 = Integer.parseInt(id);
            tem.setId(id1);
            temctrl.delete(tem);
            List<Temporada> listtemporadas = temctrl.getAll();
            request.setAttribute("listatemporadas", listtemporadas);
            String vista = "listartemporadas";
            request.setAttribute("vista", vista);

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
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("Agregar")) { //funciona
            String nombre = request.getParameter("nombre");
            Integer estado = Integer.parseInt(request.getParameter("estado"));
           /* tem.setNombre(nombre);
            tem.setEstado(estado);
            temctrl.save(tem);*/
            List<Temporada> listemporadas = temctrl.getAll();
            request.setAttribute("listatemporadas", listemporadas);
            String vista = "listartemporadas";
            request.setAttribute("vista", vista);
            // listar
        } else if (action.equalsIgnoreCase("update")) {
            Integer id = Integer.parseInt(request.getParameter("txtid"));
            String descripcion = request.getParameter("txtdescripcion");
            String fecha_desde = request.getParameter("txtfdesde");
            String fecha_hasta = request.getParameter("txtfhasta");
            float precio = Integer.parseInt(request.getParameter("txtprecio"));
            
            tem.setId(id);
            tem.setDescripcion(descripcion);
            tem.setFecha_desde(fecha_desde);
            tem.setFecha_hasta(fecha_hasta);
            tem.setPrecio(precio);
            

           /* tem.setId(id);
            tem.setNombre(nombre);
            tem.setEstado(hab);*/

            if (temctrl.update(tem) == true) {
                List<Temporada> listcategorias = temctrl.getAll();
                request.setAttribute("listacategorias", listcategorias);
                String vista = "listarcategorias";
                request.setAttribute("vista", vista);
            } else {
                String vista = "erroredit";
                request.setAttribute("vista", vista);

            }
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
