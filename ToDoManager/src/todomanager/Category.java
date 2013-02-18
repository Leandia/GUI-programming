package todomanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 */
public class Category extends JPanel {

    private JComboBox selectLanguage;
    private JLabel categories;
    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public Category() {
        this.setBackground(Color.red);
        this.setPreferredSize(new Dimension(200, 200));
        categories = new JLabel(TODOManager.manager.getBundle().getString("categories"));
        addLanguageSelection();
        this.add(this.selectLanguage);
        this.add(categories);
    }

    /**
     * Temporary for test purposes, will have Action instead later
     */
    private void addLanguageSelection() {
        selectLanguage = new JComboBox();
        for (int i=0;i<TODOManager.manager.getLanguages().length;i++){
            selectLanguage.addItem(TODOManager.manager.getLanguages()[i]);
        }        
        selectLanguage.setEditable(false);
        selectLanguage.addActionListener(new ActionListener() {
        

            @Override
            public void actionPerformed(ActionEvent e) {
                TODOManager.manager.UpdateLanguage(selectLanguage.getSelectedItem().toString());
            }
        });
        
        
    }    
}
