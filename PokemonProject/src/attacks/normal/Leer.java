package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;

public class Leer extends PokemonAttack {
    public Leer() {
        this.name = "Leer";
        this.type = "normal";
        this.description = "Leer attack lowers opponent's defence.";
    }

    public double attack(Pokemon userPokemon, Pokemon enemyPokemon) {
        double lowerEnemyPokemonDefence = 15;

        enemyPokemon.setDefencePoints(enemyPokemon.getDefencePoints() - lowerEnemyPokemonDefence);
        return lowerEnemyPokemonDefence;
    }

}
