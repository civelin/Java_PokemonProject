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
        int critChance = rnd.nextInt(9 + 1);
        double finalInflictedDmg;
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints() ;
        String descriptiveText = userPokemon.getName()+" is using 'Attack Order' ability against "+enemyPokemon.getName()+".";
        if (critChance < 3) {
            finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * 1.3)) -dmgReductionAccordingToEnemyPokemonDefencePoints);


        } else if (critChance > 3 && critChance < 7) {
            finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * 1.6)) - dmgReductionAccordingToEnemyPokemonDefencePoints);
            System.out.println(descriptiveText);
        } else {
            finalInflictedDmg = (pokemonAttackPower+ ((this.attackPower * 2)) - dmgReductionAccordingToEnemyPokemonDefencePoints);

        }
        System.out.println(descriptiveText);
        enemyPokemon.setHp(enemyPokemon.getHp()-finalInflictedDmg);
        return finalInflictedDmg;


    }

}
