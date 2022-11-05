package users;

import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String name;
    protected List<Pokemon> currentPokemons;
    protected List<Pokemon> availablePokemons;

}
