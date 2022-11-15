package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public interface IUser {
    List<Pokemon> getAvailablePokemons();

    List<Pokemon> getCurrentPokemons();

    String getName();

    String printCurrentPokemon();
    List<Pokemon> choosePokemonsFromAvailableListToCurrentList();
    Pokemon choosePokemonForBattleFromCurrentList();
    boolean addPokemonToCurrentList(Pokemon pokemon);
    boolean removePokemonFromCurrentList(Pokemon pokemon);

    PokemonAttack chooseAttack(Pokemon pokemon);
}
