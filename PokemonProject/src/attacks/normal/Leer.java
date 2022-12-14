package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

import java.util.List;

public class Leer extends PokemonAttack {
    public Leer() {
        this.name = "Leer";
        this.type = "normal";
        this.description = "Leer attack lowers the defence of your opponent's pokemon.";
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        int lowerEnemyPokemonDefence = 15;

        if (enemyPokemon.getDefencePoints() - lowerEnemyPokemonDefence >= 0) {
            enemyPokemon.setDefencePoints((int) (enemyPokemon.getDefencePoints() - lowerEnemyPokemonDefence));
        } else {
            enemyPokemon.setDefencePoints(0);
        }

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " now has ---> " + enemyPokemon.getDefencePoints() + " defence points.");

        return enemyPokemon.getDefencePoints();
    }

}
