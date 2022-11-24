package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

import java.util.Random;

public class Spark extends PokemonAttack {

    public Spark() {
        this.name = "Spark";
        this.type = "electric";
        this.description = "Spark attack has equal chances to hit opponent's hp or miss the target.";
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        Random randomChance = new Random();
        int critChance = randomChance.nextInt(2); //returns 0 or 1

        int finalAttackPower = (int) (critChance * ((userPokemon.getAttackPoints() + this.attackPower) * 1.1 - enemyPokemon.getDefencePoints() * 0.3));

        if (finalAttackPower < 0) {
            finalAttackPower = (int) (0.7 * this.attackPower);
        }

        enemyPokemon.setHp((int) (enemyPokemon.getHp() - finalAttackPower));

        if (critChance == 0) {
            System.out.println(userPokemon.getName() + " missed the target!");
        } else {
            System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
            System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());
        }

        return critChance;
    }
}
