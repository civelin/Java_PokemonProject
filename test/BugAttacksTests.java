import attacks.bug.FirstImpression;

import attacks.bug.LeechLife;
import org.junit.Before;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;

import users.HumanUser;
import users.PCUser;
import users.User;

import static org.testng.Assert.assertEquals;

public class BugAttacksTests {
    private User user1;
    private User user2;
    @Before
    public void setUp(){
        user1 = new HumanUser("Tester", null);
        user1.setCurrentPokemonForBattle(new NormalPokemon());
        user2 = new PCUser("PcUserTester", null);
        user2.setCurrentPokemonForBattle(new NormalPokemon());
    }
    @Test
    public void testFirstImpressionAttack() {
        FirstImpression firstImpression = new FirstImpression();

        int actualDmg = firstImpression.attack(user1, user2);

        assertEquals( actualDmg, 21);
        assertEquals(79 , user2.getCurrentPokemonForBattle().getHp());
    }

    @Test
    public void testLeechLife(){
        LeechLife leechLife = new LeechLife();

        user1.getCurrentPokemonForBattle().setHp(10);
        int expectedDmg = leechLife.attack(user1, user2);

        assertEquals(28, expectedDmg);
        assertEquals(24, user1.getCurrentPokemonForBattle().getHp());
        assertEquals(72, user2.getCurrentPokemonForBattle().getHp());

    }
    @Test
    public void testLeechLifeAttackWhenUser1NewHpIsMoreThanItsInitialHp(){
        LeechLife leechLife = new LeechLife();
        int expectedDmg = leechLife.attack(user1, user2);

        assertEquals(28, expectedDmg);
        assertEquals( 100, user1.getCurrentPokemonForBattle().getHp());
        assertEquals(72, user2.getCurrentPokemonForBattle().getHp());
    }

    @Test
    public void testLeechLifeAttackWhenFinalInflictedDmgIsEqualToZero(){
        LeechLife leechLife = new LeechLife();

        user2.setCurrentPokemonForBattle(new LargePokemon());
        user1.getCurrentPokemonForBattle().setAttackPoints(0);

        int expectedDmg = leechLife.attack(user1, user2);

        assertEquals(15, expectedDmg);
        assertEquals(100, user1.getCurrentPokemonForBattle().getHp());
        assertEquals(105, user2.getCurrentPokemonForBattle().getHp());

    }

}
