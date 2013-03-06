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
import todomanager.TODOManager;

/**
 *
 * @author Kristian
 */
public class AddCategoryAction extends AbstractAction {

    private JFrame frame;
    private NewCategoryPopup popup;
    
    public AddCategoryAction(){
    }
    
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
