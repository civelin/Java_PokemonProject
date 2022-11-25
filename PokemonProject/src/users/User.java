package users;

import Utilities.Validator;
import pokemons.Pokemon;

import java.util.List;
import java.util.Objects;

public abstract class User implements IUser {
    // fields
    protected String name;
    protected List<Pokemon> currentPokemons;
    protected List<Pokemon> availablePokemons;
    protected Pokemon currentPokemonForBattle;

    // getters and setters
    public List<Pokemon> getAvailablePokemons() {
        return availablePokemons;
    }
    public List<Pokemon> getCurrentPokemons() {
        return currentPokemons;
    }
    public String getName() {
        return name;
    }
    public Pokemon getCurrentPokemonForBattle() {
        return currentPokemonForBattle;
    }
    public void setCurrentPokemonForBattle(Pokemon currentPokemonForBattle) {
        this.currentPokemonForBattle = currentPokemonForBattle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setCurrentPokemons(List<Pokemon> currentPokemons) {
        this.currentPokemons = currentPokemons;
    }

    // methods
    @Override
    public boolean addPokemonToCurrentList(Pokemon pokemon) {
        if (!this.currentPokemons.contains(pokemon)) {
            this.currentPokemons.add(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePokemonFromCurrentList(Pokemon pokemon) {
        if (this.currentPokemons.contains(pokemon)) {
            this.currentPokemons.remove(pokemon);
            return true;
        }
        return false;
    }


}