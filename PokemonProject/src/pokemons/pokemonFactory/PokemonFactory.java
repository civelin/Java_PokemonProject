package pokemons.pokemonFactory;

import attacks.PokemonAttack;
import attacks.attackFactory.AttackFactory;
import pokemons.LargePokemon;
import pokemons.NormalPokemon;
import pokemons.Pokemon;
import pokemons.SmallPokemon;


import java.util.*;


public class PokemonFactory {


    // available pokemons of pcUser1 (level1)
    public static List<Pokemon> PCUser1Pokemons() {
        List<Pokemon> pokemonPcUser1List = new ArrayList<>();
        pokemonPcUser1List.add(new SmallPokemon("Charmander", new ArrayList<>(Arrays.asList("fire", "normal"))));
        pokemonPcUser1List.add((new SmallPokemon("Rattata", new ArrayList<>(Arrays.asList("bug")))));
        pokemonPcUser1List.add((new SmallPokemon("Pichu", new ArrayList<>(Arrays.asList("electric", "normal")))));
        pokemonPcUser1List.add((new SmallPokemon("Vulpix", new ArrayList<>(Arrays.asList("fire")))));
        pokemonPcUser1List.add((new SmallPokemon("Weedle", new ArrayList<>(Arrays.asList("grass", "bug")))));
        pokemonPcUser1List.forEach(p -> fillPokemonAttacks(p));
        return pokemonPcUser1List;
    }

    // available pokemons of pcUser2 (level2)
    public static List<Pokemon> PCUser2Pokemons() {
        List<Pokemon> pokemonPcUser2List = new ArrayList<>();
        pokemonPcUser2List.add((new NormalPokemon("Ivysaur", new ArrayList<>(Arrays.asList("grass", "normal", "bug")))));
        pokemonPcUser2List.add((new NormalPokemon("Pidgeotto", new ArrayList<>(Arrays.asList("normal", "grass")))));
        pokemonPcUser2List.add(new NormalPokemon("Persian", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser2List.add((new NormalPokemon("Golduck", new ArrayList<>(Arrays.asList("electric", "bug")))));
        pokemonPcUser2List.add(new NormalPokemon("Poliwhirl", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser2List.forEach(p -> fillPokemonAttacks(p));
        return pokemonPcUser2List;
    }


    // available pokemons of pcUser3 on (level3)
    public static List<Pokemon> PCUser3Pokemons() {
        List<Pokemon> pokemonPcUser3List = new ArrayList<>();
        pokemonPcUser3List.add(new LargePokemon("Wartortle", new ArrayList<>(Arrays.asList("electric", "fire"))));
        pokemonPcUser3List.add(new LargePokemon("Arcanine", new ArrayList<>(Arrays.asList("fire"))));
        pokemonPcUser3List.add(new LargePokemon("Dodrio", new ArrayList<>(Arrays.asList("normal"))));
        pokemonPcUser3List.add(new LargePokemon("Electabuzz", new ArrayList<>(Arrays.asList("electric"))));
        pokemonPcUser3List.add(new LargePokemon("Gyarados", new ArrayList<>(Arrays.asList("bug", "grass"))));
        pokemonPcUser3List.forEach(p -> fillPokemonAttacks(p));
        return pokemonPcUser3List;

    }

    // available user's small pokemons (on level1)
    public static List<Pokemon> getUserSmallPokemons() {
        List<Pokemon> userSmallPokemons = new ArrayList<>();
        userSmallPokemons.add(new SmallPokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userSmallPokemons.add(new SmallPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userSmallPokemons.add(new SmallPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userSmallPokemons.add(new SmallPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userSmallPokemons.add(new SmallPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        userSmallPokemons.forEach(p -> fillPokemonAttacks(p));
        return userSmallPokemons;
    }

    // available user's normal pokemons (on level2)
    public static List<Pokemon> getUserNormalPokemons() {
        List<Pokemon> userNormalPokemons = new ArrayList<>();
        userNormalPokemons.add(new NormalPokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userNormalPokemons.add(new NormalPokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userNormalPokemons.add(new NormalPokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userNormalPokemons.add(new NormalPokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userNormalPokemons.add(new NormalPokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        userNormalPokemons.forEach(p -> fillPokemonAttacks(p));
        return userNormalPokemons;
    }

    // available user's large pokemons (on level3)
    public static List<Pokemon> getUserLargePokemons() {
        List<Pokemon> userLargePokemons = new ArrayList<>();
        userLargePokemons.add(new LargePokemon("Meowth", new ArrayList<>(Arrays.asList("normal"))));
        userLargePokemons.add(new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric"))));
        userLargePokemons.add(new LargePokemon("Bellsprout", new ArrayList<>(Arrays.asList("grass", "bug"))));
        userLargePokemons.add(new LargePokemon("Venonat", new ArrayList<>(Arrays.asList("fire"))));
        userLargePokemons.add(new LargePokemon("Paras", new ArrayList<>(Arrays.asList("bug"))));
        userLargePokemons.forEach(pokemon -> fillPokemonAttacks(pokemon));
        return userLargePokemons;
    }

    //TODO: REFACTOR the method
    private static void fillPokemonAttacks(Pokemon pokemon) {
        Random randomAttackGenerator = new Random();

        List<String> pokemonTypes = pokemon.getTypes();

        int numberOfTypes = pokemonTypes.size();
        if (numberOfTypes == 1) {
            // get the type
            String currentType = pokemonTypes.get(0);
            // get all attacks of currentType
            List<PokemonAttack> allAttacksOfCurrentTypeInTheFactory = AttackFactory.getAllAttacks().get(currentType);
            // get the number of all attacks of currentType in the Factory

            int numberOfAllAttacksOfCurrentTypeInTheFactory = allAttacksOfCurrentTypeInTheFactory.size();
            for (int i = 0; i < 2; i++) {
                while (!pokemon.isThereAttackOnConcreteIndexAtPokemonAttacks(i)) {
                    int randomIndex = randomAttackGenerator.nextInt(numberOfAllAttacksOfCurrentTypeInTheFactory);
                    // get attack on randomIndex
                    PokemonAttack randomAttackOfCurrentType = AttackFactory.getAllAttacks().get(currentType).get(randomIndex);
                    if (i == 0) {
                        pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
                    } else if (!pokemon.getAttacks()[0].compare(randomAttackOfCurrentType)) {
                        pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
                    }
                }
            }

        } else {
            // shuffles randomly pokemon's types
            Collections.shuffle(pokemonTypes);
            for (int i = 0; i < 2; i++) {
                String currentType = pokemonTypes.get(i);
                int numberOfCurrentTypeAttacksInTheFactory = AttackFactory.getAllAttacks().get(currentType).size();
                int index = randomAttackGenerator.nextInt(numberOfCurrentTypeAttacksInTheFactory); // from 0 to numberOfCurrentTypeAttacksInTheFactory - 1
                PokemonAttack randomAttackOfCurrentType = AttackFactory.getAllAttacks().get(currentType).get(index);
                pokemon.addAttackToPokemon(randomAttackOfCurrentType, i);
            }
        }
    }

}
