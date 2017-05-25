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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    static int anio, mes;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //emf = Persistence.createEntityManagerFactory("citasPacientes2PU");
        CitaJpaController controlCita = new CitaJpaController(utx, emf);
        PacienteJpaController controlPaciente = new PacienteJpaController(utx, emf);
      
        try (PrintWriter out = response.getWriter()) {
            
            int idPaciente = Integer.parseInt(request.getParameter("idPaciente")); //viene del select
            Paciente p = controlPaciente.findPaciente(idPaciente);
            
            //creando lista de citas del paciente actual
            List<Cita> listaTodasCitas = controlCita.findCitaEntities();
            ArrayList<Integer> listaCitasPacienteX = new ArrayList<Integer>();
            
            //agregando citas a la lista del paciente
            for(Cita c : listaTodasCitas){
                Date d = c.getFecha();
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                int diaMesCita = cal.get(Calendar.DAY_OF_MONTH);
                
                if(c.getPaciente().getIdpaciente() == idPaciente){
                    listaCitasPacienteX.add(diaMesCita);
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarCita</title>");            
            out.println("<link rel=\"stylesheet\" href=\"style.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>AgregarCita </h1>");
            
            out.println("<h1>Nueva cita para paciente: "+ p.getNombre() +"</h1>");
            //imprimir el mes actual
            LocalDate hoy = LocalDate.now();
            int numeroMes = hoy.getMonthValue();
            mes = numeroMes;
            anio = hoy.getYear();
            String mesActual = mesAString(numeroMes);
            out.println("<h2>Los dias coloreados indican que hay una cita agendada</h2>");
            out.println("<h3>" + mesActual + "</h3>");
            out.println("<table><tbody>"+
                    "<thead>"
                    + "<tr>"
                    + "<td>L</td>"
                    + "<td>M</td>"
                    + "<td>M</td>"
                    + "<td>J</td>"
                    + "<td>V</td>"
                    + "<td>S</td>"
                    + "<td>D</td>"
                    + "</tr>"
                    + "</thead>");
            out.println("<tr>");
            int numDia = hoy.getDayOfWeek().getValue();
            int numDiaMes = hoy.getDayOfMonth();
            int diasMes = hoy.lengthOfMonth();
            int dow = 1; //day of week 1: lunes, 7: domingo
            
            for(int i = numDiaMes; i <= diasMes; i++){
                if(numDia == dow){
                    if(listaCitasPacienteX.contains(i)){
                        out.println("<td class=\"hayCitaEnEsteDia\"><a href=\"SeleccionHoraCita?diaCita="
                            + i + "&idPaciente="+idPaciente+"\">"+ i +"</a></td>");
                    }else{
                        out.println("<td><a href=\"SeleccionHoraCita?diaCita="
                            + i + "&idPaciente="+idPaciente+"\">"+ i +"</a></td>");
                    }
                    dow++;
                    numDia++;
                    if(dow == 8){
                        dow = 1;
                        numDia = 1;
                        out.println("<tr></tr>");
                    }
                }else{
                    out.println("<td>"+ "    " +"</td>");
                    dow++;
                    i = numDiaMes - 1; //sorry for this magic number :/
                }
            }
            out.println("</tr>");
            out.println("</tbody></table>");
            
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
