package Actions;

import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import todomanager.TODOManager;

/**
 *
 * @author Kristian
 */
public class DeleteItemAction extends AbstractAction{

    private ToDoItem todoItem;
    
    public DeleteItemAction(ToDoItem item){
        super(TODOManager.manager.getBundle().getString("delete"));
        this.todoItem = item;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TODOManager.backend.deleteItem(this.todoItem);
    }
}