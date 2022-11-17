package attacks.CottonGuardTest;

import attacks.AttackTest;
import attacks.grass.CottonGuard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.SmallPokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CottonGuardTestWithSmallPokemons extends AttackTest {

    private CottonGuard cottonGuard = new CottonGuard();

    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new SmallPokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new SmallPokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testCottonGuardWithSmallPokemonsWhenInitialDefPoints(){
        double friendlyDeffendPoints = pokemon.get(0).getDefencePoints();

        double expectedDefPoints = pokemon.get(0).returnInitialDefencePoints();
            assertEquals(friendlyDeffendPoints, expectedDefPoints);

        }

    @Test
    public void testCottonGuardWithSmallPokemonsWhenLowerThanInitialDefPoints(){
        this.pokemon.get(0).setDefencePoints(15);

        double friendlyDefPoints = this.pokemon.get(0).getDefencePoints();

        double newFriendlyDefPoints = this.cottonGuard.attack(pokemon, enemyPokemon);

        double expectedFriendly = 1.5 * friendlyDefPoints;

        assertEquals(newFriendlyDefPoints , expectedFriendly);

    }
}
