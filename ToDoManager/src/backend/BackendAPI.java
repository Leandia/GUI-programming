/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.*;
import todomanager.TODOManager;
import values.TimeFilter;

/**
 *
 * @author Daniel
 * @author Emil
 * @author Kristian
 */
public class BackendAPI {

    private Database database;
    private DisplayList displayList = new DisplayList();
    //final DisplayList list;
    private int index = 0;
    private ArrayList<Category> categories = new ArrayList();
    private String selectedCategory;
    private TimeFilter filter;
    private CategoryListModel categoryList = new CategoryListModel();

    public BackendAPI(int index) {
        this.index = index;
        this.database = new Database();
        this.selectedCategory = TODOManager.savedSettings.getSelectedCategory();
        this.filter = TODOManager.savedSettings.getFilter();
        
        //setDisplayItems();
        initCategories();
        viewChange();
        //this.list = new DisplayList();
    }

    
    
    /**
     * Method to fetch all items from the database and insert into the display
     * list.
     
    private void isnsertItems() {
        ArrayList<ToDoItem> tempList = getDisplayItems(this.selectedCategory);
        Iterator iter = tempList.iterator();
        while (iter.hasNext()) {
            ToDoItem item = (ToDoItem) iter.next();
            this.displayList.addElement(item);
        }
    }*/
    
    
    private void setDisplayItems(){
        ArrayList<ToDoItem> temp = new ArrayList();
        ArrayList<ToDoItem> allItems = this.database.getAllItems();
        ToDoItem item;
        
        if(this.selectedCategory == null || this.selectedCategory.equals("All")){
            this.displayList.setList(allItems);
        }
        else{
            Iterator iterator = allItems.iterator();
            
            while(iterator.hasNext()){
                item = (ToDoItem)iterator.next();
                if(item.getCategory().equals(this.selectedCategory)){
                    temp.add(item);
                }
            }
            this.displayList.setList(temp);;
        }
        
    }

    /**
     * Add an item to the program, both adds the item to be displayed and to the
     * database.
     *
     * @param item
     */
    public void addItem(ToDoItem item) {
        this.displayList.addElement(item);
        database.addItem(item);
    }

    /**
     *
     * @param item
     */
    public void deleteItem(ToDoItem item) {
        this.displayList.removeElement(item);
        database.deleteItem(item);
    }

    /**
     * Method to close the database.
     */
    public void closeDB() {
        //this.database.closeDB();
    }

    /**
     * Method to get the index of the item to add.
     *
     * @return The index of the next item.
     */
    public int getIndex() {
        return this.index++;
    }

    public DisplayList getListModel() {
        return displayList;
    }

    public static ArrayList<ToDoItem> sortByDate(ArrayList<ToDoItem> items) {

        if (items.size() <= 1) {
            return items;
        }
        int middle = items.size() / 2;

        ArrayList<ToDoItem> left = new ArrayList<>(middle);
        ArrayList<ToDoItem> right = new ArrayList<>(items.size() - middle);

        left = sortByDate(left);
        right = sortByDate(right);

        return dateMerge(left, right);
    }

    public static ArrayList<ToDoItem> dateMerge(ArrayList<ToDoItem> left, ArrayList<ToDoItem> right) {

        ArrayList<ToDoItem> result = new ArrayList<>(left.size() + right.size());

        int i = 0; //left index
        int j = 0; //right index
        int k = 0; //result index

        while (i < left.size() && j < right.size()) {

            if (left.get(i).getDate().compareTo(right.get(j).getDate()) < 0) {
                result.add(k, right.get(j));
                j++; //next right index
            } else {

                result.add(k, left.get(i));
                i++; //next left index
            }
            k++; //next result index 
        }

        // Append what is left from the left array into the result array.
        while (i < left.size()) {
            result.add(k, left.get(i));
            i++;
            k++;
        }
        // Append what is left from the right array into the result array.
        while (j < right.size()) {
            result.add(k, right.get(j));
            j++;
            k++;
        }

        return result;
    }

    /**
     * Function that filter by time, what period is determined by the filter
     * parameter
     */
    private void filterByTime() {
        ArrayList<ToDoItem> list = this.displayList.getList();
        ArrayList<ToDoItem> temp = new ArrayList();
        
        switch (filter) {
            default:
                break;
            case OLD:
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getDate().before(new GregorianCalendar())) {
                        temp.add(list.get(i));
                    }
                }
                this.displayList.setList(temp);
                break;
            case TODAY:
                for (int i = 0; i < list.size(); i++) {
                    
                    if (CompareDateAndTime.isSpecficDay(list.get(i).getDate(),0)) {
                        temp.add(list.get(i));
                    }
                }
                this.displayList.setList(temp);
                break;
            case TOMORROW:
                for (int i = 0; i < list.size(); i++) {
                    if (CompareDateAndTime.isSpecficDay(list.get(i).getDate(),1)) {
                        temp.add(list.get(i));
                    }
                }
                this.displayList.setList(temp);
                break;
            case THIS_WEEK:
                for (int i = 0; i < list.size(); i++) {
                    if (CompareDateAndTime.isThisWeek(list.get(i).getDate())) {
                        temp.add(list.get(i));
                    }
                }
                this.displayList.setList(temp);
                break;
        }
        
        
    }

    /**
     * Called on changes in which items to view, either changing category
     * or time filter. In returns calls each method respectively.
     */
    public final void viewChange(){
        setDisplayItems();
        filterByTime();
    }
    /**
     * Initializes categories on startup
     */
    private void initCategories() {
        
        if(this.database.getCategories().isEmpty()){
            addCategory(new Category(0,TODOManager.manager.getBundle().getString("all"),new ArrayList()));
            addCategory(new Category(1,TODOManager.manager.getBundle().getString("home"),new ArrayList()));
            addCategory(new Category(2,TODOManager.manager.getBundle().getString("work"),new ArrayList()));
            addCategory(new Category(3,TODOManager.manager.getBundle().getString("other"),new ArrayList()));
        }
        else{
            this.categoryList.setList(this.database.getCategories());
        }
    } 
    
    /**
     * Adds a category to the list of categories, also writes through to
     * the database.
     * @param category 
     */
    public void addCategory(Category category){
        this.categoryList.addCategory(category);
        this.database.addCategory(category);
    }
    
    /**
     * Deletes the input category from the list of categories,
     * deletes also from the database
     * @param category 
     */
    public void deleteCategory(Category category){
        this.categoryList.removeCategory(category);
        this.database.deleteCategory(category);
    }

    public void setSelectedCategory(String category) {
        this.selectedCategory = category;
        TODOManager.savedSettings.setSelectedCategory(category);
    }
    
    public CategoryListModel getCategoryListModel(){
        return this.categoryList;
    }
    
    public void setFilter(TimeFilter filt){
        this.filter = filt;
    }

    public void createCategory(String title) {
        addCategory(new Category(this.categoryList.getSize(),title,new ArrayList()));
    }
}
