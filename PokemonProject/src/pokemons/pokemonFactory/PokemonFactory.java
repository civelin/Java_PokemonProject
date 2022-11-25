package pokemons.pokemonFactory;

import attacks.PokemonAttack;
import attacks.attackFactory.AttackFactory;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;

import java.util.*;

public class PokemonFactory {
    // fields
    private static List<Pokemon> pokemonRewards = pokemonAsRewards();

    // private constructor
    private PokemonFactory() {
    }

    // available pokemons of pcUser1 (level1)
    public static List<Pokemon> PCUser1Pokemons() {
        List<Pokemon> pokemonPcUser1List = new ArrayList<>();
        pokemonPcUser1List.add(new NormalPokemon("Charmander", new ArrayList<>(Arrays.asList("fire", "normal"))));
        pokemonPcUser1List.add((new SmallPokemon("Rattata", new ArrayList<>(Arrays.asList("bug")))));
        pokemonPcUser1List.add((new LargePokemon("Pichu", new ArrayList<>(Arrays.asList("electric", "normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Vulpix", new ArrayList<>(Arrays.asList("fire")))));
        pokemonPcUser1List.add((new SmallPokemon("Weedle", new ArrayList<>(Arrays.asList("grass", "bug")))));
        pokemonPcUser1List.forEach(PokemonFactory::fillPokemonAttacks);
        return pokemonPcUser1List;
    }

    // available pokemons of pcUser2 (level2)
    public static List<Pokemon> PCUser2Pokemons() {
        List<Pokemon> pokemonPcUser2List = new ArrayList<>();
        pokemonPcUser2List.add((new LargePokemon("Ivysaur", new ArrayList<>(Arrays.asList("grass", "normal", "bug")))));
        pokemonPcUser2List.add((new NormalPokemon("Pidgeotto", new ArrayList<>(Arrays.asList("normal", "grass")))));
        pokemonPcUser2List.add(new NormalPokemon("Persian", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser2List.add((new NormalPokemon("Golduck", new ArrayList<>(Arrays.asList("electric", "bug")))));
        pokemonPcUser2List.add(new SmallPokemon("Poliwhirl", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser2List.forEach(PokemonFactory::fillPokemonAttacks);
        return pokemonPcUser2List;
    }

    // available pokemons of pcUser3 on (level3)
    public static List<Pokemon> PCUser3Pokemons() {
        List<Pokemon> pokemonPcUser3List = new ArrayList<>();
        pokemonPcUser3List.add(new LargePokemon("Wartortle", new ArrayList<>(Arrays.asList("electric", "fire"))));
        pokemonPcUser3List.add(new NormalPokemon("Arcanine", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser3List.add(new LargePokemon("Dodrio", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser3List.add(new SmallPokemon("Electabuzz", new ArrayList<>(Arrays.asList("electric"))));
        pokemonPcUser3List.add(new LargePokemon("Gyarados", new ArrayList<>(Arrays.asList("bug", "grass"))));
        pokemonPcUser3List.forEach(PokemonFactory::fillPokemonAttacks);
        return pokemonPcUser3List;
    }

    // available user's small pokemons (on level1)
    public static List<Pokemon> getUserPokemons() {
        List<Pokemon> userPokemons = new ArrayList<>();
        userPokemons.add(new LargePokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userPokemons.add(new NormalPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userPokemons.add(new SmallPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userPokemons.add(new SmallPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userPokemons.add(new NormalPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        userPokemons.forEach(PokemonFactory::fillPokemonAttacks);
        return userPokemons;
    }

    private static List<Pokemon> pokemonAsRewards() {
        List<Pokemon> rewards = new ArrayList<>();
        rewards.add(new SmallPokemon("Oddish", new ArrayList<>(Arrays.asList("grass", "bug"))));
        rewards.add(new LargePokemon("Gengar", new ArrayList<>(Arrays.asList("grass", "fire"))));
        rewards.add(new SmallPokemon("Sandshrew", new ArrayList<>(Arrays.asList("normal", "electric"))));
        rewards.add(new NormalPokemon("Machoke", new ArrayList<>(Arrays.asList("normal"))));
        rewards.add(new LargePokemon("Tentacruel", new ArrayList<>(Arrays.asList("fire", "bug"))));
        rewards.add(new SmallPokemon("Nidoran", new ArrayList<>(Arrays.asList("normal", "grass"))));
        rewards.add(new NormalPokemon("Golduck", new ArrayList<>(Arrays.asList("electric", "fire"))));
        rewards.add(new LargePokemon("Golem", new ArrayList<>(Arrays.asList("normal", "electric"))));
        rewards.add(new NormalPokemon("Kadabra", new ArrayList<>(Arrays.asList("bug", "grass"))));
        rewards.forEach(PokemonFactory::fillPokemonAttacks);
        return rewards;

    }

    private static void fillPokemonAttacks(Pokemon pokemon) {
        Random randomAttackGenerator = new Random();

        List<String> pokemonTypes = pokemon.getTypes();

        int numberOfTypes = pokemonTypes.size();
        if (numberOfTypes == 1) {
            // get the type
            String currentType = pokemonTypes.get(0);

            // get all attacks of currentType
            List<PokemonAttack> allAttacksOfCurrentTypeInTheFactory = AttackFactory.getAllAttacks().get(currentType);

            fillPokemonAttacksWhenPokemonHasExactlyOneType(pokemon, randomAttackGenerator, currentType, allAttacksOfCurrentTypeInTheFactory);

        } else {
            // shuffles randomly pokemon's types
            Collections.shuffle(pokemonTypes);
            fillPokemonAttackWhenPokemonHasMoreThanOneType(pokemon, randomAttackGenerator, pokemonTypes);
        }
    }

    private static void fillPokemonAttacksWhenPokemonHasExactlyOneType(Pokemon pokemon, Random randomAttackGenerator, String currentType, List<PokemonAttack> allAttacksOfCurrentTypeInTheFactory) {
        // get the number of all attacks of currentType in the Factory
        int numberOfAllAttacksOfCurrentTypeInTheFactory = allAttacksOfCurrentTypeInTheFactory.size();
        for (int i = 0; i < 2; i++) {
            while (pokemon.getAttacks()[i] == null){
                int randomIndex = randomAttackGenerator.nextInt(numberOfAllAttacksOfCurrentTypeInTheFactory);
                // get attack on randomIndex
                PokemonAttack randomAttackOfCurrentType = AttackFactory.getAllAttacks().get(currentType).get(randomIndex);
                if (i == 0) {
                    pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
                } else if (!pokemon.getAttacks()[0].equals(randomAttackOfCurrentType)) {
                    pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
                }
            }
        }
    }

    private static void fillPokemonAttackWhenPokemonHasMoreThanOneType(Pokemon pokemon, Random randomAttackGenerator, List<String> pokemonTypes) {
        for (int i = 0; i < 2; i++) {
            String currentType = pokemonTypes.get(i);
            int numberOfCurrentTypeAttacksInTheFactory = AttackFactory.getAllAttacks().get(currentType).size();
            int index = randomAttackGenerator.nextInt(numberOfCurrentTypeAttacksInTheFactory); // from 0 to numberOfCurrentTypeAttacksInTheFactory - 1
            PokemonAttack randomAttackOfCurrentType = AttackFactory.getAllAttacks().get(currentType).get(index);
            pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
        }
    }

    // getters
    public static List<Pokemon> getPokemonRewards() {
        return pokemonRewards;
    }
}
