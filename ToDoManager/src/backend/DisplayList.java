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

    private ArrayList<ToDoItem> list = new ArrayList<>();

    /**
     * Constructor, takes no arguments.
     */
    public DisplayList() {
    }

    /**
     * Returns number of rows in dataset.
     *
     * @return Number of rows in dataset.
     */
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    /**
     * Returns 1 as the columncount.
     *
     * @return 1 as the columncount.
     */
    @Override
    public int getColumnCount() {
        return 1;
    }

    /**
     * Returns the value at index rowIndex. Index columnIndex is never used.
     *
     * @param rowIndex The index of the wanted item.
     * @param columnIndex Never used.
     * @return Returns the object at position rowIndex.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = null;
        if (this.list != null && this.list.size() > rowIndex) {
            result = this.list.get(rowIndex);
        }
        return result;
    }

    /**
     * Returns the column class, which is ToDoItem.class.
     *
     * @param c Never used.
     * @return The class ToDoItem.class.
     */
    @Override
    public Class getColumnClass(int c) {
        return ToDoItem.class;
    }

    /**
     * Method to tell if the cell is editable, always return true.
     *
     * @param columnIndex Never used.
     * @param rowIndex Never used.
     * @return true
     */
    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return true;
    }

    /**
     * Method to add an element and tell the Table the dataset has changed.
     *
     * @param item The element to add to the dataset.
     */
    public void addElement(ToDoItem item) {
        this.list.add(item);
        this.fireTableDataChanged();
    }

    /**
     * Method to remove an item from the dataset.
     *
     * @param item The item to remove from the dataset.
     */
    public void removeElement(ToDoItem item) {
        this.list.remove(item);
        this.fireTableStructureChanged();
    }

    /**
     * Method to get the item at index i.
     *
     * @param i The index for the wanted item.
     * @return The item at index i.
     */
    public ToDoItem get(int i) {
        return this.list.get(i);
    }

    /**
     * Method to remove an item at index i.
     *
     * @param i The index for the item to be removed.
     */
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
        this.fireTableDataChanged();
    }
}
