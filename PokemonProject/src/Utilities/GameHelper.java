package Utilities;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.User;
import users.userFactory.PCUserFactory;

import java.util.List;
import java.util.Scanner;

public class GameHelper {

    // private constructor
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
            return GameHelper.enterUserName(scan);
        }

        System.out.println("\u2714 Successfully entered username.\r\n");
        return userName;
    }

    public static HumanUser initializeHumanUser(String userName) {
        return new HumanUser(userName, PokemonFactory.getUserPokemons());
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

    public static void addAttackToPokemon(Pokemon pokemon, PokemonAttack attack, int index) {
        if (index >= 0 && index < pokemon.getAttacks().length) {
            if (pokemon.getAttacks()[index] == null) {
                pokemon.getAttacks()[index] = attack;
            }
        }
    }

    // add 1 crystal to humanUser's crystals
    public static void addCrystalAfterWin(HumanUser humanUser, int crystals) {
        humanUser.setCrystals(humanUser.getCrystals() + crystals);
        System.out.println("\uD83D\uDC8E You won " + crystals + " crystal");
        System.out.println("\uD83D\uDC8E ---> Available crystals: " + humanUser.getCrystals() + "\r");
    }

    public static String printListOfPokemons(List<Pokemon> pokemons) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pokemons.size(); i++) {
            stringBuilder.append(" ").append(i + 1).append(". ").append(pokemons.get(i).getName()).append("\n");
        }
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }

    public static void printAttacks(Pokemon pokemon) {
        System.out.println("-> " + pokemon.getName() + "'s attacks:");
        for (int i = 0; i <= 1; i++) {
            System.out.println((i + 1) + ". " + pokemon.getAttacks()[i].returnDescription());
        }
    }

    public static boolean checkIfHumanUserAvaiablePokemonsListSizeIsLessThan3(HumanUser humanUser) {
        if (humanUser.getAvailablePokemons().size() < 3) {
            System.out.println("You must have 3 alive pokemons before jumping into the next battle! Please revive any pokemon!");
            return true;
        }
        return false;
    }

    public static void resetInitialPointsOfPokemonsAfterEachBattle(User user) {
        for (Pokemon pokemon : user.getAvailablePokemons()) {
            pokemon.resetInitialPointsOfPokemon();
        }
    }

    public static boolean doesHumanUserMeetRequirementsToContinueTheGame(HumanUser humanUser) {
        return (humanUser.getAvailablePokemons().size() >= 2 || humanUser.getCrystals() >= 2) && (humanUser.getAvailablePokemons().size() > 2 || humanUser.getCrystals() != 0);
    }


    public static boolean checkIfUserIsDefeated(User user) {
        return user.getCurrentPokemonForBattle() == null && user.getCurrentPokemons().size() == 0;
    }
}
