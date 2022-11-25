package users;

import Utilities.GameHelper;
import attacks.PokemonAttack;
import pokemons.Pokemon;
import Utilities.Validator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class HumanUser extends User implements IHumanUser {

    // fields
    private int crystals;
    private List<Pokemon> deadPokemonList;
    private Scanner scan;
    private PrintStream printStream;

    public void setOutputAndInputStream(InputStream inputStream, PrintStream printStream) {
        this.scan = new Scanner(inputStream);
        this.printStream = printStream;
    }


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
    public boolean addPokemonToAvailableList(Pokemon newPokemon) {
        if (!this.availablePokemons.contains(newPokemon)) {
            this.availablePokemons.add(newPokemon);
            return true;
        }
        return false;
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
    public boolean addPokemonToDeadList(Pokemon pokemon) {
        if (pokemon.isPokemonDead() && !this.deadPokemonList.contains(pokemon)) {
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
    public PokemonAttack chooseAttack() {
        this.currentPokemonForBattle.printAttacks();
        printStream.println("\uD83D\uDC49 Please select attack:");
        printStream.print("\uD83D\uDC49");
        int choice = enterHumanUserChoice(2);
        return this.currentPokemonForBattle.getAttacks()[choice - 1];

    }


    @Override
    public void choosePokemonAsReward(List<Pokemon> pokemons) {
        printStream.println("Choose one of the pokemons as a reward!");
        int index = 1;
        for (Pokemon pokemon : pokemons) {
            printStream.println(index + "." + pokemon.getName());
            index++;
        }

        int choice = enterHumanUserChoice(pokemons.size());

        Pokemon rewardPokemon = pokemons.get(choice - 1);

        if (addPokemonToAvailableList(rewardPokemon)) {
            printStream.println("Congratulation , you have added successfully " + pokemons.get(choice - 1).getName() + " to your pokemon inventory!");
            pokemons.remove(rewardPokemon);
        } else {
            printStream.println("You already have that pokemon !! Please select another one !");
        }

    }

    @Override
    public void revivePokemon() {

        if (deadPokemonList.size() > 0 && crystals > 0) {
            printStream.println("Select which pokemon you'd like to revive!");
            printStream.println("One revive costs one crystal!");
            printStream.println(GameHelper.printListOfPokemons(this.deadPokemonList));
            int choice = enterHumanUserChoice(deadPokemonList.size());
            Pokemon chosenDeadPokemon = this.deadPokemonList.get(choice - 1);
            chosenDeadPokemon.resetInitialPointsOfPokemon();
            addPokemonToAvailableList(chosenDeadPokemon);
            removePokemonFromDeadList(chosenDeadPokemon);

            printStream.println("You successfully revived " + chosenDeadPokemon.getName());
            crystals--;
            printStream.println("After the revive , you have left with " + crystals + " crystals.");

        } else {
            printStream.println("You don't have enough crystals or dead pokemons ! ");
            printStream.println("Available crystals ---->" + crystals);
            printStream.print("Dead pokemons ---->");
            for (Pokemon pokemon : this.deadPokemonList) {
                printStream.print(pokemon.getName() + " ");
            }

            printStream.println();
        }

    }


    @Override
    public void choosePokemonsFromAvailableListToCurrentList() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;
        printStream.println("\u2757 Select 3 pokemons with which you want to play.");

        for (int i = 1; i <= 3; i++) {
            boolean isAdded = false;
            printStream.println("\uD83D\uDC49 Please enter your choice");

            while (!isAdded) {
                printStream.print("\uD83D\uDC49");
                int choice = enterHumanUserChoice(availablePokemons.size());
                pokemon = availablePokemons.get(choice - 1);
                isAdded = this.addPokemonToCurrentList(pokemon);
                if (isAdded) {
                    printStream.println("\u2714 " + pokemon.getName() + " has been successfully chosen.");
                } else {
                    printStream.println("\u274C " + pokemon.getName() + " has been already chosen. Please choose another pokemon!");
                }
            }
            pokemons.add(pokemon);
        }
    }

    @Override
    public Pokemon choosePokemonForBattleFromCurrentList() {

        printStream.println("❗ Please choose your pokemon for this turn:");
        printStream.println(GameHelper.printListOfPokemons(this.currentPokemons));
        printStream.print("\n\uD83D\uDC49 ");
        int choice = enterHumanUserChoice(currentPokemons.size());

        Pokemon pokemonForBattle = this.currentPokemons.get(choice - 1);
        this.currentPokemonForBattle = pokemonForBattle;
        this.removePokemonFromCurrentList(pokemonForBattle);
        printStream.println("✔ You chose " + this.currentPokemonForBattle.getName() + "!");
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
            printStream.println("Cannot change current pokemon");
            return null;
        }
    }

    @Override
    public int enterHumanUserChoice(int upperBound) {
        String choice = scan.next();
        while (!Validator.validateUserInputChoice(upperBound, choice)) {
            choice = scan.next();
        }
        return Integer.parseInt(choice);
    }

    // getters and setters
    public int getCrystals() {
        return crystals;
    }

    public void setCrystals(int crystals) {
        this.crystals = crystals;
    }

    public List<Pokemon> getDeadPokemonList() {
        return deadPokemonList;
    }

    public void setDeadPokemonList(List<Pokemon> deadPokemonList) {
        this.deadPokemonList = deadPokemonList;
    }
}
