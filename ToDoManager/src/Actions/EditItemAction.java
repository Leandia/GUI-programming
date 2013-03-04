package Actions;

import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;

/**
 * Class for editItemAction. Extends AbstractAction.
 * @author Daniel
 */
public class EditItemAction  extends AbstractAction {

    private ToDoItem todoItem;
    
    public EditItemAction(ToDoItem item){
        super(TODOManager.manager.getBundle().getString("edit"));
        this.todoItem = item;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO implement the edit thingie.
    }
}
