package todomanager;

import backend.ToDoItem;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * TaskPanel class, extends JPanel and holds all currently viewed ToDoItems.
 * @author Kristian Johansson 
 * @author Kristoffer Wass
 */
public class TaskPanel extends JPanel{
    
    // Use JTable instead!
    private final JTable list;
    private JScrollPane scrollPane = new JScrollPane();
    
    public TaskPanel() {
        super(new GridBagLayout());
        this.list = new JTable(TODOManager.backend.getListModel());
        this.list.setDefaultRenderer(ToDoItem.class, new ToDoItemRenderer());
        this.list.setRowHeight(50);
        scrollPane.getViewport().setView(this.list);
        //scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        this.add(scrollPane, constraints);
    }

    /**
     * Adds an item to the GUI by placing it on the TaskPanel. Takes a
     * Todoitem as only parameter.
     * @param item 
     */
    public void addItem(ToDoItem item) {
        TODOManager.backend.addItem(item);
    }
    
    
    
}
