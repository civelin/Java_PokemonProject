package users;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public interface IPCUser {
    int chooseOptionBeforeEachTurn(int turn);

}
