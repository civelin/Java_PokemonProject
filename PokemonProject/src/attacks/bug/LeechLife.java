package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class LeechLife extends PokemonAttack {

    public LeechLife() {
        this.name = "LeechLife";
        this.type = "bug";
        this.description = "Leech Life attack recovers half the hp inflicted on opponent";
    }

    //User recovers half the HP inflicted on opponent.
    public double leechLife(Pokemon userPokemon, Pokemon enemyPokemon) {

        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double pokemonAttackPower = userPokemon.getAttackPoints();
        double finalInflictedDmg = (pokemonAttackPower + this.attackPower) - dmgReductionAccordingToEnemyPokemonDefencePoints;

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
