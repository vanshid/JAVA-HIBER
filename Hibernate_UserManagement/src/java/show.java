/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.hibernate.Session;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author DHAVAL PANCHAL
 */
@WebServlet(urlPatterns = {"/show"})
public class show extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>Servlet show</title>");            
            out.println("</head>");
            out.println("<body>");

		
	      try {
                 Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		                
		          SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();	      
                Transaction tx=null;
	    	  
	          tx = session.beginTransaction();
            String sql = "SELECT * FROM user_manager";
            SQLQuery query = session.createSQLQuery(sql);
         query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
         List data = query.list();
         out.print("<table border='1'>");
         out.print("<tr>");
         out.print("<th>ID</th>");
         out.print("<th>Name</th>");
         out.print("<th>Email</th>");
         out.print("<th>Gender</th>");
         out.print("<th>Contact Number</th>");         
         out.print("<th>Update</th>");         
         out.print("<th>Delete</th>");         
         out.print("</tr>");
         for(Object object : data) {
             Map row = (Map)object;
             String id=row.get("id").toString();
             String name=row.get("name").toString();
             String email=row.get("email").toString();
             String gender=row.get("gender").toString();
             String Contact_Number=row.get("Contact_Number").toString();
             String  pass=row.get("password").toString();
             out.print("<tr>");
            out.print("<td>");
            out.print(row.get("id"));
            out.print("</td>");
            out.print("<td>");
            out.print(row.get("name"));
            out.print("</td>");
            out.print("<td>");
            out.print(row.get("email"));
            out.print("</td>");
            out.print("<td>");
            out.print(row.get("gender"));
            out.print("</td>");
            out.print("<td>");
            out.print(row.get("Contact_Number"));
            out.print("</td>");
            out.print("<td><a href='up.jsp?id="+id+"&name="+name+"&email="+email+"&gender="+gender+"&Contact_Number="+Contact_Number+"'+>Update</a></td>");         
            out.print("<td><a href='del?id="+id+"'+>Delete</a></td>");         
            out.print("<tr>");            
            
         }
         tx.commit();
         session.close();
              }
              catch(Exception e){
                  out.print(e);
              }
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
