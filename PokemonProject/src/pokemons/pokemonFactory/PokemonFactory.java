package pokemons.pokemonFactory;

import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.*;

public class PokemonFactory {


    // available pokemons of pcUser1 (level1)
    public static List<Pokemon> PCUser1Pokemons() {
        List<Pokemon> pokemonPcUser1List = new ArrayList<>();
        pokemonPcUser1List.add(new SmallPokemon("Charmander", new ArrayList<>(Arrays.asList("fire", "dragon", "flying"))));
        pokemonPcUser1List.add((new SmallPokemon("Rattata", new ArrayList<>(Arrays.asList("normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Pichu", new ArrayList<>(Arrays.asList("electric", "normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Vulpix", new ArrayList<>(Arrays.asList("fire")))));
        pokemonPcUser1List.add((new SmallPokemon("Weedle", new ArrayList<>(Arrays.asList("grass", "bug")))));
        return pokemonPcUser1List;
    }

    // available pokemons of pcUser2 (level2)
    public static List<Pokemon> PCUser2Pokemons() {
        List<Pokemon> pokemonPcUser2List = new ArrayList<>();
        pokemonPcUser2List.add((new NormalPokemon("Ivysaur", new ArrayList<>(Arrays.asList("grass", "normal", "bug")))));
        pokemonPcUser2List.add((new NormalPokemon("Pidgeotto", new ArrayList<>(Arrays.asList("normal", "flying")))));
        pokemonPcUser2List.add(new NormalPokemon("Persian", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser2List.add((new NormalPokemon("Golduck", new ArrayList<>(Arrays.asList("water")))));
        pokemonPcUser2List.add(new NormalPokemon("Poliwhirl", new ArrayList<>(Arrays.asList("water"))));
        return pokemonPcUser2List;
    }

    // available pokemons of pcUser3 on (level3)
    public static List<Pokemon> PCUser3Pokemons() {
        List<Pokemon> pokemonPcUser3List = new ArrayList<>();
        pokemonPcUser3List.add(new LargePokemon("Wartortle", new ArrayList<>(Arrays.asList("water", "normal"))));
        pokemonPcUser3List.add(new LargePokemon("Arcanine", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser3List.add(new LargePokemon("Dodrio", new ArrayList<>(Arrays.asList("flying", "normal"))));
        pokemonPcUser3List.add(new LargePokemon("Electabuzz", new ArrayList<>(Arrays.asList("electric"))));
        pokemonPcUser3List.add(new LargePokemon("Gyarados", new ArrayList<>(Arrays.asList("water", "flying", "grass"))));
        return pokemonPcUser3List;

    }

    // available user's pokemons (on level1)
    private static List<Pokemon> getUserSmallPokemons() {
        List<Pokemon> userSmallPokemons = new ArrayList<>();
        userSmallPokemons.add(new SmallPokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userSmallPokemons.add(new SmallPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userSmallPokemons.add(new SmallPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userSmallPokemons.add(new SmallPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userSmallPokemons.add(new SmallPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        return userSmallPokemons;
    }

    // available user's pokemons (on level2)
    private static List<Pokemon> getUserNormalPokemons() {
        List<Pokemon> userNormalPokemons = new ArrayList<>();
        userNormalPokemons.add(new NormalPokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userNormalPokemons.add(new NormalPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userNormalPokemons.add(new NormalPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userNormalPokemons.add(new NormalPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userNormalPokemons.add(new NormalPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        return userNormalPokemons;
    }

    // available user's pokemons (on level3)
    private static List<Pokemon> getUserLargePokemons() {
        List<Pokemon> userLargePokemons = new ArrayList<>();
        userLargePokemons.add(new LargePokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userLargePokemons.add(new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userLargePokemons.add(new LargePokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userLargePokemons.add(new LargePokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userLargePokemons.add(new LargePokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        return userLargePokemons;
    }

    //TODO: method that fill all pokemon's attack using the AttackFactory class
}
