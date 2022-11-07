package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class Leer extends PokemonAttack {
    public Leer(){
        this.type = "normal";
        this.attackPower = 0;
    }

    public double leer(Pokemon userPokemon, Pokemon enemyPokemon){
        double lowerEnemyPokemonDefence = 25;

        enemyPokemon.setDefencePoints(enemyPokemon.getDefencePoints()-lowerEnemyPokemonDefence);
        return lowerEnemyPokemonDefence;
    }

}
