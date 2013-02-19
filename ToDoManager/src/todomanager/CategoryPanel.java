package todomanager;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 */
public class CategoryPanel extends JPanel {

    private JLabel categories;
    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public CategoryPanel() {
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(200, 200));
        categories = new JLabel(TODOManager.manager.getBundle().getString("categories"));
        this.add(categories);
    }
}
