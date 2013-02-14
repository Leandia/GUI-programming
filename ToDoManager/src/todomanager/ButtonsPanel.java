package todomanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private TaskPanel middle;
    private JButton addButton;
    /**
     *
     * @param list
     * @param middle
     */
    public ButtonsPanel(TaskPanel middle) {
        this.middle = middle;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        addButton = new JButton(TODOManager.manager.getBundle().getString("buttontext"));
        addButton.setActionCommand("button");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (addButton == ae.getSource()) {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    NewItemPopup opt = new NewItemPopup(frame, true);
                    if ((opt.getTitle() != null) && (opt.getDescription() != null)) {
                        ToDoItem tdi = new ToDoItem(opt.getTitle(), 
                                opt.getDescription(), opt.getCategory(), 
                                opt.getPriority(), opt.getDate());
                        middle.addItem(tdi);
                    }
                }
            }
        });
        this.add(addButton);
    }
}