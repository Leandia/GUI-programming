package backend;

import java.util.Date;

/**
 * Static class for doing operations regarding comparing dates and times.
 * @author Kristian
 */
public class CompareDateAndTime {
    
    /**
     * Returns true if the two dates represent the same day
     * @param todaysDate This represents the current time
     * @param toBeCompared This represents the date to be compared 
     * @return True or false depending on whether or not they are on the same
     * day
     */
    public static boolean isToday(Date todaysDate, Date toBeCompared){
        if(todaysDate.getDay() != toBeCompared.getDay()){
            return false;
        }
        else{
            if(todaysDate.getMonth() != toBeCompared.getMonth()){
                return false;
            }
            else{
                if(todaysDate.getYear() != toBeCompared.getYear()){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
    }
    
    private static boolean isThisYear(int thisYear,int toBeCompared){
        if (thisYear == toBeCompared){
            return true;
        }
        else{
            return false;
        }
    }
    
    private static boolean isThisMonth(int thisMonth, int toBeCompared){
        if (thisMonth != toBeCompared){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static boolean isTomorrow(Date todaysDate, Date toBeCompared){
    
        int date = todaysDate.getDay();
        
        switch (date){
            case 28:                
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            default:
                if(todaysDate.getDay() == toBeCompared.getDay() ||isThisMonth(todaysDate.getMonth(),toBeCompared.getMonth()) ||isThisYear(todaysDate.getYear(),toBeCompared.getYear())){
                    return true;
                }
                else{
                    return false;
                }
        }
        
    }
    
    
}
