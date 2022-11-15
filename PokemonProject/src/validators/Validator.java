package validators;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    public static boolean validateUserName(String username) {
        // compile the regex to create pattern
        // using compile() method
        Pattern pattern = Pattern.compile("^[A-Za-z]\\w{7}\\w{0,7}$");

        // get a matcher object from pattern
        Matcher matcher = pattern.matcher(username);

        // check whether Regex string is
        // found in actualString or not
        boolean matches = matcher.matches();
        return matches;
    }

    public static boolean enterChoice(int upperBound, String choice) {
        try {
            int integerChoice = Integer.parseInt(choice);
             if(integerChoice >= 1 && integerChoice <= upperBound){
                return true;
            } else {
                 throw new InputMismatchException();
             }
        } catch (Exception e){
            System.out.println("\u274C Choice must be between 1 and "+upperBound);
            return false;
        }
    }
}
