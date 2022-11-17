package attacks.BurningJealouslyTest.MagneticFluxTest;

import attacks.AttackTest;
import attacks.electric.MagneticFlux;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.NormalPokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagneticFluxTestWithNormalPokemons extends AttackTest {
    private MagneticFlux magneticFlux = new MagneticFlux();


    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new NormalPokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new NormalPokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testMagneticFluxWithNormalPokemons(){
        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();
        double pokemonInitialHP = this.pokemon.get(0).getHp();

        // pokemon attack enemyPokemon
        double finalInflictedDmg = this.magneticFlux.attack(this.pokemon, this.enemyPokemon);

        // expected values
        double enemyPokemonExpectedHP = enemyPokemonInitialHP - finalInflictedDmg;

        // test expected and actual values
        assertEquals(enemyPokemonExpectedHP, this.enemyPokemon.get(0).getHp());
        assertEquals(pokemonInitialHP, this.pokemon.get(0).getHp());
    }
}
