package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Enum.Priority;

/**
 *
 * @author Daniel
 */
public class DatabaseTest {
    String testAddItem = "./testAddItem.xml";
    String testEditItem = "./testEditItem.xml";
    String testDeleteItem = "./testDeleteItem.xml";
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of constructor, of class Database
     */
    /*
    @Test
    public void testDatabase() {
        System.out.println("constructor");
        String file = "./testDB.xml";
        Database db = new Database(file);
        File f = new File(file);
        f.delete();
        }
    */
    /**
     * Test of addItem method, of class Database.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        GregorianCalendar cal = new GregorianCalendar();
        ToDoItem item1 = new ToDoItem(1, "aa", "bb", "cc", Priority.HIGH, cal);
        ToDoItem item2 = new ToDoItem(2, "aa", "bb", "cc", Priority.LOW, cal);
        Database instance = new Database(testAddItem);
        instance.addItem(item1);
        instance.addItem(item2);
        instance.closeDB();
    }

    /**
     * Test of editItem method, of class Database.
     */
    @Test
    public void testEditItem() {
        System.out.println("addItem");
        GregorianCalendar cal = new GregorianCalendar();
        ToDoItem item1 = new ToDoItem(1, "aa", "bb", "cc", Priority.HIGH, cal);
        ToDoItem item2 = new ToDoItem(2, "aa", "bb", "cc", Priority.LOW, cal);
        Database instance = new Database(testEditItem);
        instance.addItem(item1);
        instance.addItem(item2);
        item1.setDescription("test");
        instance.addItem(item1);
        instance.closeDB();
    }

    /**
     * Test of deleteItem method, of class Database.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        GregorianCalendar cal = new GregorianCalendar();
        ToDoItem item1 = new ToDoItem(1, "aa", "bb", "cc", Priority.HIGH, cal);
        ToDoItem item2 = new ToDoItem(2, "aa", "bb", "cc", Priority.LOW, cal);
        Database instance = new Database(testDeleteItem);
        instance.addItem(item1);
        instance.addItem(item2);
        instance.deleteItem(item1);
        instance.closeDB();
    }

    /**
     * Test of getItems method, of class Database.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getItems");
        Database instance = new Database();
        ArrayList expResult = null;
        ArrayList result = instance.getAllItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
