package todomanager;

import backend.State;
import Actions.QuitAction;
import Actions.SelectEnglishAsLanguageAction;
import Actions.SelectSwedishAsLanguageAction;
import backend.BackendAPI;
import backend.LanguageManager;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    public static State savedSettings;
    public static LanguageManager manager = new LanguageManager();
    JFrame mainWindow;
    JMenu file;
    JMenuItem quit;
    JMenu edit;
    JMenu settings;
    JMenu language;
    JMenuItem eng;
    JMenuItem swe;
    JMenu help;
    CategoryPanel category;
    public static final BackendAPI backend = new BackendAPI();
    
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
        
        category = new CategoryPanel();
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
        QuitAction leftAction = new QuitAction(manager.getBundle().getString("quit"), "This is the quit button.");
        file.add(leftAction);
        //file.add(quit);

        edit = new JMenu(manager.getBundle().getString("edit"));
        menu.add(edit);

        settings = new JMenu(manager.getBundle().getString("settings"));
        language = new JMenu(manager.getBundle().getString("language"));
        
        language.add(new SelectEnglishAsLanguageAction(manager.getBundle().getString("english")));
        language.add(new SelectSwedishAsLanguageAction(manager.getBundle().getString("swedish")));
        settings.add(language);
        menu.add(settings);
        
        help = new JMenu(manager.getBundle().getString("help"));
        menu.add(help);

        this.mainWindow.setJMenuBar(menu);
    }  
         
    public static State getState(){
        return savedSettings;
    }
    
    public static void main(String[] args) {
        
        /**
         * Saves settings on program exit
         */
        BackendAPI bapi = new BackendAPI();
        bapi.createDatabase();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                TODOManager.savedSettings.saveState();
            }
        }));
        
        savedSettings = new State();
        savedSettings.loadState();
        TODOManager main = new TODOManager();
        
    }
    
    public static LanguageManager getManager() {
        return manager;
    }
}
