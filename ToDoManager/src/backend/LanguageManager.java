package backend;


import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import todomanager.TODOManager;

/**
 * The LanguageManager provides methods for dynamically changing the language
 * of a application using properties-files for each individual language.
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
        initLanguage(getSelectedLanguage());
    }   
    
    /**
     * This function should retrieve correct string value from a file
     * @return 
     */
    private String getSelectedLanguage(){
        try{
            return TODOManager.savedSettings.getLanguage();
        }
        catch(NullPointerException e){
            return this.defaultLanguage;
        }
    }
    
    /**
     * Initializes the language to be used
     */
    private void initLanguage(String language){
        switch(language){
            case "English":
                bundle = ResourceBundle.getBundle(fileName, locales.get(0));
                break;
            case "Swedish":
                bundle = ResourceBundle.getBundle(fileName, locales.get(1));
                break;
        }
    }
    
    /**
     * This should set the language stored on file to the input parameter
     **/
    public void UpdateLanguage(String language){
        initLanguage(language);
        this.manager.changeLocale();
    }
    
    
    
    /**
     * 
     * @return The resourcebundle of the manager
     */
    public ResourceBundle getBundle(){
        return this.bundle;
    }   
    
    public void setTodoManager(TODOManager mngr){
        this.manager = mngr;
    }
}