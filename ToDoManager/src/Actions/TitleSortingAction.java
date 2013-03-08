package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.SortBar;
import todomanager.TODOManager;
import values.Sorting;

/**
 *
 * @author Daniel
 */
public class TitleSortingAction extends AbstractAction {

    SortBar sort;

    public TitleSortingAction(SortBar sort) {
        super();
        this.sort = sort;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sort.resetIcon();
        TODOManager.backend.setSorting(Sorting.TITLE);
        TODOManager.backend.viewChange();
        sort.updateIcon();
    }
}
