package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;


public interface IUser {

    // methods
    PokemonAttack chooseAttack();

    List<Pokemon> choosePokemonsFromAvailableListToCurrentList();
    Pokemon choosePokemonForBattleFromCurrentList();

    boolean removePokemonFromCurrentList(Pokemon pokemon);
    boolean addPokemonToCurrentList(Pokemon pokemon);

    Pokemon changeCurrentPokemon();
}
