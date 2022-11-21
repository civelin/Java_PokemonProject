package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public interface IUser {

    // methods
    List<Pokemon> choosePokemonsFromAvailableListToCurrentList();

    Pokemon choosePokemonForBattleFromCurrentList();

    boolean removePokemonFromCurrentList(Pokemon pokemon);
    boolean addPokemonToCurrentList(Pokemon pokemon);
    String printCurrentPokemons();

    PokemonAttack chooseAttack();

    Pokemon changeCurrentPokemon();
}
