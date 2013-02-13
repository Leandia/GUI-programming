package todomanager;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emil
 */
public class CategoryClass {
    
  private String categoryTitle;
  private int id;
  private ArrayList<ToDoItem> toDoItems = new ArrayList<>();
  
  public CategoryClass(String title){
      this.categoryTitle = title;
      this.toDoItems = null;
  }
  
  public void setCategoryTitle(String title){
      this.categoryTitle = title;
  }
  
  public void addToDoItem(ToDoItem item){
      toDoItems.add(item);
  }
  
  public String getCategoryTitle(){
      return this.categoryTitle;
  }
  
  public int getId(){
      return this.id;
  }
  
  public ArrayList getToDoItems(){
      return this.toDoItems;
  }
}
