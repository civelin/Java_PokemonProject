package Utilities;

public class Menu {

    // private constructor
    private Menu() {
    }

    public static String printLoginMenu() {
        return """
                \u2757 Username must be between 8 and 15 characters.
                \u2757 Allowed characters are lowercase, uppercase letters, numbers and _
                \u2757 Username must start with a letter.""";
    }

    public static String printTurnMenu() {

        return """
                Please choose what you want to do.
                1. Attack
                2. Change pokemon
                3. Forfeit (in that case you will lose the battle!)
                """;
    }

    public static void printMenuAfterBattle() {
        System.out.println("\uD83D\uDEBE" + " Quick break, before you face your next opponent!");
        System.out.println("Choose an option --->");
        System.out.println("1. Continue the battle");
        System.out.println("2. Revive pokemon");
        System.out.println("3. Exit the game. !!!Alert!!! If you choose this option , your progress will be lost!)");

    }
}