import users.HumanUser;
import users.PCUser;
import users.userFactory.PCUserFactory;
import validators.Validator;

import java.util.Scanner;

public class GameHelper {
    // fields
    public final static int numberOfLevels = 3;
    public static int currentTurn;

    // constructor
    private GameHelper() {
    }

    // methods
    public static String enterUserName(Scanner scan) {
        System.out.println("\uD83D\uDC49 Enter username");
        System.out.print("\uD83D\uDC49" + " ");
        String userName = scan.next();
        // using regExp
        if (!Validator.validateUserName(userName)) {
            System.out.println("\u274C Invalid username. Username must meet all of the following requirements:");
            System.out.println("    \u2757 username must be between 8 and 15 characters");
            System.out.println("    \u2757 username must start with letter");
            System.out.println("    \u2757 username can contain letter, numbers and _");
            return enterUserName(scan);
        }
        System.out.println("\u2714 Successfully entered username.");
        System.out.println();
        return userName;
    }


    public static PCUser initializePCUserAccordingToCurrentLevel(int level) {
        PCUser pcUser = null;
        switch (level) {
            case 1:
                pcUser = PCUserFactory.pcUser1();
                break;
            case 2:
                pcUser = PCUserFactory.pcUser2();
                break;
            case 3:
                pcUser = PCUserFactory.pcUser3();
                break;
        }
        return pcUser;
    }

    // add 1 crystal to humanUser's crystals
    public static int addCrystals(HumanUser humanUser) {
        humanUser.setCrystals(humanUser.getCrystals() + 1);
        System.out.println("You won one crystal");
        System.out.println("-> Available crystals: " + humanUser.getCrystals());
        return humanUser.getCrystals();
    }

    //remove 1 crystal from humanUser's crystals if it is possible


//    public static Pokemon returnPokemonReward(PCUser loser, HumanUser winner){
//        for (Pokemon pokemon: loser.getAvailablePokemons()) {
//            if(!winner.getAvailablePokemons().contains(pokemon) && !winner.get){
//                return pokemon;
//            }
//        }
//        // връща на рандом покемон от
//        // списъкът с available на опонента
//        // като трябва да се провери дали има възможност
//        // да върне такъв, който го има в списъка с available на победителя
//    }
//


}
