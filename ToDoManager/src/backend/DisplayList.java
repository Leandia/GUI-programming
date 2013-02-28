/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel
 */
public class DisplayList extends AbstractTableModel {

    private String[] columNames = {"ToDoItem"};
    private ArrayList<ToDoItem> list = new ArrayList<>();

    public DisplayList() {
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return this.columNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.list.get(rowIndex);
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public void addElement(ToDoItem item) {
        this.list.add(item);
        this.fireTableDataChanged();
    }

    public void removeElement(ToDoItem item) {
        this.list.remove(item);
        this.fireTableDataChanged();
    }

    public ToDoItem get(int i) {
        return this.list.get(i);
    }

    public void remove(int i) {
        this.list.remove(i);
        this.fireTableDataChanged();
    }

    // ---------------------------------------------
    //              Getters and Setters
    // ---------------------------------------------
    public ArrayList<ToDoItem> getList() {
        return list;
    }

    public void setList(ArrayList<ToDoItem> list) {
        this.list = list;
    }
}
