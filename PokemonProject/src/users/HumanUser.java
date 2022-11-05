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

    //interfaces
    @Override
    public void addPokemonToCurrentList(Pokemon pokemon) {

    }

    @Override
    public void addPokemonToAvailableList(Pokemon pokemon) {

    }

    @Override
    public void addPokemonToDeadList(Pokemon pokemon) {

    }

    @Override
    public void removePokemonFromCurrentList(Pokemon pokemon) {

    }

    @Override
    public void removePokemonFromAvailableList(Pokemon pokemon) {

    }

    @Override
    public void removePokemonFromDeadList(Pokemon pokemon) {

    }
}
