/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logic.ProductoControler;
import Logic.ReservaControler;
import Logic.TemporadaControler;
import Logic.UsuarioControler;
import Modelo.ListaProducto;
import Modelo.Producto;
import Modelo.Reserva;
import Modelo.Usuario;
import ModeloDaoImpl.ProductoDaoImpl;
import ModeloDaoImpl.ReservaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.CORBA.Current;

/**
 *
 * @author Alejandro
 */
@WebServlet(name = "ControladorReserva", urlPatterns = {"/ControladorReserva"})
public class ControladorReserva extends HttpServlet {

    /*String listar="/vistas/listar.jsp";
      String add="/vistas/addReserva.jsp";
        String edit="/vistas/editReserva.jsp";
  
          Reserva res= new Reserva();
    //UsuarioDaoImpl dao=new UsuarioDaoImpl();
     ReservaDaoImpl dao=new ReservaDaoImpl();
     ProductoDaoImpl pdao=new ProductoDaoImpl();
     List<Producto> productos= new ArrayList<>();
     Producto p=new Producto();
     List<ListaProducto> listaproducto=new ArrayList<>();
     */
    int item;
    double totalPagar = 0.0;
    //int cantidad=1; // ver si no interfiere en el proceso declararla aca
    ProductoControler ctrlproducto;
    Producto pr;
    List<ListaProducto> listaproductos = new ArrayList<>();
    ReservaControler rctrl;
    Reserva resChecked = new Reserva();
    UsuarioControler uctrl;

    // ListaProducto listpro;
    public ControladorReserva() {
        this.ctrlproducto = new ProductoControler();
        pr = new Producto();
        this.rctrl = new ReservaControler();
        this.uctrl = new UsuarioControler();
        //listpro=new ListaProducto();

    }

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
        
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("nueva")) {
            
            List<Producto> listproductos = ctrlproducto.getAllDisponibles();
            request.setAttribute("productos", listproductos);
            String vista = "reserva";
            request.setAttribute("vista", vista);
        } else if (action.equalsIgnoreCase("listar")) {
            //traer todas las reservas
            List<Reserva> listareservas = rctrl.getAll();
            request.setAttribute("reservas", listareservas);
            String vista = "listarReservas";
            request.setAttribute("vista", vista);
        }//reservausuario lista reservas del usuario
        else if (action.equalsIgnoreCase("reservausuario")) {
            //traer todas las reservas del usuario
            int idusuarioreserva = (int) request.getSession().getAttribute("idusuario");
            List<Reserva> listareservas = rctrl.getAllbyID(idusuarioreserva);
            request.setAttribute("reservas", listareservas);
            String vista = "listarReservasUsuario";
            request.setAttribute("vista", vista);
        } else if (action.equalsIgnoreCase("Reservar")) {
            Integer idp = Integer.parseInt(request.getParameter("id"));
            int cantidad = 1;
            pr = ctrlproducto.list(idp);
            item = item + 1;
            ListaProducto listpro = new ListaProducto(); //creo objeto listproducto que se va a almacenar en una ArrayList<ListarProducto>
            listpro.setItem(item);
            listpro.setProducto_id(pr.getId());
            listpro.setNombre(pr.getNombre());
            listpro.setDescripcion(pr.getDescripcion());
            listpro.setPrecio(pr.getPrecio());
            listpro.setCantidad(cantidad);
            listpro.setSubtotal(cantidad * pr.getPrecio());
            
            listaproductos.add(listpro);
            request.setAttribute("contador", listaproductos.size());
            request.setAttribute("carrito", listaproductos);
            for (int i = 0; i < listaproductos.size(); i++) {
                totalPagar = totalPagar + listaproductos.get(i).getSubtotal();
                
            }
            request.setAttribute("totalPagar", totalPagar);
            String vista = "carrito";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("AgregarReserva")) {
            int pos = 0;
            int cantidad = 1;
            Integer idp = Integer.parseInt(request.getParameter("id"));
            pr = ctrlproducto.list(idp);
            if (listaproductos.size() > 0) {
                for (int i = 0; i < listaproductos.size(); i++) {
                    if (idp == listaproductos.get(i).getProducto_id()) {
                        pos = i;
                    }
                }
                if (idp == listaproductos.get(pos).getProducto_id()) {
                    cantidad = listaproductos.get(pos).getCantidad() + cantidad;
                    double subtotal = listaproductos.get(pos).getPrecio() * cantidad;
                    listaproductos.get(pos).setCantidad(cantidad);
                    listaproductos.get(pos).setSubtotal(subtotal);
                } else {
                    item = item + 1;
                    //creo objeto listproducto que se va a almacenar en una ArrayList<ListarProducto>
                    ListaProducto listpro = new ListaProducto();
                    listpro.setItem(item);
                    listpro.setProducto_id(pr.getId());
                    listpro.setNombre(pr.getNombre());
                    listpro.setDescripcion(pr.getDescripcion());
                    listpro.setPrecio(pr.getPrecio());
                    listpro.setCantidad(cantidad);
                    listpro.setSubtotal(cantidad * pr.getPrecio());
                    listaproductos.add(listpro);
                    
                }
                
            } else {
                item = item + 1;
                //creo objeto listproducto que se va a almacenar en una ArrayList<ListarProducto>
                ListaProducto listpro = new ListaProducto();
                listpro.setItem(item);
                listpro.setProducto_id(pr.getId());
                listpro.setNombre(pr.getNombre());
                listpro.setDescripcion(pr.getDescripcion());
                listpro.setPrecio(pr.getPrecio());
                listpro.setCantidad(cantidad);
                listpro.setSubtotal(cantidad * pr.getPrecio());
                listaproductos.add(listpro);
            }
            
            request.setAttribute("contador", listaproductos.size());
            ProductoControler ctrlproducto = new ProductoControler();
            List<Producto> listproductos = ctrlproducto.getAll();
            request.setAttribute("productos", listproductos);
            String vista = "reserva";
            request.setAttribute("vista", vista);
            // request.getRequestDispatcher("ControladorReserva?accion=reserva").forward(request, response);

        } else if (action.equalsIgnoreCase("reserva")) {
            ProductoControler ctrlproducto = new ProductoControler();
            List<Producto> listproductos = ctrlproducto.getAll();
            request.setAttribute("productos", listproductos);
            String vista = "reserva";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("carrito")) {
            totalPagar = 0.0;
            request.setAttribute("carrito", listaproductos);
            for (int i = 0; i < listaproductos.size(); i++) {
                totalPagar = totalPagar + listaproductos.get(i).getSubtotal();
                
            }
            request.setAttribute("totalPagar", totalPagar);
            String vista = "carrito";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("RevisarReserva")) {
            //tomo id reserva y chequeo que la cantidad pedida pueda descontarse de el stock de todos los productos.
            //obterner reserva y detalle metodo chequar reservar.
            int idreserva;
            idreserva = Integer.parseInt(request.getParameter("id"));
            resChecked = rctrl.chequearReserva(idreserva);
            request.setAttribute("resChecked", resChecked);
            String vista = "revisar";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("RevisarReservaUsuario")) {
            //tomo id reserva y chequeo que la cantidad pedida pueda descontarse de el stock de todos los productos.
            //obterner reserva y detalle metodo chequar reservar.
            int idreserva;
            idreserva = Integer.parseInt(request.getParameter("id"));
            resChecked = rctrl.chequearReserva(idreserva);
            request.setAttribute("resChecked", resChecked);
            String vista = "DetalleRUsuario";
            request.setAttribute("vista", vista);
            
        }else if (action.equalsIgnoreCase("EditarReserva")) {
            String idresedit = request.getParameter("id");
            List<Reserva> listareservas;
            listareservas = rctrl.getAll();
            Reserva reditar = listareservas.get(Integer.parseInt(idresedit));
            request.setAttribute("reditar", reditar);
            String vista = "editarReserva";
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
        if (action.equalsIgnoreCase("Delete")) {
            int idproducto = Integer.parseInt(request.getParameter("idp"));
            for (int i = 0; i < listaproductos.size(); i++) {
                if (listaproductos.get(i).getProducto_id() == idproducto) {
                    listaproductos.remove(i);
                }
                
            }
            String vista = "carrito";
            request.setAttribute("vista", vista);
        } else if (action.equalsIgnoreCase("ActualizarCantidad")) {
            
            int idproducto = Integer.parseInt(request.getParameter("idp"));
            int cant = Integer.parseInt(request.getParameter("Cantidad"));
            for (int i = 0; i < listaproductos.size(); i++) {
                if (listaproductos.get(i).getProducto_id() == idproducto) {
                    listaproductos.get(i).setCantidad(cant);
                    double st = listaproductos.get(i).getPrecio() * cant;
                    listaproductos.get(i).setSubtotal(st);
                }
            }
            
        } else if (action.equalsIgnoreCase("Generar")) {
            
            TemporadaControler tctrl = new TemporadaControler();
            UsuarioControler uctrl = new UsuarioControler();
            String fdesde = request.getParameter("txtfdesde");
            int dniusu = Integer.parseInt(request.getParameter("dniusuario")); // todos ingresar su dni para reservar y validar usuario.
            int idusu = uctrl.getidbyDni(dniusu);
            Timestamp fecha_desde = Timestamp.valueOf(fdesde);
            int idtemporada = tctrl.getIDByFecha(fecha_desde);
            // valido que el usuario exista y la temporada coincida

            if (idusu != 0 & idtemporada != 0) {
                Reserva r = new Reserva();
                //temporada id desde fecha seleccionada
                r.setTemporada_id(idtemporada);
                //obtener id cliente para reserva, dato ingresado por admin
                r.setUsuario_id(idusu);
                //precio total reserva
                r.setPrecio(totalPagar);
                //fecha reserva comienzo
                r.setFecha_desde(fecha_desde);
                //fecha que se hizo la reserva
                Date date = new Date();
                long time = date.getTime();
                
                r.setFecha_reserva(new Timestamp(time));//guarda fecha y hora del momento en que se reserva
                //cantidad de dias reserva
                r.setCantidad_dias(Integer.parseInt(request.getParameter("cantidaddias")));
                //lista productos detalle
                r.setDetalle(listaproductos);
                
                int valor = rctrl.add(r);
                if (valor != 0) {
                    List<Producto> listproductos = ctrlproducto.getAll();
                    request.setAttribute("productos", listproductos);
                    String vista = "reserva";
                    request.setAttribute("vista", vista);
                } else {
                    String vista = "error";
                    request.setAttribute("vista", vista);
                }
            } else {
                String vista = "error";
                String mensaje = "DNI incorrecto o Fecha fuera de Temporada";
                request.setAttribute("mensaje", mensaje);
                request.setAttribute("vista", vista);
                
            }

            //que hacer despues generar reserva? o
            // DEBE MOSTRAR DETALLE EN USUARIO , y LISTA EN ADMIN, Indicar que debe ser aprobada la reserva.
        } else if (action.equalsIgnoreCase("Validar")) {
            //aprobar reserva , descontar stock y avisar al usuario cambiando estado reserva /correo con detalle
            Reserva rfinalizada = resChecked;
            rfinalizada.setEstadodetalle(request.getParameter("comentarios"));
            rctrl.aprobarReserva(rfinalizada);
            List<Reserva> listareservas = rctrl.getAll();
            request.setAttribute("reservas", listareservas);
            String vista = "listarReservas";
            request.setAttribute("vista", vista);
            
        } else if (action.equalsIgnoreCase("Cancelar")) {
            //aprobar reserva , descontar stock y avisar al usuario cambiando estado reserva /correo con detalle
            int rol = (int) request.getSession().getAttribute("rol");
            //obtengo rol usuario y diferencio funcionamiento de admin con usuario con un if
            
            Reserva rfinalizada = resChecked;
            rfinalizada.setEstadodetalle(request.getParameter("comentarios"));
            rctrl.cancelarReserva(rfinalizada);
            if (rol == 1) {
                List<Reserva> listareservas = rctrl.getAll();
                request.setAttribute("reservas", listareservas);
                String vista = "listarReservas";
                request.setAttribute("vista", vista);
            } else if (rol == 2) {
                List<Reserva> listareservas = rctrl.getAllbyID(rfinalizada.getUsuario_id());
                request.setAttribute("reservas", listareservas);
                String vista = "listarReservasUsuario";
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
