package todomanager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class NewItemPopup extends JDialog implements ActionListener {

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
        titleLabel = new JLabel("Title:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        myPanel.add(titleLabel, constraints);
        //1,2
        titleTextField = new JTextField(10);
        constraints.gridx = 1;
        myPanel.add(titleTextField, constraints);
        //2,1
        descriptionLabel = new JLabel("Description: ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        myPanel.add(descriptionLabel, constraints);
        //2,2
        descriptionTextField = new JTextField(10);
        constraints.gridx = 1;
        myPanel.add(descriptionTextField, constraints);
        //3,1
        categoryLabel = new JLabel("Category: ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        myPanel.add(categoryLabel, constraints);
        //3,2
        categoryTextField = new JTextField("Default", 10);
        constraints.gridx = 1;
        myPanel.add(categoryTextField, constraints);
        //4,1
        dateLabel = new JLabel("Date (YYMMDD): ");
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
        //5,1
        priorityLabel = new JLabel("Priority: ");
        constraints.gridx = 0;
        constraints.gridy = 4;
        myPanel.add(priorityLabel, constraints);
        //5,2
        priorityMenu = new JComboBox(prioList);
        priorityMenu.setSelectedIndex(0);
        constraints.gridx = 1;
        myPanel.add(priorityMenu, constraints);
        //6,1
        yesButton = new JButton("Add");
        yesButton.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 5;
        myPanel.add(yesButton, constraints);
        //6,2
        noButton = new JButton("Cancel");
        noButton.addActionListener(this);
        constraints.gridx = 1;
        myPanel.add(noButton, constraints);

        //Display the window.
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (yesButton == e.getSource()) {
            //System.err.println("User chose yes.");
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
            setVisible(false);
        } else if (noButton == e.getSource()) {
            //System.err.println("User chose no.");
            title = null;
            description = null;
            setVisible(false);
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

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
}