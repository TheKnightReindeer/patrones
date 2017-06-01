/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import citasPaciente2.modelo.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "AgregarDiagnostico", urlPatterns = {"/AgregarDiagnostico"})
public class AgregarDiagnostico extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //emf = Persistence.createEntityManagerFactory("citasPacientes2PU");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        ConsultaJpaController controlConsulta = new ConsultaJpaController(utx, emf);
        
        int idCita = Integer.parseInt(request.getParameter("idCita"));
        String diagnostico = request.getParameter("stringDiagnostico");
        Cita c = controlCita.findCita(idCita);
        
        
        
        Consulta con = new Consulta();
        con.setCita(c);
        con.setDiagnostico(diagnostico);
        c.setEstatus("Asistió a su cita :D");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarDiagnostico</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            try{
                //controlCita.create(c);
                controlCita.edit(c);
                //response.sendRedirect("index.jsp");
                out.println("<h1> estatus cita modificado correctamente </h1>");
            }catch(Exception e){
                out.println("<h1> error al modificar cita" + request.getContextPath() + " </h1>");
            }
            
            try{
                controlConsulta.create(con);
                out.println("<h1> consulta creada correctamente </h1>");
            }catch(Exception e){
                out.println("<h1> error al crear consulta" + request.getContextPath() + " </h1>");   
            }
            finally{
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
