package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class FirstImpression extends PokemonAttack {

    public FirstImpression() {
        this.name = "FirstImpression";
        this.type = "bug";
        this.description = "First Impression attack only works the first turn the user is in battle. It decreases enemy's hp. ";
        this.attackPower = 1.9 * super.attackPower;
    }

    //Although this move has great power, it only works the first turn the user is in battle.
    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        double finalInflictedDmg = (pokemonAttackPower + (this.attackPower)) - dmgReductionAccordingToEnemyPokemonDefencePoints;
        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);
        System.out.println(userPokemon.getName()+" has attacked "+enemyPokemon.getName());
        System.out.println(enemyPokemon.getName()+" new hp ----> "+enemyPokemon.getHp());
        return finalInflictedDmg;
    }

}
