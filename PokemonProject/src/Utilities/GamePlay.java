package Utilities;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;

import java.util.Scanner;


public class GamePlay {
    private static Scanner scan = new Scanner(System.in);
    private final static int numberOfLevels = 3;

    private static int currentTurn;

    public static void play(HumanUser humanUser) {

        for (int level = 1; level <= numberOfLevels; level++) {
            currentTurn = 1;

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

            Boolean ifHumanIsWinner = getWinner(humanUser, pcUser);

            if (ifHumanIsWinner == null) return;

            resetUserCurrentListOfPokemons(humanUser, pcUser);

            //if the user is winner , we have to chose pokemons as a reward, but if the user lost , the program checks if it meets the requirements to continue the game
            if (ifHumanIsWinner) {
                if (checkIfHumanIsWinnerOnLevel3(humanUser, level)) return;
            } else {
                if (ifHumanUserMeetRequirementsToContinueTheGame(humanUser)) return;
                level = restartLevelIfHumanUserLostBattle(level);
            }
            resetInitialPointsOfPokemonAfterEachBattle(humanUser, pcUser);


            //menu between the battles
            if (userChoiceBetweenEachBattle(humanUser)) return;

        }
    }

    private static boolean userChoiceBetweenEachBattle(HumanUser humanUser) {
        while (true) {
            Menu.printMenuAfterBattle();
            int choice = humanUser.enterHumanUserChoice(3, scan);


            if (choice == 1) {
                if (checkHumanUserAvaiablePokemonsListSize(humanUser)) continue;
                break;
            } else if (choice == 2) {
                humanUser.revivePokemon(); //revive pokemon
            } else if (choice == 3) {
                return true;
            }
        }
        return false;
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

    private static boolean ifHumanUserMeetRequirementsToContinueTheGame(HumanUser humanUser) {
        if (humanUser.getAvailablePokemons().size() < 2 && humanUser.getCrystals() < 2 || humanUser.getAvailablePokemons().size() <= 2 && humanUser.getCrystals() == 0) {
            System.out.println("You have lost the game! Better luck next time!");
            return true;
        }
        return false;
    }

    private static boolean checkIfHumanIsWinnerOnLevel3(HumanUser humanUser, int level) {
        if (level == 3) {
            //final text after the last opponent is defeated
            System.out.println("Congratulations, you beat all the opponents !!! You won nothing, in case you lost VALUABLE time by playing the game. Bye bye");
            return true;
        } else {
            //list of pokemons , from which the user will choose one as a reward of successful battle.
            humanUser.choosePokemonAsReward(PokemonFactory.getPokemonRewards());
            GameHelper.addCrystalAfterWin(humanUser);
        }
        return false;
    }

    private static void resetUserCurrentListOfPokemons(HumanUser humanUser, PCUser pcUser) {
        humanUser.getCurrentPokemons().clear();
        pcUser.getCurrentPokemons().clear();
    }

    private static Boolean getWinner(HumanUser humanUser, PCUser pcUser) {
        boolean ifHumanIsWinner = false;
        // battle starts
        while (true) {
            System.out.println("❗ It's " + pcUser.getName() + " turn!");

            if (!pcUserTurn(humanUser, pcUser)) {
                break;
            }

            // Human user on turn
            if (humanUserTurn(humanUser, pcUser)) {
                ifHumanIsWinner = true;
                break;
            }
            currentTurn++;
        }
        return ifHumanIsWinner;
    }

    private static boolean humanUserTurn(HumanUser humanUser, PCUser pcUser) {
        System.out.println("❗It's " + humanUser.getName() + " turn!");

        System.out.println(Menu.printTurnMenu());

        int choice = humanUser.chooseOptionBeforeEachTurn();
        if (choice == 1) {
            PokemonAttack humanAttackForCurrentTurn = humanUser.chooseAttack();
            System.out.println();
            humanAttackForCurrentTurn.attack(humanUser, pcUser);

            // checking if pcUser's pokemon for current battle is dead
            if (checkIfPcUserIsDefeated(pcUser)) return true;
        } else if (choice == 2) {
            humanUser.changeCurrentPokemon();
        } else if (choice == 3) {
            System.out.println("❌" + humanUser.getName() + " has forfeited!");
            System.exit(0);
        }
        return false;
    }

    private static boolean checkIfPcUserIsDefeated(PCUser pcUser) {


        if (pcUser.getCurrentPokemons().stream().filter(p -> p.isPokemonDead()).toList().size() != 0) {
            pcUser.getCurrentPokemons().stream().filter(p ->
                    p.isPokemonDead()).toList().forEach(deadPokemon ->
                    System.out.println("❌" + deadPokemon.getName() + " is dead."));
            GameHelper.doLogicAfterPCUserPokemonInCurrentListIsDead(pcUser);
        }

        if (pcUser.getCurrentPokemonForBattle().isPokemonDead() && pcUser.getCurrentPokemons().size() > 0) {
            // pc have to choose pokemon for next turn;
            System.out.println("❌" + pcUser.getCurrentPokemonForBattle().getName() + " is dead.");
            pcUser.setCurrentPokemonForBattle(null);
            pcUser.choosePokemonForBattleFromCurrentList();
        }

        if (pcUser.getCurrentPokemons().size() == 0 && pcUser.getCurrentPokemonForBattle().isPokemonDead()) {
            System.out.println("❌" + pcUser.getName() + " has been defeated!");
            return true;

        }

        return false;
    }

    private static boolean pcUserTurn(HumanUser humanUser, PCUser pcUser) {

        int pcUserChoice = pcUser.chooseOptionBeforeEachTurn(currentTurn);

        // if pcUser's choice < 13 it will attack
        if (pcUserChoice < 13) {
            // pcUser is choosing attack for the current turn
            PokemonAttack pcAttackForCurrentTurn = pcUser.chooseAttack();
            // pcUser attacks
            System.out.println();
            pcAttackForCurrentTurn.attack(pcUser, humanUser);
            System.out.println();

            // checking if humanUser's pokemon for current battle is dead
            if (checkIfHumanUserDefeat(humanUser)) {
                return false;
            }
        } else {
            pcUser.changeCurrentPokemon();
            System.out.println();
        }
        return true;
    }

    private static boolean checkIfHumanUserDefeat(HumanUser humanUser) {
        if (humanUser.getCurrentPokemons().stream().filter(p -> p.isPokemonDead()).toList().size() != 0) {
            humanUser.getCurrentPokemons().stream().filter(p ->
                    p.isPokemonDead()).toList().forEach(deadPokemon ->
                    System.out.println("❌" + deadPokemon.getName() + " is dead."));
            GameHelper.doLogicAfterHumanUserPokemonIsDead(humanUser);
        }

        if (humanUser.getCurrentPokemonForBattle().isPokemonDead() && humanUser.getCurrentPokemons().size() > 0) {
            // pc have to choose pokemon for next turn;
            System.out.println("❌" + humanUser.getCurrentPokemonForBattle().getName() + " is dead.");
            humanUser.setCurrentPokemonForBattle(null);
            humanUser.choosePokemonForBattleFromCurrentList();
        }

        if (humanUser.getCurrentPokemons().size() == 0 && humanUser.getCurrentPokemonForBattle().isPokemonDead()) {
            System.out.println("❌" + humanUser.getName() + " has been defeated!");
            return true;

        }

        return false;
    }
}
