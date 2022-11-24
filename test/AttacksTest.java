import attacks.bug.FirstImpression;

import org.junit.Before;
import org.junit.Test;
import pokemons.NormalPokemon;

import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.userFactory.PCUserFactory;

import static org.testng.Assert.assertEquals;


public class AttacksTest {
    private PCUser pcUser;
    private HumanUser humanUser;
    @Before
    public void setUp(){
         pcUser = PCUserFactory.pcUser1();
        pcUser.setCurrentPokemonForBattle(new NormalPokemon());
        humanUser = new HumanUser("Tester", PokemonFactory.getUserPokemons());
        humanUser.setCurrentPokemonForBattle(new NormalPokemon());
    }
    @Test
    public void testFirstImpressionAttack() {
        FirstImpression firstImpression = new FirstImpression();

        int expectedDmg = firstImpression.attack(humanUser , pcUser);

       assertEquals( expectedDmg, 21);
       assertEquals(79 , pcUser.getCurrentPokemonForBattle().getHp());

    }

}
