package attacks.grass;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class CottonGuard extends PokemonAttack {

    public CottonGuard() {
        this.name = "CottonGuard";
        this.type = "grass";
        this.description = "Cotton guard attack drastically raises(with 50%) user's defense and increases enemy's defence with 15 percent";
    }

    //Drastically raises(with 50%) user's defense and decreases enemy's defence with 15 percent
    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];


        enemyPokemon.setDefencePoints(0.85 * enemyPokemon.getDefencePoints());

        double currentDefencePoints = userPokemon.getDefencePoints();
        double newDefencePoints = 1.5 * currentDefencePoints;

        // check if newDefencePoints > initialDefencePoints
        if (newDefencePoints > userPokemon.returnInitialDefencePoints()) {
            userPokemon.setDefencePoints(userPokemon.returnInitialDefencePoints());
        } else {
            userPokemon.setDefencePoints(newDefencePoints);
        }

        System.out.println("Enemy's pokemon " + enemyPokemon.getName() + " now has " + enemyPokemon.getDefencePoints() + " defence points.");
        System.out.println("Your pokemon " + userPokemon.getName() + " now has " + userPokemon.getDefencePoints() + " defence points.");
        return userPokemon.getDefencePoints();
    }
}
