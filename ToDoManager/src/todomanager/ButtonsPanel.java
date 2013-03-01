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
 */
public class ButtonsPanel extends JPanel {

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private JButton addButton;
    private TaskPanel panel_all;
    private TaskPanel panel_today;
    private TaskPanel panel_tomorrow;
    private TaskPanel panel_this_week;
    private TaskPanel panel_old;
    /**
     *
     * @param list
     * @param middle
     */
    public ButtonsPanel() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        addButton = new JButton(new AddItemPopupAction());
        addButton.setActionCommand("button");
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
        
        JTabbedPane pane = new JTabbedPane();
        panel_all = new TaskPanel();
        panel_today = new TaskPanel();
        panel_tomorrow = new TaskPanel();
        panel_this_week = new TaskPanel();
        panel_old = new TaskPanel();
        
        
        pane.add(TODOManager.manager.getBundle().getString("all"),panel_all);
        pane.add(TODOManager.manager.getBundle().getString("today"),panel_today);
        pane.add(TODOManager.manager.getBundle().getString("tomorrow"),panel_tomorrow);        
        pane.add(TODOManager.manager.getBundle().getString("this_week"),panel_this_week);
        pane.add(TODOManager.manager.getBundle().getString("old"),panel_old);
        
        pane.addChangeListener(new ChangeListener() {

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
                
                //Sets the initial selected tab, default will be "all"
                TODOManager.savedSettings.setFiltering(filter);
                TODOManager.backend.filterByTime(filter);
            }
        });
        
        pane.setSelectedIndex(setTab(TODOManager.savedSettings.getFilter()));
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
}