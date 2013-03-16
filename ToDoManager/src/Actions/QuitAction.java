package Actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Class to quit the program.
 *
 * @author Emil
 */
public class QuitAction extends AbstractAction {

    /**
     * Constructor takikng the name of the action and a description of the
     * action.
     *
     * @param text The name of the action.
     * @param desc The description of the action.
     */
    public QuitAction(String text, String desc) {
        super(text);
        putValue(SHORT_DESCRIPTION, desc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println("Quit!");
        System.exit(0);
    }
}
