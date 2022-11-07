package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class MegaPunch extends PokemonAttack {

    public MegaPunch() {
        this.type = "normal";
        this.attackPower = super.attackPower*1.5;
    }

    public double megaPunch(Pokemon userPokemon, Pokemon enemyPokemon) {
        // High critical hit ratio
        Random rnd = new Random();
        int critChance = rnd.nextInt(9 + 1);
        double finalInflictedDmg;
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints() ;
        if (critChance < 3) {
            finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * 1.3)) -dmgReductionAccordingToEnemyPokemonDefencePoints);


        } else if (critChance > 3 && critChance < 7) {
            finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * 1.6)) - dmgReductionAccordingToEnemyPokemonDefencePoints);

        } else {
            finalInflictedDmg = (pokemonAttackPower+ ((this.attackPower * 2)) - dmgReductionAccordingToEnemyPokemonDefencePoints);

        }

        enemyPokemon.setHp(enemyPokemon.getHp()-finalInflictedDmg);
        return finalInflictedDmg;


    }



}
