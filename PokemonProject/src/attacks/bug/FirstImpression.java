package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class FirstImpression extends PokemonAttack {

    public FirstImpression() {
        this.type = "bug";
        this.description = "First Impression attack only works the first turn the user is in battle./n It increases enemy's hp. ";
    }

    //Although this move has great power, it only works the first turn the user is in battle.
    public double firstImpression(Pokemon userPokemon, Pokemon enemyPokemon) {
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        double finalInflictedDmg = (pokemonAttackPower + (this.attackPower)) - dmgReductionAccordingToEnemyPokemonDefencePoints;
        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);
        return finalInflictedDmg;
    }

}
