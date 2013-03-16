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
        
        new NewCategoryPopup(frame);
    }
    
}
