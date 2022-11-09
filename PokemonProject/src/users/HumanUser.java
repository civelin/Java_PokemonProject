package users;

import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class HumanUser extends User implements Removable, Addable {

    private int crystals;
    private List<Pokemon> deadPokemonList;

    public HumanUser(String name, List<Pokemon> availablePokemons) {
        this.name = name;
        this.crystals = 0;
        this.availablePokemons = availablePokemons;
        this.currentPokemons = new ArrayList<>();
        this.deadPokemonList = new ArrayList<>();
    }

    public void addCrystals(){
        this.crystals++;
    }

    public void removeCrystals() {
        if (this.crystals > 0) {
            this.crystals--;
        }
    }
    //interfaces
    @Override
    public void addPokemonToCurrentList(Pokemon pokemon) {
        this.currentPokemons.add(pokemon);
    }

    @Override
    public void addPokemonToAvailableList(Pokemon pokemon) {
        this.availablePokemons.add(pokemon);
    }

    @Override
    public void addPokemonToDeadList(Pokemon pokemon) {
        this.deadPokemonList.add(pokemon);
    }

    @Override
    public void removePokemonFromCurrentList(Pokemon pokemon) {
        this.currentPokemons.remove(pokemon);
    }

    @Override
    public void removePokemonFromAvailableList(Pokemon pokemon) {
        this.availablePokemons.remove(pokemon);
    }

    @Override
    public void removePokemonFromDeadList(Pokemon pokemon) {
        this.deadPokemonList.remove(pokemon);
    }
}
