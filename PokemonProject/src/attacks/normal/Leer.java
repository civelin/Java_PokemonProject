package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class Leer extends PokemonAttack {
    public Leer() {
        this.name = "Leer";
        this.type = "normal";
        this.description = "Leer attack lowers opponent's defence.";
    }

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        double lowerEnemyPokemonDefence = 15;

        enemyPokemon.setDefencePoints(enemyPokemon.getDefencePoints() - lowerEnemyPokemonDefence);

        System.out.println(enemyPokemon.getName() + " now has " + enemyPokemon.getDefencePoints() + " defence points.");
        return lowerEnemyPokemonDefence;
    }

}
