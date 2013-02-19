package todomanager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    static State savedSettings;
    static LanguageManager manager;
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
        LeftAction leftAction = new LeftAction(manager.getBundle().getString("quit"), "This is the quit button.");
        file.add(leftAction);
        //file.add(quit);

        edit = new JMenu(manager.getBundle().getString("edit"));
        menu.add(edit);

        settings = new JMenu("settings");
        language = new JMenu("language");
        
        language.add(new SelectEnglishAsLanguageAction(manager.getBundle().getString("english")));
        language.add(new SelectSwedishAsLanguageAction(manager.getBundle().getString("swedish")));
        settings.add(language);
        menu.add(settings);
        
        help = new JMenu(manager.getBundle().getString("help"));
        menu.add(help);

        this.mainWindow.setJMenuBar(menu);
    }
    
     public class LeftAction extends AbstractAction {
        public LeftAction(String text,String desc) {
            super(text);
            putValue(SHORT_DESCRIPTION, desc);
            }
        public void actionPerformed(ActionEvent e) {
            TODOManager.savedSettings.saveState();
            System.err.println("Quit!");
            System.exit(0);
        }
    }
     
     public class SelectEnglishAsLanguageAction extends AbstractAction{
         
         private final String eng = "English";
         
         public SelectEnglishAsLanguageAction(String text){
             super(text);
         }

        @Override
        public void actionPerformed(ActionEvent ae) {
            TODOManager.savedSettings.setSelectedLanguage(eng);
        }
     }
     
     public class SelectSwedishAsLanguageAction extends AbstractAction{
         
         private final String swe = "Swedish";
         
         public SelectSwedishAsLanguageAction(String text){
             super(text);
         }

        @Override
        public void actionPerformed(ActionEvent ae) {
            TODOManager.savedSettings.setSelectedLanguage(swe);
        }
     }
    
     
    
    
    public static void main(String[] args) {
        savedSettings = new State();
        savedSettings.loadState();
        manager = new LanguageManager();
        TODOManager main = new TODOManager();       
    }
}
