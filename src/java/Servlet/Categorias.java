/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logic.CategoriaControler;
import Modelo.Categoria;
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
@WebServlet(name = "Categorias", urlPatterns = {"/Categorias"})
public class Categorias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Categoria cat;
    CategoriaControler catcntrl;

    public Categorias() {

        this.cat = new Categoria();
        this.catcntrl = new CategoriaControler();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Categorias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Categorias at " + request.getContextPath() + "</h1>");
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
            List<Categoria> listcategorias = catcntrl.getAll();
            request.setAttribute("listacategorias", listcategorias);
            String vista = "listarcategorias";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("add")) {
            String vista = "addcategoria";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("edit")) {
            int idcategoria = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idcat", request.getParameter("id"));
            cat = catcntrl.getById(idcategoria);
            request.setAttribute("categoria", cat);
            String vista = "editcategoria";
            request.setAttribute("vista", vista);

        } else if (action.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id");
            int id1 = Integer.parseInt(id);
            cat.setId(id1);
            catcntrl.delete(cat);
            List<Categoria> listcategorias = catcntrl.getAll();
            request.setAttribute("listacategorias", listcategorias);
            String vista = "listarcategorias";
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
            cat.setNombre(nombre);
            cat.setEstado(estado);
            catcntrl.save(cat);
            List<Categoria> listproductos = catcntrl.getAll();
            request.setAttribute("listaproductos", listproductos);
            String vista = "listarproductos";
            request.setAttribute("vista", vista);
            // listar
        } else if (action.equalsIgnoreCase("update")) {
            Integer id = Integer.parseInt(request.getParameter("txtid"));
            String nombre = request.getParameter("txtnombre");
            String h = request.getParameter("txtestado");
            int hab = Integer.parseInt(h);

            cat.setId(id);
            cat.setNombre(nombre);
            cat.setEstado(hab);

            if (catcntrl.update(cat) == true) {
                List<Categoria> listcategorias = catcntrl.getAll();
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

}
