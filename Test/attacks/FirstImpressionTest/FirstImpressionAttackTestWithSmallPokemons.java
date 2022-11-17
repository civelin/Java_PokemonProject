package attacks.FirstImpressionTest;

import attacks.AttackTest;
import attacks.bug.FirstImpression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.SmallPokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstImpressionAttackTestWithSmallPokemons extends AttackTest {
    private FirstImpression firstImpression = new FirstImpression();
    @Override
    @BeforeEach
    public void setUp() {
        this.pokemon.add(new SmallPokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new SmallPokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();

    }
    @Test
    public void testFirstImpressionAttackWithSmallPokemons(){
        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = this.firstImpression.attack(this.pokemon, this.enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(this.enemyPokemon.get(0).getHp(), expectedEnemyPokemonHPAfterAttack);

    }
}
