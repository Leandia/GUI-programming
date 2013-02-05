package todomanager;

import java.awt.GridLayout;
import javax.swing.JDialog; 
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ToDoItemPopup extends JDialog implements ActionListener {
    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private JLabel titleLabel = null;
    private JTextField titleTextField = null;
    private JLabel descriptionLabel = null;
    private JTextField descriptionTextField = null;
    private String title;
    private String description;
    
    public String getTitle(){
        return title; 
    }
    
    public String getDescription(){
        return description; 
    }
    
    
    public ToDoItemPopup(JFrame frame, boolean modal) {
        //JFrame frame = new JFrame();
        super(frame,modal);
        myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3,2));  
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

    public void actionPerformed(ActionEvent e) {
        if(yesButton == e.getSource()) {
            //System.err.println("User chose yes.");
            if(!titleTextField.getText().equals("")){
                title = titleTextField.getText();
            }
            if(!descriptionTextField.getText().equals("")){
                description = descriptionTextField.getText();
            }
            setVisible(false);
        }
        else if(noButton == e.getSource()) {
            //System.err.println("User chose no.");
            title = null;
            description = null;
            setVisible(false);
        }
    }
    
}