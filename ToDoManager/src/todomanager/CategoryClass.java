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
  private ArrayList<ToDoItem> toDoItems = new ArrayList<>();
  
  public CategoryClass(String title){
      this.categoryTitle = title;
      this.toDoItems = null;
  }
  
  public String getCategoryTitle(){
      return this.categoryTitle;
  }
  
  public ArrayList getToDoItems(){
      return this.toDoItems;
  }
}
