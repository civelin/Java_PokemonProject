package Utilities;

public class Menu {

    // private constructor
    private Menu() {
    }

    public static String printLoginMenu() {
        return """
                ❗ In order to play the game , please first create an account.
                \u2757 Username must be between 8 and 15 characters.
                \u2757 Allowed characters are lowercase, uppercase letters, numbers and _
                \u2757 Username must start with a letter.""";
    }

    public static String printTurnMenu() {

        return """
                ❗ Please choose what you want to do.
                1. Attack
                2. Change pokemon (in that case you will miss the turn!)
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

    public static void printOptionWhenUserChoseToChangePokemonsDuringBattle() {
        System.out.println("1.Confirm to change pokemon");
        System.out.println("2.Return back");
    }

    public static void printGameRules() {
        System.out.println("\uD83D\uDC4B" + " Welcome to our pokemon game!");
        System.out.println("                ----------  \uD83E\uDDFE GAME INFORMATION AND RULES \uD83E\uDDFE ----------");
        System.out.println("""
                In this game you are going to face three different opponents , each with unique pokemons , in 3 levels.
                Primarily, you must choose 3 pokemons from 5 before jumping into each battle. The battle starts when you choose
                1 pokemon from the already chosen with which you will fight the opponent's pokemon. In every turn you can attack,
                change your fighting pokemon or forfeit the battle (!!!ALERT!!! you will loose the game!).
                Each pokemon has 2 attacks , health points , attack points and defence points. The battle is played
                in turns where your opponent is always first. One player is victorious when all of the opponent's pokemons
                are defeated. For every achieved win, you will be granted to choose one pokemon as a reward and receive
                a crystal. The crystal can be used to revive a dead pokemon.
                If you are defeated on the first level, the game is over! Nonetheless, defeats on level 2 and 3,
                you have a chance to replay the battle if you meet one of the requirements which are the following ----->.
                    ---> At least 3 alive pokemons
                    ---> At least 1 crystal and 2 alive pokemons
                    ---> At least 2 crystals and 1 alive pokemon.
                Major success is achieved when all of the levels are passed.
                \uD83E\uDD1E Good luck and have fun!\r""");
    }
}