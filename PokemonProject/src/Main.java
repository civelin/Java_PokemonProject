import Utilities.GameHelper;
import Utilities.GamePlay;
import Utilities.Menu;
import users.HumanUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GamePlay.setScan(scanner);

        System.out.println("\uD83D\uDC4B" + " Welcome to our pokemon game!!! In order to play the game , please first create account\n");
        System.out.println(Menu.printLoginMenu());
        String name = GameHelper.enterUserName(scanner);
        HumanUser humanUser = GameHelper.initializeHumanUser(name);

        GamePlay.start(humanUser);
    }
}