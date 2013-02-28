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
    
    public ToDoItemEditor() {
        this.item = new ToDoItemDesign();
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ToDoItem toDoItem = (ToDoItem) value;
        this.item.updateItemPanel(toDoItem);
        return this.item;
    }
}
