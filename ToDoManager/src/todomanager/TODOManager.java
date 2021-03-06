package todomanager;

import Actions.AddCategoryAction;
import Actions.AddItemPopupAction;
import Actions.QuitAction;
import Actions.SelectEnglishAsLanguageAction;
import Actions.SelectSwedishAsLanguageAction;
import backend.BackendAPI;
import backend.LanguageManager;
import backend.State;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

/**
 *
 * @author Vita, Daniel
 */
public class TODOManager {

    public static State savedSettings;
    public static LanguageManager manager;
    public static MetalTheme theme;    
    JCheckBoxMenuItem changeLanguageToSwedish;
    JCheckBoxMenuItem changeLanguageToEnglish;
    JFrame mainWindow;
    JMenu file;
    JMenuItem quit;
    JMenu edit;
    JMenuItem newItem;
    JMenu settings;
    JMenu language;
    JMenuItem eng;
    JMenuItem swe;
    TodoList todoList;
    JMenu help;
    CategoryPanel category;
    public static BackendAPI backend;

    /**
     * Constructor divides the mainwindow in two sides, left and right, and
     * inserts categories to left and todoList to the right.
     */
    public TODOManager() throws IOException {
        this.mainWindow = new JFrame("ToDo Manager");
        this.mainWindow.setPreferredSize(new Dimension(TODOManager.savedSettings.getWidth(700), TODOManager.savedSettings.getHeight(500)));
        this.mainWindow.setBounds(savedSettings.getXPos(), savedSettings.getYPos(), savedSettings.getWidth(700), savedSettings.getHeight(500));
        windowSetup();
        addMenu();
        this.mainWindow.pack();
        this.mainWindow.setVisible(true);
        this.mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                TODOManager.savedSettings.setX(mainWindow.getWidth());
                TODOManager.savedSettings.setY(mainWindow.getHeight());
                TODOManager.savedSettings.setXPos(mainWindow.getX());
                TODOManager.savedSettings.setYPos(mainWindow.getY());
                TODOManager.savedSettings.setItemIndex(backend.getIndex());
                TODOManager.savedSettings.saveState();
            }
        }));

    }

    /**
     * Setup of the mainwindow, does not pack or make it visible.
     */
    private void windowSetup() throws IOException {
        mainWindow.setLayout(new GridBagLayout());

        category = new CategoryPanel();
        GridBagConstraints categoryConstraints = new GridBagConstraints();
        categoryConstraints.fill = GridBagConstraints.BOTH;
        categoryConstraints.gridx = 0;
        categoryConstraints.gridy = 0;
        categoryConstraints.weighty = 1.0;
        this.mainWindow.getContentPane().add(category, categoryConstraints);

        todoList = new TodoList();
        GridBagConstraints todoListConstraints = new GridBagConstraints();
        todoListConstraints.fill = GridBagConstraints.BOTH;
        todoListConstraints.gridx = 1;
        todoListConstraints.gridy = 0;
        todoListConstraints.weighty = 1.0;
        todoListConstraints.weightx = 1.0;
        this.mainWindow.getContentPane().add(todoList, todoListConstraints);
    }

    /**
     * Adds the menu to the mainwindow.
     */
    private void addMenu() {
        JMenuBar menu = new JMenuBar();

        file = new JMenu(manager.getBundle().getString("file"));
        menu.add(file);
        quit = new JMenuItem(manager.getBundle().getString("quit"));
        QuitAction leftAction = new QuitAction(manager.getBundle().getString("quit"), "This is the quit button.");
        file.add(leftAction);//file.add(quit);

        edit = new JMenu(manager.getBundle().getString("edit"));
        menu.add(edit);
        newItem = new JMenuItem(new AddItemPopupAction(TODOManager.manager.getBundle().getString("buttontext")));
        edit.add(newItem);
        edit.add(new JMenuItem(new AddCategoryAction(TODOManager.manager.getBundle().getString("add_category"))));
        
        settings = new JMenu(manager.getBundle().getString("settings"));
        
        language = new JMenu(manager.getBundle().getString("language"));
        
        changeLanguageToSwedish = new JCheckBoxMenuItem(new SelectSwedishAsLanguageAction(manager.getBundle().getString("swedish"))); 
        changeLanguageToEnglish = new JCheckBoxMenuItem(new SelectEnglishAsLanguageAction(manager.getBundle().getString("english"))); 
        
        ButtonGroup group = new ButtonGroup();
        group.add(changeLanguageToSwedish);
        group.add(changeLanguageToEnglish);
        language.add(changeLanguageToSwedish);
        language.add(changeLanguageToEnglish);
        
        switch(savedSettings.getLanguage()){
            case "Swedish":
                changeLanguageToSwedish.setSelected(true);
                break;
            case "English":
                changeLanguageToEnglish.setSelected(true);
                break;
        }
         
        settings.add(language);
        menu.add(settings);

        help = new JMenu(manager.getBundle().getString("help"));
        menu.add(help);

        this.mainWindow.setJMenuBar(menu);

    }
    
    /**
     * Updates all internationalized components belonging
     * to the TODOManager class given the set locale. 
     */
    private void updateLabels(){
        this.file.setText(manager.getBundle().getString("file"));
        this.quit.setText(manager.getBundle().getString("quit"));
        file.removeAll();
        file.add(new QuitAction(manager.getBundle().getString("quit"),"This is the quit button."));
        this.edit.setText(manager.getBundle().getString("edit"));
        edit.removeAll();
        edit.add(new JMenuItem(new AddItemPopupAction(TODOManager.manager.getBundle().getString("add_item"))));
        edit.add(new JMenuItem(new AddCategoryAction(TODOManager.manager.getBundle().getString("add_category"))));
        
        
        this.settings.setText(manager.getBundle().getString("settings"));
        this.language.setText(manager.getBundle().getString("language"));
        
        language.removeAll();
        changeLanguageToSwedish = new JCheckBoxMenuItem(new SelectSwedishAsLanguageAction(manager.getBundle().getString("swedish"))); 
        changeLanguageToEnglish = new JCheckBoxMenuItem(new SelectEnglishAsLanguageAction(manager.getBundle().getString("english")));
        language.add(changeLanguageToSwedish);
        language.add(changeLanguageToEnglish);
        
        switch(savedSettings.getLanguage()){
            case "Swedish":
                changeLanguageToSwedish.setSelected(true);
                break;
            case "English":
                changeLanguageToEnglish.setSelected(true);
                break;
        }
        
        this.help.setText(manager.getBundle().getString("help"));
        
    }

    /**
     * Method is called on localechange and calls all methods for updating the
     * GUI components that are internationalized
     */
    public void changeLocale() {
        this.todoList.top.updateLabels();
        updateLabels();
    }

    public static void main(String[] args) throws IOException {
        theme = new Theme();
        MetalLookAndFeel.setCurrentTheme(theme);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TODOManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TODOManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TODOManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TODOManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        savedSettings = new State();
        savedSettings.loadState();
        backend = new BackendAPI(savedSettings.getItemIndex());
        manager = new LanguageManager();
        TODOManager main = new TODOManager();
        manager.setTodoManager(main);
        
        Timer timer = new Timer();
        TaskReminder reminder = new TaskReminder();
        timer.schedule(reminder,0,1*60000);
    }
}
