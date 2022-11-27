import Utilities.GameHelper;

import attacks.PokemonAttack;
import attacks.fire.BurningJealously;
import org.junit.Test;
import pokemons.NormalPokemon;
import pokemons.Pokemon;

import users.HumanUser;
import users.PCUser;


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
    public void testAddCrystalsAfterWin() {
        List<Pokemon> tester = new ArrayList<>();
        HumanUser humanUser = new HumanUser("Gosheto1234", tester);
        humanUser.setCrystals(5);
        GameHelper.addCrystalAfterWin(humanUser);
        assertEquals(6, humanUser.getCrystals());

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
    public void testDoLogicAfterHumanUserPokemonInCurrentListIsDead() {
        Pokemon deadPokemon = new NormalPokemon();
        List<Pokemon> tester = new ArrayList<>();
        tester.add(deadPokemon);
        HumanUser humanUser = new HumanUser("Gosheto1234", tester);

        List<Pokemon> currentPokemonList = new ArrayList<>();
        currentPokemonList.add(deadPokemon);
        humanUser.setCurrentPokemons(currentPokemonList);
        deadPokemon.setHp(0);

        GameHelper.doLogicAfterHumanUserPokemonIsDead(humanUser, deadPokemon);

        assertEquals(0, humanUser.getCurrentPokemons().size());
        assertEquals(0, humanUser.getAvailablePokemons().size());
        assertEquals(1, humanUser.getDeadPokemonList().size());
        assertFalse(humanUser.getCurrentPokemons().contains(deadPokemon));
        assertFalse(humanUser.getAvailablePokemons().contains(deadPokemon));
        assertTrue(humanUser.getDeadPokemonList().contains(deadPokemon));

    }
    @Test
    public void testDoLogicAfterPCUserPokemonInCurrentListIsDead(){
        Pokemon testerPokemon = new NormalPokemon();
        List<Pokemon> tester = new ArrayList<>();
        tester.add(testerPokemon);
        PCUser pcUser = new PCUser("Tester",tester);

        List<Pokemon>currentPokemons = new ArrayList<>();
        currentPokemons.add(testerPokemon);
        testerPokemon.setHp(0);

        GameHelper.doLogicAfterPCUserPokemonInCurrentListIsDead(pcUser , testerPokemon);
        assertEquals(0, pcUser.getCurrentPokemons().size());
        assertFalse(pcUser.getCurrentPokemons().contains(testerPokemon));
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
    public void testAddAttackToPokemon() {
        Pokemon pokemon = new NormalPokemon();
        PokemonAttack attack1 = new BurningJealously();
        GameHelper.addAttackToPokemon(pokemon,attack1, 1);

        assertEquals(pokemon.getAttacks()[1], attack1);
    }



}
