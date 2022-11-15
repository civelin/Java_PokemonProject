package menus;

import validators.Validator;

import java.util.Scanner;

public class LoginMenu {
    private static Scanner scan = new Scanner(System.in);

    private LoginMenu(){};

    public static void print(){
        System.out.println("\u2757" + " Username must be between 8 and 15 characters.");
        System.out.println("\u2757" + " Allowed characters are lowercase, uppercase letters, numbers and _");
        System.out.println("\u2757" + " Username must start with a letter.");
    }

    public static String enterUserName(){
        System.out.println("\uD83D\uDC49 Enter username");
        System.out.print("\uD83D\uDC49" + " ");
        String userName = scan.next();
        // using regExp
        while(!Validator.validateUserName(userName)){
            System.out.println("\u274C Invalid username. Username must meet all of the following requirements:");
            System.out.println("    \u2757 username must be between 8 and 15 characters");
            System.out.println("    \u2757 username must start with letter");
            System.out.println("    \u2757 username can contain letter, numbers and _");
            return enterUserName();
        }
        System.out.println("\u2714 Successfully entered username.");
        System.out.println();
        return userName;
    }
}
