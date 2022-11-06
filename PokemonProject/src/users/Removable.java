package users;

import pokemons.Pokemon;

public interface Removable {
    void removePokemonFromCurrentList(Pokemon pokemon);
    void removePokemonFromAvailableList(Pokemon pokemon);
    void removePokemonFromDeadList(Pokemon pokemon);
}
