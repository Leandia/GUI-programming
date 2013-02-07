package todomanager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewItemPopup extends JDialog implements ActionListener {

    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private JLabel titleLabel = null;
    private JTextField titleTextField = null;
    private JLabel descriptionLabel = null;
    private JTextField descriptionTextField = null;
    private String title;
    private String description;
/**
 * Constructor for NewItemPopup
 * @param frame the frame the NewItemPopup appears in
 * @param modal a boolean which decides if the NewItemPopup will be a modal or not 
 */
    
    public NewItemPopup(JFrame frame, boolean modal) {
        //JFrame frame = new JFrame();
        super(frame, modal);
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        getContentPane().add(myPanel);

        titleLabel = new JLabel("Title:");
        myPanel.add(titleLabel);
        titleTextField = new JTextField(10);
        myPanel.add(titleTextField);
        descriptionLabel = new JLabel("Description: ");
        myPanel.add(descriptionLabel);
        descriptionTextField = new JTextField(10);
        myPanel.add(descriptionTextField);
        yesButton = new JButton("Add");
        yesButton.addActionListener(this);
        myPanel.add(yesButton);
        noButton = new JButton("Cancel");
        noButton.addActionListener(this);
        myPanel.add(noButton);

        //Display the window.
        pack();
        setVisible(true);
    }
    
/**
 * Getter method to get the text from the title textfield
 * @return title a string containing the title from the title text field
 */
    public String getTitle() {
        return title;
    }

/**
 * Getter method to get the text from the description textfield
 * @return title a string containing the description from the title text field
 */
    public String getDescription() {
        return description;
    }

/**
 * Binds the text in the title and description textfield to the strings title and
 * description
 */
    public void actionPerformed(ActionEvent e) {
        if (yesButton == e.getSource()) {
            //System.err.println("User chose yes.");
            if (!titleTextField.getText().equals("")) {
                title = titleTextField.getText();
            }
            if (!descriptionTextField.getText().equals("")) {
                description = descriptionTextField.getText();
            }
            setVisible(false);
        } else if (noButton == e.getSource()) {
            //System.err.println("User chose no.");
            title = null;
            description = null;
            setVisible(false);
        }
    }
}