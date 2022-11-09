package users;

import pokemons.Pokemon;

public interface Removable {
    boolean removePokemonFromCurrentList(Pokemon pokemon);
    boolean removePokemonFromAvailableList(Pokemon pokemon);
}
