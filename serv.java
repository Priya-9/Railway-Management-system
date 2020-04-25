import java.io.FileWriter; 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "serv", urlPatterns = {"/serv"})
public class serv extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    public serv()
    {   super();    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {   response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String name=request.getParameter("name");
	String frm=request.getParameter("frm");
	String too=request.getParameter("too");
	String clas=request.getParameter("clas");
	String pnr=request.getParameter("pnr");
        
	String str = request.getParameter("seats");
	int seats = Integer.parseInt(str);
        int pn = Integer.parseInt(pnr);
        int sea = 5-seats;
        
    try
    {
      Certificate cg = new Certificate(pn, frm, too, seats, name, clas);
      cg.generate("Desktop\\certi"+ pn+ ".png");
    }
    catch(Exception ex)
    {
      System.out.println("Err : " + ex);
    }
	
    try{
        Class.forName("java.sql.DriverManager");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/priya?autoReconnet=true&useSSL=false","root","1234");
        Statement stmt=con.createStatement();
        Statement stm=con.createStatement();
        String stf="insert into pnr_status values("+ pn + "," + frm + "," + too +"," +seats + "," + name + "," + clas +")";
        stmt.executeUpdate(stf);
        String stt="update train set" + sea + "where from_stn=' " + frm + " ' "+" and to_stn= " + "' " + too + "';";
        stm.executeUpdate(stt);
       }
    catch(Exception e)
    {
        System.out.print("excpr " + e.getMessage());
    }
 }      
}