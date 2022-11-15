package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class BurningJealously extends PokemonAttack {

    public BurningJealously() {
        this.name = "BurningJealously";
        this.type = "fire";
        this.attackPower = 0.5 * super.attackPower;
        this.description = "Burning jealously attack hits all opponents.";
    }

    //Hits all opponents

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        double attackPower = userPokemon.getAttackPoints() + this.attackPower;
        for (Pokemon pokemon : enemyCurrentPokemons) {
            pokemon.setHp(pokemon.getHp() - (attackPower - pokemon.getDefencePoints()));
        }

        return attackPower;
    }


}
