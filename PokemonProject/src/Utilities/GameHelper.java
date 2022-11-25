package Utilities;

import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.userFactory.PCUserFactory;

import java.util.List;
import java.util.Scanner;

public class GameHelper {
    private static final Scanner scan = new Scanner(System.in);

    // private constructor
    private GameHelper() {
    }

    // methods
    public static String enterUserName() {
        System.out.println("\uD83D\uDC49 Enter username");
        System.out.print("\uD83D\uDC49" + " ");
        String userName = scan.next();

        // using regExp
        if (!Validator.validateUserName(userName)) {
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

    public static HumanUser initializeHumanUser(String userName) {
        System.out.println(Menu.printLoginMenu());

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

    // add 1 crystal to humanUser's crystals
    public static int addCrystalAfterWin(HumanUser humanUser) {
        humanUser.setCrystals(humanUser.getCrystals() + 1);
        System.out.println("\uD83D\uDC8E You won one crystal");
        System.out.println("\uD83D\uDC8E ---> Available crystals: " + humanUser.getCrystals());
        return humanUser.getCrystals();
    }

    public static void doLogicAfterHumanUserPokemonInCurrentListIsDead(HumanUser humanUser, Pokemon deadPokemon) {
        if (deadPokemon.isPokemonDead()) {
            if (humanUser.removePokemonFromCurrentList(deadPokemon)) {
                humanUser.addPokemonToDeadList(deadPokemon);
            }
            humanUser.removePokemonFromAvailableList(deadPokemon);
        }
    }

    public static void doLogicAfterPCUserPokemonInCurrentListIsDead(PCUser pcUser, Pokemon deadPokemon) {
        if (deadPokemon.isPokemonDead()) {
            pcUser.removePokemonFromCurrentList(deadPokemon);
        }
    }

    public static String printListOfPokemons(List<Pokemon> pokemons) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < pokemons.size(); i++) {
            stringBuilder.append(" ").append(i + 1).append(". ").append(pokemons.get(i).getName()).append("\n");
        }
        return stringBuilder.toString();
    }

}
