import Utilities.GameHelper;
import Utilities.Menu;
import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize Scanner scan
        Scanner scan = new Scanner(System.in);

        System.out.println(Menu.printLoginMenu());
        String username = GameHelper.enterUserName(scan);
        HumanUser humanUser = new HumanUser(username, PokemonFactory.getUserPokemons());

        for (int level = 1; level <= GameHelper.numberOfLevels; level++) {
            GameHelper.currentTurn = 1;

            //initialize opponent according to current level
            PCUser pcUser = GameHelper.initializePCUserAccordingToCurrentLevel(level);

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
                System.out.println("❗ It's " + pcUser.getName() + " turn!");
                int pcUserChoice = pcUser.chooseOptionBeforeEachTurn(GameHelper.currentTurn);

                // if pcUser's choice < 13 it will attack
                if (pcUserChoice < 13) {
                    // pcUser is choosing attack for the current turn
                    PokemonAttack pcAttackForCurrentTurn = pcUser.chooseAttack();
                    // pcUser attacks
                    System.out.println();
                    pcAttackForCurrentTurn.attack(pcUser, humanUser);
                    System.out.println();

                    // checking if humanUser's pokemon for current battle is dead
                    if (humanUser.getCurrentPokemonForBattle().isPokemonDead() || humanUser.getCurrentPokemons().stream().filter(Pokemon::isPokemonDead).toList().size() != 0){
                        GameHelper.doLogicAfterHumanUserPokemonIsDead(humanUser);
                        if (humanUser.getCurrentPokemons().size() == 0) {
                            System.out.println("❌" + humanUser.getName() + " has been defeated " + " !");
                            break;
                        } else {
                            // human has to choose pokemon for next turn;
                            System.out.println("❌" + humanUser.getCurrentPokemonForBattle().getName() + " is dead.");
                            humanUser.setCurrentPokemonForBattle(null);
                            System.out.println("You have to choose new pokemon with whom to continue the game");
                            humanUser.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else {
                    pcUser.changeCurrentPokemon();
                }

                // Human user on turn
                System.out.println("❗It's " + humanUser.getName() + " turn!");

                System.out.println(Menu.printTurnMenu());

                int choice = humanUser.chooseOptionBeforeEachTurn(scan);
                if (choice == 1) {
                    PokemonAttack humanAttackForCurrentTurn = humanUser.chooseAttack();
                    System.out.println();
                    humanAttackForCurrentTurn.attack(humanUser, pcUser);

                    // checking if pcUser's pokemon for current battle is dead
                    if (pcUser.getCurrentPokemonForBattle().isPokemonDead() || pcUser.getCurrentPokemons().stream().filter(p -> p.isPokemonDead()).toList().size() != 0) {
                        GameHelper.doLogicAfterPCUserPokemonIsDead(pcUser);
                        if (pcUser.getCurrentPokemons().size() == 0) {
                            System.out.println("❌" + pcUser.getName() + " has been defeated!");
                            break;
                        } else {
                            // pc have to choose pokemon for next turn;
                            System.out.println("❌" + pcUser.getCurrentPokemonForBattle().getName() + " is dead.");
                            pcUser.setCurrentPokemonForBattle(null);
                            pcUser.choosePokemonForBattleFromCurrentList();
                        }
                    }
                } else if (choice == 2) {
                    humanUser.changeCurrentPokemon();
                } else {
                    System.out.println("❌" + humanUser.getName() + " has forfeited!");
                    return;
                }
                GameHelper.currentTurn++;
            }
            // clear humanUser's current pokemon list
            humanUser.getCurrentPokemons().clear();

            // награди
            // съживяване, преди следващо ниво
        }

    }

}