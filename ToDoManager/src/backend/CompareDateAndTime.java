package backend;

import java.util.GregorianCalendar;

/**
 * Static class for doing operations regarding comparing dates and times.
 * @author Kristian
 */
public class CompareDateAndTime {
    
    private static GregorianCalendar todaysDate = new GregorianCalendar();
    
    /**
     * Boolean that evaluates whether the input day is a specific day
     * relative to today. Offset decides which day in relation to 
     * todays date. So for example offset = 0 would mean it checks if tobeCompared
     * is today
     * @param toBeCompared Date to be compared
     * @param offset Number of days added or removed from todays day.
     * @return 
     */
    public static boolean isSpecficDay(GregorianCalendar toBeCompared, int offset){
        
        //Adding 31 due to how Gregoriancalendar is implemented.
        if(todaysDate.get(GregorianCalendar.DAY_OF_YEAR) == 365){
            return (offset == toBeCompared.get(GregorianCalendar.DAY_OF_YEAR) && todaysDate.getTime().getYear() == toBeCompared.getTime().getYear());
        }
        return (todaysDate.get(GregorianCalendar.DAY_OF_YEAR)+offset == toBeCompared.get(GregorianCalendar.DAY_OF_YEAR) && todaysDate.getTime().getYear() == toBeCompared.getTime().getYear());     
    }
    
    /**
     * Returns true if the date to be checked is in the intervall between
     * the current time and 23:59:59 on the following sunday.
     * @param toBeCompared Date that is to be checked
     * @return 
     */
    public static boolean isThisWeek(GregorianCalendar toBeCompared){
        int day_of_week = todaysDate.get(GregorianCalendar.DAY_OF_WEEK)-1;
        switch(day_of_week){
            default:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1)|| isSpecficDay(toBeCompared,2)|| isSpecficDay(toBeCompared,3)|| isSpecficDay(toBeCompared,4)|| isSpecficDay(toBeCompared,5)|| isSpecficDay(toBeCompared,6);
            case 2:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1)|| isSpecficDay(toBeCompared,2)|| isSpecficDay(toBeCompared,3)|| isSpecficDay(toBeCompared,4)|| isSpecficDay(toBeCompared,5);
            case 3:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1)|| isSpecficDay(toBeCompared,2)|| isSpecficDay(toBeCompared,3)|| isSpecficDay(toBeCompared,4);
            case 4:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1)|| isSpecficDay(toBeCompared,2)|| isSpecficDay(toBeCompared,3);
            case 5:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1)|| isSpecficDay(toBeCompared,2);
            case 6:
                return isSpecficDay(toBeCompared,0) || isSpecficDay(toBeCompared,1);
            case 7:
                return isSpecficDay(toBeCompared,0);
                
        }
    }    
} 
    
