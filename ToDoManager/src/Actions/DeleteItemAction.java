package Actions;

import backend.BackendAPI;
import backend.ToDoItem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Kristian
 */
public class DeleteItemAction extends AbstractAction{

    private BackendAPI backEnd;
    private ToDoItem todoItem;
    
    public DeleteItemAction(String text, ToDoItem item, BackendAPI backend){
        super(text);
        this.backEnd = backend;
        this.todoItem = item;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        backEnd.deleteItem(this.todoItem);
    }
}
