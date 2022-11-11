package users;

import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class User implements Addable, Removable{
    protected String name;
    protected List<Pokemon> currentPokemons;
    protected List<Pokemon> availablePokemons;


}
