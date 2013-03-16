package Actions;

import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import todomanager.TODOManager;

/**
 * Class to mark items as done.
 *
 * @author Daniel
 */
public class DoneAction extends AbstractAction {

    private ToDoItem item;
    private JCheckBox box;

    /**
     * Constructor taking the ToDoItem to change and the JCeckbox from which to
     * read the change.
     *
     * @param item A ToDoItem.
     * @param box A JCheckBox.
     */
    public DoneAction(ToDoItem item, JCheckBox box) {
        super(TODOManager.manager.getBundle().getString("done"));
        this.item = item;
        this.box = box;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.box.isSelected()) {
            this.item.setDone(true);
        } else {
            this.item.setDone(false);
        }
        TODOManager.backend.updateItem(this.item);
        TODOManager.backend.viewChange();
    }
}
