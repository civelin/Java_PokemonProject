import Utilities.GameHelper;
import attacks.PokemonAttack;
import attacks.fire.BurningJealously;
import org.junit.Before;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import static org.junit.Assert.*;

public class PokemonTests {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;

    @Before
    public void initialize() {
        pokemon1 = new SmallPokemon("Misho", null);
        pokemon2 = new NormalPokemon("Lili", null);
        pokemon3 = new LargePokemon("Tom", null);
    }

    @Test
    public void testIsPokemonDead() {
        pokemon1.setHp(10);
        pokemon2.setHp(0);

        assertFalse(pokemon1.isPokemonDead());
        assertTrue(pokemon2.isPokemonDead());
    }

    @Test
    public void testResetInitialPointsOfPokemon() {
        pokemon1.setHp(0);
        pokemon1.setAttackPoints(0);
        pokemon1.setDefencePoints(0);

        pokemon1.resetInitialPointsOfPokemon();

        assertEquals(80, pokemon1.getHp());
        assertEquals(12, pokemon1.getAttackPoints());
        assertEquals(40, pokemon1.getDefencePoints());

        pokemon2.setHp(5);
        pokemon2.setAttackPoints(10);
        pokemon2.setDefencePoints(23);

        pokemon2.resetInitialPointsOfPokemon();

        assertEquals(100, pokemon2.getHp());
        assertEquals(15, pokemon2.getAttackPoints());
        assertEquals(50, pokemon2.getDefencePoints());
    }


    @Test
    public void testSmallPokemonReturnInitialHp() {
        assertEquals(80, pokemon1.returnInitialHP());
    }

    @Test
    public void testSmallPokemonReturnInitialAttackPoints() {
        assertEquals(12, pokemon1.returnInitialAttackPoints());
    }

    @Test
    public void testSmallPokemonReturnInitialDefencePoints() {
        assertEquals(40, pokemon1.returnInitialDefencePoints());
    }

    @Test
    public void testNormalPokemonReturnInitialHp() {
        assertEquals(100, pokemon2.returnInitialHP());
    }

    @Test
    public void testNormalPokemonReturnInitialAttackPoints() {
        assertEquals(15, pokemon2.returnInitialAttackPoints());
    }

    @Test
    public void testNormalPokemonReturnInitialDefencePoints() {
        assertEquals(50, pokemon2.returnInitialDefencePoints());
    }

    @Test
    public void testLargePokemonReturnInitialHp() {
        assertEquals(120, pokemon3.returnInitialHP());
    }

    @Test
    public void testLargePokemonReturnInitialAttackPoints() {
        assertEquals(18, pokemon3.returnInitialAttackPoints());
    }

    @Test
    public void testLargePokemonReturnInitialDefencePoints() {
        assertEquals(60, pokemon3.returnInitialDefencePoints());
    }

}
