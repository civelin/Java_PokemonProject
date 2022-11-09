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

    public void addCrystals() {
        this.crystals++;
    }

    public void removeCrystals() {
        if (this.crystals > 0) {
            this.crystals--;
            System.out.println("-> Available crystals: " + this.crystals);
        }
    }

    //interfaces
    @Override
    public boolean addPokemonToCurrentList(Pokemon pokemon) {
        if (!currentPokemons.contains(pokemon)) {
            this.currentPokemons.add(pokemon);
            System.out.println("->" + pokemon.getName() + " has been successfully chosen.");
            return true;
        } else {
            System.out.println("->" + this.name + " has been already chosen.");
            return false;
        }
    }

    public boolean addPokemonToAvailableList(Pokemon pokemon) {
        if (!availablePokemons.contains(pokemon)) {
            this.availablePokemons.add(pokemon);
            return true;
        } else {
            return false;
        }
    }


    private void addPokemonToDeadList(Pokemon pokemon) {
        this.deadPokemonList.add(pokemon);
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


    public boolean removePokemonFromDeadList(Pokemon pokemon) {
        if (this.deadPokemonList.contains(pokemon)) {
            this.deadPokemonList.remove(pokemon);
            return true;
        }
        return false;
    }
}
