package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class AttackOrder extends PokemonAttack {

    public AttackOrder() {
        this.type = "bug";
        this.attackPower = super.attackPower*1.5;
    }

    public double highCriticalHitRatio(Pokemon userPokemon, Pokemon enemyPokemon) {
        // High critical hit ratio
        Random rnd = new Random();
        double critChance = rnd.nextDouble(9 + 1);
        double finalInfclictedDmg;
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints() ;
        if (critChance < 3) {
            finalInfclictedDmg = (pokemonAttackPower + ((this.attackPower * 1.3)) -dmgReductionAccordingToEnemyPokemonDefencePoints);
            return finalInfclictedDmg;
        } else if (critChance > 3 && critChance < 7) {
            finalInfclictedDmg = (pokemonAttackPower + ((this.attackPower * 1.6)) - dmgReductionAccordingToEnemyPokemonDefencePoints);
            return finalInfclictedDmg;
        } else {
            finalInfclictedDmg = (pokemonAttackPower+ ((this.attackPower * 2)) - dmgReductionAccordingToEnemyPokemonDefencePoints);
            return finalInfclictedDmg;
        }
    }

}
