package rlwy;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name = "pnrr", urlPatterns = {"/pnrr"})
public class pnrr extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pnrr</title>"); 
            out.println("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">"); 
            out.println("</head>");
            
            out.println("<body style=\"background-color: rgb(255,255,200);\">");
            out.println("<div id= \"icon\">\n" +"	<img src=\"G:\\priya\\semproj\\image\\1.gif\" alt=\"ICON\" >\n" +"</div>");
            out.println("<div id=\"top_strip\">PNR STATUS</div>");
            
            out.println("<div id = \"img\">\n" +"	<img src=\"G:\\priya\\semproj\\image\\4.jpg\" alt=\"ICON\" >\n" +"</div>");
            out.println("<div id = \"box\">");
            
            String str = request.getParameter("pnr_no");
        
            try
            {
                Class.forName("java.sql.DriverManager");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost/priya","root","1234");
                int h = Integer.parseInt(str);
                String st= "select * from pnr_status where pnr = "+str;
                PreparedStatement stmt=con.prepareStatement(st);
                ResultSet rs = stmt.executeQuery();
            
                int p = rs.getInt("pnr");
                String f = rs.getString("frm");
                String t = rs.getString("too");
                int s = rs.getInt("seat");
                String n = rs.getString("name");
                String c = rs.getString("clas");
            
                try
                {
                    Certificate cg = new Certificate(p, f, t, s, n, c);
                    cg.generate("G:\\priya\\image\\pnr.png");
                }
                catch(Exception ex)
                {       System.out.println("Err : " + ex);      }
            }   

            catch(Exception ex)
            {       System.out.println("Err : " + ex);      }
            
            out.println("<h4 >Your Ticket is successfully downloaded. </h4>\n" +"<h4 id=\"option\"><a href= \"first1.html\">HOME</a></h4>\n" +"</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
