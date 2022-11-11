import attacks.attackFactory.AttackFactory;
import menus.LoginMenu;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.userFactory.UserFactory;
import pokemons.Pokemon;
import users.HumanUser;
import users.PCUser;
import users.User;
import users.userFactory.UserFactory;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean battleLogic(HumanUser humanUser, PCUser pcUser1) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int randomPokemonForPCuser;
        System.out.println("The pokemon tournament is about to begin." +
                "\n First opponent is " + pcUser1.getName() + ". Her pokemons are --->");
        System.out.println("1 - " + pcUser1.getAvailablePokemons().get(0).getName());
        System.out.println("2 - " + pcUser1.getAvailablePokemons().get(1).getName());
        System.out.println("3 - " + pcUser1.getAvailablePokemons().get(2).getName());
        System.out.println("4 - " + pcUser1.getAvailablePokemons().get(3).getName());
        System.out.println("5 - " + pcUser1.getAvailablePokemons().get(4).getName());
        System.out.println();
        System.out.println("Choose 3 pokemons from your list to enter the battle!");
        boolean flag = false;
        int userPokemons = humanUser.getAvailablePokemons().size();
        int userPokemonChoice;

        for (int i = 0; i < userPokemons; i++) {
            System.out.println((i + 1) + ".Pokemon - " + humanUser.getAvailablePokemons().get(i).getName());
        }
        do {
        for (int i = 0; i < 3; i++) {
            do {
                System.out.print("Pokemon " + (i + 1) + " : ");
                userPokemonChoice = sc.nextInt();

                  flag = humanUser.addPokemonToCurrentList(humanUser.getAvailablePokemons().get(userPokemonChoice - 1));
                    humanUser.removePokemonFromAvailableList(humanUser.getAvailablePokemons().get(userPokemonChoice - 1));


            } while (!flag);
            flag = false;

        pcUser1.choosePokemonsFromAvailableListToCurrentList();

        }

       }while(humanUser.getCurrentPokemons().size()!=3&&pcUser1.getCurrentPokemons().size()!=3);
       boolean userTurns= true;
        Pokemon pcCurrentPokemonForBattle = pcUser1.choosePokemonForBattleFromCurrentList();
        System.out.println(pcUser1.getName()+" chose "+ pcCurrentPokemonForBattle.getName()+" this turn.");
        Pokemon humanUserCurrentPokemonForBattle = humanUser.choosePokemonForBattleFromCurrentList();
        do{
            if(userTurns) {


            }
            System.out.println();
        } while(pcUser1.getCurrentPokemons().size()>0||humanUser.getCurrentPokemons().size()>0);

        return true;
    }
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