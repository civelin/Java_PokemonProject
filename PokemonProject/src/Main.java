import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import validators.Validator;

import java.util.List;
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

            boolean ifHumanIsWinner = false;
            // battle starts
            while (true) {
                System.out.println("It's " + pcUser.getName() + " turn!");
                int pcUserChoice = pcUser.chooseOptionBeforeEachTurn(GameHelper.currentTurn);

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
                            ifHumanIsWinner = false;
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

                int choice = humanUser.chooseOptionBeforeEachTurn();
                if (choice == 1) {
                    PokemonAttack humanAttackForCurrentTurn = humanUser.chooseAttack();
                    humanAttackForCurrentTurn.attack(humanUser, pcUser);

                    // checking if pcUser's pokemon for current battle is dead
                    if (pcUser.getCurrentPokemonForBattle().isPokemonDead()) {
                        if (pcUser.getCurrentPokemons().size() == 0) {
                            System.out.println(pcUser.getName() + " has been defeated!");
                            ifHumanIsWinner = true;
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
                GameHelper.currentTurn++;
            }
            humanUser.getCurrentPokemons().clear();
            pcUser.getCurrentPokemons().clear();

            //if the user is winner , we have to chose pokemons as a reward, but if the user lost , the program checks if it meets the requirements to continue the game
            if (ifHumanIsWinner) {
                if (level == 3) {
                    //final text after the last opponent is defeated
                    System.out.println("Congratulations, you beat all the opponents !!! You won nothing, in case you lost VALUABLE time by playing the game. Bye bye");
                    return;
                } else {
                    //list of pokemons , from which the user will choose one as a reward of successful battle.
                    List<Pokemon> pokemonsAsReward = PokemonFactory.pokemonAsRewards();
                    while(!humanUser.choosePokemonAsReward(pokemonsAsReward)) {
                        humanUser.choosePokemonAsReward(pokemonsAsReward);
                    }
                    GameHelper.addCrystalAfterWin(humanUser);
                }
            } else {
                if (humanUser.getAvailablePokemons().size() < 2 && humanUser.getCrystals() < 2 || humanUser.getAvailablePokemons().size() <= 2 && humanUser.getCrystals() == 0) {
                    System.out.println("You have lost the game! Better luck next time!");
                    return;
                }
                if (level == 2) {
                    level = 1;
                } else if (level == 3) {
                    level = 2;
                }
            }
            for (Pokemon pokemon : humanUser.getAvailablePokemons()) {
                pokemon.resetInitialPointsOfPokemon();
            }
            for (Pokemon pokemon : pcUser.getAvailablePokemons()) {
                pokemon.resetInitialPointsOfPokemon();
            }


            //menu between the battles
            while (true) {
                Menu.printMenuAfterBattle();
                String choice = scan.next();
                while (!Validator.validateUserInputForChoice(3, choice)) {
                    choice = scan.next();
                }
                int opt = Integer.parseInt(choice);

                if (opt == 1) {
                    if (humanUser.getAvailablePokemons().size() < 3) {
                        System.out.println("You must have 3 alive pokemons before jumping into the next battle! Please revive any pokemon!");
                        continue;
                    }
                    break;
                } else if (opt == 2) {
                    humanUser.revivePokemon(); //revive pokemon
                } else if (opt == 3) {
                    return;
                }
            }


        }

    }

}