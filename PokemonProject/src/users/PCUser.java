package users;

import Utilities.Validator;
import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PCUser extends User implements IPCUser {
    // constructor
    public PCUser(String name, List<Pokemon> availablePokemons) {
        this.name = name;
        this.availablePokemons = availablePokemons;
        this.currentPokemons = new ArrayList<>();
    }

    @Override
    public PokemonAttack chooseAttack() {
        int index = (int) Math.round(Math.random()); // return 0 or 1
        PokemonAttack attack = this.getCurrentPokemonForBattle().getAttacks()[index];
        System.out.println("✔ " + this.name + " has chosen " + attack.getName() + " attack for its move.");
        return attack;
    }

    @Override
    public int chooseOptionBeforeEachTurn(int turn) {
        if (turn == 1) {
            return 1;
        }
        Random random = new Random();
        int randomChoice = random.nextInt(15);

        return randomChoice;
    }

    @Override
    public List<Pokemon> choosePokemonsFromAvailableListToCurrentList() {
        Random randomPokemonGenerator = new Random();
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;

        int size = this.availablePokemons.size();
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            while (!flag) {
                int index = randomPokemonGenerator.nextInt(size);
                pokemon = this.availablePokemons.get(index);
                // add pokemon to current list
                flag = addPokemonToCurrentList(pokemon);
            }
            pokemons.add(pokemon);
            flag = false;
        }
        System.out.println("\uD83E\uDD14 " + this.name + " is choosing its current pokemons for the battle ...\n" + this.name + " has chosen: ");
        return pokemons;
    }

    public Pokemon choosePokemonForBattleFromCurrentList() {
        Random randomPokemonGenerator = new Random();
        int size = this.currentPokemons.size();
        int index = randomPokemonGenerator.nextInt(size);
        Pokemon pokemonForBattle = this.currentPokemons.get(index);

        this.currentPokemonForBattle = pokemonForBattle;
        this.removePokemonFromCurrentList(pokemonForBattle);

        System.out.println("\u2714 " + this.name + " has chosen " + pokemonForBattle.getName() + " for its move!");
        return pokemonForBattle;
    }

    @Override
    public Pokemon changeCurrentPokemon() {
        if(this.currentPokemons.size() != 0){
            System.out.println(this.name + " is going to change its pokemon for battle");
            Pokemon lastCurrentPokemon = this.currentPokemonForBattle;
            Pokemon newCurrentPokemon = choosePokemonForBattleFromCurrentList();
            if (lastCurrentPokemon != null) {
                this.addPokemonToCurrentList(lastCurrentPokemon); // return in currentList
            }
            return newCurrentPokemon;
        } else {
            System.out.println("Cannot change current pokemon");
            return null;
        }

    }
}
