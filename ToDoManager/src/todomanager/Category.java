package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author vita, daniel
 */
public class Category extends JPanel {

    public Category() {
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(200, 200));
        this.add(new JLabel("Categories"));
    }
}
