package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import values.TimeFilter;

/**
 * State class that holds all settings for the interface
 *
 * @author Kristian
 */
public class State {

    private String selectedLanguage;
    private Properties pro = new Properties();
    private TimeFilter filtering = TimeFilter.ALL;
    private int x = 0;
    private int y = 0;
    private int itemIndex = 0;

    /**
     *
     * @return Language that is to be used in the graphical interface
     */
    public String getLanguage() {
        return this.selectedLanguage;
    }

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

            pro.setProperty("lan", selectedLanguage);
            pro.setProperty("x", Integer.toString(x));
            pro.setProperty("y", Integer.toString(y));
            pro.setProperty("filter", this.filtering.toString());
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
                
                //catch numberformat exception incase there are
                //no values for x and y saved yet
                try {
                    this.y = Integer.parseInt(pro.getProperty("y"));
                    this.x = Integer.parseInt(pro.getProperty("x"));
                    this.itemIndex = Integer.parseInt(pro.getProperty("itemIndex"));
                } //If no states is yet saved x and y are set to 0 which
                //would render the return function returning the default
                //values instead
                catch (NumberFormatException e) {
                    this.x = 0;
                    this.y = 0;
                    this.itemIndex = 0;
                }
                
                


            } catch (FileNotFoundException e) {
                this.selectedLanguage = "English";
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
}
