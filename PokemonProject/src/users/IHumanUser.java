package users;

import pokemons.Pokemon;

import java.util.List;
import java.util.Scanner;

public interface IHumanUser {
    int enterHumanUserChoice(int upperBound, Scanner scanner);

    boolean addPokemonToAvailableList(Pokemon pokemon);

    boolean removePokemonFromAvailableList(Pokemon pokemon);

    boolean addPokemonToDeadList(Pokemon pokemon);

    boolean removePokemonFromDeadList(Pokemon pokemon);

    void choosePokemonAsReward(List<Pokemon> pokemons, Scanner scanner);

    void revivePokemon(Scanner scanner);


}
