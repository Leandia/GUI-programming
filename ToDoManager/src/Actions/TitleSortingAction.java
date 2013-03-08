package Actions;

import Enum.Sorting;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.SortBar;
import todomanager.TODOManager;

/**
 * Class to set sorting acording to title.
 * @author Daniel
 */
public class TitleSortingAction extends AbstractAction {

    SortBar sort;

    /**
     * Constructor, takes a SortBar.
     * @param sort A SortBar.
     */
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
