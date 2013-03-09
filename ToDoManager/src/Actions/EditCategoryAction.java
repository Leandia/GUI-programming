package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Class to edit a category. NOT YET IMPLEMENTED:
 *
 * @author Kristian
 */
public class EditCategoryAction extends AbstractAction {

    public EditCategoryAction() {
    }

    /**
     * Constructor taking the name of the action.
     *
     * @param text The name of the action.
     */
    public EditCategoryAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
