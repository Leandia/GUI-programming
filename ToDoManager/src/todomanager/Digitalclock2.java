/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todomanager;
import javax.swing.*;   
    import java.awt.*;   
    import java.util.Date;  
    public class Digitalclock2 extends JPanel  
    {  
    //JFrame frame;  
      
    int currentHour;  
    int currentMinute;  
    int currentSecond;  
    
    Font myFont=new Font("Tahoma",Font.BOLD+Font.ITALIC,19);       
    Color myColor=new Color(255,255,255);  
      
    //Font metrics that will use to store font informations width of a character  
    FontMetrics fm;  
    //private final JFrame frame;
      
    public Digitalclock2()  
    {  
    
        //frame=new JFrame();    
    //frame.add(this);  
      
    //Set default close operation for JFrame;
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    //frame.setSize(150, 150); 
    //locate at center  
    //frame.setLocationRelativeTo(null);   
    //frame.setVisible(true);  
    
    /* 
     *Loop for panel show current time 
     */
    //while(true)  
    //{    
    //repaint();  
      
     //try  
     //{  
      //Thread.sleep(100000000);  
     //}  
     //catch(Exception exception)  
     //{  
      //exception.printStackTrace();  
     //}  
    //}  
    }  
      
    public void paint(Graphics g)  
    {  
    super.paint(g);  
      
    /* 
     *store information about current hour, minute and second. 
     */  
    Date myDate=new Date();  
      
    currentHour=myDate.getHours();  
    currentMinute=myDate.getMinutes();  
    currentSecond=myDate.getSeconds();  
      
    //Set font   
    g.setFont(myFont);  
      
    //distance between number in digital clock  
    fm=g.getFontMetrics();  
    int hourXCoordinate=20;  
    int minuteXCoordinate=hourXCoordinate+(fm.getMaxAdvance()*2);  
    int secondXCoordinate=hourXCoordinate+(fm.getMaxAdvance()*4);  
      
    //Set color that will use to draw digital number  
    g.setColor(myColor);  
       
    g.drawString(Integer.toString(currentHour),hourXCoordinate,20);  
    g.drawString(":",(hourXCoordinate+minuteXCoordinate)/2,20);  
    g.drawString(Integer.toString(currentMinute),minuteXCoordinate,20);  
    g.drawString(":",(secondXCoordinate+minuteXCoordinate)/2,20);  
    g.drawString(Integer.toString(currentSecond),secondXCoordinate,20);  
    }  
      
   // public static void main(String[]args)  
    //{  
    //Digitalclock2 sdc=new Digitalclock2();  
    //}  
    }  