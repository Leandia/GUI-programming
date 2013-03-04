package todomanager;

import java.awt.BorderLayout;
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
        this.setMinimumSize(new Dimension(200, 200));
        this.setLayout(new BorderLayout());
        categories = new JLabel(TODOManager.manager.getBundle().getString("categories"));
        JPanel clock = new JPanel();
        clock.setBackground(Color.DARK_GRAY);
        clock.setPreferredSize(new Dimension(150, 150));
        this.add(clock, BorderLayout.NORTH);
        this.add(categories, BorderLayout.CENTER);
    }
    
    public void updateLabels(){
        this.categories.setText(TODOManager.manager.getBundle().getString("categories"));
    }
}
