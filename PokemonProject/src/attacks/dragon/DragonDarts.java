package attacks.dragon;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class DragonDarts extends PokemonAttack {

    public DragonDarts(){
        this.type = "dragon";
        this.attackPower = 1.2*super.attackPower;
    }
    //User attacks twice.
    public double dragonDarts(Pokemon userPokemon , Pokemon enemyPokemon){
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints() ;
        double finalInflictedDmg = pokemonAttackPower - dmgReductionAccordingToEnemyPokemonDefencePoints;
        return finalInflictedDmg*2;

    }
}
