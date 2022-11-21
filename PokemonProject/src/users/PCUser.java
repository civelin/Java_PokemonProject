package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PCUser extends User {

    public PCUser(String name, List<Pokemon> availablePokemons) {
        this.name = name;
        this.availablePokemons = availablePokemons;
        this.currentPokemons = new ArrayList<>();
    }


    //TODO: make PC-user to think logically.

    @Override
    public boolean addPokemonToCurrentList(Pokemon pokemon) {
        if (!currentPokemons.contains(pokemon)) {
            this.currentPokemons.add(pokemon);
            return true;
        } else {
            return false;
        }
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
        int index = (int) Math.round(Math.random());
        PokemonAttack attack = pokemon.getAttacks()[index];
        System.out.println("✔ " + this.name + " has chosen " + attack.getName() + " attack for its move.");
        return attack;
    }

    @Override
    public int userChoiceOptionAfterEachTurn() {
        Random random = new Random();
        int randomChoice = random.nextInt(6);

        return randomChoice;
    }

    @Override
    public List<Pokemon> choosePokemonsFromAvailableListToCurrentList() {
        Random randomPokemonGenerator = new Random();
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon = null;

        int size = this.availablePokemons.size(); //5
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
        pokemonForBattle.changeIsPokemonFightingStatus();

        System.out.println("\u2714 " + this.name + " has chosen " + pokemonForBattle.getName() + " for its move!");
        System.out.println();
        return pokemonForBattle;
    }

    
//    TODO: public Attack chooseAttackForTheCurrentTurn(){};

}
