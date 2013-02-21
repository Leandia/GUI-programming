package backend;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import todomanager.TODOManager;

/**
 * State class that holds all settings for the interface
 * @author Kristian
 */
public class State {
    
    private String selectedLanguage;
    private Properties pro = new Properties();
    private int x;
    private int y;
    
    public State(){
    }
    
    public String getLanguage(){
        return this.selectedLanguage;
    }
    
    public void setSelectedLanguage(String language){
        this.selectedLanguage = language;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Saves each parameter of a state, which represents different settings
     * for the application, into a properties file
     */
    public void saveState(){
        try{
            
            pro.setProperty("lan", selectedLanguage);
            pro.setProperty("x",Integer.toString(x));
            pro.setProperty("y",Integer.toString(y));           
            System.out.println(Integer.toString(y));
            try{
                pro.store(new FileOutputStream("config.properties"),null);
            }
            catch(FileNotFoundException e){
                
                pro.store(new FileOutputStream(new File("config.properties")), null);
            }
        }
        catch(IOException e){
        }
    }
    
    /**
     * Loads each parameter of a state, which represents different settings
     * for the application, from a properties files and save them into
     * the state class variables
     */
    public void loadState(){
        try {
               try{
                   //load a properties file
                    pro.load(new FileInputStream("config.properties"));
                    
                    //get the property value and print it out
                    this.selectedLanguage = pro.getProperty("lan");
                    try{
                        this.y = Integer.parseInt(pro.getProperty("y"));
                        this.x = Integer.parseInt(pro.getProperty("x"));
                    }
                    catch(NumberFormatException e){
                        this.x = 0;
                        this.y = 0;
                    }
                    
                    
                }
                catch(FileNotFoundException e){
                    this.selectedLanguage = "";
                }
               
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
    
    public int getWidth(int def){
        if(this.x > 0){
            return this.x;
        }
        else{
            return def;
        }
    }
    
    public int getHeight(int def){
        if(this.y > 0){
            return this.y;
        }
        else{
            return def;
        }
    }
}
