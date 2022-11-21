package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.ArrayList;
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

    // methods
    @Override
    public String printCurrentPokemons() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.currentPokemons.size(); i++) {
            stringBuilder.append(" " + (i + 1) + ". " + this.currentPokemons.get(i).getName());
        }
        return stringBuilder.toString();
    }



}
