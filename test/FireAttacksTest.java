import attacks.fire.BlazeKick;
import attacks.fire.BurningJealously;
import org.junit.Before;
import org.junit.Test;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;
import users.HumanUser;
import users.PCUser;
import users.User;

import static org.junit.Assert.assertEquals;

public class FireAttacksTest {
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
    public void testBlazeKickAttack() {
        BlazeKick blazeKick = new BlazeKick();
        int chance = blazeKick.attack(user1, user2);

        if (chance == 0) {
            assertEquals(81, user2.getCurrentPokemonForBattle().getHp());
        } else {
            assertEquals(73, user2.getCurrentPokemonForBattle().getHp());
        }
    }

    @Test
    public void testBurningJealously() {
        BurningJealously burningJealously = new BurningJealously();
        user2.addPokemonToCurrentList(new NormalPokemon());
        user2.addPokemonToCurrentList(new SmallPokemon());

        int expectedDmg = burningJealously.attack(user1, user2);
        assertEquals(25, expectedDmg);
        assertEquals(90, user2.getCurrentPokemonForBattle().getHp());
        assertEquals(90, user2.getCurrentPokemons().get(0).getHp());
        assertEquals(67, user2.getCurrentPokemons().get(1).getHp());

    }

}
