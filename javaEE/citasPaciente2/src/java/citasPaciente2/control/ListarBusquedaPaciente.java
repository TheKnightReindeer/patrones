/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citasPaciente2.control;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet(name = "ListarBusquedaPaciente", urlPatterns = {"/ListarBusquedaPaciente"})
public class ListarBusquedaPaciente extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    @Resource
    private UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        emf = Persistence.createEntityManagerFactory("citasPaciente2PU2");
        
        try (PrintWriter out = response.getWriter()) {
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarBusquedaPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String busqueda = request.getParameter("busqueda");
            String query = 
            "SELECT * FROM MALDAD.PACIENTE WHERE NOMBRE LIKE '%" + busqueda + "%'";
            //SELECT * FROM MALDAD.PACIENTE WHERE NOMBRE LIKE '%Agus%';

            EntityManager em = emf.createEntityManager();
            List<Object[]> listaPacientes = em.createNativeQuery(query).getResultList();
            
            System.out.println(listaPacientes.get(0)[0]);
            System.out.println(listaPacientes.get(0)[1]);
            System.out.println(listaPacientes.get(0)[2]);
            System.out.println(listaPacientes.get(0)[3]);
            System.out.println(listaPacientes.get(0)[4]);
            
            out.println("<table aling='left' width='60%' border=1>");
            out.println("<tr><td class='datos'>ID</td>"
                +"<td class='datos'>Nombre</td>"
                +"<td>Enlaces</td></tr>"
                );
            for(int i = 0; i < listaPacientes.size(); i++){
                out.println(
                    "<tr>"
                            + "<td>"+listaPacientes.get(i)[0]+"</td>"
                            + "<td>"+listaPacientes.get(i)[1]+"</td>"
                            + "<td><a href=\"ConsultarCitasPaciente?idPaciente="+listaPacientes.get(i)[0]+"\">Citas</a></td>"
                            + "</tr>"
                );
            }
            out.println("</table>");
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
