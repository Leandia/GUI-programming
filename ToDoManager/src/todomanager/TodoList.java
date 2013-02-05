/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package todomanager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import mockClasses.item;
/**
 *
 * @author vita, daniel
 */
public class TodoList extends JPanel{
    public TodoList() {
        this.setBackground(Color.GREEN);
        
        
        JPanel top = new JPanel();
        top.setBackground(Color.yellow);
        top.setPreferredSize(new Dimension(100, 100));
        top.add(new JLabel("MAKE YOUR CLASS EXTEND JPANEL!"));
        
        tasksPanel middle = new tasksPanel();
        ArrayList<item> items = new ArrayList();
        
        items.add(new item("test1"));
        items.add(new item("test2"));
        items.add(new item("test2"));
        middle.updatePanel(items);
        
        JPanel bottom = new JPanel();
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
