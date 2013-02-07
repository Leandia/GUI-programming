package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 */
public class Category extends JPanel {

    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public Category() {
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(200, 200));
        this.add(new JLabel("Categories"));
    }
}
