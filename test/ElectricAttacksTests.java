import attacks.electric.MagneticFlux;
import attacks.electric.Spark;
import org.junit.Before;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;

import users.HumanUser;
import users.PCUser;
import users.User;

import static org.testng.Assert.assertEquals;

public class ElectricAttacksTests {
    private User user1;
    private User user2;

    @Before
    public void setUp() {
        user1 = new HumanUser("Tester", null);
        user1.setCurrentPokemonForBattle(new NormalPokemon());
        user2 = new PCUser("PcUserTester", null);
        user2.setCurrentPokemonForBattle(new NormalPokemon());
    }

    @Test
    public void testMagneticFlux() {
        MagneticFlux magneticFlux = new MagneticFlux();
        int expectedDmg = magneticFlux.attack(user1, user2);

        assertEquals(13, expectedDmg);
        assertEquals(87, user2.getCurrentPokemonForBattle().getHp());
    }

    @Test
    public void testMagneticFluxWhenFinalAttackPowerHasNegativeValue() {
        MagneticFlux magneticFlux = new MagneticFlux();
        user2.setCurrentPokemonForBattle(new LargePokemon());
        user1.getCurrentPokemonForBattle().setAttackPoints(0);
        int finalAttackPower = magneticFlux.attack(user1, user2);

        assertEquals(12, finalAttackPower);
        assertEquals(108, user2.getCurrentPokemonForBattle().getHp());
    }

    @Test
    public void testSparkAttack() {
        Spark spark = new Spark();
        int critChance = spark.attack(user1, user2);

        if(critChance == 0){
            assertEquals(100, user2.getCurrentPokemonForBattle().getHp());
        } else if(critChance == 1){
            assertEquals(82, user2.getCurrentPokemonForBattle().getHp());
        }
    }

    @Test
    public void testSparkAttackWhenFinalAttackPowerIsUnderZero(){
        Spark spark = new Spark();

        user2.setCurrentPokemonForBattle(new LargePokemon());
        user1.getCurrentPokemonForBattle().setAttackPoints(0);

        int critChance = spark.attack(user1, user2);

        if(critChance == 0){
            assertEquals(120, user2.getCurrentPokemonForBattle().getHp());
        } else if(critChance == 1){
            assertEquals(110, user2.getCurrentPokemonForBattle().getHp());
        }

    }


}
