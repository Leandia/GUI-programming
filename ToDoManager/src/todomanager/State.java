package todomanager;

/**
 * State class that holds all settings for the interface
 * @author Kristian
 */
public class State {
    
    private String selectedLanguage;
    
    public State(){
        
    }
    
    public void setSelectedLanguage(String language){
        this.selectedLanguage = language;
    }
}
