package users;

import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements IUser {
    protected String name;
    protected List<Pokemon> currentPokemons;
    protected List<Pokemon> availablePokemons;

    public List<Pokemon> getAvailablePokemons() {
        return availablePokemons;
    }

    public List<Pokemon> getCurrentPokemons() {
        return currentPokemons;
    }

    public String getName() {
        return name;
    }

    public String printCurrentPokemon() {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < this.currentPokemons.size(); i++) {
            strBuilder.append(" " + (i + 1) + ". " + this.currentPokemons.get(i).getName());
        }
        return strBuilder.toString();
    }

    public void setAvailablePokemons(List<Pokemon> availablePokemons) {
        this.availablePokemons = availablePokemons;
    }
}
