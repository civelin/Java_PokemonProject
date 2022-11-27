package Utilities;

import java.util.InputMismatchException;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Validator {
    // private constructor
    private Validator() {
    }

    public static boolean validateUserName(String username) {
        // compile the regex to create pattern using compile() method
        Pattern pattern = Pattern.compile("^[A-Za-z]\\w{7}\\w{0,7}$");

        // get a matcher object from pattern
        Matcher matcher = pattern.matcher(username);

        // check whether Regex string is found a match or not and return it
        return matcher.matches();
    }

    public static boolean validateUserInputChoice(int upperBound, String choice) {
        try {
            int integerChoice = Integer.parseInt(choice);
            if (integerChoice >= 1 && integerChoice <= upperBound) {
                return true;
            } else {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println("\u274C Choice must be between 1 and " + upperBound + " inclusive");
            return false;
        }
    }



}