import org.junit.Test;

import validators.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void testUsernameValidator(){
        assertFalse(Validator.validateUserName("val4"), "return false when username is shorter than 8 symbols");
        assertFalse(Validator.validateUserName(""), "return false when username is shorter than 8 symbols");
        assertFalse(Validator.validateUserName("c14dj_slkclcdkpjivelin"), "return false when username is longer than 8 symbols");
        assertFalse(Validator.validateUserName("1civelin"), "return false when username do not start with letter");
        assertFalse(Validator.validateUserName("civel.in"), "return false when username contains symbol different from letters, numbers and _");
        assertFalse(Validator.validateUserName("valyo-65"), "return false when username contains symbol different from letters, numbers and _");

        assertTrue(Validator.validateUserName("civelin_77"), "return true when username start with letter, its length is between 8 and 15 symbols and contains only letter, numbers and _");
        assertTrue(Validator.validateUserName("Valyo_96"), "return true when username start with letter, its length is between 8 and 15 symbols and contains only letter, numbers and _");
        assertTrue(Validator.validateUserName("blum_b1989"), "return true when username start with letter, its length is between 8 and 15 symbols and contains only letter, numbers and _");
    }
    @Test
    public void testEnterChoiceWhenReturnTrue(){
        boolean result = Validator.enterChoice(5, "2");
        assertTrue(result);
    }
    @Test
    public void testEnterChoiceWhenReturnFalse(){
        boolean result = Validator.enterChoice(5, "7");
        assertFalse(result);
    }
    @Test
    public void testEnterChoiceWhenThrowException(){
        boolean result = Validator.enterChoice(5, "incorrect input");

        assertFalse(result);
    }



}
