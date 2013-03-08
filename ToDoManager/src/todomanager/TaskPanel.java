package todomanager;

import Actions.CategorySortingAction;
import Actions.PrioSortingAction;
import Actions.TimeSortingAction;
import Actions.TitleSortingAction;
import backend.ToDoItem;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * TaskPanel class, extends JPanel and holds all currently viewed ToDoItems.
 *
 * @author Kristian Johansson
 * @author Kristoffer Wass
 * @author Daniel
 */
public class TaskPanel extends JPanel {

    private final JTable list;
    private JScrollPane scrollPane = new JScrollPane();
    private int rowHeight = 51;

    /**
     * Constructor, it sets up the JTable.
     */
    public TaskPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        SortBar sorting = new SortBar();
        sorting.setPreferredSize(new Dimension(100, 10));
        this.add(sorting, constraints);
        
        
        this.list = new JTable(TODOManager.backend.getListModel());
        this.list.setDefaultRenderer(ToDoItem.class, new ToDoItemRenderer());
        this.list.setDefaultEditor(ToDoItem.class, new ToDoItemEditor());
        this.list.setTableHeader(null);
        this.list.setRowHeight(rowHeight);
        scrollPane.getViewport().setView(this.list);
        constraints.weighty = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, constraints);
    }

    /**
     * Adds an item to the GUI by placing it on the TaskPanel. Takes a Todoitem
     * as only parameter.
     *
     * @param item
     */
    public void addItem(ToDoItem item) {
        TODOManager.backend.addItem(item);
    }
}
