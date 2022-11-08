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




    @Override
    public void addPokemonToCurrentList(Pokemon pokemon) {
        this.currentPokemons.add(pokemon);
    }

    @Override
    public void addPokemonToAvailableList(Pokemon pokemon) {

    }

    @Override
    public void addPokemonToDeadList(Pokemon pokemon) {

    }

    @Override
    public void removePokemonFromCurrentList(Pokemon pokemon) {
        this.currentPokemons.remove(pokemon);
    }

    @Override
    public void removePokemonFromAvailableList(Pokemon pokemon) {

    }

    @Override
    public void removePokemonFromDeadList(Pokemon pokemon) {

    }
}
