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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import todomanager.Category;
import todomanager.ToDoItem;
import values.Priority;

/**
 * A class making a database as an xml document.
 *
 * @author Daniel
 */
public class Database {

    private SAXBuilder builder = new SAXBuilder();
    private Document doc;
    private Element root;
    private Element data;
    private Element category;
    private String file;
    private XMLOutputter out;
    private FileOutputStream fileOutputStream;

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
        this.data = this.root.getChild("data");
        this.category = this.root.getChild("category");

        try {
            fileInputStream.close();
        } catch (IOException ex) {
            //Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        out = new XMLOutputter(Format.getPrettyFormat());
        try {
            fileOutputStream = new FileOutputStream(this.file);
        } catch (FileNotFoundException ex) {
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
        this.data.addContent(addItem);
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
        this.data.removeChild("_" + Integer.toString(item.getNumber()));
    }

    private void writeDB() {
        try {
            out.output(this.doc, fileOutputStream);
        } catch (IOException ex) {
        }
    }
    
    /**
     * Method to save the database to the file supplied when the class was
     * created.
     */
    public void closeDB() {
        try {
            this.fileOutputStream.close();
        } catch (IOException ex) {
        }
    }

    /**
     * Get all items in the database as an ArrayList of ToDoItems.
     *
     * @return An ArrayList of all the ToDoItems in the database.
     */
    public ArrayList<ToDoItem> getAllItems() {
        return getItems("");
    }

    public ArrayList<ToDoItem> getItemsByCategory(String category) {
        return getItems(category);
    }

    /**
     * Method to create and add items to the list shown to the world.
     * @param cat If category is null all items are added, otherwise only items 
     * whose category is the same as the supplied category.
     */
    private ArrayList<ToDoItem> getItems(String cat) {
        List list = data.getChildren();
        ArrayList<ToDoItem> listOfItems = new ArrayList<>();
        Iterator iter = list.iterator();
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
                listOfItems.add(item);
            }
        }
        return listOfItems;
    }

    /**
     * Add a category to the database.
     * @param cat The category to add to the database.
     */
    public void addCategory(Category cat) {
        deleteCategory(cat);
        Element newCategory = new Element("_" + Integer.toString(cat.getId()));
        newCategory.setAttribute("name", cat.getCategoryTitle());
        this.category.addContent(newCategory);
    }
    
    /**
     * Delete a category from the database.
     * @param cat The Category to be deleted from the database.
     */
    public void deleteCategory(Category cat) {
        this.category.removeChild("_" + Integer.toString(cat.getId()));
    }
    
    /**
     * Edit a category in the database.
     * @param cat The category in it's edited form.
     */
    public void editCategory(Category cat) {
        addCategory(cat);
    }
    
    /**
     * Get all categories from the database in an ArrayList<Category>.
     * @return An ArrayList<Category> of all categories in the database.
     */
    public ArrayList<Category> getCategories() {
        ArrayList<Category> result = new ArrayList<>();
        List list = this.category.getChildren();
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Element e = (Element) iter.next();
            int number = Integer.parseInt(e.getName().substring(1));
            String name = e.getAttributeValue("name");
            Category cat = new Category(number, name, getItemsByCategory(name));
            result.add(cat);
        }
        return result;
    }
    
    /**
     * Private class to setup the database if it doesn't exist.
     */
    private void setupDB() {
        Element tempRoot = new Element("todoManager");
        Element tempCategory = new Element("category");
        Element tempData = new Element("data");
        tempRoot.addContent(tempCategory);
        tempRoot.addContent(tempData);
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        try {
            out.output(new Document(tempRoot), new FileOutputStream(this.file));
        } catch (IOException ex) {
        }
    }
}
