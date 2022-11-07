package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class Charge extends PokemonAttack {

    public Charge(){
        this.type = "electric";
        this.attackPower =super.attackPower + 5;
    }

    //Raises user's Special Defense and next Electric move's power increases.

    public double charge(Pokemon userPokemon){
        double boostPokemonDefenceAndAttack =this.attackPower;
        userPokemon.setAttackPoints(userPokemon.getAttackPoints()+boostPokemonDefenceAndAttack);
        userPokemon.setDefencePoints(userPokemon.getDefencePoints()+boostPokemonDefenceAndAttack);
        return boostPokemonDefenceAndAttack;
    }
}
