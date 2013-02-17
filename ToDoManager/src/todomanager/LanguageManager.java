/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todomanager;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Kristian
 * @author Vita
 */
public class LanguageManager {

    private final String fileName = "buttonlabel";
    private ArrayList<Locale> locales = new ArrayList();
    private ResourceBundle bundle;
    private String defaultLanguage = "English";
    private TODOManager manager;
    
    public LanguageManager(){
        locales.add(new Locale.Builder().setLanguage("en").setRegion("US").build());
        locales.add(new Locale.Builder().setLanguage("se").setRegion("se").build());
        initLanguage(defaultLanguage);
    }
    
    public void setTODOManager(TODOManager mngr){
        this.manager = mngr;
    }
    
    
    private void initLanguage(String language){
        switch(language){
            case "English":
                bundle = ResourceBundle.getBundle(fileName, locales.get(0));
                break;
            case "Swedish":
                bundle = ResourceBundle.getBundle(fileName, locales.get(1));
        }
    }
    
    public void UpdateLanguage(String language){
       switch(language){
            case "English":
                bundle = ResourceBundle.getBundle(fileName, locales.get(0));
                this.manager.setLanguage();
                break;
            case "Swedish":
                bundle = ResourceBundle.getBundle(fileName, locales.get(1));
                this.manager.setLanguage();
        } 
    }
    
    public ResourceBundle getBundle(){
        return this.bundle;
    }
    
    public ArrayList<Locale> getLocales(){
        return this.locales;
    }
}
