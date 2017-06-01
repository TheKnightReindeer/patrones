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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@WebServlet(name = "ConsultarCita", urlPatterns = {"/ConsultarCita"})
public class ConsultarCita extends HttpServlet {

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
            
            int idCita = Integer.parseInt(request.getParameter("idCita"));
            int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
            Paciente p = controlPaciente.findPaciente(idPaciente);
            
            Cita c = controlCita.findCita(idCita);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"AgregarDiagnostico?idCita="+idCita+"\" method=\"post\">");
            out.println("<h1>Diagnóstico de la consulta</h1>");
            out.println("<h1>Paciente: "+p.getNombre()+"</h1>");
            out.println("<table aling='left' width='80%' border=1><tbody>");
            out.println("<tr>");
            out.println("<td>Fecha</td>");
            out.println("<td>Hora</td>");
            out.println("<td>Diagnóstico</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>"+c.getFecha()+"</td>");
            out.println("<td>"+c.getHora()+"</td>");
            
            //hacer una consulta a la tabla consultas y obtener el diagnostico
            String query = "SELECT * FROM MALDAD.CONSULTA WHERE CITA = " + c.getIdcita();
            EntityManager em = emf.createEntityManager();
            List<Object[]> listaConsultas = em.createNativeQuery(query).getResultList();
            
            String diagnostico = "";
            if(listaConsultas.size() > 0){
                diagnostico = listaConsultas.get(0)[2].toString();
            }
            System.out.println(c.getEstatus());
            //sorry for this
            if(c.getEstatus().length() > 10){ // > "pendiente", es decir, tiene la cadena "Asistió a su cita :D"
                //imprime su diagnostico
                out.println("<td>"+diagnostico+"</td>");
            }else{
                //registra su diagnostico
                out.println("<td><input type=\"text\" name=\"stringDiagnostico\" placeholder=\"escriba aqui el diagnóstico\"></td>");
                out.println("<td><input type=\"submit\" value=\"Aceptar\"/></td>");    
            }
            out.println("</tr>");
            out.println("</tbody></table>");
            out.println("<a href=\"index.jsp\">Index</a>");
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
