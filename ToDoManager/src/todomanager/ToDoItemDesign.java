/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todomanager;

import Actions.DeleteItemAction;
import backend.ToDoItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import values.Priority;

/**
 *
 * @author Daniel
 */
public class ToDoItemDesign extends JPanel {

    private ToDoItem item;
    private JCheckBox doneButton;
    private ImagePanel donePrioPanel;
    private JPanel donePanel;
    private JLabel priority;
    private JLabel title;
    private JLabel category;
    private JLabel date;
    private JButton deleteBtn;
    private JButton editBtn;

    /**
     * Constructor, it sets up the design, creates all the objects and sets them
     * in apropriate places.
     */
    public ToDoItemDesign() {
        super();

        this.setLayout(new GridBagLayout());

        // -- Panel 1 for done button and priority, position (0,0).
        donePrioPanel = new ImagePanel();
        donePrioPanel.setOpaque(false);
        donePrioPanel.setPreferredSize(new Dimension(150, 50));
        GridBagConstraints donePrioConstraints = new GridBagConstraints();
        donePrioConstraints.gridx = 0;
        donePrioConstraints.gridy = 0;
        this.add(donePrioPanel, donePrioConstraints);
        // The done button.
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
        donePrioPanel.add(donePanel, doneConstraints);
        // Display priority with text.
        JPanel priorityPanel = new JPanel();
        priorityPanel.setOpaque(false);
        priorityPanel.setPreferredSize(new Dimension(50, 50));
        priority = new JLabel(TODOManager.manager.getBundle().getString("error"));
        priorityPanel.add(priority);
        GridBagConstraints prioConstraints = new GridBagConstraints();
        prioConstraints.gridx = 1;
        prioConstraints.gridy = 0;
        donePrioPanel.add(priorityPanel, prioConstraints);


        // -- Panel 2 for title, category and date, position(2,0).
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        // Add the titlepanel
        GridBagConstraints titlePanelConstraints = new GridBagConstraints();
        titlePanelConstraints.gridx = 2;
        titlePanelConstraints.gridy = 0;
        titlePanelConstraints.weightx = 1;
        titlePanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(titlePanel, titlePanelConstraints);
        // Create constraints for items on this panel.
        GridBagConstraints titleConstraints = new GridBagConstraints();
        // Add title.
        title = new JLabel("-- error no title --");
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = 2;
        titlePanel.add(title, titleConstraints);
        // Add date.
        JPanel datePanel = new JPanel();
        datePanel.setOpaque(false);
        date = new JLabel("-- error no date --");
        datePanel.add(date);
        titleConstraints.gridy = 1;
        titleConstraints.gridwidth = 1;
        titlePanel.add(datePanel, titleConstraints);
        // Add category.
        JPanel categoryPanel = new JPanel();
        categoryPanel.setOpaque(false);
        category = new JLabel("-- error no category --");
        categoryPanel.add(category);
        titleConstraints.gridx = 1;
        titlePanel.add(categoryPanel, titleConstraints);

        // -- Panel 3 for edit and delete buttons, position(3,0).
        JPanel editPanel = new JPanel();
        editPanel.setOpaque(false);
        editPanel.setPreferredSize(new Dimension(75, 50));
        editBtn = new JButton(TODOManager.manager.getBundle().getString("edit"));
        editPanel.add(editBtn);

        deleteBtn = new JButton();
        editPanel.add(deleteBtn);
        GridBagConstraints editConstraints = new GridBagConstraints();
        editConstraints.gridx = 3;
        editConstraints.gridy = 0;
        this.add(editPanel, editConstraints);
    }

    /**
     * Updates the panel with current data and adds actions.
     */
    public void updateItemPanel(ToDoItem item) {
        this.item = item;
        // Set actions to button here.
        deleteBtn.setAction(new DeleteItemAction(this.item));

        switch (this.item.getPrio()) {
            case LOW:
                priority.setText(TODOManager.manager.getBundle().getString("low"));
                break;
            case MEDIUM:
                priority.setText(TODOManager.manager.getBundle().getString("medium"));
                break;
            case HIGH:
                priority.setText(TODOManager.manager.getBundle().getString("high"));
                break;
            default:
                priority.setText("--Error--");
                break;
        }

        title.setText(this.item.getTitle());

        category.setText(this.item.getCategory());
        //Month start by 0 in gregoriancalendar so need to add 1 to
        //display the correct value
        int month = this.item.getDate().get(Calendar.MONTH) + 1;

        date.setText(this.item.getDate().get(Calendar.YEAR) + "-"
                + month + "-"
                + this.item.getDate().get(Calendar.DATE));

        setBackgroundColor();
    }

    /**
     * Sets the color of the item as function of priority
     */
    private void setBackgroundColor() {
        switch (this.item.getPrio()) {
            case LOW:
                //this.setBackground(Color.GREEN);
                this.donePrioPanel.setPicture("./Resources/low_prio.gif");
                break;
            case MEDIUM:
                //this.setBackground(Color.YELLOW);
                this.donePrioPanel.setPicture("./Resources/medium_prio.gif");
                break;
            case HIGH:
                //this.setBackground(Color.red);
                this.donePrioPanel.setPicture("./Resources/high_prio.gif");
                break;
            default:
                this.setBackground(Color.GRAY);
                break;
        }
    }

    public void updateLabels() {
        this.doneButton.setText(TODOManager.manager.getBundle().getString("done"));
        this.editBtn.setText(TODOManager.manager.getBundle().getString("edit"));
        deleteBtn.removeAll();
        deleteBtn.setAction(new DeleteItemAction(this.item));
    }
}
