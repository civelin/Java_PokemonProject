package users;

import Utilities.GameHelper;
import attacks.PokemonAttack;
import pokemons.Pokemon;
import Utilities.Validator;

import java.util.*;

public class HumanUser extends User implements IHumanUser {

    // fields
    private int crystals;
    private List<Pokemon> deadPokemonList;
    private static final Scanner scan = new Scanner(System.in);

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
        if (!Validator.checkIfGivenListContainsPokemon(this.availablePokemons, newPokemon)) {
            this.availablePokemons.add(newPokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePokemonFromAvailableList(Pokemon pokemon) {
        if (Validator.checkIfGivenListContainsPokemon(this.availablePokemons, pokemon)) {
            this.availablePokemons.remove(pokemon);
            return true;
        }
        return false;
    }



    @Override
    public boolean addPokemonToDeadList(Pokemon pokemon) {
        if (pokemon.isPokemonDead() && !Validator.checkIfGivenListContainsPokemon(this.deadPokemonList, pokemon)) {
            this.deadPokemonList.add(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePokemonFromDeadList(Pokemon pokemon) {
        if (Validator.checkIfGivenListContainsPokemon(this.deadPokemonList, pokemon)) {
            this.deadPokemonList.remove(pokemon);
            return true;
        }
        return false;
    }


    @Override
    public PokemonAttack chooseAttack() {

        this.currentPokemonForBattle.printAttacks();
        System.out.println("\uD83D\uDC49 Please select attack:");
        System.out.print("\uD83D\uDC49");
        int choice = enterHumanUserChoice(2, scan);
        return this.currentPokemonForBattle.getAttacks()[choice - 1];
    }

    @Override
    public int chooseOptionBeforeEachTurn() {

        return enterHumanUserChoice(3, scan);
    }

    @Override
    public boolean choosePokemonAsReward(List<Pokemon> pokemons) {
        System.out.println("Choose one of the pokemons as a reward!");
        int index = 1;
        for (Pokemon pokemon : pokemons) {
            System.out.println(index + "." + pokemon.getName());
            index++;
        }

        int choice = enterHumanUserChoice(pokemons.size(), scan);

        Pokemon rewardPokemon = pokemons.get(choice - 1);

        if (addPokemonToAvailableList(rewardPokemon)) {
            System.out.println("Congratulation , you have added successfully " + pokemons.get(choice - 1).getName() + " to your pokemon inventory!");
            pokemons.remove(rewardPokemon);
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
            GameHelper.printListOfPokemons(this.deadPokemonList);
            int choice = enterHumanUserChoice(deadPokemonList.size(), scan);
            Pokemon chosenDeadPokemon = this.deadPokemonList.get(choice - 1);
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
        GameHelper.printListOfPokemons(this.availablePokemons);

        for (int i = 1; i <= 3; i++) {
            boolean isAdded = false;
            System.out.println("\uD83D\uDC49 Please enter your choice");

            while (!isAdded) {
                System.out.print("\uD83D\uDC49");
                int choice = enterHumanUserChoice(availablePokemons.size(), scan);
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
        return pokemons;
    }

    @Override
    public Pokemon choosePokemonForBattleFromCurrentList() {

        System.out.println("❗ Please choose your pokemon for this turn:");
        System.out.println(GameHelper.printListOfPokemons(this.currentPokemons));
        System.out.print("\n\uD83D\uDC49 ");
        int choice = enterHumanUserChoice(currentPokemons.size(), scan);

        Pokemon pokemonForBattle = this.currentPokemons.get(choice - 1);
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
    @Override
    public int enterHumanUserChoice(int upperBound, Scanner scan) {
        String choice = scan.next();
        while (!Validator.validateUserInputForChoice(upperBound, choice)) {
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


}
