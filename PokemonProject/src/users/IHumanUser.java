package users;

import pokemons.Pokemon;

public interface IHumanUser {
    int addCrystals();
    int removeCrystals();
    boolean addPokemonToAvailableList(Pokemon pokemon);
    boolean addPokemonToDeadList(Pokemon pokemon);
    boolean removePokemonFromAvailableList(Pokemon pokemon);


}
