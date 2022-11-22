package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

import java.util.List;

public class BurningJealously extends PokemonAttack {

    public BurningJealously() {
        this.name = "BurningJealously";
        this.type = "fire";
        this.attackPower = 0.8 * super.attackPower;
        this.description = "Burning jealously attack hits all opponent's pokemons.";
    }

    @Override
    public double attack(User user, User enemyUser) {
        Pokemon userPokemon = user.getCurrentPokemonForBattle();

        System.out.println(userPokemon.getName() + " has attacked all the enemy pokemons!");

        double attackPower = userPokemon.getAttackPoints() + this.attackPower;

        for (Pokemon enemyPokemon : enemyUser.getCurrentPokemons()) {
            enemyPokemon.setHp(enemyPokemon.getHp() - attackPower + 0.3 * enemyPokemon.getDefencePoints());
            System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());
        }

        enemyUser.getCurrentPokemonForBattle().setHp(enemyUser.getCurrentPokemonForBattle().getHp() - attackPower + 0.3 * enemyUser.getCurrentPokemonForBattle().getDefencePoints());
        System.out.println("\u2694 " + enemyUser.getCurrentPokemonForBattle().getName() + " new hp ---> " + enemyUser.getCurrentPokemonForBattle().getHp());
        return attackPower;
    }
}
