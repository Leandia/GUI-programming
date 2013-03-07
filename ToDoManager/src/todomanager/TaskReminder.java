package todomanager;

import backend.BackendAPI;
import backend.Category;
import backend.ToDoItem;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;

/**
* Class that keeps track of
* @author Kristian
*/
public class TaskReminder extends TimerTask{

    private ArrayList<ToDoItem> items;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private long count;
    private boolean setCount = true;
   
    public TaskReminder(){
       this.items = new ArrayList();
    }
    public class DateComparator implements Comparator<ToDoItem> {
       
       @Override
       public int compare(ToDoItem o1, ToDoItem o2) {
           return o1.getDate().compareTo(o2.getDate());
       }
    }
   
    private void setCount(long c){
       this.count = c;
    }
   
    @Override
    public void run() {
       ArrayList<Category> categories = TODOManager.backend.getCategoryListModel().getList();
       Iterator iterator = categories.iterator();
       
       while(iterator.hasNext()){
           Category cat = (Category)iterator.next();
           Collections.sort(cat.getToDoItems(), new DateComparator());
           try{
               items.add((ToDoItem)cat.getToDoItems().get(0));
           }
           catch(Exception e){
               
           }
       }
       
       
       Collections.sort(items, new DateComparator());
       
       if(!items.isEmpty() && setCount){
           setCount(getTimeLeftInMilliSeconds(items.get(0)));
           setCount = false;
       }       
       count = count-60000;
           
       System.out.println(count);
       
       if(getTimeLeftInMilliSeconds(items.get(0))<=0)
       {
           toolkit.beep();
           JOptionPane.showMessageDialog(null, "jaa!");
           setCount = true;
       }        
       try {
           Thread.currentThread().sleep(60000);
    }
       catch (InterruptedException e) {
       }
    }
    
    private long getTimeLeftInMilliSeconds(ToDoItem item){
       long offset = 60000;
       GregorianCalendar time = item.getDate();
       GregorianCalendar now = new GregorianCalendar();
       return time.getTimeInMillis()-now.getTimeInMillis()-offset;
    }
   
}