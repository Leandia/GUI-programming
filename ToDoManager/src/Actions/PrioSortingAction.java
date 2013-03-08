package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.SortBar;
import todomanager.TODOManager;
import Enum.Sorting;

/**
 *
 * @author Daniel
 */
public class PrioSortingAction extends AbstractAction {

    SortBar sort;

    public PrioSortingAction(SortBar sort) {
        super();
        this.sort = sort;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sort.resetIcon();
        TODOManager.backend.setSorting(Sorting.PRIO);
        TODOManager.backend.viewChange();
        sort.updateIcon();
    }
}
