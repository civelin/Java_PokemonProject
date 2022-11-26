package Utilities;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.User;

import java.util.List;
import java.util.Scanner;


public class GamePlay {
    // fields
    private static Scanner scanner = new Scanner(System.in);
    private final static int numberOfLevels = 3;
    private static int currentTurn;

//    public static void setScan(Scanner scan) {
//        scanner = scan;
//    }

    // methods
    public static void start(HumanUser humanUser) {

        for (int level = 1; level <= numberOfLevels; level++) {
            currentTurn = 1;
            //initialize opponent according to current level
            PCUser pcUser = GameHelper.initializePCUserAccordingToCurrentLevel(level);

            System.out.println("        \u25B6 LEVEL №" + level + " \u25C0");
            System.out.println("    You are going to face " + pcUser.getName() + "\r\n");


            // pcUser is choosing pokemons for the battle
            pcUser.choosePokemonsFromAvailableListToCurrentList(null);
            System.out.println(GameHelper.printListOfPokemons(pcUser.getCurrentPokemons()));
            System.out.println();

            // humanUser must is choosing pokemons for the battle
            System.out.println(GameHelper.printListOfPokemons(humanUser.getAvailablePokemons()));
            humanUser.choosePokemonsFromAvailableListToCurrentList(scanner);
            System.out.println();

            // pcUser is choosing one pokemon for the battle
            pcUser.choosePokemonForBattleFromCurrentList(null);
            System.out.println();

            // humanUser choose one pokemon fot the battle
            humanUser.choosePokemonForBattleFromCurrentList(scanner);
            System.out.println();

            GamePlay.play(humanUser, pcUser);

            clearUserCurrentListOfPokemons(humanUser, pcUser);

            //if the user is winner , we have to chose pokemons as a reward, but if the user lost , the program checks if it meets the requirements to continue the game
            if (!checkIfUserIsDefeated(humanUser)) {
                doLogicAfterHumanUserIsWinner(humanUser, level);
            } else {
                if (level == 1) {
                    System.exit(0);
                } else {
                    if (!isHumanUserMetRequirementsToContinueTheGame(humanUser)){
                        return;
                    }
                    level = restartLevelIfHumanUserLostBattle(level);
                }
            }

            resetInitialPointsOfPokemonAfterEachBattle(humanUser, pcUser);

            //menu between the battles
            if (userChoiceBetweenEachBattle(humanUser)) return;

        }
    }
    private static void play(HumanUser humanUser, PCUser pcUser) {
        // battle starts
        while (true) {
            System.out.println("❗ It's " + pcUser.getName() + " turn!");
            pcUserTurn(humanUser, pcUser);
            // checking if humanUser's pokemon for current battle is dead
            doLogicAfterHumanUserIsAttacked(humanUser);
            if (checkIfUserIsDefeated(humanUser)) {
                return;
            } else if (humanUser.getCurrentPokemonForBattle() == null) {
                // human has to choose pokemon for next turn
                System.out.println("You have to choose new pokemon with whom to continue the game");
                humanUser.choosePokemonForBattleFromCurrentList(scanner);
            }

            // Human user on turn
            System.out.println("❗It's " + humanUser.getName() + " turn!");
            humanUserTurn(humanUser, pcUser);
            // do logic after pcUser had been attacked and check if pcUser's pokemon for current battle is dead
            doLogicAfterPcUserIsAttacked(pcUser);
            if (checkIfUserIsDefeated(pcUser)) {
                return;
            } else if (pcUser.getCurrentPokemonForBattle() == null) {
                pcUser.choosePokemonForBattleFromCurrentList(null);
            }
            currentTurn++;
        }
    }
    private static boolean userChoiceBetweenEachBattle(HumanUser humanUser) {
        while (true) {
            Menu.printMenuAfterBattle();
            System.out.print("👉");
            int choice = humanUser.enterHumanUserChoice(3, scanner);

            if (choice == 1) {
                if (checkHumanUserAvaiablePokemonsListSize(humanUser)){
                    continue;
                }
                break;
            } else if (choice == 2) {
                humanUser.revivePokemon(scanner); //revive pokemon
            } else if (choice == 3) {
                return true;
            }
        }
        return false;
    }
    private static void pcUserTurn(HumanUser humanUser, PCUser pcUser) {

        int pcUserChoice = pcUser.chooseOptionBeforeEachTurn(currentTurn);

        // if pcUser's choice < 13 it will attack
        if (pcUserChoice < 13) {
            // pcUser is choosing attack for the current turn
            PokemonAttack pcAttackForCurrentTurn = pcUser.chooseAttack(null);
            // pcUser attacks
            System.out.println();
            pcAttackForCurrentTurn.attack(pcUser, humanUser);
            System.out.println();
        } else {
            System.out.println();
            pcUser.changeCurrentPokemon(null);
        }
    }

    private static void doLogicAfterHumanUserIsAttacked(HumanUser humanUser) {
        List<Pokemon> humanUserDeadPokemonsAtCurrentList = humanUser.getCurrentPokemons().stream().filter(Pokemon::isPokemonDead).toList();
        Pokemon humanUserCurrentPokemon = humanUser.getCurrentPokemonForBattle();

        if (humanUserDeadPokemonsAtCurrentList.size() != 0) {
            humanUserDeadPokemonsAtCurrentList.forEach(deadPokemon -> {
                System.out.println("\uD83D\uDC80" + deadPokemon.getName() + " is dead.");
                GameHelper.doLogicAfterHumanUserPokemonInCurrentListIsDead(humanUser, deadPokemon);
            });
        }

        if (humanUserCurrentPokemon.isPokemonDead()) {
            System.out.println("\uD83D\uDC80" + humanUserCurrentPokemon.getName() + " is dead.");
            humanUser.addPokemonToDeadList(humanUserCurrentPokemon);
            humanUser.removePokemonFromAvailableList(humanUserCurrentPokemon);
            humanUser.setCurrentPokemonForBattle(null);
        }

    }
    private static void humanUserTurn(HumanUser humanUser, PCUser pcUser) {
        System.out.println(Menu.printTurnMenu());

        int choice = humanUser.enterHumanUserChoice(3, scanner);
        if (choice == 1) {
            PokemonAttack humanAttackForCurrentTurn = humanUser.chooseAttack(scanner);
            System.out.println();
            humanAttackForCurrentTurn.attack(humanUser, pcUser);
            System.out.println();

        } else if (choice == 2) {
            Menu.printOptionWhenUserChoseToChangePokemonsDuringBattle();
            int choice2 =  humanUser.enterHumanUserChoice(2, scanner);
            switch (choice2){
                case 1 ->   humanUser.changeCurrentPokemon(scanner);
                case 2 ->   humanUserTurn(humanUser , pcUser);
            }

        } else if (choice == 3) {
            System.out.println("❌" + humanUser.getName() + " has forfeited!");
            System.exit(0);
            System.out.println();
        }
    }

    private static void doLogicAfterPcUserIsAttacked(PCUser pcUser) {
        List<Pokemon> pcUserDeadPokemonsAtCurrentList = pcUser.getCurrentPokemons().stream().filter(Pokemon::isPokemonDead).toList();
        Pokemon pcUserCurrentPokemon = pcUser.getCurrentPokemonForBattle();

        // check if pcUser has dead pokemons at its current list
        if (pcUserDeadPokemonsAtCurrentList.size() != 0) {
            pcUserDeadPokemonsAtCurrentList.forEach(deadPokemon -> {
                System.out.println("\uD83D\uDC80" + deadPokemon.getName() + " is dead.");
                GameHelper.doLogicAfterPCUserPokemonInCurrentListIsDead(pcUser, deadPokemon);
            });
        }

        if (pcUserCurrentPokemon.isPokemonDead()) {
            System.out.println("\uD83D\uDC80" + pcUserCurrentPokemon.getName() + " is dead.");
            pcUser.setCurrentPokemonForBattle(null);
        }
    }
    private static boolean checkHumanUserAvaiablePokemonsListSize(HumanUser humanUser) {
        if (humanUser.getAvailablePokemons().size() < 3) {
            System.out.println("You must have 3 alive pokemons before jumping into the next battle! Please revive any pokemon!");
            return true;
        }
        return false;
    }

    private static void resetInitialPointsOfPokemonAfterEachBattle(HumanUser humanUser, PCUser pcUser) {
        for (Pokemon pokemon : humanUser.getAvailablePokemons()) {
            pokemon.resetInitialPointsOfPokemon();
        }
        for (Pokemon pokemon : pcUser.getAvailablePokemons()) {
            pokemon.resetInitialPointsOfPokemon();
        }
    }

    private static int restartLevelIfHumanUserLostBattle(int level) {
        if (level == 2) {
            level = 1;
        } else if (level == 3) {
            level = 2;
        }
        return level;
    }

    private static boolean isHumanUserMetRequirementsToContinueTheGame(HumanUser humanUser) {
        if (humanUser.getAvailablePokemons().size() < 2 && humanUser.getCrystals() < 2 || humanUser.getAvailablePokemons().size() <= 2 && humanUser.getCrystals() == 0) {
            System.out.println("You have lost the game! Better luck next time!");
            return false;
        }
        return true;
    }

    private static void doLogicAfterHumanUserIsWinner(HumanUser humanUser, int level) {
        if (level == 3) {
            //final text after the last opponent is defeated
            System.out.println("\uD83C\uDF87" +  " Congratulations, you beat all the opponents!!!\nYou won nothing, in fact you lost VALUABLE time by playing the game. Bye bye");
            System.exit(0);
        } else {
            //list of pokemons , from which the user will choose one as a reward of successful battle.
            humanUser.choosePokemonAsReward(PokemonFactory.getPokemonRewards(), scanner);
            System.out.println();
            GameHelper.addCrystalAfterWin(humanUser);
        }
    }

    private static void clearUserCurrentListOfPokemons(HumanUser humanUser, PCUser pcUser) {
        humanUser.getCurrentPokemons().clear();
        pcUser.getCurrentPokemons().clear();
    }

    private static boolean checkIfUserIsDefeated(User user) {
        return user.getCurrentPokemonForBattle() == null && user.getCurrentPokemons().size() == 0;
    }





}
