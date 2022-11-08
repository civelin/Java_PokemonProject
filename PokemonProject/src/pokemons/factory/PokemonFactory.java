package pokemons.factory;

import attacks.PokemonAttack;
import attacks.bug.FirstImpression;
import attacks.normal.MegaPunch;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonFactory {


    public static List<Pokemon> PCUser1Pokemons(){
        List<Pokemon> pokemonPcUser1List=new ArrayList<>();
        pokemonPcUser1List.add(new SmallPokemon("Charmander",new ArrayList<>(Arrays.asList("fire","dragon","flying"))));
        pokemonPcUser1List.add((new SmallPokemon("Rattata",new ArrayList<>(Arrays.asList("normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Pichu",new ArrayList<>(Arrays.asList("electric","normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Vulpix",new ArrayList<>(Arrays.asList("fire")))));
        pokemonPcUser1List.add((new SmallPokemon("Weedle",new ArrayList<>(Arrays.asList("grass","bug")))));
        return pokemonPcUser1List;
    }

    public static List<Pokemon> PCUser2Pokemons(){
        List<Pokemon>pokemonPcUser2List =new ArrayList<>();
        pokemonPcUser2List.add((new NormalPokemon("Ivysaur",new ArrayList<>(Arrays.asList("grass","normal","bug")))));
        pokemonPcUser2List.add((new NormalPokemon("Pidgeotto",new ArrayList<>(Arrays.asList("normal","flying")))));
        pokemonPcUser2List.add(new NormalPokemon("Persian", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser2List.add((new NormalPokemon("Golduck", new ArrayList<>(Arrays.asList("water")))));
        pokemonPcUser2List.add(new NormalPokemon("Poliwhirl", new ArrayList<>(Arrays.asList("water"))));
        return pokemonPcUser2List;
    }

    public static List<Pokemon> PCUser3Pokemons(){
        List<Pokemon>pokemonPcUser3List = new ArrayList<>();
        pokemonPcUser3List.add(new LargePokemon("Wartortle", new ArrayList<>(Arrays.asList("water","normal"))));
        pokemonPcUser3List.add(new LargePokemon("Arcanine", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser3List.add(new LargePokemon("Dodrio", new ArrayList<>(Arrays.asList("flying","normal"))));
        pokemonPcUser3List.add(new LargePokemon("Electabuzz", new ArrayList<>(Arrays.asList("electric"))));
        pokemonPcUser3List.add(new LargePokemon("Gyarados", new ArrayList<>(Arrays.asList("water","flying","grass"))));
        return pokemonPcUser3List;

    }
}
