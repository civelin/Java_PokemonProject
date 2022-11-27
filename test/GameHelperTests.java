import Utilities.GameHelper;

import attacks.PokemonAttack;
import attacks.fire.BurningJealously;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;

import pokemons.SmallPokemon;
import users.HumanUser;
import users.PCUser;
import users.User;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GameHelperTests {
    @Test
    public void testEnterUserName(){
        String input = "Valyoo12345";
        String actualUserName = GameHelper.enterUserName(new Scanner(new ByteArrayInputStream(input.getBytes())));
        assertEquals("Valyoo12345", actualUserName);
    }
    @Test
    public void testInitializeHumanUser(){
        HumanUser humanUserExpected = new HumanUser("Emo_number1", null);
        HumanUser humanUserActual = GameHelper.initializeHumanUser("Emo_number1");

        assertEquals(humanUserExpected , humanUserActual);

    }

    @Test
    public void testinitializePCUserAccordingToCurrentLevelWhenLevelIsOne() {
        PCUser pcUser1Expected = new PCUser("Misty", null);
        PCUser pcUser1Actual = GameHelper.initializePCUserAccordingToCurrentLevel(1);

        assertEquals(pcUser1Expected, pcUser1Actual);
    }

    @Test
    public void testinitializePCUserAccordingToCurrentLevelWhenLevelIsTwo() {
        PCUser pcUser2Expected = new PCUser("Blaine", null);
        PCUser pcUser2Actual = GameHelper.initializePCUserAccordingToCurrentLevel(2);

        assertEquals(pcUser2Expected, pcUser2Actual);
    }

    @Test
    public void testinitializePCUserAccordingToCurrentLevelWhenLevelIsThree() {
        PCUser pcUser3Expected = new PCUser("James", null);
        PCUser pcUser3Actual = GameHelper.initializePCUserAccordingToCurrentLevel(3);

        assertEquals(pcUser3Expected, pcUser3Actual);
    }

    @Test
    public void testAddAttackToPokemon() {
        Pokemon pokemon = new NormalPokemon();
        PokemonAttack attack1 = new BurningJealously();
        GameHelper.addAttackToPokemon(pokemon,attack1, 1);

        assertEquals(pokemon.getAttacks()[1], attack1);
    }

    @Test
    public void testAddCrystalsAfterWin() {
        List<Pokemon> tester = new ArrayList<>();
        HumanUser humanUser = new HumanUser("Gosheto1234", tester);
        humanUser.setCrystals(5);
        GameHelper.addCrystalAfterWin(humanUser , 1);
        assertEquals(6, humanUser.getCrystals());

    }

    @Test
    public void testPrintListOfPokemonsWhenListIsEmpty(){
        List<Pokemon> pokemons = new ArrayList<>();

        assertEquals("\r\n" , GameHelper.printListOfPokemons(pokemons));
    }

    @Test
    public void testPrintListOfPokemonsWhenListIsNotEmpty(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new NormalPokemon());

        assertEquals(" 1. Pikachu\n\r\n",  GameHelper.printListOfPokemons(pokemons));
    }

    @Test
    public void testCheckIfHumanUserAvaiablePokemonsListSizeIsLessThan3WhenAvailableListSizeIs2(){
        // create available list with two pokemons
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new NormalPokemon());
        pokemons.add(new SmallPokemon());
        HumanUser humanUser = new HumanUser("Valyo", pokemons);
        assertTrue(GameHelper.checkIfHumanUserAvaiablePokemonsListSizeIsLessThan3(humanUser));
    }

    @Test
    public void testCheckIfHumanUserAvaiablePokemonsListSizeIsLessThan3WhenAvailableListSizeIs3(){
        // create available list with two pokemons
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new NormalPokemon());
        pokemons.add(new SmallPokemon());
        pokemons.add(new LargePokemon());
        HumanUser humanUser = new HumanUser("Valyo", pokemons);
        assertFalse(GameHelper.checkIfHumanUserAvaiablePokemonsListSizeIsLessThan3(humanUser));
    }

    @Test
    public void testResetInitialPointsOfPokemonsAfterEachBattle(){
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon1 = new NormalPokemon();
        pokemon1.setHp(15);
        pokemon1.setDefencePoints(7);
        pokemon1.setAttackPoints(4);
        pokemons.add(pokemon1);

        User humanUser = new HumanUser("Tsetska", pokemons);
        GameHelper.resetInitialPointsOfPokemonsAfterEachBattle(humanUser);

        assertEquals(100, humanUser.getAvailablePokemons().get(0).getHp());
        assertEquals(50, humanUser.getAvailablePokemons().get(0).getDefencePoints());
        assertEquals(15, humanUser.getAvailablePokemons().get(0).getAttackPoints());
    }
    
    @Test
    public void testDoesHumanUserMeetRequirementsToContinueTheGameWhenNoAvailablePokemons(){
        List<Pokemon> emptyList = new ArrayList<>();
        HumanUser humanUser = new HumanUser("Tester",emptyList);

        assertFalse(GameHelper.doesHumanUserMeetRequirementsToContinueTheGame(humanUser));
    }

    @Test
    public void testDoesHumanUserMeetRequirementsToContinueTheGameWhenAvailablePokemonsAnd2Crystals(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new NormalPokemon());

        HumanUser humanUser = new HumanUser("Tester",pokemons);

        humanUser.setCrystals(2);

        assertTrue(GameHelper.doesHumanUserMeetRequirementsToContinueTheGame(humanUser));
    }

    @Test
    public void testCheckIfUserIsDefeatedWhenDefeated(){
        User user = new HumanUser("tester", null);
        assertTrue(GameHelper.checkIfUserIsDefeated(user));
    }

    @Test
    public void testCheckIfUserIsDefeatedWhenIsNot(){
        User user = new HumanUser("tester", null);
        user.setCurrentPokemonForBattle(new LargePokemon());
        assertFalse(GameHelper.checkIfUserIsDefeated(user));
    }
}
