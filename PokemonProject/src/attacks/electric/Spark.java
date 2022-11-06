package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class Spark extends PokemonAttack {

    public Spark(){
        this.type = "electric";
        this.attackPower = 1.6*super.attackPower;
    }

    public double spark(Pokemon userPokemon, Pokemon enemyPokemon){
        Random randomChance = new Random();
        int critChance = randomChance.nextInt(1+1);
        double attackPower;
        if(critChance==0){
            attackPower=(userPokemon.getAttackPoints()+this.attackPower)*1.1 - enemyPokemon.getDefencePoints()*0.3;
          return   attackPower;
        }else {
            attackPower=((userPokemon.getAttackPoints()+this.attackPower)*1.5) - enemyPokemon.getDefencePoints()*0.2;
            return  attackPower;
        }
    }
}
