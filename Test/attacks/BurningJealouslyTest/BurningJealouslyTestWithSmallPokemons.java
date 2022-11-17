package attacks.BurningJealouslyTest;

import attacks.AttackTest;
import attacks.fire.BurningJealously;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurningJealouslyTestWithSmallPokemons extends AttackTest {

    private BurningJealously burningJealously = new BurningJealously();


    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new SmallPokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new SmallPokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new SmallPokemon());
        this.enemyPokemon.add(new SmallPokemon());

    }

    @Test
    public void testBurningJealouslyTestWithSmallPokemons() {
        this.pokemon.get(0).setAttackPoints(0);
        for (Pokemon pokemon : enemyPokemon) {

            pokemon.setHp(30);
            pokemon.setDefencePoints(0);
        }
        double expectedDmg = this.burningJealously.attack(pokemon, enemyPokemon);
        assertEquals(expectedDmg, 5);
        assertEquals(enemyPokemon.get(0).getHp(), 25);
        assertEquals(enemyPokemon.get(1).getHp(), 25);
        assertEquals(enemyPokemon.get(2).getHp(), 25);


    }
}
