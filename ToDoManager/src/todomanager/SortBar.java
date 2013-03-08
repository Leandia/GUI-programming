package todomanager;

import Actions.CategorySortingAction;
import Actions.PrioSortingAction;
import Actions.TimeSortingAction;
import Actions.TitleSortingAction;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Bar with sorting options.
 *
 * @author Daniel
 */
public class SortBar extends JPanel {

    private IconButton prio;
    private IconButton time;
    private IconButton title;
    private IconButton category;
    private String selected = "./Resources/sort_selected.gif";
    private String unselected = "./Resources/sort_unselected.gif";

    public SortBar() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        prio = new IconButton(new PrioSortingAction(this), unselected);
        this.add(prio);
        this.add(new JLabel("prio"));
        time = new IconButton(new TimeSortingAction(this), unselected);
        this.add(time);
        this.add(new JLabel("time"));
        title = new IconButton(new TitleSortingAction(this), unselected);
        this.add(title);
        this.add(new JLabel("title"));
        category = new IconButton(new CategorySortingAction(this), unselected);
        this.add(category);
        this.add(new JLabel("category"));
    }

    /**
     * Method to reset the used icon to unselected state.
     */
    public void resetIcon() {
        update(unselected);
    }

    /**
     * Method to set the used icon to selected state.
     */
    public void updateIcon() {
        update(selected);
    }

    private void update(String image) {
        switch (TODOManager.backend.getSorting()) {
            case TIME:
                time.setImage(image);
                break;
            case PRIO:
                prio.setImage(image);
                break;
            case TITLE:
                title.setImage(image);
                break;
            case CATEGORY:
                category.setImage(image);
                break;
        }
    }
}
