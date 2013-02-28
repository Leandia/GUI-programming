package todomanager;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author vita, daniel
 */
public class TodoList extends JPanel {

    ButtonsPanel top;
    TaskPanel middle = new TaskPanel();
    JPanel bottom;

    /**
     * Constructor setsup the right side of the mainwindow where the todoItems
     * will be presented. Divides this side into three for the top to be a panel
     * with buttons, the middle to be the panel where the items are shown and
     * the bottom a panel showing number of items.
     */
    public TodoList() {
        //middle = new TaskPanel();
        top = new ButtonsPanel();
        
        this.setLayout(new BorderLayout());
        this.add(top, BorderLayout.NORTH);
        //this.add(middle, BorderLayout.CENTER);
    }
}
