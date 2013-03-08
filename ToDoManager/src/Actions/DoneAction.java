package Actions;

import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

/**
 * Class to mark items as done.
 *
 * @author Daniel
 */
public class DoneAction extends AbstractAction {

    private ToDoItem item;
    private JCheckBox box;

    public DoneAction(ToDoItem item, JCheckBox box) {
        super();
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
    }
}
