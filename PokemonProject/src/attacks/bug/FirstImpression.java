package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class FirstImpression extends PokemonAttack {
    // bug

    public FirstImpression(){
        this.type = "bug";
        this.attackPower=3.2*super.attackPower;

    }
    //Although this move has great power, it only works the first turn the user is in battle.
    public double firstImpression(Pokemon userPokemon, Pokemon enemyPokemon){
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints()*0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        double finalInflictedDmg = (pokemonAttackPower + (this.attackPower)) -dmgReductionAccordingToEnemyPokemonDefencePoints;
        String descriptiveText = userPokemon.getName()+" is using 'First Impression' ability against "+enemyPokemon.getName()+".";
        System.out.println(descriptiveText);
        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);
        return   finalInflictedDmg;
    }
}
