package users;

import pokemons.Pokemon;

public interface Addable {
    void addPokemonToCurrentList(Pokemon pokemon);
    void addPokemonToAvailableList(Pokemon pokemon);

    void addPokemonToDeadList(Pokemon pokemon);

}
