package users;

import Utilities.GameHelper;
import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PCUser extends User implements IPCUser {
    // constructor
    public PCUser(String name, List<Pokemon> availablePokemons) {
        this.name = name;
        this.availablePokemons = availablePokemons;
        this.currentPokemons = new ArrayList<>();
    }

    @Override
    public PokemonAttack chooseAttack(Scanner scanner) {
        int index = (int) Math.round(Math.random()); // return 0 or 1
        PokemonAttack attack = this.getCurrentPokemonForBattle().getAttacks()[index];
        System.out.println("✔ " + this.name + " chose " + attack.getName() + " attack for this turn.");
        return attack;
    }

    @Override
    public int chooseOptionBeforeEachTurn(int turn) {
        if (turn == 1) {
            return 1;
        }
        Random random = new Random();

        return random.nextInt(15);
    }

    @Override
    public void choosePokemonsFromAvailableListToCurrentList(Scanner scanner) {
        Random randomPokemonGenerator = new Random();
        Pokemon pokemon;

        int size = this.availablePokemons.size();
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            while (!flag) {
                int index = randomPokemonGenerator.nextInt(size);
                pokemon = this.availablePokemons.get(index);
                // add pokemon to current list
                flag = addPokemonToCurrentList(pokemon);
            }
            flag = false;
        }
        System.out.println("\uD83E\uDD14 " + this.name + " is choosing 3 pokemons for the battle ...\n" + this.name + " has chosen: ");
        System.out.println(GameHelper.printListOfPokemons(this.currentPokemons));

    }

    @Override
    public void choosePokemonForBattleFromCurrentList(Scanner scanner) {
        Random randomPokemonGenerator = new Random();
        int size = this.currentPokemons.size();
        int index = randomPokemonGenerator.nextInt(size);
        Pokemon pokemonForBattle = this.currentPokemons.get(index);

        this.currentPokemonForBattle = pokemonForBattle;
        this.removePokemonFromCurrentList(pokemonForBattle);

        System.out.println("\u2714 " + this.name + " has chosen " + pokemonForBattle.getName() + " for their move!");

    }

    @Override
    public void changeCurrentPokemon(Scanner scanner) {
        if(this.currentPokemons.size() != 0){
            System.out.println(this.name + " is going to change the pokemon!");
            Pokemon lastCurrentPokemon = this.currentPokemonForBattle;
            choosePokemonForBattleFromCurrentList(scanner);
            if (lastCurrentPokemon != null) {
                this.addPokemonToCurrentList(lastCurrentPokemon); // return in currentList
            }
        } else {
            System.out.println(this.name + "has tried unsuccessfully to change their current pokemon, because the others are defeated.");

        }

    }
}
