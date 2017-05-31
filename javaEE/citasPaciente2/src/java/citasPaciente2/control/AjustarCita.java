package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "AjustarCita", urlPatterns = {"/AjustarCita"})
public class AjustarCita extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        emf = Persistence.createEntityManagerFactory("citasPaciente2PU2");
        
        try (PrintWriter out = response.getWriter()) {
            
            CitaJpaController controlCita = new CitaJpaController(utx, emf);
            int idCita = Integer.parseInt(request.getParameter("idCita"));
            Cita modificar = controlCita.findCita(idCita);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjustarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"AjustarFechaCita?idCita="+ modificar.getIdcita() +"\" method=\"post\">");
            out.println("<h1>Fecha actual: "+modificar.getFecha()+"</h1>");
            out.println("<br>");
            out.println("<h1>Hora actual: "+modificar.getHora()+"</h1>");
            out.println("<input type=\"number\" min=7 max=22 placeholder=\"hora\" name=\"horaCita\"<br>");
            out.println("<input type=\"number\" min=0 max=59 placeholder=\"mins\" name=\"minutoCita\"><br>");
            
            out.println("<input type=\"submit\" value=\"Aceptar\"/>");
            
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
