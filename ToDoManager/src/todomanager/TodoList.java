package todomanager;

import java.awt.*;
import javax.swing.*;

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
        top = new ButtonsPanel();

        this.setLayout(new GridBagLayout());

        GridBagConstraints topConstraints = new GridBagConstraints();
        topConstraints.gridx = 0;
        topConstraints.gridy = 0;
        topConstraints.fill = GridBagConstraints.BOTH;
        topConstraints.weightx = 1.0;
        this.add(top, topConstraints);

        GridBagConstraints middleConstraints = new GridBagConstraints();
        middleConstraints.gridx = 0;
        middleConstraints.gridy = 1;
        middleConstraints.fill = GridBagConstraints.BOTH;
        middleConstraints.weightx = 1.0;
        middleConstraints.weighty = 1.0;
        this.add(middle, middleConstraints);
    }
}
