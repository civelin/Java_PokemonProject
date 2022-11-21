import attacks.PokemonAttack;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize Scanner scan
        Scanner scan = new Scanner(System.in);

        System.out.println(Menu.printLoginMenu());
        String username = Battle.enterUserName(scan);
        HumanUser humanUser = new HumanUser(username, PokemonFactory.getUserPokemons());

        for (int level = 1; level <= Battle.numberOfLevels; level++) {
            Battle.currentTurn = 1;

            //initialize opponent according to current level
            PCUser pcUser = Battle.initializePCUserAccordingToCurrentLevel(level);

            // pcUser is choosing pokemons for the battle
            pcUser.choosePokemonsFromAvailableListToCurrentList();
            System.out.println(pcUser.printCurrentPokemons());
            System.out.println();

            // the user must choose pokemons for the current battle
            System.out.println(humanUser.printAvailablePokemons());
            humanUser.choosePokemonsFromAvailableListToCurrentList();
            System.out.println();

            // pcUser is choosing one pokemon for the battle
            pcUser.choosePokemonForBattleFromCurrentList();
            System.out.println();

            // humanUser choose one pokemon fot the battle
            humanUser.choosePokemonForBattleFromCurrentList();
            System.out.println();

            // battle starts
            while (true) {
                System.out.println("It's " + pcUser.getName() + " turn!");
                int pcUserChoice = pcUser.chooseOptionBeforeEachTurn(Battle.currentTurn);

                // if pcUser's choice < 4 it will attack
                if (pcUserChoice < 13) {
                    // pcUser is choosing attack for the current turn
                    PokemonAttack pcAttackForCurrentTurn = pcUser.chooseAttack();
                    // pcUser attacks
                    pcAttackForCurrentTurn.attack(pcUser, humanUser);
                    System.out.println();

                    // checking if humanUser's pokemon for current battle is dead
                    if (humanUser.getCurrentPokemonForBattle().isPokemonDead()) {
                        humanUser.addPokemonToDeadList(humanUser.getCurrentPokemonForBattle());
                        humanUser.removePokemonFromAvailableList(humanUser.getCurrentPokemonForBattle());
                        if (humanUser.getCurrentPokemons().size() == 0) {
                            System.out.println(humanUser.getName() + "have been defeated " + " !");
                            break;
                        } else {
                            // human has to choose pokemon for next turn;
                            System.out.println(humanUser.getCurrentPokemonForBattle().getName() + " is dead.");
                            humanUser.setCurrentPokemonForBattle(null);
                            System.out.println("You have to choose new pokemon with whom to continue the game");
                            humanUser.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else {
                    pcUser.changeCurrentPokemon();
                }

                // Human user on turn
                System.out.println("It's " + humanUser.getName() + " turn!");

                System.out.println(Menu.printTurnMenu());

                int choice = humanUser.chooseOptionBeforeEachTurn(scan);
                if (choice == 1) {
                    PokemonAttack humanAttackForCurrentTurn = humanUser.chooseAttack();
                    humanAttackForCurrentTurn.attack(humanUser, pcUser);

                    // checking if pcUser's pokemon for current battle is dead
                    if (pcUser.getCurrentPokemonForBattle().isPokemonDead()) {
                        if (pcUser.getCurrentPokemons().size() == 0) {
                            System.out.println(pcUser.getName() + " has been defeated!");
                            break;
                        } else {
                            // pc have to choose pokemon for next turn;
                            System.out.println(pcUser.getCurrentPokemonForBattle().getName() + " is dead.");
                            pcUser.setCurrentPokemonForBattle(null);
                            pcUser.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else if (choice == 2) {
                    humanUser.changeCurrentPokemon();
                } else {
                    System.out.println(humanUser.getName() + " has forfeited!");
                    return;
                }
                Battle.currentTurn++;
            }
            // награди
            // съживяване
        }

    }

}