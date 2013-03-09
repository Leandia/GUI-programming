/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import todomanager.NewCategoryPopup;

/**
 * Class to add a category.
 * 
 * @author Kristian
 */
public class AddCategoryAction extends AbstractAction {

    private JFrame frame;
    private NewCategoryPopup popup;
    
    public AddCategoryAction(){
    }
    
    /**
     * Constructor, takes a String as category name.
     * 
     * @param text The name of the category.
     */
    public AddCategoryAction(String text){
        super(text);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(200,200));
        
        popup = new NewCategoryPopup(frame);
    }
    
}
