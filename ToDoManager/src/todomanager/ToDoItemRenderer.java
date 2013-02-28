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
public class ToDoItemRenderer extends JPanel implements TableCellRenderer {

    private final int width = 6000;
    private final int height = 50;
    private ToDoItem item;
    private JCheckBox doneButton;
    private ImagePanel donePrioPanel;
    private JPanel donePanel;
    private JLabel priority;
    private JLabel title;
    private JLabel category;
    private JLabel date;

    public ToDoItemRenderer() {
        super();

        this.setLayout(new GridBagLayout());

        // -- Panel 1 for done button and priority, position (0,0).
        donePrioPanel = new ImagePanel();
        donePrioPanel.setOpaque(false);
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
        priority = new JLabel(TODOManager.manager.getBundle().getString("error"));
        priorityPanel.setPreferredSize(new Dimension(75, 50));
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
        JButton editBtn = new JButton("Edit");
        editPanel.add(editBtn);
        
        JButton deleteBtn = new JButton(new DeleteItemAction(TODOManager.manager.getBundle().getString("delete"),this.item));
        editPanel.add(deleteBtn);
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
    
    private void setBackgroundColor(int i) {
        setBackgroundColor();
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./Resources/low_prio.gif"));
        } catch (IOException ex) {
            System.err.println("Image not found");
        }
        JLabel imageIcon = new JLabel(new ImageIcon(image));
        donePrioPanel.add(imageIcon);
    }

    /**
     *
     * @return itemHeadline as a String
     */
    public String getHeadline() {
        return item.getTitle();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.item = (ToDoItem) value;
        this.setMaximumSize(new Dimension(width, height));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.updateItemPanel();
        this.setBackgroundColor();
        return this;
    }
}