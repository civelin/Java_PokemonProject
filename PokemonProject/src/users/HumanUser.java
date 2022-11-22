package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import validators.Validator;

import java.util.*;

public class HumanUser extends User implements IHumanUser {
    // fields
    private int crystals;
    private List<Pokemon> deadPokemonList;
    private Scanner scan = new Scanner(System.in);

    // constructor
    public HumanUser(String name, List<Pokemon> availablePokemons) {
        this.name = name;
        this.crystals = 0;
        this.availablePokemons = availablePokemons;
        this.currentPokemons = new ArrayList<>();
        this.deadPokemonList = new ArrayList<>();
    }

    //methods from interfaces


    @Override
    public boolean addPokemonToAvailableList(Pokemon pokemon) {
        if (!availablePokemons.contains(pokemon)) {
            this.availablePokemons.add(pokemon);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removePokemonFromAvailableList(Pokemon pokemon) {
        if (this.availablePokemons.contains(pokemon)) {
            this.availablePokemons.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public String printAvailablePokemons() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < availablePokemons.size(); i++) {
            stringBuilder.append(" " + (i + 1) + ". " + availablePokemons.get(i).getName() + "\n");
        }
        return stringBuilder.toString();
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
    public boolean removePokemonFromDeadList(Pokemon pokemon) {
        if (this.deadPokemonList.contains(pokemon)) {
            this.deadPokemonList.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public String printDeadPokemons() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < this.deadPokemonList.size(); i++) {
            strBuilder.append((i + 1) + "." + deadPokemonList.get(i).getName());
        }
        return strBuilder.toString();
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

    @Override
    public boolean removePokemonFromCurrentList(Pokemon pokemon) {
        if (this.currentPokemons.contains(pokemon)) {
            this.currentPokemons.remove(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public PokemonAttack chooseAttack() {

        this.currentPokemonForBattle.printAttacks();
        System.out.println("\uD83D\uDC49 Please select attack:");
        System.out.println("\uD83D\uDC49");
        String choice = scan.next();
        while (!Validator.validateUserInputForChoice(2, choice)) {
            System.out.println("\uD83D\uDC49");
            choice = scan.next();
        }
        return this.currentPokemonForBattle.getAttacks()[Integer.parseInt(choice) - 1];
    }

    @Override
    public int chooseOptionBeforeEachTurn() {
        String choice = scan.next();
        while (!Validator.validateUserInputForChoice(3, choice)) {
            choice = scan.next();
        }
        return Integer.parseInt(choice);
    }

    @Override
    public boolean choosePokemonAsReward(List<Pokemon> pokemons) {

        System.out.println("Choose one of the pokemons as a reward!");
        int index = 1;
        for (Pokemon pokemon : pokemons) {
            System.out.println(index + "." + pokemon.getName());
            index++;
        }
        String choice = scan.next();
        while (!Validator.validateUserInputForChoice(pokemons.size(), choice)) {
            System.out.print("\uD83D\uDC49");
            choice = scan.next();
        }
        if (addPokemonToAvailableList(pokemons.get(Integer.parseInt(choice) - 1))) {
            pokemons.remove(pokemons.get(Integer.parseInt(choice) - 1));
            System.out.println("Congratulation , you have added successfully " + pokemons.get(Integer.parseInt(choice) - 1).getName() + " to your pokemon inventory!");
            return true;
        } else {
            System.out.println("You already have that pokemon !! Please select another one !");
            return false;
        }

    }

    @Override
    public Pokemon revivePokemon() {

        if (deadPokemonList.size() > 0 && crystals > 0) {
            System.out.println("Select which pokemon you'd like to revive!");
            System.out.println("One revive costs one crystal!");
            int index = 1;
            for (Pokemon pokemon : this.deadPokemonList) {
                System.out.println(index + "." + pokemon.getName());
                index++;
            }
            String choice = scan.next();
            while (!Validator.validateUserInputForChoice(this.deadPokemonList.size(), choice)) {
                System.out.print("\uD83D\uDC49");
                choice = scan.next();
            }
            Pokemon chosenDeadPokemon = this.deadPokemonList.get(Integer.parseInt(choice) - 1);
            chosenDeadPokemon.resetInitialPointsOfPokemon();
            addPokemonToAvailableList(chosenDeadPokemon);
            removePokemonFromDeadList(chosenDeadPokemon);

            System.out.println("You successfully revived " + chosenDeadPokemon.getName());
            crystals--;
            System.out.println("After the revive , you have left with " + crystals + " crystals.");


            return chosenDeadPokemon;
        } else {
            System.out.println("You don't have enough crystals or dead pokemons ! ");
            System.out.println("Available crystals ---->" + crystals);
            System.out.print("Dead pokemons ---->");
            for (Pokemon pokemon : this.deadPokemonList) {
                System.out.print(pokemon.getName() + " ");
            }
            System.out.println();
            return null;
        }

    }


    @Override
    public List<Pokemon> choosePokemonsFromAvailableListToCurrentList() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;

        System.out.println("\u2757 Please select the pokemons with which you want to play. You have to choose 3 pokemons.");
        printAvailablePokemons();

        for (int i = 1; i <= 3; i++) {
            boolean isAdded = false;
            System.out.println("\uD83D\uDC49 Please enter your choice");

            while (!isAdded) {
                System.out.print("\uD83D\uDC49");
                String choice = scan.next();

                // entering choice until it falls within the interval
                while (!Validator.validateUserInputForChoice(availablePokemons.size(), choice)) {
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

    @Override
    public Pokemon choosePokemonForBattleFromCurrentList() {

        System.out.println("❗ Please choose your pokemon for this turn:");
        System.out.println(this.printCurrentPokemons());
        System.out.print("\n\uD83D\uDC49 ");
        String index = scan.next();
        // entering choice until it falls within the interval
        while (!Validator.validateUserInputForChoice(currentPokemons.size(), index)) {
            System.out.print("\uD83D\uDC49");
            index = scan.next();
        }

        Pokemon pokemonForBattle = this.currentPokemons.get(Integer.parseInt(index) - 1);
        this.currentPokemonForBattle = pokemonForBattle;
        this.removePokemonFromCurrentList(pokemonForBattle);
        System.out.println("✔ You chose " + this.currentPokemonForBattle.getName() + "!");
        return pokemonForBattle;
    }

    @Override
    public Pokemon changeCurrentPokemon() {
        if (this.currentPokemons.size() != 0) {
            Pokemon lastCurrentPokemon = this.currentPokemonForBattle;
            Pokemon newCurrentPokemon = this.choosePokemonForBattleFromCurrentList();
            if (lastCurrentPokemon != null) {
                this.addPokemonToCurrentList(lastCurrentPokemon);
            }
            return newCurrentPokemon;
        } else {
            System.out.println("Cannot change current pokemon");
            return null;
        }
    }

    // getters and setters
    public int getCrystals() {
        return crystals;
    }

    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }


}
