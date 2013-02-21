/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
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
    
    public BackendAPI() {
        this.database = new Database();
        //this.list = new DisplayList();
    }
    
    public void addItem(ToDoItem item) {
        this.list.addElement(item);
        database.addItem(item);
    }
    
    public DefaultListModel getList() {
        return this.list;
    }
    
    public void closeDB() {
        this.database.closeDB();
    }
    
    /*
    public void createDatabase(){
        this.database = new Database();
    }*/
    
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
