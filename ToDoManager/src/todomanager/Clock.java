package todomanager;

import java.awt.*;  
import java.util.Date;
import javax.swing.*;  

public class Clock extends JPanel implements Runnable{  
    
    int currentHour;  
    int currentMinute;  
    int currentSecond; 
    String minuteCorrection = "";
    String secondCorrection = "";
    
    Font myFont=new Font("Tahoma",Font.BOLD,15);       
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
     
    if (currentMinute < 10){
        this.minuteCorrection = "0";
    }
    if (currentSecond < 10){
        this.secondCorrection = "0";
    }
    if (currentMinute >= 10){
        this.minuteCorrection = "";
    }
    if (currentSecond >= 10){
        this.secondCorrection = "";
    }
    
    //Set font   
    g.setFont(myFont);  
      
    //distance between number in digital clock  
    fm=g.getFontMetrics();  
    int hourXCoordinate=20;  
    int minuteXCoordinate=hourXCoordinate+(fm.getMaxAdvance()*2);  
    int secondXCoordinate=hourXCoordinate+(fm.getMaxAdvance()*4);  
      
    //Set color that will use to draw digital number  
    g.setColor(myColor);  
       
    g.drawString(Integer.toString(currentHour),hourXCoordinate,80);  
    g.drawString(":",(hourXCoordinate+minuteXCoordinate)/2,80);  
    g.drawString(minuteCorrection + Integer.toString(currentMinute),minuteXCoordinate,80);  
    g.drawString(":",(secondXCoordinate+minuteXCoordinate)/2,80);  
    g.drawString(secondCorrection + Integer.toString(currentSecond),secondXCoordinate,80);
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