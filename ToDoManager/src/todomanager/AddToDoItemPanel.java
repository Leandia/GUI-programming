package todomanager;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddToDoItemPanel extends JPanel {

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private tasksPanel middle;

    /**
     *
     * @param list
     * @param middle
     */
    public AddToDoItemPanel(tasksPanel middle) {
        this.middle = middle;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        final JButton addButton = new JButton("Add new ToDo");
        addButton.setActionCommand("button");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (addButton == ae.getSource()) {
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ToDoItemPopup opt = new ToDoItemPopup(frame, true);
                    if ((opt.getTitle() != null) && (opt.getDescription() != null)) {
                        String title = opt.getTitle();
                        String description = opt.getDescription();
                        ToDoItem tdi = new ToDoItem(title, description);
                        middle.addItem(tdi);
                    }
                }
            }
        });
        this.add(addButton);
    }
}