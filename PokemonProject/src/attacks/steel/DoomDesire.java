package attacks.steel;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class DoomDesire extends PokemonAttack {

    public DoomDesire(){
        this.type = "steel";
        this.attackPower =2* super.attackPower;
    }

    public double doomDesire(Pokemon userPokemon , Pokemon enemyPokemon){
        double attackPower = userPokemon.getAttackPoints() + this.attackPower;
        double enemyDefencePoints = enemyPokemon.getDefencePoints();
        double finalInflictedDmg = attackPower - enemyDefencePoints;
        enemyPokemon.setHp(enemyPokemon.getHp()-finalInflictedDmg);
        return finalInflictedDmg;
    }
}
