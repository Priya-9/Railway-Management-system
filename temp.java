package rlwy;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class temp {
     public  void fun(String s) 
    {
        int roll = Integer.parseInt(s);
        
        try{
            Class.forName("java.sql.DriverManager");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/priya","root","1234");
            Statement stmt=con.createStatement();
            String str="select * from pnr_status where pnr = " + roll;
            ResultSet rs = stmt.executeQuery(str);
            
            while(rs.next())
            {
                int pn = rs.getInt("pnr");
                String from = rs.getString("frm");
                String o = rs.getString("too");
                int sea = rs.getInt("seat");
                String nam = rs.getString("name");
                String cla = rs.getString("clas");
                
                System.out.println(pn+" " + from);
            }
            
            /*try
            {
                Certificate cg = new Certificate(pn, from, to, sea, nam, cla);
                cg.generate("G:\\priya\\pnr.png");
            }
            catch(Exception ex)
            {   System.out.println("Err : " + ex); 
            }
                */
            }

        catch(Exception ex)
        {   System.out.println("Err : " + ex);          }
    
    
    }
}
