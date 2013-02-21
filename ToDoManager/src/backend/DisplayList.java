/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Daniel
 */
public class DisplayList extends DefaultListModel{

    private ArrayList<ToDoItem> list = new ArrayList<>();
    
    public DisplayList() {
        super();
    }
    
    public ArrayList<ToDoItem> getList() {
        return this.list;
    }
    
    public void addItem(ToDoItem item) {
        list.add(item);
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
