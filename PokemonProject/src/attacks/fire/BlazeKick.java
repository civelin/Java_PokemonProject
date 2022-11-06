package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class BlazeKick extends PokemonAttack {

    public BlazeKick(){
        this.type = "fire";
        this.attackPower =1.2*super.attackPower;
    }

    public double blazeKick(Pokemon userPokemon, Pokemon enemyPokemon){
        Random chanceToBurnOpponentForExtraDmg=new Random();
        double attackPower;
        int chance = chanceToBurnOpponentForExtraDmg.nextInt(1+1);

        if(chance==0){
            attackPower = (userPokemon.getAttackPoints()+this.attackPower) - enemyPokemon.getDefencePoints()*0.3;
            return attackPower;
        }else {
            attackPower = (userPokemon.getAttackPoints()+this.attackPower+7) - enemyPokemon.getDefencePoints()*0.3;
            return attackPower;
        }
    }
}
