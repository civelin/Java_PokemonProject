import attacks.normal.Leer;
import attacks.normal.MegaPunch;
import org.junit.Before;
import org.junit.Test;
import pokemons.NormalPokemon;
import users.HumanUser;
import users.PCUser;
import users.User;

import static org.junit.Assert.assertEquals;

public class NormalAttacksTest {
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
    public void testLeerAttackWhenEnemyDefendPointsSubtractedBy15arePositiveDigits(){
        Leer leer = new Leer();

        int enemyDefPoints = leer.attack(user1, user2);
        assertEquals(35 , enemyDefPoints);
        assertEquals(35 , user2.getCurrentPokemonForBattle().getDefencePoints());
    }
    @Test
    public void testLeerAttackWhenEnemyDefendPointsSubtractedBy15areNegativeDigits(){
        Leer leer = new Leer();
        user2.getCurrentPokemonForBattle().setDefencePoints(5);

        int enemyDefPoints = leer.attack(user1, user2);
        assertEquals(0 , enemyDefPoints);
        assertEquals(0 , user2.getCurrentPokemonForBattle().getDefencePoints());
    }

    @Test
    public void testMegaPunchAttack(){
        MegaPunch megaPunch = new MegaPunch();

        int chance = megaPunch.attack(user1 , user2);

        if(chance==1){
            assertEquals(93 , user2.getCurrentPokemonForBattle().getHp());
        } else if (chance==2) {
            assertEquals(86, user2.getCurrentPokemonForBattle().getHp());
        }
    }
}
