package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import citasPaciente2.modelo.Consulta;
import citasPaciente2.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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


@WebServlet(name = "ConsultarCitasPaciente", urlPatterns = {"/ConsultarCitasPaciente"})
public class ConsultarCitasPaciente extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        emf = Persistence.createEntityManagerFactory("citasPaciente2PU2");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
        List<Cita> listaCitas = controlCita.findCitaEntities();
        
        
        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        Paciente p = controlPaciente.findPaciente(idPaciente);
        LocalDate hoy = LocalDate.now();
        Date hoyDate = new Date(hoy.getYear() - 1900, hoy.getMonthValue() - 1, hoy.getDayOfMonth());
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarCitas</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Paciente: "+p.getNombre()+"</h1>");
            out.println("<table aling='left' width='80%' border=1>");
            out.println(
                "<tr><td class='datos'>Fecha</td>"
                +"<td class='datos'>Hora</td>"
                +"<td>Modificar</td>"
                +"<td>Eliminar</td>"
                +"<td>Consultar</td>"
                + "</tr>"
                );
            
            for(Cita c : listaCitas){
                
                if(c.getPaciente().getIdpaciente() == idPaciente){
                    String fecha = c.getFecha().toString();
                    String hora = c.getHora().toString();
                    
                    System.out.println(hoyDate);
                    System.out.println(c.getFecha());
                    
                    if(hoyDate.compareTo(c.getFecha()) >= 0){
                       out.println("<tr><td class='datos'>"+fecha+"</td>"
                      +"<td class='datos'>"+hora+"</td>"
                      +"<td>Modificar cita</td>"
                      +"<td>Eliminar cita</td>"
                      +"<td><a href=\"ConsultarCita?idCita="+c.getIdcita()+"\">Consultar cita</a></td>"
                      +"</tr>"
                      ); 
                    }else{
                        out.println("<tr><td class='datos'>"+fecha+"</td>"
                      +"<td class='datos'>"+hora+"</td>"
                      +"<td><a href=\"AjustarCita?idCita="+c.getIdcita()+"\">Modificar cita</a></td>"
                      +"<td><a href=\"EliminarCita?idCita="+c.getIdcita()+"\">Eliminar cita</a></td>"
                      +"<td><a href=\"ConsultarCita?idCita="+c.getIdcita()+"\">Consultar cita</a></td>"
                      +"</tr>"
                      );
                    }
                }
            } //for
            out.println("</table>");
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
