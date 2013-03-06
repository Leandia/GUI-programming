package todomanager;

/**
 * A simple class with static method for validating different kinds of input. 
 * @author Kristian
 */
public class InputUtility {
    
    
    /**
     * Validates a string, returns true if it fulfills the constarints
     * @param input String to be validated
     * @param maxSize The user provides a maxsize for the string to have
     * @return True or false
     */
    protected static boolean validateString(String input,int maxSize){
        if(!input.equals("") && input.length()<maxSize){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Fucnction that tries to convert a string to integer, if not succesfull
     * it will return -1
     * @param input String to be converted
     * @return The int representation of the string or -1 if it couldnt be 
     * converted
     */
    protected static int tryParseInt(String input){
        int result;
        
        try{
            result = Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            result = -1;
        }
        
        return result;
    }
    
}
