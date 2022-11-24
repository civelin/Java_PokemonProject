import Utilities.Validator;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTests {
    @Test
    public void testValidateUserName(){
        assertTrue(Validator.validateUserName("civelin77"));
        assertTrue(Validator.validateUserName("valyo_theBest"));

        assertFalse(Validator.validateUserName("1civelin"));
        assertFalse(Validator.validateUserName("asd"));
        assertFalse(Validator.validateUserName("asddtgdfdtdtgdgdtrsdfsdre"));
        assertFalse(Validator.validateUserName("here.123"));
    }

    @Test
    public void testValidateUserInputChoice() {
        // estEnterChoiceWhenThrowException
        assertFalse(Validator.validateUserInputChoice(5, "66"));
        assertFalse(Validator.validateUserInputChoice(5, "-4"));
        assertFalse(Validator.validateUserInputChoice(2, "asd"));
        assertFalse(Validator.validateUserInputChoice(2, ""));

        // testEnterChoiceWhenReturnTrue
        assertTrue(Validator.validateUserInputChoice(7, "4"));
        assertTrue(Validator.validateUserInputChoice(5, "1"));
    }

    @Test
    public void testCheckIfGivenListContainsPokemon() {
        List<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new SmallPokemon("Valyo", null));
        pokemons.add(new SmallPokemon("Tsetska", null));

        // equals is redefined, it checks if two pokemons are the same comparing them by their names
        assertFalse(Validator.checkIfGivenListContainsPokemon(pokemons, new SmallPokemon("Pesho", null)));
        assertFalse(Validator.checkIfGivenListContainsPokemon(pokemons, new NormalPokemon("Tsetska", null)));
        assertFalse(Validator.checkIfGivenListContainsPokemon(pokemons, new LargePokemon("Valyo", null)));

        assertTrue(Validator.checkIfGivenListContainsPokemon(pokemons, new SmallPokemon("Tsetska", null)));
        assertTrue(Validator.checkIfGivenListContainsPokemon(pokemons, new SmallPokemon("Valyo", null)));
    }
}
