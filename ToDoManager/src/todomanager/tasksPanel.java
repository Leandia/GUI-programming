package todomanager;

import java.awt.Color;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/**
 *
 * @author Kristian Johansson and Kristoffer Wass
 */
class tasksPanel extends JPanel{
    private ArrayList<ToDoItem> items = new ArrayList<>();
    
    public tasksPanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    
    public void add(ToDoItem item) {
        this.items.add(item);
        updatePanel();
    }
    /**
     * Method that updates the GUI, takes a list of items as argument
     * @param items 
     */
    private void updatePanel(){
        this.removeAll();
        for(int i=0;i<items.size();i++){
            addItems(this.items.get(i));
        }
    }
    
    /**
     * Create an itemPanel using the input item and adds this panel to
     * the tasksPanel
     * @param item 
     */
    private void addItems(ToDoItem item){
        itemPanel itemPanel = new itemPanel(item.getTitle());
        itemPanel.setBackground(Color.red);
        itemPanel.setAlignmentX(0);
        this.add(itemPanel);
    }
}
