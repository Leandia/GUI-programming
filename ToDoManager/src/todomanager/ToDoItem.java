package todomanager;

/**

 * @author Emil Björling
 */
public class ToDoItem {

/** a ToDoItem's title **/    
    private String title;
/** a ToDoItem's description **/    
    private String description;

/**
 * Constructor for a ToDoItem
 * @param titl the wanted title of a ToDoItem 
 * @param desc the wanted description a ToDoItem 
 */    
    
    public ToDoItem(String tit, String desc) {
        title = tit;
        description = desc;
    }

/**
 * Returns the title of a ToDoItem
 *
 * @return title a string containing title of a ToDoItem 
 */    
    public String getTitle() {
        return title;
    }

/**
 * Returns the description of a ToDoItem
 *
 * @return description a string containing the title of a ToDoItem 
 */          
    public String getDescription() {
        return description;
    }
}
