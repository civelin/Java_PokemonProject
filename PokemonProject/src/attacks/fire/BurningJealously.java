package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class BurningJealously extends PokemonAttack {

    public BurningJealously() {
        this.name = "BurningJealously";
        this.type = "fire";
        this.attackPower = (int) (0.7 * super.attackPower);
        this.description = "Burning jealously attack hits all opponent's pokemons.";
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get user pokemon that is currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyCurrentPokemon = enemyUser.getCurrentPokemonForBattle();

        int attackPower = userPokemon.getAttackPoints() + this.attackPower;

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked all the enemy pokemons!");

        for (Pokemon enemyPokemon : enemyUser.getCurrentPokemons()) {

            enemyPokemon.setHp((int) (enemyPokemon.getHp() - attackPower + 0.3 * enemyPokemon.getDefencePoints()));
            System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());
        }

        enemyCurrentPokemon.setHp((int) (enemyCurrentPokemon.getHp() - attackPower + 0.3 * enemyCurrentPokemon.getDefencePoints()));

         

        System.out.println("\u2694 " + enemyCurrentPokemon.getName() + " new hp ---> " + enemyCurrentPokemon.getHp());

        return  attackPower;
    }
}