package todomanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * State class that holds all settings for the interface
 * @author Kristian
 */
public class State {
    
    private String selectedLanguage;
    private Properties pro = new Properties();
    
    
    public State(){
    }
    
    public String getLanguage(){
        return this.selectedLanguage;
    }
    
    public void setSelectedLanguage(String language){
        this.selectedLanguage = language;
    }
    
    /**
     * Saves each parameter of a state, which represents different settings
     * for the application, into a properties file
     */
    public void saveState(){
        try{
            pro.setProperty("lan", selectedLanguage);
            try{
                pro.store(new FileOutputStream("config.properties"),"lan");
            }
            catch(FileNotFoundException e){
                
                pro.store(new FileOutputStream(new File("config.properties")), "lan");
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
                    
                }
                catch(FileNotFoundException e){
                    this.selectedLanguage = "";
                }
               
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
    }
}
