/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;

/**
 *
 * @author Daniel
 * @author Emil
 */
public class BackendAPI {
    
    private Database database;
    private DefaultListModel<ToDoItem> list = new DefaultListModel<>();
    //final DisplayList list;
    private int index = 0;
    
    public BackendAPI(int index) {
        this.index = index;
        this.database = new Database();
        insertItems();
        //this.list = new DisplayList();
    }
    
    /**
     * Method to fetch all items from the database and insert 
     * into the display list.
     */
    private void insertItems() {
        ArrayList<ToDoItem> tempList = this.database.getAllItems();
        Iterator iter = tempList.iterator();
        while (iter.hasNext()) {
            ToDoItem item = (ToDoItem) iter.next();
            this.list.addElement(item);
        }
    }
    
    /**
     * Add an item to the program, both adds the item to be 
     * displayed and to the database.
     * @param item 
     */
    public void addItem(ToDoItem item) {
        this.list.addElement(item);
        database.addItem(item);
    }
    
    /**
     * Return the list where items are stored.
     * @return A list that stores the items.
     */
    public DefaultListModel getList() {
        return this.list;
    }
    
    /**
     * Method to close the database.
     */
    public void closeDB() {
        //this.database.closeDB();
    }
    
    /**
     * Method to get the index of the item to add.
     * @return The index of the next item.
     */
    public int getIndex() {
        return this.index++;
    }
    
    public static ArrayList<ToDoItem> sortByDate(ArrayList<ToDoItem> items){
        
        if (items.size() <= 1 ){
           return items;  
        }
         int middle = items.size()/2;
         
        ArrayList<ToDoItem> left = new ArrayList<>(middle);
        ArrayList<ToDoItem> right = new ArrayList <>(items.size()-middle);
        
        left = sortByDate(left);
        right = sortByDate(right);
        
        return dateMerge(left, right);
    }
    
    public static ArrayList<ToDoItem> dateMerge(ArrayList<ToDoItem> left,ArrayList<ToDoItem> right){
        
        ArrayList<ToDoItem> result = new ArrayList<>(left.size()+right.size());
        
        int i = 0; //left index
        int j = 0; //right index
        int k = 0; //result index
        
        while(i < left.size() && j < right.size()) {
            
            if (left.get(i).getDate().compareTo(right.get(j).getDate())<0){
               result.add(k,right.get(j));
               j++; //next right index
            } else {
                
                result.add(k,left.get(i));
                i++; //next left index
            }
            k++; //next result index 
        }
        
        // Append what is left from the left array into the result array.
        while(i < left.size()){
            result.add(k,left.get(i));
            i++;
            k++;
        }
        // Append what is left from the right array into the result array.
        while(j < right.size()){
            result.add(k,right.get(j));
            j++;
            k++;
        }
        
        return result;
    }
    
    
}