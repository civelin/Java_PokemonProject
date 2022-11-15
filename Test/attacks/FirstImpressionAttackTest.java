package attacks;

import attacks.bug.FirstImpression;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstImpressionAttackTest {

    @Test
    public void testFirstsImpressionAttackWithSmallPokemons() {
        FirstImpression firstImpression = new FirstImpression();
        Pokemon pokemon = new SmallPokemon();
        Pokemon enemyPokemon = new SmallPokemon();
        double enemyPokemonInitialHP = enemyPokemon.getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemon.getHp(), expectedEnemyPokemonHPAfterAttack);

    }

    @Test
    public void testFirstsImpressionAttackWithNormalPokemons() {
        FirstImpression firstImpression = new FirstImpression();
        Pokemon pokemon = new NormalPokemon();
        Pokemon enemyPokemon = new NormalPokemon();
        double enemyPokemonInitialHP = enemyPokemon.getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemon.getHp(), expectedEnemyPokemonHPAfterAttack);

    } @Test
    public void testFirstsImpressionAttackWithLargePokemons() {
        FirstImpression firstImpression = new FirstImpression();
        Pokemon pokemon = new LargePokemon();
        Pokemon enemyPokemon = new LargePokemon();
        double enemyPokemonInitialHP = enemyPokemon.getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemon.getHp(), expectedEnemyPokemonHPAfterAttack);

    }
}
