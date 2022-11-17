package attacks.SparkTest;

import attacks.AttackTest;
import attacks.electric.Spark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.LargePokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SparkTestWithLargePokemons extends AttackTest {

    private Spark spark = new Spark();


    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new LargePokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new LargePokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testSparkWithLargePokemons(){
        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();
        double finalInflictedDmg = (pokemon.get(0).getAttackPoints() + spark.getAttackPower()) * 1.1 - enemyPokemon.get(0).getDefencePoints() * 0.3;
        double critChance = this.spark.attack(this.pokemon, this.enemyPokemon);
        finalInflictedDmg *= critChance;
        assertEquals(enemyPokemon.get(0).getHp(), enemyPokemonInitialHP - finalInflictedDmg);
    }
}
