package menus;

import validators.Validator;

import java.util.Scanner;

public class LoginMenu {
    private static Scanner scan = new Scanner(System.in);

    private LoginMenu(){};

    public static void print(){
        System.out.println(" -> Username must be between 8 and 15 characters");
        System.out.println("Allowed characters are lowercase, uppercase letters, numbers and _");
    }

    public static String enterUserName(){
        System.out.print("    -> Enter username: ");
        String userName = scan.next();
        while(!Validator.validateUserName(userName)){
            System.out.println("Invalid username.Check the following requirements:");
            System.out.println("-> username must be between 8 and 15 characters");
            System.out.println("-> username must start with letter");
            System.out.println("-> username can contain letter, numbers and _");
            return enterUserName();
        }
        return userName;
    }
}
