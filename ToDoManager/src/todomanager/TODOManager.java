package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    JFrame mainWindow;

    /**
     * Constructor divides the mainwindow in two sides, left and right, and
     * inserts categories to left and todoList to the right.
     */
    public TODOManager() {
        this.mainWindow = new JFrame("ToDo Manager");

        windowSetup();
        addMenu();

        this.mainWindow.setPreferredSize(new Dimension(700, 500));
        this.mainWindow.pack();
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Setup of the mainwindow, does not pack or make it visible.
     */
    private void windowSetup() {
        JPanel mainPanel = new JPanel(new GridBagLayout());

        Category category = new Category();
        GridBagConstraints categoryConstraints = new GridBagConstraints();
        categoryConstraints.fill = GridBagConstraints.BOTH;
        categoryConstraints.gridx = 0;
        categoryConstraints.gridy = 0;
        categoryConstraints.weighty = 1.0;
        mainPanel.add(category, categoryConstraints);

        TodoList todoList = new TodoList();
        GridBagConstraints todoListConstraints = new GridBagConstraints();
        todoListConstraints.fill = GridBagConstraints.BOTH;
        todoListConstraints.gridx = 1;
        todoListConstraints.gridy = 0;
        todoListConstraints.weighty = 1.0;
        todoListConstraints.weightx = 1.0;
        mainPanel.add(todoList, todoListConstraints);

        this.mainWindow.add(mainPanel);
    }

    /**
     * Adds the menu to the mainwindow.
     */
    private void addMenu() {
        //addMenu();
        JMenuBar menu = new JMenuBar();

        JMenu file = new JMenu("File");
        menu.add(file);
        JMenuItem quit = new JMenuItem("Quit");
        file.add(quit);

        JMenu edit = new JMenu("Edit");
        menu.add(edit);

        JMenu help = new JMenu("Help");
        menu.add(help);

        this.mainWindow.setJMenuBar(menu);
    }

    public static void main(String[] args) {
        TODOManager main = new TODOManager();
    }
}
