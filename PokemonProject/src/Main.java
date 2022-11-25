import Utilities.GameHelper;
import Utilities.GamePlay;
import users.HumanUser;

public class Main {
    public static void main(String[] args) {
        System.out.println("\uD83D\uDC4B" + " Welcome to our pokemon game!!! In order to play the game , please first create account\n");
        String name = GameHelper.enterUserName();
        HumanUser humanUser = GameHelper.initializeHumanUser(name);

        humanUser.setOutputAndInputStream(System.in, System.out);

        GamePlay.start(humanUser);
    }
}