package todomanager;

import Actions.AddCategoryAction;
import backend.CategoryListModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The left side of the main window displaying time and categories.
 * @author vita, daniel
 * @author Kristian
 */
public class CategoryPanel extends JPanel {

    private JList list;
    private CategoryListModel model = TODOManager.backend.getCategoryListModel();
    
    /**
     * The left side of the main window, will be divided and show time at the
     * top and categories in the middle and buttons to make/delete categories at
     * the bottom.
     */
    public CategoryPanel() throws IOException {
        setMinimumSize(new Dimension(200, 200));
        setLayout(new GridBagLayout());
        setBackground(TODOManager.theme.getWindowBackground());
        addNewCategoryList();
        addClock();
        addAddCategoryButton();
    }

    /**
     * Adds list of categories to the interface in a form of a jlist
     */
    private void addNewCategoryList() {
        list = new JList(model);
        
        //Add a selectionlistener that listens for change in row 
        list.addListSelectionListener(new ListSelectionListener() {
        
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                TODOManager.backend.setSelectedCategory(model.getElementAt(list.getSelectedIndex()).toString());
                TODOManager.backend.viewChange();
            }
        });
        
        //Adds a keylistener as we are deleting items with the delete
        //key
        list.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
                
            }

            @Override
            public void keyPressed(KeyEvent ke) {                
                //You can delete categories using the delete key, a confirm dialog
                //will popup for the user to answer to
                if(ke.getKeyCode() == KeyEvent.VK_DELETE){
                    
                    //You shouldnt be able to delete the category All, appropriate dialog
                    //is shown if you try
                    if(!list.getSelectedValue().equals(TODOManager.backend.getCategoryListModel().getElementAt(0)))
                    {
                        int result = JOptionPane.showConfirmDialog(null, TODOManager.manager.getBundle().getString("catequestion"));
                        if(result == JOptionPane.YES_OPTION && !model.getList().get(list.getSelectedIndex()).getCategoryTitle().equals(TODOManager.manager.getBundle().getString("all"))){
                            TODOManager.backend.deleteCategory((model.getList().get(list.getSelectedIndex())));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, TODOManager.manager.getBundle().getString("cantDelete"));
                    }
                }
                
                
            }

            @Override
            public void keyReleased(KeyEvent ke) {                
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
        
        Clock clock = new Clock();
        
        //Put the clock in its own thread.
        Thread thread = new Thread(clock,"thread1");
        thread.start();
        
        clock.setPreferredSize(new Dimension(150, 150));
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = .1;
        
        this.add(clock, c);
    }
    
    /**
     * Adds a add category button to the panel. 
     * @throws IOException 
     */
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
