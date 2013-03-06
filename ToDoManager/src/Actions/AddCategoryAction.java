/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;

/**
 *
 * @author Kristian
 */
public class AddCategoryAction extends AbstractAction {

    public AddCategoryAction(){
        super(TODOManager.manager.getBundle().getString("add_category"));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
