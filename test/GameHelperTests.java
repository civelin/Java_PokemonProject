import Utilities.GameHelper;
import Utilities.GamePlay;
import org.junit.Test;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import users.HumanUser;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameHelperTests {
    @Test
    public void testAddCrystalsAfterWin(){
        List<Pokemon> tester = new ArrayList<>();
        HumanUser humanUser =new HumanUser("Gosheto1234",tester);
        humanUser.setCrystals(5);
        int crystals = GameHelper.addCrystalAfterWin(humanUser);
        assertEquals(6 , crystals);

    }

    @Test
    public void testDoLogicAfterHumanUserPokemonInCurrentListIsDead(){
        Pokemon deadPokemon = new NormalPokemon();
        List<Pokemon> tester = new ArrayList<>();
        tester.add(deadPokemon);
        HumanUser humanUser =new HumanUser("Gosheto1234",tester);

        humanUser.setCurrentPokemons(Arrays.asList(deadPokemon));
        deadPokemon.setHp(0);
        deadPokemon.isPokemonDead();
        humanUser.setCurrentPokemons(null);
       // не знам...... :))))))))))))))))))))
    }
}
