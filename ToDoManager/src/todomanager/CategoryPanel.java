package todomanager;


import Actions.AddCategoryAction;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import backend.CategoryListModel;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 * @author Kristian
 */
public class CategoryPanel extends JPanel {

    private JLabel categories;
    private JList list;
    private CategoryListModel model = TODOManager.backend.getCategoryListModel();
    
    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public CategoryPanel() throws IOException {
        this.setMinimumSize(new Dimension(200, 200));
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.white);
        addNewCategoryList();
        addClock();
        addAddCategoryButton();
    }
    
    public void updateLabels(){
        this.categories.setText(TODOManager.manager.getBundle().getString("categories"));
    }

    /**
     * Adds list of categories to the interface
     */
    private void addNewCategoryList() {
        list = new JList(model);
        list.addListSelectionListener(new ListSelectionListener() {
        
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                TODOManager.backend.setSelectedCategory(model.getElementAt(list.getSelectedIndex()).toString());
                TODOManager.backend.viewChange();
            }
        });
        
        //On startup sets selected category
        list.setSelectedValue(TODOManager.savedSettings.getSelectedCategory(), true);
        
        //Set style of the list, font, text size and alignment
        list.setFont(new Font("",Font.HANGING_BASELINE,18));
        list.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public int getHorizontalAlignment() {
                return CENTER;
            }
            });
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1;
        c.weighty = 10;
        
        this.add(list,c);
        
        
    }

    /**
     * Adds the clock to the interface
     */
    private void addClock() {
        JPanel clock = new JPanel();
        clock.setBackground(Color.DARK_GRAY);
        clock.setPreferredSize(new Dimension(150, 150));
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .1;
        
        this.add(clock, c);
    }

    private void addAddCategoryButton() throws IOException {
        IconButton addCategory = new IconButton(new AddCategoryAction(),"./Resources/test.gif");
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1;
        c.weighty = .1;
        c.anchor = GridBagConstraints.SOUTH;
        
        this.add(addCategory, c);
    }

}
