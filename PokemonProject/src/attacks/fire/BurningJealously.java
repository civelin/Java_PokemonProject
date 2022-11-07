package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class BurningJealously extends PokemonAttack {

    public BurningJealously(){
        this.type = "fire";
        this.attackPower =1.1*super.attackPower;
    }

    //Hits all opponents

    public double burningJealously(Pokemon userPokemon, List<Pokemon> enemyPokemons){
        double attackPower = userPokemon.getAttackPoints()+this.attackPower;
        for(Pokemon pokemon: enemyPokemons){
            pokemon.setHp(pokemon.getHp()-(attackPower-pokemon.getDefencePoints()));
        }

        return attackPower;
    }
}
