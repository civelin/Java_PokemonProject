package attacks.dragon;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.Random;

public class ClangingScales extends PokemonAttack {

    public ClangingScales(){
        this.type = "dragon";
        this.attackPower =0;
    }
    //Lowers user's Defense
    public double clangingScales(){
        double lowerEnemyPokemonDefence = 25;
        return lowerEnemyPokemonDefence;
    }
}
