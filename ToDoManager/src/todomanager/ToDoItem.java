package todomanager;

import java.util.GregorianCalendar;
import values.Priority;

/**
 *
 * @author Emil
 */
public class ToDoItem {

    private String title;
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

    public String getTitle() {
        return title;
    }

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
