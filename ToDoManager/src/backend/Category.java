package backend;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Emil
 */
public class Category {

    private String categoryTitle;
    private final int id;
    private ArrayList<ToDoItem> toDoItems = new ArrayList<>();

    /**
     * Create a category with given number and name and a set list of items.
     * @param id The number to identify this category.
     * @param title The name of this category.
     * @param list The list of items in this category.
     */
    public Category(int id, String title, ArrayList<ToDoItem> list) {
        this.id = id;
        this.categoryTitle = title;
        this.toDoItems = list;
    }
    
    /**
     * Create a category with given number and name.
     * @param id The number to identify this category.
     * @param title The name of this category.
     */
    public Category(int id, String title) {
        this(id, title, null);
    }

    /**
     * @deprecated Do not use, use Category(int, String) or 
     * Category(int, String, ArrayList<ToDoItem> instead.
     * @param title Title of the category.
     */
    public Category(String title) {
        this(0, title, null);
    }

    public void setCategoryTitle(String title) {
        this.categoryTitle = title;
    }

    public void addToDoItem(ToDoItem item) {
        toDoItems.add(item);
    }

    public String getCategoryTitle() {
        return this.categoryTitle;
    }

    public int getId() {
        return this.id;
    }

    public ArrayList getToDoItems() {
        return this.toDoItems;
    }
        
    
}
