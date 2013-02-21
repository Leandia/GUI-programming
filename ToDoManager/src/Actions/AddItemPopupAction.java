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

/**
 *
 * @author Daniel
 */
public class AddItemPopupAction extends AbstractAction {


    public AddItemPopupAction() {
        super(TODOManager.getManager().getBundle().getString("buttontext"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        NewItemPopup opt = new NewItemPopup(frame, true);
        if (opt.getItem() != null) {
            TODOManager.backend.addItem(opt.getItem());
        }
    }
}
