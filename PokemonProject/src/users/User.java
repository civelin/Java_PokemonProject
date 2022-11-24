package users;

import Utilities.Validator;
import pokemons.Pokemon;

import java.util.List;

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

    public void setCurrentPokemons(List<Pokemon> currentPokemons) {
        this.currentPokemons = currentPokemons;
    }

    // methods
    @Override
    public boolean addPokemonToCurrentList(Pokemon pokemon) {
        if (!Validator.checkIfGivenListContainsPokemon(this.currentPokemons, pokemon)) {
            this.currentPokemons.add(pokemon);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePokemonFromCurrentList(Pokemon pokemon) {
        if (Validator.checkIfGivenListContainsPokemon(this.currentPokemons, pokemon)) {
            this.currentPokemons.remove(pokemon);
            return true;
        }
        return false;
    }


}