package todomanager;

import Actions.AddItemPopupAction;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Emil
 */
public class ButtonsPanel extends JPanel {

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private JButton addButton;

    /**
     *
     * @param list
     * @param middle
     */
    public ButtonsPanel() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        addButton = new JButton(new AddItemPopupAction());
        addButton.setActionCommand("button");
        this.add(addButton);
    }
}