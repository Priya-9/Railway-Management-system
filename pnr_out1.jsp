<!DOCTYPE html>
<%@ page import="rlwy.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<html>
<head>
<title>pnr_status</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color: rgb(255,255,200);">
    
<div id= "icon">
	<img src="G:\priya\semproj\image\1.gif" alt="ICON" >
</div>
<div id="top_strip">PNR STATUS</div>
<div id = "img">
	<img src="G:\priya\semproj\image\4.jpg" alt="ICON" >
</div>

<div id = "box">
    <%  String str = request.getParameter("pnr_no");
        
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
         
    %>
        
<h4 >Your Ticket is successfully downloaded. </h4>
<h4 id="option"><a href= "first1.html">HOME</a></h4>
</div>

</body>
</html>