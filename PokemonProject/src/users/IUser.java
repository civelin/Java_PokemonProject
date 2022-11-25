package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;
import java.util.Scanner;


public interface IUser {

    // methods
    PokemonAttack chooseAttack(Scanner scanner);
    void choosePokemonsFromAvailableListToCurrentList(Scanner scanner);
    void choosePokemonForBattleFromCurrentList(Scanner scanner);
    boolean removePokemonFromCurrentList(Pokemon pokemon);
    boolean addPokemonToCurrentList(Pokemon pokemon);

    void changeCurrentPokemon(Scanner scanner);
}
