package attacks.BlazeKickTest;

import attacks.AttackTest;
import attacks.fire.BlazeKick;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pokemons.SmallPokemon;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlazeKickTestWIthSmallPokemons extends AttackTest {

    private BlazeKick blazeKick = new BlazeKick();


    @Override
    @BeforeEach
    protected void setUp() {
        this.pokemon.add(new SmallPokemon());
        this.pokemon.get(0).changeIsPokemonFightingStatus();
        this.enemyPokemon.add(new SmallPokemon());
        this.enemyPokemon.get(0).changeIsPokemonFightingStatus();
    }

    @Test
    public void testBlazeKickWithSmallPokemons(){
        double enemyPokemonInitialHP = this.enemyPokemon.get(0).getHp();
        double dmg = this.blazeKick.attack(pokemon, enemyPokemon);
        double option1 =  (pokemon.get(0).getAttackPoints() + this.blazeKick.getAttackPower()) -
                enemyPokemon.get(0).getDefencePoints() * 0.3;
        double option2 = (pokemon.get(0).getAttackPoints() + this.blazeKick.getAttackPower()+7) -
                enemyPokemon.get(0).getDefencePoints() * 0.3;
        if(dmg == option1){
            assertEquals(enemyPokemon.get(0).getHp(), enemyPokemonInitialHP-option1);
        }else if (dmg == option2){
            assertEquals(enemyPokemon.get(0).getHp(), enemyPokemonInitialHP-option2);
        }


    }
}
