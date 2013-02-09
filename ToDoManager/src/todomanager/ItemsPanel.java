package todomanager;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Simple temPanel class that is the visual representation of a todoitem.
 * @author Kristian Johansson and Kristoffer Wass
 */
public class ItemsPanel extends JPanel {

    private String headline;
    private final int max_width = 600;
    private int height = 50;
    private String description; 
    
    public ItemsPanel(String hl, String des) {
        this.headline = hl;
        this.description = des;
        setMaximumSize(new Dimension(max_width, height));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        updateItemPanel();
    }

    /**
     * Updates the panel with current data
     */
    public void updateItemPanel() {
        this.add(new JLabel(this.headline));
        setBackgroundColor();
    }

    /**
     * Sets the color of the item as function of priority
     */
    private void setBackgroundColor() {
        this.setBackground(Color.red);
    }
    
    /**
     *
     * @return itemHeadline as a String
     */
    public String getHeadline() {
        return this.headline;
    }

    /**
     * Set a new headline for the itempanel.
     * @param newHeadline 
     */
    private void setHeadline(String newHeadline) {
        this.headline = newHeadline;
    }
}
