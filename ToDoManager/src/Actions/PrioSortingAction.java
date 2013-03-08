package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;
import values.Sorting;

/**
 *
 * @author Daniel
 */
public class PrioSortingAction extends AbstractAction {

    public PrioSortingAction() {
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TODOManager.backend.setSorting(Sorting.PRIO);
        TODOManager.backend.viewChange();
    }
    
}
