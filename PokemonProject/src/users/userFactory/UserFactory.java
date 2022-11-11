package users.userFactory;

import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.User;

public class UserFactory {

    public static User pcUser1() {
        User pcUser1 = new PCUser("Misty", PokemonFactory.PCUser1Pokemons());
        return pcUser1;
    }

    public static User pcUser2() {
        User pcUser2 = new PCUser("Blaine", PokemonFactory.PCUser2Pokemons());
        return pcUser2;
    }

    public static User pcUser3() {
        User pcUser3 = new PCUser("James", PokemonFactory.PCUser3Pokemons());
        return pcUser3;
    }

    public static User humanUser(){
        User humanUser = new HumanUser("Az", PokemonFactory.getUserSmallPokemons());
        return humanUser;
    }
}
