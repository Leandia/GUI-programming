package todomanager;

import java.util.GregorianCalendar;
import values.Priority;

/**

 * @author Emil Björling
 */
public class ToDoItem {

/** a ToDoItem's title **/    
    private String title;
/** a ToDoItem's description **/    
    private String description;
    private String category;
    private GregorianCalendar date;
    private Priority prio;

    public ToDoItem(String titl, String desc, String cat, Priority prio, GregorianCalendar cal) {
        this.title = titl;
        this.description = desc;
        this.category = cat;
        this.prio = prio;
        this.date = cal;
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

    public String getCategory() {
        return category;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Priority getPrio() {
        return prio;
    }
}
