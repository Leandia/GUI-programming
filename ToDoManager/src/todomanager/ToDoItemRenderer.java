package todomanager;

import backend.ToDoItem;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Simple temPanel class that is the visual representation of a todoitem.
 *
 * @author Kristian Johansson
 * @author Kristoffer Wass
 * @author Daniel
 */
public class ToDoItemRenderer implements TableCellRenderer {

    private ToDoItemDesign item;

    public ToDoItemRenderer() {
        item = new ToDoItemDesign();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ToDoItem toDoItem = (ToDoItem) value;
        this.item.updateItemPanel(toDoItem);
        return this.item;
    }
}