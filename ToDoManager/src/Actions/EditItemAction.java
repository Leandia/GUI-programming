package Actions;

import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import todomanager.NewItemPopup;
import todomanager.TODOManager;

/**
 * Class for editItemAction. Extends AbstractAction.
 *
 * @author Daniel
 */
public class EditItemAction extends AbstractAction {

    private ToDoItem todoItem;

    /**
     * Constructor taking the ToDoItem to edit.
     *
     * @param item The ToDoItem to edit.
     */
    public EditItemAction(ToDoItem item) {
        this.todoItem = item;
    }

    /**
     * Constructor taking the ToDoItem to edit and a sname of the action.
     *
     * @param item The ToDoItem to edit.
     * @param text THe name of the action.
     */
    public EditItemAction(ToDoItem item, String text) {
        super(text);
        this.todoItem = item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.print(this.todoItem.getPrio());
        NewItemPopup opt = new NewItemPopup(frame, true, this.todoItem.getTitle(), this.todoItem.getCategory(),
                this.todoItem.getDate(), this.todoItem.getPrio());
        if (opt.getItem() != null) {
            TODOManager.backend.deleteItem(this.todoItem);
            TODOManager.backend.addItem(opt.getItem());
            TODOManager.backend.viewChange();
        }
    }
}