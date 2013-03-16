package todomanager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Popup thats created for adding new categories. Provides one input field only
 * @author Kristian
 */
public class NewCategoryPopup extends JDialog {
    private JTextField inputName;
    private JLabel category;
    private JPanel mainPanel;
    private JButton yBtn;
    private JButton nBtn;
    GridBagConstraints c = new GridBagConstraints();
    
    public NewCategoryPopup(JFrame frame){
        super(frame,TODOManager.manager.getBundle().getString("add_new_category"));
        mainPanel = new JPanel(new GridBagLayout());
        this.getContentPane().add(mainPanel);
        
        category = new JLabel(TODOManager.manager.getBundle().getString("cat_title"));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(category,c);
        
        c.gridx = 1;
        inputName = new JTextField();
        mainPanel.add(inputName,c);
        
        c.gridx = 0;
        c.gridy = 1;
        yBtn = new JButton(new AddButton(this));
        mainPanel.add(yBtn,c);
        
        c.gridx = 1;
        nBtn = new JButton(new CancelButton(this));
        mainPanel.add(nBtn,c);
        
        
        pack();
        setVisible(true);
        
    }


    /**
     * Inner class, provides action for the add category button
     */
    private class AddButton extends AbstractAction{
        
        private NewCategoryPopup window;
        
        private AddButton(NewCategoryPopup popup){
            super(TODOManager.manager.getBundle().getString("add"));
            window = popup;            
        }
                
        @Override
        public void actionPerformed(ActionEvent ae) {
            boolean createCategory = false;
            String title = this.window.inputName.getText();
            if(InputUtility.validateString(title, 70)){
                createCategory = true;                
            }
            
            if(createCategory){
                TODOManager.backend.createCategory(title);
                window.setVisible(false);
            }
            
        }
    
    }
    
    /**
     * Inner class that provides action for the cancel button. 
     */
    private class CancelButton extends AbstractAction{
        
        private NewCategoryPopup window;
        
        private CancelButton(NewCategoryPopup popup){
            super(TODOManager.manager.getBundle().getString("cancel"));
            window = popup;            
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            this.window.setVisible(false);
        }
    
    }

}