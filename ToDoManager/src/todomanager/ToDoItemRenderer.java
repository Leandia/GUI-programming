package todomanager;

import backend.ToDoItem;
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
    private JLabel title;
    private JLabel category;
    private JLabel date;

    public ToDoItemRenderer() {
        super();

        this.setLayout(new GridBagLayout());

        // -- The done button, position(0,0).
        donePanel = new JPanel();
        donePanel.setOpaque(false);
        doneButton = new JCheckBox(TODOManager.manager.getBundle().getString("done"));
        doneButton.setOpaque(false);
        doneButton.setEnabled(true);
        donePanel.add(doneButton);
        donePanel.setPreferredSize(new Dimension(75, 50));
        GridBagConstraints doneConstraints = new GridBagConstraints();
        doneConstraints.gridx = 0;
        doneConstraints.gridy = 0;
        this.add(donePanel, doneConstraints);

        // -- Display priority with text, position(1,0).
        JPanel priorityPanel = new JPanel();
        priorityPanel.setOpaque(false);
        priority = new JLabel(TODOManager.manager.getBundle().getString("error"));
        priorityPanel.setPreferredSize(new Dimension(75, 50));
        priorityPanel.add(priority);
        GridBagConstraints prioConstraints = new GridBagConstraints();
        prioConstraints.gridx = 1;
        prioConstraints.gridy = 0;
        this.add(priorityPanel, prioConstraints);


        // -- Panel for title, category and date, position(2,0).
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        // Add title.
        title = new JLabel("-- error no title --");
        titlePanel.add(title, titleConstraints);
        titleConstraints.gridy = 1;
        titleConstraints.gridwidth = 1;
        // Add date.
        JPanel datePanel = new JPanel();
        datePanel.setOpaque(false);
        date = new JLabel("-- error no date --");
        datePanel.add(date);
        titlePanel.add(datePanel, titleConstraints);
        titleConstraints.gridx = 1;
        // Add category.
        JPanel categoryPanel = new JPanel();
        categoryPanel.setOpaque(false);
        category = new JLabel("-- error no category --");
        categoryPanel.add(category);
        titlePanel.add(categoryPanel, titleConstraints);
        // Add the titlepanel
        GridBagConstraints titlePanelConstraints = new GridBagConstraints();
        titlePanelConstraints.gridx = 2;
        titlePanelConstraints.gridy = 0;
        titlePanelConstraints.weightx = 1;
        titlePanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(titlePanel, titlePanelConstraints);

        // -- Panel for edit and delete buttons, position(3,0).
        JPanel editPanel = new JPanel();
        editPanel.setOpaque(false);
        editPanel.setPreferredSize(new Dimension(75, 50));
        JLabel buttons = new JLabel("edit/delete");
        editPanel.add(buttons);
        GridBagConstraints editConstraints = new GridBagConstraints();
        editConstraints.gridx = 3;
        editConstraints.gridy = 0;
        this.add(editPanel, editConstraints);
    }

    /**
     * Updates the panel with current data
     */
    private void updateItemPanel() {

        priority.setText(this.item.getPrio().toString());

        title.setText(this.item.getTitle());
        //System.out.println(this.item.getTitle());
        category.setText(this.item.getCategory());

        date.setText(this.item.getDate().get(Calendar.YEAR) + "-"
                + this.item.getDate().get(Calendar.MONTH) + "-"
                + this.item.getDate().get(Calendar.DATE));
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