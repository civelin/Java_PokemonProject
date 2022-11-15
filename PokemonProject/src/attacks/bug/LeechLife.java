package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class LeechLife extends PokemonAttack {

    public LeechLife() {
        this.name = "LeechLife";
        this.type = "bug";
        this.description = "Leech Life attack recovers half the hp inflicted on opponent";
    }

    //User recovers half the HP inflicted on opponent.
    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.6;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        double finalInflictedDmg = 0.8 * (pokemonAttackPower + this.attackPower) - dmgReductionAccordingToEnemyPokemonDefencePoints;

        if (finalInflictedDmg <= 0) {
            finalInflictedDmg = this.attackPower;
        }
        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);

        if (userPokemon.getHp() + finalInflictedDmg / 2 < userPokemon.returnInitialHP()) {
            userPokemon.setHp(userPokemon.getHp() + finalInflictedDmg / 2);
        } else {
            userPokemon.setHp(userPokemon.returnInitialHP());
        }

        return finalInflictedDmg;
    }


}
