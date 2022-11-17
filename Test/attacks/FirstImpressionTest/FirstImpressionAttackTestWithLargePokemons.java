package attacks.FirstImpressionTest;

import attacks.AttackTest;
import attacks.bug.FirstImpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;
import pokemons.Pokemon;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstImpressionAttackTestWithLargePokemons extends AttackTest {

    private FirstImpression firstImpression = new FirstImpression();



    @BeforeEach
    @Override
    protected void setUp() {
        this.pokemon.add(new LargePokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new LargePokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testFirstsImpressionAttackWithLargePokemons() {

        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = this.firstImpression.attack(this.pokemon, this.enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(this.enemyPokemon.get(0).getHp(), expectedEnemyPokemonHPAfterAttack);

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
