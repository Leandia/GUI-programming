package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;
import values.Sorting;

/**
 *
 * @author Daniel
 */
public class TimeSortingAction extends AbstractAction {

    public TimeSortingAction() {
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TODOManager.backend.setSorting(Sorting.TIME);
        TODOManager.backend.viewChange();
    }
    
}
