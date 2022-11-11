import attacks.attackFactory.AttackFactory;
import menus.LoginMenu;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.userFactory.UserFactory;

public class Main {
    public static void main(String[] args) {
//        List<PokemonAttack> bugAttacks = AttackFactory.getBugAttacks();
//        bugAttacks.forEach(System.out::println);
//        System.out.println();
//        PokemonAttack attack = new BUG( );
//        AttackFactory.addToBugAttacks(attack);
//        AttackFactory.getBugAttacks().forEach(System.out::println);
//        System.out.println();
//        PokemonAttack attack1 = new BUG( );
//        AttackFactory.addToBugAttacks(attack1);
//        AttackFactory.getBugAttacks().forEach(System.out::println);
//        System.out.println();
//
//        AttackFactory.getBugAttacks().forEach(System.out::println);
//        System.out.println();
//
//
//        System.out.println(AttackFactory.getAllAttacks());
//        PokemonAttack attack2 = new BUG1();
//        AttackFactory.addToBugAttacks(attack2);
//        System.out.println(AttackFactory.getAllAttacks());


//        PokemonFactory.getUserSmallPokemons().forEach(pokemon -> {
//            for (String type: pokemon.getTypes()) {
//                System.out.print(type + " ");
//            }
//            System.out.println();
//        });

//        // test that the fill method generate random attack to pokemons of same types
//
//        Pokemon largePokemon = new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric")));
//        Pokemon largePokemon1 = new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric")));
//        Pokemon largePokemon2 = new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric")));
//        Pokemon largePokemon3 = new LargePokemon("Growlithe", new ArrayList<>(Arrays.asList("fire", "electric")));
//        PokemonFactory.fillPokemonAttacks(largePokemon);
//        PokemonFactory.fillPokemonAttacks(largePokemon1);
//        PokemonFactory.fillPokemonAttacks(largePokemon2);
//        PokemonFactory.fillPokemonAttacks(largePokemon3);
//
//        for (PokemonAttack attack: largePokemon.getAttacks()) {
//            System.out.println(attack);
//        }
//        System.out.println();
//        for (PokemonAttack attack: largePokemon1.getAttacks()) {
//            System.out.println(attack);
//        }
//        System.out.println();
//        for (PokemonAttack attack: largePokemon2.getAttacks()) {
//            System.out.println(attack);
//        }
//        System.out.println();
//        for (PokemonAttack attack: largePokemon3.getAttacks()) {
//            System.out.println(attack);
//        }

//        PokemonFactory.getUserLargePokemons().forEach(pokemon -> pokemon.printAttacks());

        LoginMenu.print();
        String userName = LoginMenu.enterUserName();

    }
}