package todomanager;

import backend.Category;
import backend.ToDoItem;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.JOptionPane;

/**
* Class that keeps track of pending tasks and reminds the user when the due
* date is in less than an hour
* @author Kristian
*/
public class TaskReminder extends TimerTask{

    private ArrayList<ToDoItem> items;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private ToDoItem pending;
    private final String message = TODOManager.manager.getBundle().getString("message");
    private final int anHour = 3600000;
    
    public TaskReminder(){
       this.items = new ArrayList();
    }
    
    /**
     * Compares the date field of two items
     */
    public class DateComparator implements Comparator<ToDoItem> {
       
       @Override
       public int compare(ToDoItem o1, ToDoItem o2) {
           return o1.getDate().compareTo(o2.getDate());
       }
    }
   
    /**
     * Method that runs in its own thread. Keeps checking the nearest due
     * date and provides a reminder when necessary
     */
    @Override
    public void run() {
       while(true)
       {    
           //Saves a local list of items by getting it from the listmodel
        ArrayList<Category> categories = TODOManager.backend.getCategoryListModel().getList();
        Iterator iterator = categories.iterator();

        //Iterator which wil be created for each category
        Iterator it;

        //Sort list of items to make sure its in correct order
        Collections.sort(items, new DateComparator());
        
        //Iterating over all categories
        while(iterator.hasNext()){
            Category cat = (Category)iterator.next();
            
            //Sort the category by time, nearest in time first
            Collections.sort(cat.getToDoItems(), new DateComparator());

            //Catches any nullpointerexception
            try{
                it = cat.getToDoItems().iterator();

                while(it.hasNext()){

                ToDoItem item = (ToDoItem)it.next();

                //If the item is old we dont need a reminder for that, also
                //previously reminded items dont need to be reminded for again
                //except on a new session
                    if(item.getDate().after(new GregorianCalendar()) && !item.getReminded() && !items.contains(item)){
                        items.add(item);
                    }
                    
        }
        

            }
            catch(NullPointerException e){
                System.err.print(e);
            }
        
        }
        
        if(!items.isEmpty()){
            //The pending item is the nearest in time
            pending = items.get(0);
        }       
        System.out.println(items.size());

        try{
                
                        
                        
                //Hardcoded value, reminds about any item that expires within an hour
                //also a already reminded message wont be reminded about again
                if(getTimeLeftInMilliSeconds(pending)<=anHour && !pending.getReminded())
                {
                    //beep sounds
                    toolkit.beep();
                    JOptionPane.showMessageDialog(null, pending.getTitle()+" "+message);

                    //Remove the item from the list so that it wont be used again
                    items.remove(pending);
                    pending.setReminded(true);
                }
        }
        catch(NullPointerException e){
            System.err.print(e);
        }

        try {
            //Polls every 5 seconds
            Thread.currentThread().sleep(5000);
        }
        catch (InterruptedException e) {
            System.err.print(e);
        }
       }
    }
    
    /**
     * Get the time left in milliseconds between current time and due date
     * @param item Item to be checked for
     * @return Time in milliseconds
     */
    private long getTimeLeftInMilliSeconds(ToDoItem item){
       GregorianCalendar time = item.getDate();
       GregorianCalendar now = new GregorianCalendar();
       return time.getTimeInMillis()-now.getTimeInMillis();
    }
   
}