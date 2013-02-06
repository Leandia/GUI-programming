package todomanager;

import java.awt.Color;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Kristian Johansson and Kristoffer Wass
 */
class TaskPanel extends JPanel {

    private ArrayList<ToDoItem> items = new ArrayList<>();

    public TaskPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addItem(ToDoItem item) {
        this.items.add(item);
        updatePanel();
    }

    /**
     * Method that updates the GUI, takes a list of items as argument
     *
     * @param items
     */
    private void updatePanel() {
        this.removeAll();
        for (int i = 0; i < items.size(); i++) {
            add(this.items.get(i));
        }
        this.updateUI();
    }

    /**
     * Create an ItemsPanel using the input item and adds this panel to the
     * TaskPanel
     *
     * @param item
     */
    private void add(ToDoItem item) {
        ItemsPanel itemPanel = new ItemsPanel(item.getTitle());
        itemPanel.setBackground(Color.red);
        itemPanel.setAlignmentX(0);
        this.add(itemPanel);
    }
}
