package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class AttackOrder extends PokemonAttack {

    public AttackOrder(){
        this.type="bug";
    }
    public double highCriticalHitRatio(Pokemon userPokemon, Pokemon enemyPokemon) {
        // High critical hit ratio
        Random rnd=new Random();
        double critChance=rnd.nextDouble(9+1);
        double attackPower;
        if(critChance<3) {
             attackPower = userPokemon.getAttackPoints()+((this.attackPower*1.3)-enemyPokemon.getDefencePoints());
            return attackPower;
        } else if (critChance>3&&critChance<7) {
            attackPower = userPokemon.getAttackPoints()+((this.attackPower*1.6)-enemyPokemon.getDefencePoints());
            return attackPower;
        } else  {
            attackPower = userPokemon.getAttackPoints()+((this.attackPower*2)-enemyPokemon.getDefencePoints());
            return attackPower;
        }
    }
    // bug
}
