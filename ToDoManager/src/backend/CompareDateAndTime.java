package backend;

import java.util.Date;

/**
 * Static class for doing operations regarding comparing dates and times.
 * This class is yet to be tested
 * @author Kristian
 */
public class CompareDateAndTime {
    
    private static Date todaysDate = new Date();
    
    /**
     * Returns true if the two dates represent the same day
     * @param toBeCompared This represents the date to be compared 
     * @return True or false depending on whether or not they are on the same
     * day
     */
    public static boolean isToday(Date toBeCompared){
        //Add 1 to the month cause for some reason the dates are off by one month
        return (todaysDate.getDay() == toBeCompared.getDay() && todaysDate.getMonth()+1 == toBeCompared.getMonth() && todaysDate.getYear() == toBeCompared.getYear());     
    }
    
    
    /**
     * 
     * @param toBeCompared
     * @return 
     */
    public static boolean isTomorrow(Date toBeCompared){
        todaysDate.setDate(todaysDate.getDate()+1);
        return isToday(toBeCompared);
    }
    
    /**
     * Returns true if the date to be checked is in the intervall between
     * the current time and 23:59:59 on the following sunday.
     * @param toBeCompared Date that is to be checked
     * @return 
     */
    public static boolean isThisWeek(Date toBeCompared){
        Date limit = new Date();
        
        limit.setDate(todaysDate.getDate()+8-todaysDate.getDay());
        limit.setHours(0);
        limit.setMinutes(0);
        limit.setSeconds(0);
        
        if(toBeCompared.after(todaysDate) || toBeCompared.before(limit)){
            return true;
        }
        else{
            return false;
        }
    }    
} 
    
