package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class BlazeKick extends PokemonAttack {

    public BlazeKick() {
        this.type = "fire";
        this.attackPower = 1.1 * super.attackPower;
        this.description = "Blaze kick attack has a chance to burn the opponent for additional extra damage.";
    }

    public double blazeKick(Pokemon userPokemon, Pokemon enemyPokemon) {
        Random chanceToBurnOpponentForExtraDmg = new Random();
        double attackPower;
        int chance = chanceToBurnOpponentForExtraDmg.nextInt(2);

        if (chance == 0) {
            attackPower = (userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.3;

        } else {
            attackPower = (userPokemon.getAttackPoints() + this.attackPower + 7) - enemyPokemon.getDefencePoints() * 0.3;

        }
        enemyPokemon.setHp(enemyPokemon.getHp() - attackPower);
        return attackPower;
    }
}
