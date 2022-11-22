package users;
import pokemons.Pokemon;
import java.util.Scanner;

public interface IHumanUser {
    boolean addPokemonToAvailableList(Pokemon pokemon);
    boolean removePokemonFromAvailableList(Pokemon pokemon);
    String printAvailablePokemons();
    boolean addPokemonToDeadList(Pokemon pokemon);
    boolean removePokemonFromDeadList(Pokemon pokemon);
    String printDeadPokemons();
    int chooseOptionBeforeEachTurn(Scanner scan);

}
