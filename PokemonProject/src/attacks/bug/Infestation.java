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
    public double infestation(Pokemon userPokemon){
        double finalInflictedDmg = userPokemon.getAttackPoints()*0.5;
        return finalInflictedDmg;
    }
    // bug
}
