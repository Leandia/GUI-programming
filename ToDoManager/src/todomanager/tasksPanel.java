package todomanager;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import mockClasses.*;
/**
 *
 * @author Kristian Johansson and Kristoffer Wass
 */
class tasksPanel extends JPanel{
    
    private itemPanel itemPanel;
    
    public tasksPanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }
    
    /**
     * Method that updates the GUI, takes a list of items as argument
     * @param items 
     */
    public void updatePanel(ArrayList<item> items){
        for(int i=0;i<items.size();i++){
            addItems(items.get(i));
        }
    }
    
    /**
     * Create an itemPanel using the input item and adds this panel to
     * the tasksPanel
     * @param item 
     */
    private void addItems(item item){
        itemPanel = new itemPanel(item.getName());
        itemPanel.setBackground(Color.red);
        itemPanel.setAlignmentX(0);
        this.add(itemPanel);
    }
}
