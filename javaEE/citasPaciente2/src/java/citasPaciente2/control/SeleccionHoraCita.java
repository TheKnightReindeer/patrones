/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import citasPaciente2.modelo.Consulta;
import citasPaciente2.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author maldad
 */
@WebServlet(name = "SeleccionHoraCita", urlPatterns = {"/SeleccionHoraCita"})
public class SeleccionHoraCita extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //emf = Persistence.createEntityManagerFactory("citasPacientes2PU");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
        
        try (PrintWriter out = response.getWriter()) {
            
            int idPaciente = Integer.parseInt(request.getParameter("idPaciente")); //viene del select
            Paciente p = controlPaciente.findPaciente(idPaciente);
            Cita c = new Cita();
            c.setPaciente(p);
            Date fechaCita = new Date(AgregarCita.anio - 1900, AgregarCita.mes - 1, //Date empieza los meses desde 0 :/ y regresa los años -1900 atrás (¬_¬)
                    Integer.parseInt(request.getParameter("diaCita")));
            c.setFecha(fechaCita);
            
            Date horaCita = new Time(AgregarCita.hora, AgregarCita.minuto, 0);
            c.setHora(horaCita);
            c.setEstatus("pendiente");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SeleccionHoraCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registro de nueva cita: </h1>");
            out.println("<h3>Paciente: " + p.getNombre() + "</h3>");
            out.println("<h3>Fecha: " + c.getFecha() + "</h3>");
            out.println("<h3>Hora: " + c.getHora() + "</h3>");
            
            try{
                controlCita.create(c);    
                //response.sendRedirect("index.jsp");
                out.println("<h1> agregada correctamente </h1>");
            }catch(Exception e){
                out.println("<h1> error al agregar cita" + request.getContextPath() + " </h1>");
            }finally{
                out.println("<a href=\"index.jsp\">Index</a>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }
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
