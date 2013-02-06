package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author vita, daniel
 */
public class TodoList extends JPanel {

    ButtonsPanel top;
    TasksPanel middle = new TasksPanel();
    JPanel bottom;

    public TodoList() {
        top = new ButtonsPanel(middle);

        bottom = new JPanel();
        bottom.setBackground(Color.GRAY);
        bottom.setPreferredSize(new Dimension(100, 100));
        bottom.add(new JLabel("MAKE YOUR CLASS EXTEND JPANEL!"));

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

        GridBagConstraints bottomConstraints = new GridBagConstraints();
        bottomConstraints.gridx = 0;
        bottomConstraints.gridy = 2;
        bottomConstraints.fill = GridBagConstraints.BOTH;
        bottomConstraints.weightx = 1.0;
        this.add(bottom, bottomConstraints);
    }
}
