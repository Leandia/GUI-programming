package backend;

import java.util.GregorianCalendar;
import values.Priority;

/**
 *
 * @author Emil Björling
 */
public class ToDoItem {

    private final int number;
    /**
     * a ToDoItem's title *
     */
    private String title;
    /**
     * a ToDoItem's description *
     */
    private String description;
    private String category;
    private GregorianCalendar date;
    private Priority prio;
    
    /**
     * @deprecated Do not use if intended to work with database. Instead use 
     *              ToDoItem(int nb, String titl, String desc, String cat, Priority prio, GregorianCalendar cal)
     * @param titl Title
     * @param desc Description
     * @param cat Category
     * @param prio Priority
     * @param cal A Gregorian Calendar
     */
    public ToDoItem(String titl, String desc, String cat, Priority prio, GregorianCalendar cal) {
        this(0, titl, desc, cat, prio, cal);
    }

    /**
     * 
     * @param nb A number that uniquely identifies a todoItem.
     * @param titl Title
     * @param desc Description
     * @param cat Category
     * @param prio Priority
     * @param cal A Gregorian Calendar
     */
    public ToDoItem(int nb, String titl, String desc, String cat, Priority prio, GregorianCalendar cal) {
        this.title = titl;
        this.description = desc;
        this.category = cat;
        this.prio = prio;
        this.date = cal;
        this.number = nb;
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

    public int getNumber() {
        return number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setPrio(Priority prio) {
        this.prio = prio;
    }
    
    
}
