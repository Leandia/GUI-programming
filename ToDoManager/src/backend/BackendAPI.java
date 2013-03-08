/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.*;
import todomanager.TODOManager;
import values.Sorting;
import values.TimeFilter;

/**
 * @author Daniel
 * @author Emil
 * @author Kristian
 */
public class BackendAPI {

    private Database database;
    private DisplayList displayList = new DisplayList();
    //final DisplayList list;
    private int index = 0;
    private String selectedCategory;
    private TimeFilter filter;
    private CategoryListModel categoryList = new CategoryListModel();
    private Sorting sorting;

    public BackendAPI(int index) {
        this.index = index;
        this.database = new Database();
        this.selectedCategory = TODOManager.savedSettings.getSelectedCategory();
        this.filter = TODOManager.savedSettings.getFilter();
        this.sorting = TODOManager.savedSettings.getSelectedSorting();

        //setDisplayItems();
        initCategories();
        viewChange();
    }

    private void setDisplayItems() {
        ArrayList<ToDoItem> temp = new ArrayList();
        ArrayList<ToDoItem> allItems = this.database.getAllItems();
        ToDoItem item;

        if (this.selectedCategory == null || this.selectedCategory.equals("All")) {
            this.displayList.setList(allItems);
        } else {
            Iterator iterator = allItems.iterator();

            while (iterator.hasNext()) {
                item = (ToDoItem) iterator.next();
                if (item.getCategory().equals(this.selectedCategory)) {
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
        getCategoryFromString(item.getCategory()).addToDoItem(item);
        database.addItem(item);
    }

    /**
     * Retrieves the category object corresponding to the input string.
     *
     * @param cat String that represents a category title
     * @return Category object
     */
    private Category getCategoryFromString(String cat) {
        Iterator iterator = this.categoryList.getList().iterator();
        Category category;

        while (iterator.hasNext()) {
            category = (Category) iterator.next();
            if (category.getCategoryTitle().equals(cat)) {
                return category;
            }
        }
        return (Category) this.categoryList.getElementAt(0);
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

    public class DateComparator implements Comparator<ToDoItem> {

        @Override
        public int compare(ToDoItem o1, ToDoItem o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    }

    public class TitleComparator implements Comparator<ToDoItem> {

        @Override
        public int compare(ToDoItem o1, ToDoItem o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public class CategoryComparator implements Comparator<ToDoItem> {

        @Override
        public int compare(ToDoItem o1, ToDoItem o2) {
            return o2.getCategory().compareTo(o1.getCategory());
        }
    }

    public class PrioComparator implements Comparator<ToDoItem> {

        @Override
        public int compare(ToDoItem o1, ToDoItem o2) {
            return o1.getPrio().compareTo(o2.getPrio());
        }
    }

    private void sortToDoItems() {
        switch (sorting) {
            case TIME:
                Collections.sort(this.displayList.getList(), new DateComparator());
                break;
            case TITLE:
                Collections.sort(this.displayList.getList(), new TitleComparator());
                break;
            case CATEGORY:
                Collections.sort(this.displayList.getList(), new CategoryComparator());
            case PRIO:
                Collections.sort(this.displayList.getList(), new PrioComparator());
            default:
        }
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

                    if (CompareDateAndTime.isSpecficDay(list.get(i).getDate(), 0)) {
                        temp.add(list.get(i));
                    }
                }
                this.displayList.setList(temp);
                break;
            case TOMORROW:
                for (int i = 0; i < list.size(); i++) {
                    if (CompareDateAndTime.isSpecficDay(list.get(i).getDate(), 1)) {
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
     * Called on changes in which items to view, either changing category or
     * time filter. In returns calls each method respectively.
     */
    public final void viewChange() {
        setDisplayItems();
        filterByTime();
        sortToDoItems();
    }

    /**
     * Initializes categories on startup
     */
    private void initCategories() {

        if (this.database.getCategories().isEmpty()) {
            addCategory(new Category(0, TODOManager.manager.getBundle().getString("all"), new ArrayList()));
            addCategory(new Category(1, TODOManager.manager.getBundle().getString("home"), new ArrayList()));
            addCategory(new Category(2, TODOManager.manager.getBundle().getString("work"), new ArrayList()));
            addCategory(new Category(3, TODOManager.manager.getBundle().getString("other"), new ArrayList()));
        } else {
            this.categoryList.setList(this.database.getCategories());
        }
    }

    /**
     * Adds a category to the list of categories, also writes through to the
     * database.
     *
     * @param category
     */
    public void addCategory(Category category) {
        this.categoryList.addCategory(category);
        this.database.addCategory(category);
    }

    /**
     * Deletes the input category from the list of categories, deletes also from
     * the database
     *
     * @param category
     */
    public void deleteCategory(Category category) {
        this.categoryList.removeCategory(category);
        this.database.deleteCategory(category);
    }

    public void setSelectedCategory(String category) {
        this.selectedCategory = category;
        TODOManager.savedSettings.setSelectedCategory(category);
    }
    
    public CategoryListModel getCategoryListModel() {
        return this.categoryList;
    }

    public void setFilter(TimeFilter filt) {
        this.filter = filt;
    }

    public void setSorting(Sorting sorting) {
        TODOManager.savedSettings.setSelectedSorting(this.sorting);
        this.sorting = sorting;
    }

    public Sorting getSorting() {
        return this.sorting;
    }

    public void createCategory(String title) {
        addCategory(new Category(this.categoryList.getSize(), title, new ArrayList()));
    }
}
