package todomanager;

import Actions.DeleteItemAction;
import backend.ToDoItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
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