import attacks.bug.FirstImpression;
import org.testng.annotations.Test;
import pokemons.NormalPokemon;
import pokemons.SmallPokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.User;

import static org.testng.AssertJUnit.assertEquals;

public class TestAttack {

    @Test
    public void testFirstImpression(){
        FirstImpression firstImpressionAttack = new FirstImpression();

        User human = new HumanUser("Pesho", PokemonFactory.getUserPokemons());
        human.setCurrentPokemonForBattle(new NormalPokemon());

        User pcUser  = new PCUser("Gosho", PokemonFactory.getUserPokemons());
        pcUser.setCurrentPokemonForBattle(new NormalPokemon());

        int expectedDmg = firstImpressionAttack.attack(human, pcUser);
        assertEquals(21, expectedDmg);
        assertEquals(79, pcUser.getCurrentPokemonForBattle().getHp());
    }
}
