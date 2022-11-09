package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class MagneticFlux extends PokemonAttack {

    public MagneticFlux() {
        this.name = "MagneticFlux";
        this.type = "electric";
        this.description = "Magnetic Flux attack decreases opponent's hp";
    }

    public double magneticFlux(Pokemon userPokemon, Pokemon enemyPokemon) {
        double finalAttackPower = (userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.4;

        if (finalAttackPower < 0) {
            finalAttackPower = 0.5 * this.attackPower;
        }

        enemyPokemon.setHp(enemyPokemon.getHp() - finalAttackPower);
        return finalAttackPower;
    }
}
