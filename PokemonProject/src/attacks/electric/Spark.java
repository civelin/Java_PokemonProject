package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class Spark extends PokemonAttack {

    public Spark() {
        this.name = "Spark";
        this.type = "electric";
        this.description = "Spark attack has equal chances to hit opponent's hp or miss the target.";
    }


    public double attack(Pokemon userPokemon, Pokemon enemyPokemon) {

        Random randomChance = new Random();
        int critChance = randomChance.nextInt(2); //return 0 or 1

        double finalAttackPower = critChance * ((userPokemon.getAttackPoints() + this.attackPower) * 1.1 - enemyPokemon.getDefencePoints() * 0.3);
        if (finalAttackPower < 0) {
            finalAttackPower = this.attackPower;
        }
        enemyPokemon.setHp(enemyPokemon.getHp() - finalAttackPower);

        return critChance;
    }
}
