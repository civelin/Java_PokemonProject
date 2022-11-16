package attacks;

import attacks.bug.FirstImpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstImpressionAttackTest {

    private List<Pokemon> pokemon = new ArrayList<>();
    private List<Pokemon> enemyPokemon = new ArrayList<>();
    private FirstImpression firstImpression = new FirstImpression();

    @BeforeEach
    private void setUpForSmallPokemons(){
        this.pokemon.add(new SmallPokemon());
        pokemon.get(0).changeIsPokemonFightingStatus();
        enemyPokemon.add(new SmallPokemon());
        enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testFirstsImpressionAttackWithSmallPokemons() {

        double enemyPokemonInitialHP = enemyPokemon.get(0).getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemon.get(0).getHp(), expectedEnemyPokemonHPAfterAttack);

    }

//    @Test
//    public void testFirstsImpressionAttackWithNormalPokemons() {
//        FirstImpression firstImpression = new FirstImpression();
//        Pokemon pokemon = new NormalPokemon();
//        Pokemon enemyPokemon = new NormalPokemon();
//        double enemyPokemonInitialHP = enemyPokemon.getHp();
//
//        // pokemon1 attack pokemon2 with finalInflictedDmg points
//        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
//        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;
//
//        // test expected and actual values
//        assertEquals(enemyPokemon.getHp(), expectedEnemyPokemonHPAfterAttack);
//
//    } @Test
//    public void testFirstsImpressionAttackWithLargePokemons() {
//        FirstImpression firstImpression = new FirstImpression();
//        Pokemon pokemon = new LargePokemon();
//        Pokemon enemyPokemon = new LargePokemon();
//        double enemyPokemonInitialHP = enemyPokemon.getHp();
//
//        // pokemon1 attack pokemon2 with finalInflictedDmg points
//        double finalInflictedDmg = firstImpression.attack(pokemon, enemyPokemon);
//        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;
//
//        // test expected and actual values
//        assertEquals(enemyPokemon.getHp(), expectedEnemyPokemonHPAfterAttack);
//
//    }
}
