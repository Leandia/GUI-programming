package todomanager;

import Actions.AddItemPopupAction;
import java.awt.Dimension;
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
        
        pane.add(TODOManager.manager.getBundle().getString("all"),new TaskPanel());
        pane.add(TODOManager.manager.getBundle().getString("today"),new TaskPanel());
        pane.add(TODOManager.manager.getBundle().getString("tomorrow"),new TaskPanel());        
        pane.add(TODOManager.manager.getBundle().getString("this_week"),new TaskPanel());
        pane.add(TODOManager.manager.getBundle().getString("old"),new TaskPanel());
        
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
                TODOManager.backend.filterByTime(filter);
            }
        });
        
        this.add(pane,btn);
    }
}