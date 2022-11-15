package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import validators.Validator;

import java.util.*;

public class HumanUser extends User implements IHumanUser {

    private int crystals;
    private List<Pokemon> deadPokemonList;

    public HumanUser(String name) {
        this.name = name;
        this.crystals = 0;
        this.availablePokemons = new ArrayList<>();
        this.currentPokemons = new ArrayList<>();
        this.deadPokemonList = new ArrayList<>();
    }

    public int addCrystals() {
        return ++this.crystals;
    }

    public int removeCrystals() {
        if (this.crystals > 0) {
            this.crystals--;
            System.out.println("-> Available crystals: " + this.crystals);
        }
        return this.crystals;
    }

    //interfaces

    public boolean addPokemonToAvailableList(Pokemon pokemon) {
        if (!availablePokemons.contains(pokemon)) {
            this.availablePokemons.add(pokemon);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addPokemonToDeadList(Pokemon pokemon) {
        if (pokemon.isPokemonDead()) {
            this.deadPokemonList.add(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePokemonFromCurrentList(Pokemon pokemon) {
        if (this.currentPokemons.contains(pokemon)) {
            pokemon.changeIsPokemonFightingStatus();
            this.currentPokemons.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public PokemonAttack chooseAttack(Pokemon pokemon) {
        Scanner scan = new Scanner(System.in);
        pokemon.printAttacks();
        System.out.println("\uD83D\uDC49 Please select attack:");
        System.out.println("\uD83D\uDC49");
        String choice = scan.next();
        while (!Validator.enterChoice(2, choice)) {
            System.out.println("\uD83D\uDC49");
            choice = scan.next();
        }
        return pokemon.getAttacks()[Integer.parseInt(choice) - 1];
    }

    public boolean removePokemonFromAvailableList(Pokemon pokemon) {
        if (this.availablePokemons.contains(pokemon)) {
            this.availablePokemons.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public int userChoiceOptionAfterEachTurn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose what you want to do.");
        System.out.println("1---->Attack");
        System.out.println("2---->Change pokemon");
        System.out.println("3---->Forfeit (in case you forfeit , you lose the battle!)");
        String choice = sc.next();
        while (!Validator.enterChoice(3, choice)) {

            choice = sc.next();
        }
        return Integer.parseInt(choice);
    }

    public boolean removePokemonFromDeadList(Pokemon pokemon) {
        if (this.deadPokemonList.contains(pokemon)) {
            this.deadPokemonList.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPokemonToCurrentList(Pokemon pokemon) {
        if (!currentPokemons.contains(pokemon)) {
            this.currentPokemons.add(pokemon);
            System.out.println("\u2714 " + pokemon.getName() + " has been successfully chosen.");
            return true;
        } else {
            System.out.println("\u274C " + pokemon.getName() + " has been already chosen. Please choose another pokemon!");
            return false;
        }
    }

    public void printAvailablePokemons() {
        for (int i = 0; i < availablePokemons.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + availablePokemons.get(i).getName());
        }
        System.out.println();
    }

    public void printCurrentPokemons() {
        for (int i = 0; i < currentPokemons.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + currentPokemons.get(i).getName());
        }
    }

    @Override
    public List<Pokemon> choosePokemonsFromAvailableListToCurrentList() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("\u2757 Please select the pokemons with which you want to play. You have to choose 3 pokemons.");
        printAvailablePokemons();

        for (int i = 1; i <= 3; i++) {
            boolean isAdded = false;
            System.out.println("\uD83D\uDC49 Please enter your choice");

            while (!isAdded) {
                System.out.print("\uD83D\uDC49");
                String choice = scan.next();

                // entering choice until it falls within the interval
                while (!Validator.enterChoice(availablePokemons.size(), choice)) {
                    System.out.println("\u274C Choice must be between 1 and " + availablePokemons.size());
                    System.out.print("\uD83D\uDC49");
                    choice = scan.next();
                }
                pokemon = availablePokemons.get(Integer.parseInt(choice) - 1);
                isAdded = this.addPokemonToCurrentList(pokemon);
            }
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public Pokemon choosePokemonForBattleFromCurrentList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("❗ Please choose your pokemon for this turn:");
        this.printCurrentPokemons();
        System.out.print("\n\uD83D\uDC49 ");
        String index = sc.next();
        // entering choice until it falls within the interval
        while (!Validator.enterChoice(currentPokemons.size(), index)) {
            System.out.println("\u274C Choice must be between 1 and " + currentPokemons.size());
            System.out.print("\uD83D\uDC49");
            index = sc.next();
        }
        Pokemon pokemonForBattle = this.currentPokemons.get(Integer.parseInt(index) - 1);
        pokemonForBattle.changeIsPokemonFightingStatus();
        System.out.println("✔ You chose " + pokemonForBattle.getName() + "!");
        return pokemonForBattle;
    }


}
