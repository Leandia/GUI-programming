package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import todomanager.NewItemPopup;
import todomanager.TODOManager;

/**
 * Action to open the new Item popup window.
 *
 * @author Daniel
 */
public class AddItemPopupAction extends AbstractAction {

    public AddItemPopupAction() {
    }

    /**
     * Constructor taking a String which is the name oif the action.
     *
     * @param text THe name of the action.
     */
    public AddItemPopupAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NewItemPopup opt = new NewItemPopup(frame, true);
        if (opt.getItem() != null) {
            TODOManager.backend.addItem(opt.getItem());
            TODOManager.backend.viewChange();
        }
    }
}
