package todomanager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

/**
 * Simple temPanel class that is the visual representation of a todoitem.
 *
 * @author Kristian Johansson
 * @author Kristoffer Wass
 * @author Daniel
 */
public class ToDoItemRenderer extends JPanel implements ListCellRenderer {

    private final int width = 6000;
    private final int height = 50;
    private ToDoItem item;
    private JCheckBox doneButton;
    private JPanel donePanel;
    private JLabel priority;
    
    public ToDoItemRenderer() {
        super();
    }

    /**
     * Updates the panel with current data
     */
    private void updateItemPanel() {
        this.setLayout(new GridBagLayout());

        // The done button.
        donePanel = new JPanel();
        donePanel.setOpaque(false);
        doneButton = new JCheckBox(TODOManager.manager.getBundle().getString("done"));
        doneButton.setOpaque(false);
        donePanel.add(doneButton);
        donePanel.setPreferredSize(new Dimension(50, 50));
        GridBagConstraints doneConstraints = new GridBagConstraints();
        doneConstraints.gridx = 0;
        doneConstraints.gridy = 0;
        this.add(donePanel, doneConstraints);

        // Display priority with text.
        JPanel priorityPanel = new JPanel();
        priorityPanel.setOpaque(false);
        priority = new JLabel(TODOManager.manager.getBundle().getString("error"));
        priority.setText(this.item.getPrio().toString());
        priorityPanel.setPreferredSize(new Dimension(50, 50));
        priorityPanel.add(priority);
        GridBagConstraints prioConstraints = new GridBagConstraints();
        prioConstraints.gridx = 1;
        prioConstraints.gridy = 0;
        this.add(priorityPanel, prioConstraints);

        // Panel for title and date.
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;        
        // Get title.
        JLabel title = new JLabel(this.item.getTitle());
        titlePanel.add(title, titleConstraints);
        titleConstraints.gridy = 1;
        titleConstraints.gridwidth = 1;
        // Get date.
        JPanel datePanel = new JPanel();
        datePanel.setOpaque(false);
        JLabel date = new JLabel(this.item.getDate().get(Calendar.YEAR) + "-" + 
                this.item.getDate().get(Calendar.MONTH) + "-" + 
                this.item.getDate().get(Calendar.DATE));
        datePanel.add(date);
        titlePanel.add(datePanel, titleConstraints);
        titleConstraints.gridx = 1;
        // Get category.
        JPanel categoryPanel = new JPanel();
        categoryPanel.setOpaque(false);
        JLabel category = new JLabel(this.item.getCategory());
        categoryPanel.add(category);
        titlePanel.add(categoryPanel, titleConstraints);
        
        GridBagConstraints titlePanelConstraints = new GridBagConstraints();
        titlePanelConstraints.gridx = 2;
        titlePanelConstraints.gridy = 0;
        titlePanelConstraints.weightx = 1;
        titlePanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(titlePanel, titlePanelConstraints);
        
        // Panel for edit and delete buttons.
        JPanel editPanel = new JPanel();
        editPanel.setOpaque(false);
        editPanel.setPreferredSize(new Dimension(50, 50));
        JLabel buttons = new JLabel("edit/delete");
        editPanel.add(buttons);
        GridBagConstraints editConstraints = new GridBagConstraints();
        editConstraints.gridx = 3;
        editConstraints.gridy = 0;
        this.add(editPanel, editConstraints);
    }

    /**
     * Sets the color of the item as function of priority
     */
    private void setBackgroundColor() {
        switch (this.item.getPrio()) {
            case LOW:
                this.setBackground(Color.GREEN);
                break;
            case MEDIUM:
                this.setBackground(Color.YELLOW);
                break;
            case HIGH:
                this.setBackground(Color.red);
                break;
            default:
                this.setBackground(Color.GRAY);
                break;
        }
    }

    /**
     *
     * @return itemHeadline as a String
     */
    public String getHeadline() {
        return item.getTitle();
    }

    /**
     * Set a new headline for the itempanel.
     *
     * @param newHeadline
     */
    private void setHeadline(String newHeadline) {
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        this.item = (ToDoItem) value;
        this.setMaximumSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.updateItemPanel();
        this.setBackgroundColor();
        return this;
    }
}