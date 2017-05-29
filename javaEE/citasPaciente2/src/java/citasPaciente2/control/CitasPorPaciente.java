package citasPaciente2.control;

import citasPaciente2.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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


@WebServlet(name = "CitasPorPaciente", urlPatterns = {"/CitasPorPaciente"})
public class CitasPorPaciente extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        emf = Persistence.createEntityManagerFactory("citasPaciente2PU2");
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
        List<Paciente> listaPacientes = controlPaciente.findPacienteEntities();
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CitasPorPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Seleccione Paciente</h1>");
            
            out.println("<form action=\"ConsultarCitasPaciente\" method=\"post\">");
            
            
            out.println("<select name=\"idPaciente\">");
            out.println("<option></option>");
            for(Paciente p : listaPacientes){
                String elPaciente = p.getIdpaciente() + " " + p.getNombre();
                out.println("<option value=\"" + p.getIdpaciente()
                        + "\" label=\""+ p.getNombre() + "\"> " +
                        elPaciente + "</option>");
            } //for
            out.println("</select>");
            
            out.println("<input type=\"submit\" value=\"Consultar citas\"/>");
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
