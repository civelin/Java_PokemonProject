import attacks.grass.CottonGuard;
import attacks.grass.HornLeech;
import org.junit.Before;
import org.junit.Test;
import pokemons.NormalPokemon;
import users.HumanUser;
import users.PCUser;
import users.User;

import static org.junit.Assert.assertEquals;

public class GrassAttacksTest {
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
    public void testCottonGuardAttackWhenFriendlyPokemonDefencePointsAreLowerThanInitialDefaultDefPoints(){
        CottonGuard cottonGuard = new CottonGuard();
        user1.getCurrentPokemonForBattle().setDefencePoints(20);
        int friendlyPokemonExpectedDefPoints = cottonGuard.attack(user1 , user2);
        assertEquals(30 , friendlyPokemonExpectedDefPoints);
        assertEquals(30 , user1.getCurrentPokemonForBattle().getDefencePoints());
        assertEquals(42 , user2.getCurrentPokemonForBattle().getDefencePoints());
    }

    @Test
    public void testCottonGuardAttackWhenFriendlyPokemonDefencePointsAreBiggerThanInitialDefaultDefPoints(){
        CottonGuard cottonGuard = new CottonGuard();

        int friendlyPokemonExpectedDefPoints = cottonGuard.attack(user1 , user2);

        assertEquals(75 , friendlyPokemonExpectedDefPoints);
        assertEquals(50 ,user1.getCurrentPokemonForBattle().getDefencePoints());
        assertEquals(42 ,user2.getCurrentPokemonForBattle().getDefencePoints());

    }

    @Test
    public void testHornLeechWhenPokemonHasMoreThanTwentyHealthPoints(){
        HornLeech hornLeech = new HornLeech();

        int hp = hornLeech.attack(user1 , user2);

        assertEquals(100 , hp);
        assertEquals(100 , user1.getCurrentPokemonForBattle().getHp());
    }
    @Test
    public void testHornLeechWhenPokemonHasLessThanTwentyHealthPoints(){
        HornLeech hornLeech = new HornLeech();
        user1.getCurrentPokemonForBattle().setHp(5);

        int hp = hornLeech.attack(user1 , user2);

        assertEquals(20 , hp);
        assertEquals(20 , user1.getCurrentPokemonForBattle().getHp());
    }
}
