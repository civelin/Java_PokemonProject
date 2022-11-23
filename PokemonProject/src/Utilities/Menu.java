package Utilities;

public class Menu {

    // private constructor
    private Menu() {
    }

    public static String printLoginMenu() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("\u2757" + " Username must be between 8 and 15 characters.\n");
        strBuilder.append("\u2757" + " Allowed characters are lowercase, uppercase letters, numbers and _\n");
        strBuilder.append("\u2757" + " Username must start with a letter.");
        return strBuilder.toString();
    }

    public static String printTurnMenu() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("Please choose what you want to do.\n");
        strBuilder.append("1. Attack\n");
        strBuilder.append("2. Change pokemon\n");
        strBuilder.append("3. Forfeit (in that case you will lose the battle!)\n");

        return strBuilder.toString();
    }

    public static void printMenuAfterBattle() {
        System.out.println("Quick break , before you face your next opponent!");
        System.out.println("Choose an option--->");
        System.out.println("1. Continue the battle");
        System.out.println("2. Revive pokemon");
        System.out.println("3. Exit the game. !!!Alert!!! If you choose this option , your progress will be lost!)");

    }
}