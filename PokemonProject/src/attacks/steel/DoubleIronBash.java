package attacks.steel;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class DoubleIronBash extends PokemonAttack {

    public DoubleIronBash(){
        this.type = "steel";
        this.attackPower = 0.9*super.attackPower;
    }

    public double doubleIronBash(Pokemon userPokemon, Pokemon enemyPokemon){
        Random random = new Random();
        int critChance = random.nextInt(1+1 );
        double attackPower = userPokemon.getAttackPoints() + this.attackPower;
        double enemyDefencePoints = enemyPokemon.getDefencePoints();
        double finalInflictedDmg;
        if(critChance==0){
            finalInflictedDmg = attackPower - enemyDefencePoints;
        }else {
            finalInflictedDmg = attackPower*1.5 - enemyDefencePoints;
        }
        enemyPokemon.setHp(enemyPokemon.getHp()-finalInflictedDmg);
        return finalInflictedDmg;
    }
}
