package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class LeechLife  extends PokemonAttack {

    public LeechLife(){
        this.type = "bug";
        this.attackPower = 1.2*super.attackPower;
    }
    //User recovers half the HP inflicted on opponent.
    public double leechLifeDPS(Pokemon userPokemon, Pokemon enemyPokemon){
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints() ;
        double finalInflictedDmg = (pokemonAttackPower + this.attackPower) - dmgReductionAccordingToEnemyPokemonDefencePoints;
        return finalInflictedDmg;
    }

    public double leechLifeHeal(double leechLifeDPS){
        double amountOfHeal = leechLifeDPS/2;
        return amountOfHeal;
    }
}
