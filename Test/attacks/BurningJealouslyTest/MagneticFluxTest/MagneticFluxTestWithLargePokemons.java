package attacks.BurningJealouslyTest.MagneticFluxTest;

import attacks.AttackTest;
import attacks.electric.MagneticFlux;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagneticFluxTestWithLargePokemons extends AttackTest {
    private MagneticFlux magneticFlux = new MagneticFlux();


    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new LargePokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new LargePokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testMagneticFluxWithLargePokemons(){
        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();

        // pokemon1 attack pokemon2 with finalInflictedDmg points
        double finalInflictedDmg = this.magneticFlux.attack(this.pokemon, this.enemyPokemon);
        double expectedEnemyPokemonHPAfterAttack = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(this.enemyPokemon.get(0).getHp(), expectedEnemyPokemonHPAfterAttack);
    }
}
