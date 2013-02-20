/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import javax.swing.DefaultListModel;
import todomanager.ToDoItem;

/**
 *
 * @author Daniel
 */
public class BackendAPI {
    DefaultListModel<ToDoItem> list = new DefaultListModel<>();
    //final DisplayList list;
    
    public BackendAPI() {
        //this.list = new DisplayList();
    }
    
    public void addItem(ToDoItem item) {
        this.list.addElement(item);
    }
    
    public DefaultListModel getList() {
        return this.list;
    }
}
