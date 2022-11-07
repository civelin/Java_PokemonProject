package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class Infestation extends PokemonAttack {

    public Infestation(){
        this.type = "bug";
        this.attackPower = 0;
    }
    //Traps opponent, damaging them for 4-5 turns.
    public double infestation(Pokemon userPokemon,Pokemon enemyPokemon){
        double attackPower = userPokemon.getAttackPoints()*0.3;
        enemyPokemon.setHp(enemyPokemon.getHp() - attackPower);
        String descriptiveText = userPokemon.getName()+" is using 'Infestation' ability against "+enemyPokemon.getName()+".";
        System.out.println(descriptiveText);

        return attackPower;
    }
    // bug
}
