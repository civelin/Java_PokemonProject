package attacks.grass;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class CottonGuard extends PokemonAttack {

    public CottonGuard() {
        this.name = "CottonGuard";
        this.type = "grass";
        this.description = "Cotton guard attack drastically raises(with 50%) user's defense and increases enemy's defence with 15%";
    }

    // Drastically raises(with 50%) user's defense and decreases enemy's defence with 15%
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        enemyPokemon.setDefencePoints((int) (0.85 * enemyPokemon.getDefencePoints()));

        int newDefencePoints = (int) (1.5 * userPokemon.getDefencePoints());

        // check if newDefencePoints > initialDefencePoints
        if (newDefencePoints > userPokemon.returnInitialDefencePoints()) {
            userPokemon.setDefencePoints(userPokemon.returnInitialDefencePoints());
        } else {
            userPokemon.setDefencePoints(newDefencePoints);
        }

        System.out.println("\u2694 " + enemyPokemon.getName() + " now has ---> " + enemyPokemon.getDefencePoints() + " defence points.");
        System.out.println("\u2694 " + userPokemon.getName() + " now has ---> " + userPokemon.getDefencePoints() + " defence points.");


        return newDefencePoints;

    }
}