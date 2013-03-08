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
public class CategorySortingAction extends AbstractAction {

    SortBar sort;

    public CategorySortingAction(SortBar sort) {
        super();
        this.sort = sort;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sort.resetIcon();
        TODOManager.backend.setSorting(Sorting.CATEGORY);
        TODOManager.backend.viewChange();
        sort.updateIcon();
    }
}
