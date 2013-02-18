package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    static LanguageManager manager = new LanguageManager();
    JFrame mainWindow;
    JMenu file;
    JMenuItem quit;
    JMenu edit;
    JMenu help;
    Category category;
    /**
     * Constructor divides the mainwindow in two sides, left and right, and
     * inserts categories to left and todoList to the right.
     */
    public TODOManager() {
        this.mainWindow = new JFrame("ToDo Manager");
        this.mainWindow.setPreferredSize(new Dimension(700,500));
        windowSetup();
        addMenu();

        this.mainWindow.pack();
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Setup of the mainwindow, does not pack or make it visible.
     */
    private void windowSetup() {        
        mainWindow.setLayout(new GridBagLayout());
        
        category = new Category();
        GridBagConstraints categoryConstraints = new GridBagConstraints();
        categoryConstraints.fill = GridBagConstraints.BOTH;
        categoryConstraints.gridx = 0;
        categoryConstraints.gridy = 0;
        categoryConstraints.weighty = 1.0;
        this.mainWindow.getContentPane().add(category, categoryConstraints);

        TodoList todoList = new TodoList();
        GridBagConstraints todoListConstraints = new GridBagConstraints();
        todoListConstraints.fill = GridBagConstraints.BOTH;
        todoListConstraints.gridx = 1;
        todoListConstraints.gridy = 0;
        todoListConstraints.weighty = 1.0;
        todoListConstraints.weightx = 1.0;        
        this.mainWindow.getContentPane().add(todoList, todoListConstraints);

        //mainPanel.add(todoList, todoListConstraints);
        //this.mainWindow.add(mainPanel);
    }

    /**
     * Adds the menu to the mainwindow.
     */
    private void addMenu() {
        //addMenu();
        JMenuBar menu = new JMenuBar();

        file = new JMenu(manager.getBundle().getString("file"));
        menu.add(file);
        quit = new JMenuItem(manager.getBundle().getString("quit"));
        file.add(quit);

        edit = new JMenu(manager.getBundle().getString("edit"));
        menu.add(edit);

        help = new JMenu(manager.getBundle().getString("help"));
        menu.add(help);

        this.mainWindow.setJMenuBar(menu);
    }
    
    public static void main(String[] args) {
        TODOManager main = new TODOManager();       
    }
}
