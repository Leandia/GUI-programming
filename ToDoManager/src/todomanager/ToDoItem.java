package todomanager;

/**
 *
 * @author Emil
 */
public class ToDoItem {
    
    private String title;
    private String description;
    
    public ToDoItem(String titl, String desc){
        title = titl;
        description = desc;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
}

