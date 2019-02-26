package view;

import entity.Username;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.UsernameLogic;

/**
 *
 * @author khactoan9x
 */
public class CreatePlayerForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Player Information</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<form action=\"CreatePlayerForm\"  >");
            out.println("PlayerID:<br>");
            out.println("<input type=\"text\" name=\"id\" value=\"001\"><br>");
            out.println("First name:<br>");
            out.println("<input type=\"text\" name=\"firstName\" value=\"Mickey\"><br>");
            out.println("Last name:<br>");
            out.println("<input type=\"text\" name=\"lastName\" value=\"Mouse\"><br><br>"); 
              out.println("Username:<br>");
            out.println("<input type=\"text\" name=\"username\" value=\"Mouse\"><br><br>");       
            out.println("Email:<br>");
            out.println("<input type=\"text\" name=\"email\" value=\"abc@gmail.com\"><br><br>");  
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("<pre>");
            out.println("Submitted keys and values:");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</pre>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }

    
    private void submit(Map<String, String[]> values) {
       PlayerLogic logic = new PlayerLogic();
       logic.createEntity(values);
        System.out.println("okay");
        
       UsernameLogic usernameLogic  = new UsernameLogic();
       Username username = usernameLogic.createEntity(values);
       usernameLogic.add(username);
       
       
    }
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
       
   
        submit(request.getParameterMap());
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
