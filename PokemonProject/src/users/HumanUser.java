package users;

import Utilities.GameHelper;
import attacks.PokemonAttack;
import pokemons.Pokemon;
import Utilities.Validator;
import pokemons.pokemonFactory.PokemonFactory;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class HumanUser extends User implements IHumanUser {
    // fields
    private int crystals;
    private List<Pokemon> deadPokemonList;

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
    public PokemonAttack chooseAttack(Scanner scan) {
        this.currentPokemonForBattle.printAttacks();
        System.out.println("\uD83D\uDC49 Please select attack:");
        System.out.print("\uD83D\uDC49");
        int choice = enterHumanUserChoice(2, scan);
        return this.currentPokemonForBattle.getAttacks()[choice - 1];
    }

    @Override
    public void choosePokemonAsReward(List<Pokemon> pokemons, Scanner scanner) {
        System.out.println("Choose one of the pokemons as a reward!");
        System.out.println(GameHelper.printListOfPokemons(PokemonFactory.getPokemonRewards()));

        int choice = enterHumanUserChoice(pokemons.size(), scanner);

        Pokemon rewardPokemon = pokemons.get(choice - 1);


        if (addPokemonToAvailableList(rewardPokemon)) {
            System.out.println("Congratulation , you have added successfully " + pokemons.get(choice - 1).getName() + " to your pokemon inventory!\r");
            pokemons.remove(rewardPokemon);
        } else {
            System.out.println("You already have that pokemon !! Please select another one !\r");
        }

    }

    @Override
    public void revivePokemon(Scanner scanner) {

        if (deadPokemonList.size() > 0 && crystals > 0) {
            System.out.println("Select which pokemon you'd like to revive!");
            System.out.println("One revive costs one crystal!");

            System.out.println(GameHelper.printListOfPokemons(this.deadPokemonList));

            int choice = enterHumanUserChoice(deadPokemonList.size(), scanner);
            Pokemon chosenDeadPokemon = this.deadPokemonList.get(choice - 1);
            chosenDeadPokemon.resetInitialPointsOfPokemon();
            addPokemonToAvailableList(chosenDeadPokemon);
            removePokemonFromDeadList(chosenDeadPokemon);

            System.out.println("You successfully revived " + chosenDeadPokemon.getName());
            crystals--;
            System.out.println("After the revive , you have left with " + crystals + " crystals.");

        } else {
            System.out.println("You don't have enough crystals or dead pokemons ! ");
            System.out.println("Available crystals ---->" + crystals);
            System.out.print("Dead pokemons ----> ");
            for (Pokemon pokemon : this.deadPokemonList) {
                System.out.print(pokemon.getName() + " ");
            }

            System.out.println();
        }

    }


    @Override
    public void choosePokemonsFromAvailableListToCurrentList(Scanner scanner) {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;
        System.out.println("\u2757 Select 3 pokemons with which you want to play.");

        for (int i = 1; i <= 3; i++) {
            boolean isAdded = false;
            System.out.println("\uD83D\uDC49 Please enter your choice");

            while (!isAdded) {
                System.out.print("\uD83D\uDC49");
                int choice = enterHumanUserChoice(availablePokemons.size(), scanner);
                pokemon = availablePokemons.get(choice - 1);
                isAdded = this.addPokemonToCurrentList(pokemon);
                if (isAdded) {
                    System.out.println("\u2714 " + pokemon.getName() + " has been successfully chosen.");
                } else {
                    System.out.println("\u274C " + pokemon.getName() + " has been already chosen. Please choose another pokemon!");
                }
            }
            pokemons.add(pokemon);
        }
    }

    @Override
    public void choosePokemonForBattleFromCurrentList(Scanner scanner) {

        System.out.println("❗ Please choose your pokemon for this turn:");
        System.out.println(GameHelper.printListOfPokemons(this.currentPokemons));
        System.out.print("\n\uD83D\uDC49 ");
        int choice = enterHumanUserChoice(currentPokemons.size(), scanner);

        Pokemon pokemonForBattle = this.currentPokemons.get(choice - 1);
        this.currentPokemonForBattle = pokemonForBattle;
        this.removePokemonFromCurrentList(pokemonForBattle);
        System.out.println("✔ You chose " + this.currentPokemonForBattle.getName() + "!");

    }

    @Override
    public void changeCurrentPokemon(Scanner scanner) {
        if (this.currentPokemons.size() != 0) {
            Pokemon lastCurrentPokemon = this.currentPokemonForBattle;
            this.choosePokemonForBattleFromCurrentList(scanner);
            // in case that current pokemon is not dead
            if (lastCurrentPokemon != null) {
                this.addPokemonToCurrentList(lastCurrentPokemon);
            }
        } else {
            System.out.println("Cannot change current pokemon");
        }
    }

    @Override
    public int enterHumanUserChoice(int upperBound, Scanner scanner) {
        String choice = scanner.next();
        while (!Validator.validateUserInputChoice(upperBound, choice)) {
            choice = scanner.next();
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
