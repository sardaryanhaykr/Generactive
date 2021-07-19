package validator;

/**
 * Created by Hayk on 18.07.2021.
 */
public class Validator {
    public static boolean isValidNumber(String param){
        try {
            return Integer.parseInt(param) >= 0;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static boolean isValidInteger(String param){
        try {
            return Integer.getInteger(param) instanceof Integer;

        }catch (NumberFormatException e){
            return false;
        }
    }
}
