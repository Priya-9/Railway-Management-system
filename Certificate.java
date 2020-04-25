package rlwy;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Certificate 
{ 
  public int pnr, seat;
  public String frm, too, name, clas;

  public Certificate(int p, String f, String t, int s, String n, String c) 
  { pnr = p;
    frm = f;
    too = t;
    seat = s;
    name = n;
    clas = c;
  }
  
  public void generate(String trgt) throws Exception
  {
    
    //Refer the image file
    File f = new File("G:\\priya\\semproj\\image\\template.jpg");
    if(!f.exists())
    {       System.out.println("Exception ");       }

    BufferedImage bImg = ImageIO.read(f);
    BufferedImage frmm = ImageIO.read(new File("G:\\priya\\semproj\\image\\" + frm +".jpg"));
    BufferedImage tooo = ImageIO.read(new File("G:\\priya\\semproj\\image\\" + too +".jpg"));
    
    Graphics pen = bImg.getGraphics();
    String pn = Integer.toString(pnr);
    String sea = Integer.toString(seat);
    
    pen.setColor(Color.WHITE);
    pen.setFont(new Font("Malgun Gothic", Font.BOLD, 28));
    pen.drawString(pn, 278, 295);
    pen.drawString(frm, 324, 380);
    pen.drawString(too, 355, 430);
    pen.drawString(sea, 260, 578);
    pen.drawString(name, 185, 330);
    pen.drawString(clas, 170, 525);
    pen.drawString(frm + " - " + too + " Express ", 245, 475);
    pen.drawImage(frmm, 700, 250, null );
    pen.drawImage(tooo, 1100, 250, null );
    //pen.d
    //save back
    File tf = new File(trgt);
    ImageIO.write(bImg, "PNG", tf);
    
  }
  
  
}
