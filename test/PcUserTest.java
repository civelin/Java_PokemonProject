import org.junit.Test;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.PCUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PcUserTest {
    @Test
    public void testChoosePokemonsFromAvailableListToCurrentList(){

        PCUser pcUser = new PCUser("Tester", PokemonFactory.PCUser1Pokemons());
        pcUser.choosePokemonsFromAvailableListToCurrentList(null);
        assertEquals(3 , pcUser.getCurrentPokemons().size());
    }
    @Test
    public void testChoosePokemonForBattleFromCurrentList(){
        PCUser pcUser = new PCUser("Tester", null);
        List<Pokemon>currentPokemons = new ArrayList<>();
        currentPokemons.add(new NormalPokemon());
        currentPokemons.add(new NormalPokemon());
        currentPokemons.add(new NormalPokemon());
        pcUser.setCurrentPokemons(currentPokemons);
        pcUser.choosePokemonForBattleFromCurrentList(null);

        assertEquals("Pikachu" , pcUser.getCurrentPokemonForBattle().getName());
    }

    @Test
    public void testChangeCurrentPokemonWhenCurrentPokemonListSizeIsNotEmptyAndCurrentFightingPokemonIsNotNull(){
        PCUser pcUser = new PCUser("Tester", null);

        List<Pokemon>currentPokemons = new ArrayList<>();
        currentPokemons.add(new NormalPokemon());
        pcUser.setCurrentPokemons(currentPokemons);
        pcUser.setCurrentPokemonForBattle(new NormalPokemon("Test",new ArrayList<>(Arrays.asList("test"))));

        pcUser.changeCurrentPokemon(null);

        assertEquals("Pikachu", pcUser.getCurrentPokemonForBattle().getName());
        assertEquals("Test" , pcUser.getCurrentPokemons().get(0).getName());
        assertEquals(1 , pcUser.getCurrentPokemons().size());


    }

    @Test
    public void testChangeCurrentPokemonWhenCurrentPokemonListSizeIsEmptyAndCurrentFightingPokemonIsNotNull(){
        PCUser pcUser = new PCUser("Tester", null);
        List<Pokemon> currPokemons = new ArrayList<>();
        pcUser.setCurrentPokemons(currPokemons);

        pcUser.setCurrentPokemonForBattle(new NormalPokemon());
        pcUser.changeCurrentPokemon(null);

        assertEquals(0 , pcUser.getCurrentPokemons().size() );


    }
    @Test
    public void testChangeCurrentPokemonWhenCurrentPokemonListSizeIsEmptyAndCurrentFightingPokemonIsNull(){
        PCUser pcUser = new PCUser("Tester", null);
        List<Pokemon> currPokemons = new ArrayList<>();
        pcUser.setCurrentPokemons(currPokemons);

        pcUser.setCurrentPokemonForBattle(null);
        pcUser.changeCurrentPokemon(null);

        assertEquals(0 , pcUser.getCurrentPokemons().size() );


    }
    @Test
    public void testChangeCurrentPokemonWhenCurrentPokemonListSizeIsNotEmptyAndCurrentFightingPokemonIsNull(){
        PCUser pcUser = new PCUser("Tester", null);
        List<Pokemon> currPokemons = new ArrayList<>();
        currPokemons.add(new NormalPokemon());
        pcUser.setCurrentPokemons(currPokemons);

        pcUser.setCurrentPokemonForBattle(null);
        pcUser.changeCurrentPokemon(null);

        assertEquals(0 , pcUser.getCurrentPokemons().size() );


    }
}
