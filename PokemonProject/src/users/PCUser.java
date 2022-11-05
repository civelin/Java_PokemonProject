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

    public void generateCurrentThreePokemonsFromAvailableList() {
    }

    void removePokemonFromCurrentList(Pokemon pokemon) {

    }
}
