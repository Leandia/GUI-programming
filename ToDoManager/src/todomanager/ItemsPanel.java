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
    private String description;
    private final int width = 6000;
    private final int height = 50;

    public ItemsPanel(String hl, String des) {
        this.headline = hl;
        this.description = des;
        setMaximumSize(new Dimension(width, height));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        updateItemPanel();
    }

    /**
     * Updates the panel with current data
     */
    public void updateItemPanel() {
        this.setBackgroundColor();
        this.add(new JLabel(this.headline));
    }

    /**
     * Sets the color of the item as function of priority
     */
    private void setBackgroundColor() {
        this.setBackground(Color.RED);
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
