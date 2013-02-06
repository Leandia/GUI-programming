package todomanager;

import java.awt.Color;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Kristian Johansson and Kristoffer Wass
 */
class TasksPanelDelta extends JPanel {

    private ArrayList<ToDoItem> items = new ArrayList<>();

    public TasksPanelDelta() {
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
     * Create an ItemPanelDelta using the input item and adds this panel to the
     * TasksPanelDelta
     *
     * @param item
     */
    private void add(ToDoItem item) {
        ItemPanelDelta itemPanel = new ItemPanelDelta(item.getTitle());
        itemPanel.setBackground(Color.red);
        itemPanel.setAlignmentX(0);
        this.add(itemPanel);
    }
}
