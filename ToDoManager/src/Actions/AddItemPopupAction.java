/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import todomanager.NewItemPopup;
import todomanager.TODOManager;
import todomanager.TaskPanel;

/**
 *
 * @author Daniel
 */
public class AddItemPopupAction extends AbstractAction {

    TaskPanel middle;

    public AddItemPopupAction(TaskPanel middle) {
        super(TODOManager.getManager().getBundle().getString("buttontext"));
        this.middle = middle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NewItemPopup opt = new NewItemPopup(frame, true);
        if (opt.getItem() != null) {
            middle.addItem(opt.getItem());
        }
    }
}
