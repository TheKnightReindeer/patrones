/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import citasPaciente2.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

@WebServlet(name = "AgregarCita", urlPatterns = {"/AgregarCita"})
public class AgregarCita extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    public String mesAString(int m){
        switch(m){
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
        }
        return "";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //emf = Persistence.createEntityManagerFactory("citasPacientes2PU");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
      
        try (PrintWriter out = response.getWriter()) {
            
            //SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm a");
            //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/M/yyyy");
            
            //String hora = request.getParameter("horaCita");
            //Date horaCita = new Date();
            
            /*
            String fecha = request.getParameter("fechaCita");
            Date fechaCita = new Date();
            try{
                fechaCita = formatoFecha.parse(fecha);
                horaCita = formatoFecha.parse(hora);
            }catch(ParseException pe){
            }
            */
            int idPaciente = Integer.parseInt(request.getParameter("idPaciente")); //viene del select
            Cita c = new Cita();
            Paciente p = controlPaciente.findPaciente(idPaciente);
            //c.setPaciente(paciente);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>AgregarCita </h1>");
            
            out.println("<h1>Nueva cita para paciente: "+ p.getNombre() +"</h1>");
            //imprimir el mes actual
            LocalDate hoy = LocalDate.of(2016, 2, 1);
            int numeroMes = hoy.getMonthValue();
            String mesActual = mesAString(numeroMes);
            out.println("<h3>" + mesActual + "</h3>");
            
            out.println("<table><tbody>"+
                    "<thead>"
                    + "<tr>"
                    + "<td>D</td>"
                    + "<td>L</td>"
                    + "<td>M</td>"
                    + "<td>M</td>"
                    + "<td>J</td>"
                    + "<td>V</td>"
                    + "<td>S</td>"
                    + "</tr>"
                    + "</thead>");
            out.println("<tr>");
            for(int i = hoy.getDayOfMonth(); i <= hoy.lengthOfMonth(); i++){
                //for(int j = 0; j < 7; j++){
                    out.println("<td>" + i + "</td>");
                //}
            }
            out.println("</tr>");
            out.println("</tbody></table>");
            
            out.println("Dia:");
            out.println("<select>");
            for(int i = hoy.getDayOfMonth(); i <= hoy.lengthOfMonth(); i++){
                out.println("<option>" + i + "</option>");
            }
            out.println("</select>");
            //out.println("CIta: " + c.getHora() + "<br>");
            //out.println("Fecha: " + c.getFecha() + "<br>");
            
            
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
