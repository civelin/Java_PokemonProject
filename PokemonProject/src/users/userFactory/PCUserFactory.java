package users.userFactory;

import pokemons.pokemonFactory.PokemonFactory;
import users.PCUser;

public class PCUserFactory {

    // private constructor
    private PCUserFactory(){};

    public static PCUser pcUser1() {
        PCUser pcUser1 = new PCUser("Misty", PokemonFactory.PCUser1Pokemons());
        return pcUser1;
    }

    public static PCUser pcUser2() {
        PCUser pcUser2 = new PCUser("Blaine", PokemonFactory.PCUser2Pokemons());
        return pcUser2;
    }

    public static PCUser pcUser3() {
        PCUser pcUser3 = new PCUser("James", PokemonFactory.PCUser3Pokemons());
        return pcUser3;
    }

}
