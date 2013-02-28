/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todomanager;

import backend.ToDoItem;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Daniel
 */
public class ToDoItemEditor extends AbstractCellEditor implements TableCellEditor {

    ToDoItemDesign item;

    /**
     * Constructor, sets up the editor.
     */
    public ToDoItemEditor() {
        this.item = new ToDoItemDesign();
    }

    /**
     * Method needed for implemented classes.
     *
     * @return null.
     */
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    /**
     * Method from TableCellEditor.
     *
     * @param table The JTable.
     * @param value The object at a row.
     * @param isSelected If it's selected.
     * @param row What row.
     * @param column What column.
     * @return The object to be manipulated.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ToDoItem toDoItem = (ToDoItem) value;
        this.item.updateItemPanel(toDoItem);
        return this.item;
    }
}
