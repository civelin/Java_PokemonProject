package attacks.grass;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class HornLeech extends PokemonAttack {
    public HornLeech() {
        this.name = "HornLeech";
        this.type = "grass";
        this.description = "Horn Leech attack increases pokemon's hp up to 25 points if it's under 25 points.";
    }

    // Increase hp up to 25 points if it's under 25 points
    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        if (userPokemon.getHp() < 25) {
            userPokemon.setHp(25);
        }
        System.out.println(userPokemon.getName() + " hp after the attack is " + userPokemon.getHp());
        return userPokemon.getHp();
    }
}
