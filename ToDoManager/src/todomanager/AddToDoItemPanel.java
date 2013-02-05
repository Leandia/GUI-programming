
package todomanager;

/*
 * HelloWorldSwing.java requires no other files. 
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class AddToDoItemPanel extends JPanel {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static ArrayList <ToDoItem> myArr = new ArrayList<ToDoItem>();;
    static JLabel titleLabel;
    static JLabel descriptionLabel;
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        //final JFrame frame = new JFrame("");
        final JPanel panel = new JPanel();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        //titleLabel = new JLabel("");
        //descriptionLabel = new JLabel("");
        
        final JButton addButton = new JButton("Add new ToDo");
        addButton.setActionCommand("button");
        
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(addButton == ae.getSource()){
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ToDoItemPopup opt = new ToDoItemPopup(frame, true);
                    if ((opt.getTitle() != null) && (opt.getDescription() != null)){
                        String title = opt.getTitle();
                        System.err.println("Title is: "+ title);
                        String description = opt.getDescription();
                        System.err.println("Description is: "+description);
                        ToDoItem tdi = new ToDoItem(title,description);
                        myArr.add(tdi);
                        System.err.println("ToDoItem was succesfully created");
                        }
                }
            }
        });
        
        panel.add(addButton);
        panel.add(titleLabel);
        panel.add(descriptionLabel);
        
        //frame.getContentPane().add(panel);
        //Display the window.
        //frame.pack();
        //frame.setVisible(true);
    }

   /* 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}