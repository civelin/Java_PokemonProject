import Utilities.GameHelper;
import attacks.PokemonAttack;
import attacks.bug.FirstImpression;
import attacks.normal.MegaPunch;
import org.junit.Before;
import org.junit.Test;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;
import users.HumanUser;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HumanUserTests {
    private HumanUser humanUser;
    private Pokemon deadPokemon;

    private Pokemon availablePokemon;

    @Before
    public void initialize() {
        availablePokemon = new SmallPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug")));

        List<Pokemon> availablePokemons = new ArrayList<>();

        availablePokemons.add(new NormalPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        availablePokemons.add(availablePokemon);
        availablePokemons.add(new SmallPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        availablePokemons.add(new NormalPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));

        humanUser = new HumanUser("Tsetska123", availablePokemons);

        deadPokemon = new LargePokemon("Meowth", new ArrayList<>(Arrays.asList("normal")));

        List<Pokemon> deadList = new ArrayList<>();
        deadPokemon.setHp(0);

        deadList.add(deadPokemon);

        humanUser.setDeadPokemonList(deadList);
    }

    @Test
    public void testAddPokemonToAvailableList() {
        Pokemon newPokemon = new SmallPokemon("Tsetska", null);
        assertTrue(humanUser.addPokemonToAvailableList(newPokemon));
        assertFalse(humanUser.addPokemonToAvailableList(availablePokemon));
    }

    @Test
    public void testRemovePokemonFromAvailableList() {
        assertTrue(humanUser.removePokemonFromAvailableList(availablePokemon));
        assertFalse(humanUser.removePokemonFromAvailableList(new NormalPokemon()));
    }

    @Test
    public void testAddPokemonToDeadList() {
        // returns false, because pokemon is not dead
        assertFalse(humanUser.addPokemonToDeadList(new LargePokemon("Meowth", new ArrayList<>(Arrays.asList("normal")))));

        Pokemon newDeadPokemon = new NormalPokemon();
        newDeadPokemon.setHp(0);
        assertTrue(humanUser.addPokemonToDeadList(newDeadPokemon));
    }

    @Test
    public void testRemovePokemonFromDeadList() {
        assertTrue(humanUser.removePokemonFromDeadList(deadPokemon));
        assertFalse(humanUser.removePokemonFromDeadList(new SmallPokemon()));
    }

    @Test
    public void testChooseAttack() {
        // create currentPokemon for battle and set to it attacks
        Pokemon currentPokemonForBattle = new NormalPokemon("Misty", Arrays.asList("bug", "normal"));
        PokemonAttack attack1 = new FirstImpression();
        PokemonAttack attack2 = new MegaPunch();
        currentPokemonForBattle.addAttackToPokemon(attack1, 0);
        currentPokemonForBattle.addAttackToPokemon(attack2, 1);

        // set created pokemon as current pokemon to human user
        humanUser.setCurrentPokemonForBattle(currentPokemonForBattle);

        // simulated human user input equals to "1"
        System.setIn(new ByteArrayInputStream("1\r\n".getBytes()));

        // invoke human user's method chooseAttack
        PokemonAttack actualAttack = humanUser.chooseAttack(new Scanner(new ByteArrayInputStream("1\r\n".getBytes())));

        // check if actual attack is equal to attack1 at index 1
        assertEquals(attack1, actualAttack);

    }

    @Test
    public void testChoosePokemonAsReward() {
        // create list of rewards
        Pokemon reward1 = new LargePokemon("Gengar", new ArrayList<>(Arrays.asList("grass", "fire")));
        Pokemon reward2 = new SmallPokemon("Sandshrew", new ArrayList<>(Arrays.asList("normal", "electric")));
        Pokemon reward3 = new NormalPokemon("Machoke", new ArrayList<>(Arrays.asList("normal")));

        List<Pokemon> rewards = new ArrayList<>();
        rewards.add(reward1);
        rewards.add(reward2);
        rewards.add(reward3);

        // simulate human user input "2" -> reward2
        // invoke human user's method choosePokemonAsReward with created rewards
        humanUser.choosePokemonAsReward(rewards,new Scanner(new ByteArrayInputStream("2\r\n".getBytes())));

        // check if human user has such a reward at its available pokemons
        assertTrue(humanUser.getAvailablePokemons().contains(reward2));

        // check if chosen reward is removed from rewards
        assertFalse(rewards.contains(reward2));

    }

    @Test
    public void testChoosePokemonsFromAvailableListToCurrentList() {
        // simulate human user input "1\n1\n2\n3"

        humanUser.choosePokemonsFromAvailableListToCurrentList(new Scanner(new ByteArrayInputStream("1\n1\n2\n3".getBytes())));

        List<Pokemon> expectedUserCurrentPokemonList = Arrays.asList(new NormalPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))),
                new SmallPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))),
                new SmallPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));


        assertEquals(humanUser.getCurrentPokemons(), expectedUserCurrentPokemonList);
    }


    @Test
    public void testRevivePokemonWhenUserHasPositiveNumberOfCrystalsAndAtLeastOneDeadPokemon() {
        // add one crystal to user
        humanUser.setCrystals(2);

        // check that dead pokemon is not currently at available list
        assertFalse(humanUser.getAvailablePokemons().contains(deadPokemon));

        // simulate human user input "1"
        // invoke method revivePokemon
        humanUser.revivePokemon(new Scanner(new ByteArrayInputStream("1\r\n".getBytes())));

        // check that dead pokemon is at available list
        assertTrue(humanUser.getAvailablePokemons().contains(deadPokemon));
        // check that dead pokemon is removed from dead list
        assertFalse(humanUser.getDeadPokemonList().contains(deadPokemon));
        // check that crystals are less by one
        assertEquals(1, humanUser.getCrystals());
    }


    @Test
    public void testChangeCurrentPokemonWhenUserIsAllowedToChange(){
        Pokemon currentPokemon = new SmallPokemon("Niko", null);
        humanUser.setCurrentPokemonForBattle(currentPokemon);

        List<Pokemon> currentPokemons = new ArrayList<>();
        currentPokemons.add(new SmallPokemon("Pichu", null));

        humanUser.setCurrentPokemons(currentPokemons);

        humanUser.changeCurrentPokemon(new Scanner(new ByteArrayInputStream("1\n".getBytes())));

        // check for equality only names, because two pokemons are equal when their names are the same
        assertEquals(humanUser.getCurrentPokemonForBattle().getName(), "Pichu");

    }

    @Test
    public void testChangeCurrentPokemonWhenUserIsNotAllowedToChange(){
        Pokemon currentPokemon = new SmallPokemon("Niko", null);
        humanUser.setCurrentPokemonForBattle(currentPokemon);

        humanUser.changeCurrentPokemon(null);

        assertEquals("Niko", humanUser.getCurrentPokemonForBattle().getName());

    }
}

