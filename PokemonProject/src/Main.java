import Utilities.GameHelper;
import Utilities.GamePlay;
import Utilities.Menu;
import users.HumanUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu.printGameRules();
        System.out.println(Menu.printLoginMenu());

        String name = GameHelper.enterUserName(scanner);
        HumanUser humanUser = GameHelper.initializeHumanUser(name);

        GamePlay.start(humanUser);
    }
}