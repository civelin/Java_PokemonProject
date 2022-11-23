package users;

import pokemons.Pokemon;

import java.util.List;
import java.util.Scanner;

public interface IHumanUser {
    int enterHumanUserChoice(int upperBound, Scanner scan);

    boolean addPokemonToAvailableList(Pokemon pokemon);

    boolean removePokemonFromAvailableList(Pokemon pokemon);

    boolean addPokemonToDeadList(Pokemon pokemon);

    boolean removePokemonFromDeadList(Pokemon pokemon);

    int chooseOptionBeforeEachTurn();

    boolean choosePokemonAsReward(List<Pokemon> pokemons);

    Pokemon revivePokemon();


}
