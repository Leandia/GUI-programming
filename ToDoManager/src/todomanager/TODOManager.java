package todomanager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    JFrame mainWindow;

    public TODOManager() {
        this.mainWindow = new JFrame("ToDo Manager");
        mainWindow.setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());

        
        this.mainWindow.add(mainPanel);
        
        mainPanel.setPreferredSize(new Dimension(700, 500));

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
        
        this.mainWindow.pack();
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    private void addMenu() {
        JMenuBar menu = new JMenuBar();
        
        JMenu file = new JMenu("File");
        menu.add(file);
        
        JMenu edit = new JMenu("Edit");
        menu.add(edit);
        
        JMenu help = new JMenu("Help");
        menu.add(help);
        
        
        JMenuItem quit = new JMenuItem("Quit");
        file.add(quit);
        
        this.mainWindow.add(menu);
    }

    public static void main(String[] args) {
        TODOManager main = new TODOManager();
    }
}
