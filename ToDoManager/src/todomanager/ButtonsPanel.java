package todomanager;

import Actions.AddItemPopupAction;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import values.TimeFilter;

/**
 *
 * @author Emil
 * @author Kristian
 */
public class ButtonsPanel extends JPanel {

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private JButton addButton;
    private JTabbedPane pane;
    /**
     *
     * @param list
     * @param middle
     */
    public ButtonsPanel() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        addButton = new JButton();
        setLayout(new GridBagLayout());
        GridBagConstraints btn = new GridBagConstraints();
        btn.gridx = 1;
        btn.gridy = 0;
        btn.weightx = 1;
        btn.weighty = 1;;
        this.add(addButton,btn);
        
        btn.gridx = 0;
        btn.gridy = 1;
        btn.fill = GridBagConstraints.BOTH;
        btn.anchor = GridBagConstraints.WEST;
        btn.gridwidth = 2;
        
        pane = new JTabbedPane();
        pane.setPreferredSize(new Dimension(200,1500));
        
        //Set title for each tab
        updateLabels();
        
        pane.addChangeListener(new ChangeListener() {

            /**
             * Called when user changes tabs
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane pane = (JTabbedPane) e.getSource();
                int index = pane.getSelectedIndex();
                TimeFilter filter;
                
                switch(index){
                    case 1:
                        filter = TimeFilter.TODAY;
                        break;
                    case 2:
                        filter = TimeFilter.TOMORROW;
                        break;
                    case 3:
                        filter = TimeFilter.THIS_WEEK;
                        break;
                    case 4:
                        filter = TimeFilter.OLD;
                        break;
                    default:
                        filter = TimeFilter.ALL;
                        break;
                }
                
                
                TODOManager.savedSettings.setFiltering(filter);
                TODOManager.backend.setFilter(filter);
                TODOManager.backend.viewChange();
            }
        });
        //Sets the initial selected tab, default will be "all"
        pane.setSelectedIndex(setTab(TODOManager.savedSettings.getFilter()));
        TODOManager.backend.viewChange();
        this.add(pane,btn);
    }
    
    /**
     * Sets tab using the input filter constant
     * @param filter Which tab to set from startup
     * @return Index of that tab
     */
    private int setTab(TimeFilter filter){
        switch(filter){
                    case TODAY:
                        return 1;
                    case TOMORROW:
                        return 2;
                    case THIS_WEEK:
                        return 3;
                    case OLD:
                        return 4;
                    default:
                        return 0;
                }
    }

    /**
     * Function that sets all internationalized components
     * belonging to the buttonpanel.
     */
    public void updateLabels(){
        //Creates a taskpanel for each tab in the panel. First needs to remove
        //any previous components. 
        pane.removeAll();
        
        //Adds the panel and a label to each of the tabs accordingly.
        pane.add(new TaskPanel(),TODOManager.manager.getBundle().getString("all"));
        pane.add(new TaskPanel(),TODOManager.manager.getBundle().getString("today"));
        pane.add(new TaskPanel(),TODOManager.manager.getBundle().getString("tomorrow"));        
        pane.add(new TaskPanel(),TODOManager.manager.getBundle().getString("this_week"));
        pane.add(new TaskPanel(),TODOManager.manager.getBundle().getString("old"));
        this.addButton.setAction(new AddItemPopupAction());
    }
}