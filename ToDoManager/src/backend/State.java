package backend;

import Enum.Sorting;
import Enum.TimeFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * State class that holds all settings for the interface
 * @author Kristian
 */
public class State {

    private String selectedLanguage;
    private String selectedCategory;
    private String selectedSorting ="";
    private Properties pro = new Properties();
    private TimeFilter filtering = TimeFilter.ALL;
    private int x = 0;
    private int y = 0;
    private int itemIndex = 0;
    private int xPos;
    private int yPos;
    
    /**
     *
     * @param language Set the language to be used in the graphical interface
     */
    public void setSelectedLanguage(String language) {
        this.selectedLanguage = language;
    }

    /**
     *
     * @param x set the width variable for the state.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param x set the height variable for the state.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Saves each parameter of a state, which represents different settings for
     * the application, into a properties file
     */
    public void saveState() {
        try {
            pro.setProperty("sort", selectedSorting);
            pro.setProperty("lan", selectedLanguage);
            pro.setProperty("x", Integer.toString(x));
            pro.setProperty("y", Integer.toString(y));
            pro.setProperty("xpos",Integer.toString(xPos));
            pro.setProperty("ypos",Integer.toString(yPos));
            pro.setProperty("filter", this.filtering.toString());
            pro.setProperty("category", selectedCategory);
            pro.setProperty("itemIndex", Integer.toString(itemIndex));

            try {
                pro.store(new FileOutputStream("config.properties"), null);
            } catch (FileNotFoundException e) {

                pro.store(new FileOutputStream(new File("config.properties")), null);
            }
        } catch (IOException e) {
        }
    }

    /**
     * Loads each parameter of a state, which represents different settings for
     * the application, from a properties files and save them into the state
     * class variables
     */
    public void loadState() {
        try {
            try {

                pro.load(new FileInputStream("config.properties"));

                this.selectedLanguage = pro.getProperty("lan");
                stringToTimeFilter(pro.getProperty("filter"));
                this.selectedCategory = pro.getProperty("category");
                this.selectedSorting = pro.getProperty("sort");
                
                //catch numberformat exception incase there are
                //no values for x and y saved yet
                try {
                    this.y = Integer.parseInt(pro.getProperty("y"));
                    this.x = Integer.parseInt(pro.getProperty("x"));
                    this.xPos = Integer.parseInt(pro.getProperty("xpos"));
                    this.yPos = Integer.parseInt(pro.getProperty("ypos"));
                    this.itemIndex = Integer.parseInt(pro.getProperty("itemIndex"));
                } 
                //If no states is yet saved x and y are set to 0 which
                //would render the return function returning the default
                //values instead
                catch (NumberFormatException e) {
                    this.x = 0;
                    this.y = 0;
                    this.xPos = 0;
                    this.yPos = 0;
                    this.itemIndex = 0;
                }
                
                


            } catch (FileNotFoundException e) {
                this.selectedLanguage = "English";
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void stringToTimeFilter(String convert){
        switch(convert){
            default:
                this.filtering = null;
                break;
            case "ALL":
                this.filtering = TimeFilter.ALL;
                break;
            case "TODAY":
                this.filtering = TimeFilter.TODAY;
                break;
            case "TOMORROW":
                this.filtering = TimeFilter.TOMORROW;
                break;
            case "THIS_WEEK":
                this.filtering = TimeFilter.THIS_WEEK;
                break;
            case "OLD":
                this.filtering = TimeFilter.OLD;
                break;    
                
        }
    }
    
    //************************************************
    //Get and set methods
    //************************************************
    
    /**
     *
     * @param def This is the default window width for the first session or if
     * the config file has been cleared.
     * @return The width of the window from the current state
     */
    public int getWidth(int def) {
        int minWidth = 500;
        if (this.x > minWidth) {
            return this.x;
        } else {
            return def;
        }
    }

    /**
     * @param def This is the default window height for the first session or if
     * the config file has been cleared.
     * @return The height of the window from the current state
     */
    public int getHeight(int def) {
        int minHeight = 300;
        if (this.y > minHeight) {
            return this.y;
        } else {
            return def;
        }
    }
    
    public int getXPos(){
        return this.xPos;
    }
    
    public int getYPos(){
        return this.yPos;
    }
    
    public void setXPos(int x){
        this.xPos = x;
    }
    
    public void setYPos(int y){
        this.yPos = y;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
    
    public void setFiltering(TimeFilter filter){
        this.filtering = filter;
    }
    
    public TimeFilter getFilter(){
        return this.filtering;
    }

    public int getItemIndex() {
        return itemIndex;
    }
    
    public String getSelectedCategory(){
        return this.selectedCategory;
    }
    
    public Sorting getSelectedSorting(){
        switch(this.selectedSorting){
            default:
                return Sorting.TIME;
            case "PRIO":
                return Sorting.PRIO;
            case "CATEGORY":
                return Sorting.CATEGORY;
            case "TITLE":
                return Sorting.TITLE;                
        }
    }
    
    public void setSelectedSorting(Sorting sort){
        this.selectedSorting = sort.toString();
    }

    protected void setSelectedCategory(String category) {
        this.selectedCategory = category;
    }
    
    /**
     *
     * @return Language that is to be used in the graphical interface
     */
    public String getLanguage() {
        return this.selectedLanguage;
    }    
}
