package todomanager;

import backend.ToDoItem;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import values.Priority;

/**
 *
 * @author Emil
 * @author Daniel
 */
public class NewItemPopup extends JDialog {

    private JPanel myPanel = null;
    private JButton yesButton = null;
    private JButton noButton = null;
    private JLabel titleLabel = null;
    private JTextField titleTextField = null;
    private JLabel descriptionLabel = null;
    private JTextField descriptionTextField = null;
    private JLabel categoryLabel = null;
    private JTextField categoryTextField = null;
    private JLabel dateLabel = null;
    private JTextField yearTextField = null;
    private JTextField monthTextField = null;
    private JTextField dayTextField = null;
    private JLabel timeLabel = null;
    private JTextField hourTextField = null;
    private JTextField minutesTextField = null;
    private JLabel priorityLabel = null;
    private JComboBox priorityMenu = null;
    private Priority[] prioList = {Priority.LOW,
        Priority.MEDIUM, Priority.HIGH};
    // Choosable values.
    private String title;
    private String description;
    private String category;
    private GregorianCalendar date;
    private Priority prio;
    private ToDoItem item;

    public NewItemPopup(JFrame frame, boolean modal) {
        //JFrame frame = new JFrame();
        super(frame, modal);
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        getContentPane().add(myPanel);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = 1;
        constraints.weighty = 1;

        //1,1
        titleLabel = new JLabel(TODOManager.manager.getBundle().getString("title"));
        constraints.gridx = 0;
        constraints.gridy = 0;
        myPanel.add(titleLabel, constraints);
        //1,2
        titleTextField = new JTextField(10);
        constraints.gridx = 1;
        myPanel.add(titleTextField, constraints);
        //2,1
        descriptionLabel = new JLabel(TODOManager.manager.getBundle().getString("description"));
        constraints.gridx = 0;
        constraints.gridy = 1;
        myPanel.add(descriptionLabel, constraints);
        //2,2
        descriptionTextField = new JTextField(10);
        constraints.gridx = 1;
        myPanel.add(descriptionTextField, constraints);
        //3,1
        categoryLabel = new JLabel(TODOManager.manager.getBundle().getString("category"));
        constraints.gridx = 0;
        constraints.gridy = 2;
        myPanel.add(categoryLabel, constraints);
        //3,2
        categoryTextField = new JTextField("Default", 10);
        constraints.gridx = 1;
        myPanel.add(categoryTextField, constraints);
        //4,1
        dateLabel = new JLabel(TODOManager.manager.getBundle().getString("date"));
        constraints.gridx = 0;
        constraints.gridy = 3;
        myPanel.add(dateLabel, constraints);
        //4,2
        JPanel dates = new JPanel(new GridBagLayout());
        GridBagConstraints datesConstraints = new GridBagConstraints();
        datesConstraints.weightx = 1;
        datesConstraints.weighty = 1;
        datesConstraints.gridx = 0;
        datesConstraints.gridy = 0;
        GregorianCalendar d = new GregorianCalendar();
        yearTextField = new JTextField("" + d.get(Calendar.YEAR), 4);
        dates.add(yearTextField, datesConstraints);
        datesConstraints.gridx = 1;
        monthTextField = new JTextField("" + (d.get(Calendar.MONTH) + 1), 2);
        dates.add(monthTextField, datesConstraints);
        datesConstraints.gridx = 2;
        dayTextField = new JTextField("" + d.get(Calendar.DATE), 2);
        dates.add(dayTextField, datesConstraints);
        constraints.gridx = 1;
        myPanel.add(dates, constraints);

        //5.1
        timeLabel = new JLabel(TODOManager.manager.getBundle().getString("time"));
        constraints.gridx = 0;
        constraints.gridy = 4;
        myPanel.add(timeLabel, constraints);

        //5.2
        JPanel time = new JPanel(new GridBagLayout());
        GridBagConstraints timeConstraints = new GridBagConstraints();
        timeConstraints.weightx = 1;
        timeConstraints.weighty = 1;
        timeConstraints.gridx = 0;
        timeConstraints.gridy = 0;
        hourTextField = new JTextField(2);
        time.add(hourTextField, timeConstraints);
        timeConstraints.gridx = 1;
        minutesTextField = new JTextField(2);
        time.add(minutesTextField, timeConstraints);
        timeConstraints.gridx = 2;
        constraints.gridx = 1;
        myPanel.add(time, constraints);

        //6,1
        priorityLabel = new JLabel(TODOManager.manager.getBundle().getString("priority"));
        constraints.gridx = 0;
        constraints.gridy = 5;
        myPanel.add(priorityLabel, constraints);
        //6,2
        priorityMenu = new JComboBox(prioList);
        priorityMenu.setSelectedIndex(0);
        constraints.gridx = 1;
        myPanel.add(priorityMenu, constraints);
        //7,1
        yesButton = new JButton(new yesButton());
        constraints.gridx = 0;
        constraints.gridy = 6;
        myPanel.add(yesButton, constraints);
        //7,2
        noButton = new JButton(new noButton());
        constraints.gridx = 1;
        myPanel.add(noButton, constraints);

        //Display the window.
        pack();
        setVisible(true);
    }

    /**
     * Inner class for the yes button.
     */
    private class yesButton extends AbstractAction {

        public yesButton() {
            super(TODOManager.manager.getBundle().getString("add"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!titleTextField.getText().equals("")) {
                title = titleTextField.getText();
            }
            if (!descriptionTextField.getText().equals("")) {
                description = descriptionTextField.getText();
            }
            if (!categoryTextField.getText().equals("")) {
                category = categoryTextField.getText();
            }
            if (!yearTextField.getText().equals("")
                    && !monthTextField.getText().equals("")
                    && !dayTextField.getText().equals("")) {
                date = new GregorianCalendar(Integer.parseInt(yearTextField.getText()),
                        Integer.parseInt(monthTextField.getText()),
                        Integer.parseInt(dayTextField.getText()));
            }
            prio = (Priority) priorityMenu.getSelectedItem();
            item = new ToDoItem(0, title, description, category, prio, date);
            setVisible(false);
        }
    }

    /**
     * Inner class for the no button.
     */
    private class noButton extends AbstractAction {

        public noButton() {
            super(TODOManager.manager.getBundle().getString("cancel"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            title = null;
            description = null;
            item = null;
            setVisible(false);
        }
    }

    /**
     * Getter method to get the text from the title textfield
     *
     * @return title a string containing the title from the title text field
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method to get the text from the description textfield
     *
     * @return title a string containing the description from the title text
     * field
     */
    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public Priority getPriority() {
        return prio;
    }
    
    public ToDoItem getItem() {
        return item;
    }
}