package attacks.grass;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class HornLeech extends PokemonAttack {
    public HornLeech() {
        this.name = "HornLeech";
        this.type = "grass";
        this.description = "Horn Leech attack increases pokemon's hp up to 25 points if it's under 25 points.";
    }

    // Increase hp up to 25 points if it's under 25 points
    public double attack(Pokemon userPokemon) {
        if (userPokemon.getHp() < 25) {
            userPokemon.setHp(25);
        }
        System.out.println(userPokemon.getName() + " hp after the ability is " + userPokemon.getHp());
        return userPokemon.getHp();
    }
}
