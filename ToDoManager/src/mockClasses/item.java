/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mockClasses;

import java.util.ArrayList;

/**
 *
 * @author Kristian
 */
public class item {
    
    public String name;
    public static ArrayList<item> items = new ArrayList();
    
    public item(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    private boolean updateList(){
        return items.add(this);
    }
    
    
}
