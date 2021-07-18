package Util;

/**
 * Created by Hayk on 18.07.2021.
 */
public class Validator {
    public static boolean isValidNumber(String param){
        try {
            int a=Integer.parseInt(param);
            if(a>=0){
                return true;
            }
            return false;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isValidInteger(String param){
        try {
            Integer.parseInt(param);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
