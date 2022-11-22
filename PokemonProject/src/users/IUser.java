package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;
import java.util.Scanner;

public interface IUser {

    // methods
    PokemonAttack chooseAttack();

    List<Pokemon> choosePokemonsFromAvailableListToCurrentList();
    Pokemon choosePokemonForBattleFromCurrentList();


    boolean removePokemonFromCurrentList(Pokemon pokemon);
    boolean addPokemonToCurrentList(Pokemon pokemon);
    String printCurrentPokemons();

    Pokemon changeCurrentPokemon();
}
