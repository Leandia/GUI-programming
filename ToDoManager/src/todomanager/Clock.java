package todomanager;

import javax.swing.*;   
import java.awt.*;   
import java.util.Date;  

public class Clock extends JPanel implements Runnable{  
    
    int currentHour;  
    int currentMinute;  
    int currentSecond;  
    
    Font myFont=new Font("Tahoma",Font.BOLD+Font.ITALIC,19);       
    Color myColor=new Color(255,255,255);  
      
    //Font metrics that will use to store font informations width of a character  
    FontMetrics fm;  
      
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

    @Override
    public void run() {
        while(true)  
            {    
                repaint();  

        try  
            {  
                Thread.sleep(1000);  
            }  
        catch(Exception exception)  
           {  
           exception.printStackTrace();  
           }  
            }
    }
}  