import Utilities.GameHelper;
import Utilities.GamePlay;
import attacks.fire.BurningJealously;
import pokemons.pokemonFactory.PokemonFactory;
import users.HumanUser;
import users.PCUser;
import users.userFactory.PCUserFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("\uD83D\uDC4B" + " Welcome to our pokemon game!!! In order to play the game , please first create account\n");
        HumanUser humanUser = GameHelper.initializeHumanUser();
        GamePlay.play(humanUser);

    }
}