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
    private final String defaultLanguage = "Swedish";
    
    public LanguageManager(){
        locales.add(new Locale.Builder().setLanguage("en").setRegion("US").build());
        locales.add(new Locale.Builder().setLanguage("se").setRegion("se").build());
        setLanguage(defaultLanguage);
    }
    
    
    private void setLanguage(String language){
        switch(language){
            case "English":
                bundle = ResourceBundle.getBundle(fileName, locales.get(0));
                break;
            case "Swedish":
                bundle = ResourceBundle.getBundle(fileName, locales.get(1));
        }
    }
    
    public ResourceBundle getBundle(){
        return this.bundle;
    }
    
    public ArrayList<Locale> getLocales(){
        return this.locales;
    }
}
