package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class MagneticFlux extends PokemonAttack {

    public MagneticFlux() {
        this.name = "MagneticFlux";
        this.type = "electric";
        this.description = "Magnetic Flux attack decreases opponent's hp";
    }

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        double finalAttackPower = (userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.4;

        if (finalAttackPower < 0) {
            finalAttackPower = 0.5 * this.attackPower;
        }

        enemyPokemon.setHp(enemyPokemon.getHp() - finalAttackPower);
        return finalAttackPower;
    }
}
