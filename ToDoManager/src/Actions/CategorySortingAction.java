package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;
import values.Sorting;

/**
 *
 * @author Daniel
 */
public class CategorySortingAction extends AbstractAction {

    public CategorySortingAction() {
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TODOManager.backend.setSorting(Sorting.CATEGORY);
        TODOManager.backend.viewChange();
    }
    
}
