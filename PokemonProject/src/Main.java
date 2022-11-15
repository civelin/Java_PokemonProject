import attacks.PokemonAttack;
import attacks.attackFactory.AttackFactory;
import menus.LoginMenu;
//import menus.MenuInbetweenTheBattles;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.userFactory.PCUserFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//
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
//
//
//        PokemonFactory.getUserSmallPokemons().forEach(pokemon -> {
//            for (String type: pokemon.getTypes()) {
//                System.out.print(type + " ");
//            }
//            System.out.println();
//        });
//
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
//
//        PokemonFactory.getUserLargePokemons().forEach(pokemon -> pokemon.printAttacks());


        PCUser pcUser = null;
        List<Pokemon> humanUserPokemons = new ArrayList<>();

        LoginMenu.print();

        String username = LoginMenu.enterUserName();

        // create humanUser with entered username
        HumanUser human = new HumanUser(username);


        for (int level = 1; level <= 3; level++) {
            //initialize opponent and human's pokemons according to current level
            if (level == 1) {
                pcUser = PCUserFactory.pcUser1();
                humanUserPokemons = PokemonFactory.getUserSmallPokemons();
            } else if (level == 2) {
                pcUser = PCUserFactory.pcUser2();
                humanUserPokemons = PokemonFactory.getUserNormalPokemons();
//                    MenuInbetweenTheBattles.printTextAfterFirstBattle(pcUser);

            } else if (level == 3) {
                pcUser = PCUserFactory.pcUser3();
                humanUserPokemons = PokemonFactory.getUserLargePokemons();
            }
            human.setAvailablePokemons(humanUserPokemons);
            if (human.getAvailablePokemons().size() < 3) {

                System.out.println("You can't continue the tournament , since you don't meet the requirements!" +
                        "\nBetter luck next time!");
                break;
            }

            // the user must choose pokemons for the current battle
            human.choosePokemonsFromAvailableListToCurrentList();
            System.out.println();

            // pcUser is choosing pokemons for the battle;
            pcUser.choosePokemonsFromAvailableListToCurrentList().forEach(p -> System.out.println("- " + p.getName()));
            pcUser.printCurrentPokemon();

            // pcUser is choosing pokemon for the battle
            Pokemon pcUserCurrentPokemonForCurrentBattle = pcUser.choosePokemonForBattleFromCurrentList();
            // human choose pokemon fot the battle
            Pokemon humanUserPokemonForCurrentBattle = human.choosePokemonForBattleFromCurrentList();

            PokemonAttack pcAttackForCurrentTurn;

            PokemonAttack humanUserAttackForCurrentTurn;

            boolean checkIfPokemonIsDead;

            while (true) {
                System.out.println("It's " + pcUser.getName() + " turn!");
                int pcUserChoice = pcUser.userChoiceOptionAfterEachTurn();
                //TODO: проверка колко покемона са останали в текущият лист , ако е 1 , да няма право да сменя покемоните !
                if (pcUserChoice < 4) {
                    pcAttackForCurrentTurn = pcUser.chooseAttack(pcUserCurrentPokemonForCurrentBattle);
                    pcAttackForCurrentTurn.attack( pcUser.getCurrentPokemons(),human.getCurrentPokemons());
                    checkIfPokemonIsDead = humanUserPokemonForCurrentBattle.isPokemonDead();
                    if (checkIfPokemonIsDead) {
                        human.addPokemonToDeadList(humanUserPokemonForCurrentBattle);
                        human.removePokemonFromCurrentList(humanUserPokemonForCurrentBattle);
                        human.removePokemonFromAvailableList(humanUserPokemonForCurrentBattle);
                        if (human.getCurrentPokemons().size() == 0) {
                            System.out.println("You have been defeated " + human.getName() + " !");
                            break;
                        } else {
                            human.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else {
                    pcUserCurrentPokemonForCurrentBattle.changeIsPokemonFightingStatus();
                    pcUserCurrentPokemonForCurrentBattle = pcUser.choosePokemonForBattleFromCurrentList();
                    pcUser.choosePokemonForBattleFromCurrentList();
                }
                System.out.println(human.getName() + " it's your turn !");
                int humanUserChoice = human.userChoiceOptionAfterEachTurn();
                if (humanUserChoice == 1) {
                    humanUserAttackForCurrentTurn = human.chooseAttack(humanUserPokemonForCurrentBattle);
                    humanUserAttackForCurrentTurn.attack(human.getCurrentPokemons(), pcUser.getCurrentPokemons());
                    checkIfPokemonIsDead = pcUserCurrentPokemonForCurrentBattle.isPokemonDead();
                    if (checkIfPokemonIsDead) {
                        pcUser.removePokemonFromCurrentList(pcUserCurrentPokemonForCurrentBattle);
                        if (pcUser.getCurrentPokemons().size() == 0) {
//                            MenuInbetweenTheBattles.printVictoriousTextAfterSuccessfulBattle(pcUser);
                            break;
                        }else {
                            pcUser.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else if (humanUserChoice == 2) {
                    humanUserPokemonForCurrentBattle.changeIsPokemonFightingStatus();
                    humanUserPokemonForCurrentBattle = human.choosePokemonForBattleFromCurrentList();
                } else if (humanUserChoice == 3) {
                    System.out.println("You have forfeit! " + pcUser.getName() + " has won the battle!");
                    break;
                }


            }
            // pc user choose attack for the turn


            // human user choose attack for the turn

            // проверка и за двата покемона дали някой не е умрял ??


            break;


        }

    }
}