package citasPaciente2.control;

import citasPaciente2.modelo.Cita;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "ModificarCita", urlPatterns = {"/ModificarCita"})
public class ModificarCita extends HttpServlet {
    
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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarCita</title>");            
            out.println("</head>");
            out.println("<body>");
            
            int idCita = Integer.parseInt(request.getParameter("idCita"));
            int diaCita = Integer.parseInt(request.getParameter("diaCita"));
            int mesCita = AjustarFechaCita.mes;
            int anioCita = AjustarFechaCita.anio;
            int horaCita = AjustarFechaCita.hora;
            int minutoCita = AjustarFechaCita.minuto;
            
            Date fecha = new Date(anioCita - 1900, mesCita - 1, diaCita);
            Date hora = new Time(horaCita, minutoCita, 0);
            
            String query = "UPDATE MALDAD.CITA SET FECHA = " + fecha + " HORA = " + hora + " WHERE IDCITA = " + idCita;
            //UPDATE MALDAD.CITA SET PACIENTE = 30 WHERE IDCITA = 22;
            //EntityManager em = emf.createEntityManager();
            //List<Object[]> results = em.createNativeQuery(query).getResultList();
            //Query q = em.createQuery(query);
            //Query q = em.createNativeQuery(query);
            
            Cita c = controlCita.findCita(idCita);
            c.setFecha(fecha);
            c.setHora(hora);
            
            try{
                //controlCita.create(c);
                controlCita.edit(c);
                //response.sendRedirect("index.jsp");
                out.println("<h1> modificada correctamente </h1>");
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
