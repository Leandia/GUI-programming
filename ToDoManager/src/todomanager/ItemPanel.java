package todomanager;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Kristian Johansson and Kristoffer Wass
 */
public class ItemPanel extends JPanel {

    private String headline;
    private final int width = 600;
    private final int height = 50;

    public ItemPanel(String headline) {
        this.headline = headline;
        setMaximumSize(new Dimension(width, height));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        updateItemPanel();
    }

    public void updateItemPanel() {
        this.add(new JLabel(this.headline));
    }

    /**
     * Sets the color of the item as function of priority
     */
    private void setBackgroundColor() {
    }

    /**
     *
     * @return itemHeadline as a String
     */
    public String getHeadline() {
        return this.headline;
    }

    private void setHeadline(String newHeadline) {
        this.headline = newHeadline;
    }
}
