package Utilities;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
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
    public static void addCrystalAfterWin(HumanUser humanUser) {
        humanUser.setCrystals(humanUser.getCrystals() + 1);
        System.out.println("\uD83D\uDC8E You won one crystal");
        System.out.println("\uD83D\uDC8E ---> Available crystals: " + humanUser.getCrystals() + "\r");
    }

    public static void doLogicAfterHumanUserPokemonIsDead(HumanUser humanUser, Pokemon deadPokemon) {
        humanUser.addPokemonToDeadList(deadPokemon);
        humanUser.removePokemonFromAvailableList(deadPokemon);
        if (humanUser.getCurrentPokemons().contains(deadPokemon)) {
            humanUser.removePokemonFromCurrentList(deadPokemon);
        } else {
            humanUser.setCurrentPokemonForBattle(null);
        }
    }

    public static void doLogicAfterPCUserPokemonInCurrentListIsDead(PCUser pcUser, Pokemon deadPokemon) {
        pcUser.removePokemonFromCurrentList(deadPokemon);

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

}
