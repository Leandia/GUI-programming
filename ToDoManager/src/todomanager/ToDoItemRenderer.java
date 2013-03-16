package todomanager;

import backend.ToDoItem;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Simple itemPanel class that is the visual representation of a todoitem.
 *
 * @author Kristoffer Wass
 * @author Daniel
 */
public class ToDoItemRenderer implements TableCellRenderer {

    private ToDoItemDesign item;

    /**
     * Constructor, sets up the renderer.
     */
    public ToDoItemRenderer() {
        item = new ToDoItemDesign();
    }

    /**
     * Method needed by TableCellRenderer.
     *
     * @param table The JTable.
     * @param value The object to be rendered.
     * @param isSelected If the object is selected.
     * @param hasFocus If the object has focus.
     * @param row What row.
     * @param column What column.
     * @return The object to be rendered.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ToDoItem toDoItem = (ToDoItem) value;
        this.item.updateItemPanel(toDoItem);
        return this.item;
    }
}