package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import todomanager.ToDoItem;
import values.Priority;

/**
 * A class making a database as an xml document.
 *
 * @author Daniel
 */
public class Database {

    private ArrayList<ToDoItem> listOfItems = new ArrayList<>();
    private SAXBuilder builder = new SAXBuilder();
    private Document doc;
    private Element root;
    private List list;
    private String file;
    private String category = "";

    /**
     * Constructor using the default filename as name for the database.
     */
    public Database() {
        this("./database.xml");
    }

    /**
     * Constructor opening the database with the name and location file. If the
     * database does not exist a new one is created.
     *
     * @param file The name and location of the database to be opened.
     */
    public Database(String file) {
        this.file = file;
        FileInputStream fileInputStream = null;
        File f = new File(file);
        try {
            if (f.createNewFile()) {
                setupDB();
            }
        } catch (IOException ex) {
        }
        try {
            fileInputStream = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
        }
        try {
            this.doc = this.builder.build(fileInputStream);
        } catch (JDOMException | IOException ex) {
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.root = this.doc.getRootElement();

        try {
            fileInputStream.close();
        } catch (IOException ex) {
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method to add a ToDoItem to the database. The items added is also added
     * to the list supplied by getAllItems() or getItemsByCategory() if the
     * category is the same.
     *
     * @param item A ToDoItem to be added to the database.
     */
    public void addItem(ToDoItem item) {
        // Add item to the list of items known to the outside.
        if (item.getCategory().equals(this.category) || this.category.equals("")) {
            this.listOfItems.add(item);
        }

        // Add item to the root so it'll be written to file.
        deleteItem(item);
        Element addItem = new Element("_" + Integer.toString(item.getNumber()));
        addItem.setAttribute("title", item.getTitle());
        addItem.setAttribute("description", item.getDescription());
        addItem.setAttribute("category", item.getCategory());
        addItem.setAttribute("priority", item.getPrio().toString());
        GregorianCalendar cal = item.getDate();
        addItem.setAttribute("year", Integer.toString(cal.get(Calendar.YEAR)));
        addItem.setAttribute("month", Integer.toString(cal.get(Calendar.MONTH)));
        addItem.setAttribute("day", Integer.toString(cal.get(Calendar.DATE)));
        addItem.setAttribute("hour", Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));
        addItem.setAttribute("minute", Integer.toString(cal.get(Calendar.MINUTE)));
        this.root.addContent(addItem);
    }

    /**
     * Method to edit an item, the item to be edited is the supplied one with
     * updated data.
     *
     * @param item The ToDoItem to be edited.
     */
    public void editItem(ToDoItem item) {
        addItem(item);
    }

    /**
     * Method to delete an item from the database.
     *
     * @param item The item to be deleted from the database.
     */
    public void deleteItem(ToDoItem item) {
        this.root.removeChild("_" + Integer.toString(item.getNumber()));
    }

    /**
     * Method to save the database to the file supplied when the class was
     * created.
     */
    public void closeDB() {
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        try {
            out.output(this.doc, new FileOutputStream(this.file));
        } catch (IOException ex) {
        }
    }

    /**
     * Get all items in the database as an ArrayList of ToDoItems.
     *
     * @return An ArrayList of all the ToDoItems in the database.
     */
    public ArrayList<ToDoItem> getAllItems() {
        this.category = "";
        getItems("");
        return this.listOfItems;
    }

    public ArrayList<ToDoItem> getItemsByCategory(String category) {
        this.category = category;
        getItems(category);
        return this.listOfItems;
    }

    /**
     * Method to create and add items to the list shown to the world.
     * @param cat If category is null all items are added, otherwise only items 
     * whose category is the same as the supplied category.
     */
    private void getItems(String cat) {
        this.list = root.getChildren();
        this.listOfItems.clear();
        Iterator iter = this.list.iterator();
        while (iter.hasNext()) {
            Element e = (Element) iter.next();
            if (cat.equals("") || cat.equals(e.getAttributeValue("category"))) {
                int number = Integer.parseInt(e.getName().substring(1));
                Priority prio = null;
                switch (e.getAttributeValue("priority").toUpperCase()) {
                    case "LOW":
                        prio = Priority.LOW;
                        break;
                    case "MEDIUM":
                        prio = Priority.MEDIUM;
                        break;
                    case "HIGH":
                        prio = Priority.HIGH;
                        break;
                }
                int year = Integer.parseInt(e.getAttributeValue("year"));
                int month = Integer.parseInt(e.getAttributeValue("month"));
                int day = Integer.parseInt(e.getAttributeValue("day"));
                int hour = Integer.parseInt(e.getAttributeValue("hour"));
                int minute = Integer.parseInt(e.getAttributeValue("minute"));
                GregorianCalendar cal = new GregorianCalendar(year, month, day,
                        hour, minute);
                ToDoItem item = new ToDoItem(number, e.getAttributeValue("title"),
                        e.getAttributeValue("description"),
                        e.getAttributeValue("category"), prio, cal);
                this.listOfItems.add(item);
            }
        }
    }

    /**
     * Private class to setup the database if it doesn't exist.
     */
    private void setupDB() {
        Element tempRoot = new Element("todoManager");
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        try {
            out.output(new Document(tempRoot), new FileOutputStream(this.file));
        } catch (IOException ex) {
        }
    }
}
