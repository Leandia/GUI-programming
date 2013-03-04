package todomanager;


import backend.Category;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 */
public class CategoryPanel extends JPanel {

    private ArrayList<Category> categoryList;
    private JLabel categories;
    private JComboBox catCombo;
    
    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public CategoryPanel() {
        this.setMinimumSize(new Dimension(200, 200));
        this.setLayout(new BorderLayout());
        categories = new JLabel(TODOManager.manager.getBundle().getString("categories"));
        JPanel clock = new JPanel();
        clock.setBackground(Color.DARK_GRAY);
        clock.setPreferredSize(new Dimension(150, 150));
        this.categoryList = TODOManager.backend.getCategories();
        catCombo = new JComboBox();
        displayCategories();
        this.add(clock, BorderLayout.NORTH);
        this.add(categories, BorderLayout.CENTER);
        this.add(catCombo,BorderLayout.SOUTH);
        
        
    }
    
    public void updateLabels(){
        this.categories.setText(TODOManager.manager.getBundle().getString("categories"));
    }
    
    //Temporary way of selecting categories, not sure how we wanna do this. 
    //No matter what this is probably not the way to go so shouldnt be final
    private void displayCategories(){
        Iterator iterator = this.categoryList.iterator();
        Category category;
        this.catCombo.addItem("All");
        while(iterator.hasNext()){
            category = (Category) iterator.next();
            this.catCombo.addItem(category.getCategoryTitle());
            catCombo.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    TODOManager.backend.setSelectedCategory(catCombo.getSelectedItem().toString());
                    TODOManager.backend.viewChange();
                }
            });
        }
        
        this.catCombo.setSelectedItem(TODOManager.savedSettings.getSelectedCategory());
    }
}
