package attacks.LeechLife;

import attacks.bug.LeechLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeechLifeAttackTestWithLargePokemons {
    private LargePokemon pokemon;
    private LargePokemon enemyPokemon;
    private LeechLife leechLife = new LeechLife();

    @BeforeEach
    private void initialize() {
        pokemon = new LargePokemon();
        enemyPokemon = new LargePokemon();
    }

    @Test
    public void testLeechLifeAttackWithSmallPokemonWithDefaultValues() {

        double enemyPokemonInitialHP = enemyPokemon.getHp();
        double pokemonInitialHP = pokemon.getHp();

        // pokemon attack enemyPokemon
        double finalInflictedDmg = leechLife.attack(pokemon, enemyPokemon);

        // expected values
        double enemyPokemonExpectedHP = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemonExpectedHP, enemyPokemon.getHp());
        assertEquals(pokemonInitialHP, pokemon.getHp());
    }

    @Test
    public void testLeechLifeAttackWithSmallPokemonWithSetValues() {

        pokemon.setAttackPoints(40);
        pokemon.setHp(50);
        enemyPokemon.setDefencePoints(20);

        double enemyPokemonInitialHP = enemyPokemon.getHp();
        double pokemonInitialHP = pokemon.getHp();

        // pokemon attack enemyPokemon
        double finalInflictedDmg = leechLife.attack(pokemon, enemyPokemon);

        // expected values
        double enemyPokemonExpectedHP = enemyPokemonInitialHP - finalInflictedDmg;
        double pokemonExpectedHP = pokemonInitialHP + finalInflictedDmg / 2;

        // test expected and actual values
        assertEquals(enemyPokemonExpectedHP, enemyPokemon.getHp());
        assertEquals(pokemonExpectedHP, pokemon.getHp());
    }

}
