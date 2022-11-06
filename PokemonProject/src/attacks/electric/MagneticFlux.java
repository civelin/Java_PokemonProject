package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class MagneticFlux extends PokemonAttack {

    public MagneticFlux(){
        this.type = "electric";
        this.attackPower = 1.4*super.attackPower;
    }

    public double magneticFlux(Pokemon userPokemon , Pokemon enemyPokemon){
        double attackPower = (userPokemon.getAttackPoints()+this.attackPower) - enemyPokemon.getDefencePoints()*0.4;
        return attackPower;
    }
}
