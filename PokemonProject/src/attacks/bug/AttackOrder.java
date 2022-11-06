package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class AttackOrder extends PokemonAttack {

    public AttackOrder(){
        this.type="bug";
        this.attackPower=1.7 * super.attackPower;
    }
    @Override
    public double attackProperty(Pokemon userPokemon, Pokemon enemyPokemon) {
        userPokemon.setAttackPoints(userPokemon.getAttackPoints()+this.attackPower);
        double attackPoints = userPokemon.getAttackPoints();
         enemyPokemon.setHp(enemyPokemon.getHp() - (attackPoints-enemyPokemon.getDefencePoints()));
        double dmgDealt = enemyPokemon.getHp();
        return dmgDealt;

    }
    // bug
}
