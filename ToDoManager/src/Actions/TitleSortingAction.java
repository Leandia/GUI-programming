package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;
import values.Sorting;

/**
 *
 * @author Daniel
 */
public class TitleSortingAction extends AbstractAction {

    public TitleSortingAction() {
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TODOManager.backend.setSorting(Sorting.TITLE);
        TODOManager.backend.viewChange();
    }
    
}
