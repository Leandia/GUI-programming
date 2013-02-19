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
        try{
            System.out.println(TODOManager.savedSettings.getLanguage());
            return TODOManager.savedSettings.getLanguage();
        }
        catch(NullPointerException e){
            return this.defaultLanguage;
        }
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
    
    /**
     * This should set the language stored on file to the input parameter
     **/
    public void UpdateLanguage(String language){
        System.out.println(language);
    }
    
    public ResourceBundle getBundle(){
        return this.bundle;
    }
    
    public ArrayList<Locale> getLocales(){
        return this.locales;
    }
}
