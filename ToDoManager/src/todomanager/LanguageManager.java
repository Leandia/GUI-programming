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
    private final String[] languages = {"English","Swedish"};
    
    public LanguageManager(){
        locales.add(new Locale.Builder().setLanguage("en").setRegion("US").build());
        locales.add(new Locale.Builder().setLanguage("se").setRegion("se").build());
        initLanguage(getSelectedLanguage());
    }   
    
    /**
     * This function should retrieve correct string value from a file
     * @return 
     */
    private String getSelectedLanguage(){
        return "English";
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
    
    public String[] getLanguages(){
        return this.languages;
    }
    
    /**
     * This should set the language stored on file to the input parameter
     **/
    public void UpdateLanguage(String language){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public ResourceBundle getBundle(){
        return this.bundle;
    }
    
    public ArrayList<Locale> getLocales(){
        return this.locales;
    }
}
