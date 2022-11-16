package attacks.LeechLife;

import attacks.bug.LeechLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;
import pokemons.Pokemon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeechLifeAttackTestWithLargePokemons {
    private List<Pokemon> pokemon;
    private List<Pokemon> enemyPokemon;
    private LeechLife leechLife = new LeechLife();

    @BeforeEach
    private void initialize() {

        pokemon.add(new LargePokemon());
        pokemon.get(0).changeIsPokemonFightingStatus();
        enemyPokemon.add( new LargePokemon());
        enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testLeechLifeAttackWithSmallPokemonWithDefaultValues() {

        double enemyPokemonInitialHP = enemyPokemon.get(0).getHp();
        double pokemonInitialHP = pokemon.get(0).getHp();

        // pokemon attack enemyPokemon
        double finalInflictedDmg = leechLife.attack(pokemon, enemyPokemon);

        // expected values
        double enemyPokemonExpectedHP = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemonExpectedHP, enemyPokemon.get(0).getHp());
        assertEquals(pokemonInitialHP, pokemon.get(0).getHp());
    }

    @Test
    public void testLeechLifeAttackWithSmallPokemonWithSetValues() {

        pokemon.get(0).setAttackPoints(40);
        pokemon.get(0).setHp(50);
        enemyPokemon.get(0).setDefencePoints(20);

        double enemyPokemonInitialHP = enemyPokemon.get(0).getHp();
        double pokemonInitialHP = pokemon.get(0).getHp();

        // pokemon attack enemyPokemon
        double finalInflictedDmg = leechLife.attack(pokemon, enemyPokemon);

        // expected values
        double enemyPokemonExpectedHP = enemyPokemonInitialHP - finalInflictedDmg;
        double pokemonExpectedHP = pokemonInitialHP + finalInflictedDmg / 2;

        // test expected and actual values
        assertEquals(enemyPokemonExpectedHP, enemyPokemon.get(0).getHp());
        assertEquals(pokemonExpectedHP, pokemon.get(0).getHp());
    }

}
