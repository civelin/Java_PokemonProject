package users;

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
            this.currentPokemons.remove(pokemon);
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

    public void choosePokemonsFromAvailableListToCurrentList() {
        Random randomPokemonGenerator = new Random();
        int size = this.availablePokemons.size(); //5
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            int index = randomPokemonGenerator.nextInt(size);
            Pokemon pokemon = this.availablePokemons.get(index);
            while(!flag){
                // add pokemon to current list
                flag = addPokemonToCurrentList(pokemon);
            }
            flag = false;
        }
    }

    public Pokemon choosePokemonForBattleFromCurrentList() {
        Random randomPokemonGenerator = new Random();
        int size = this.currentPokemons.size();
        int index = randomPokemonGenerator.nextInt(size);
        Pokemon pokemonForBattle = this.currentPokemons.get(index);
        return pokemonForBattle;
    }

//    TODO: public Attack chooseAttackForTheCurrentTurn(){};

}
