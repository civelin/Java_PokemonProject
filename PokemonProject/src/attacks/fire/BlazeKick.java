package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;
import java.util.Random;

public class BlazeKick extends PokemonAttack {

    public BlazeKick() {
        this.name = "BlazeKick";
        this.type = "fire";
        this.attackPower = (int) (1.3 * super.attackPower);
        this.description = "Blaze kick attack has a chance to burn the opponent for extra damage.";
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        Random chanceToBurnOpponentForExtraDmg = new Random();
        int chance = chanceToBurnOpponentForExtraDmg.nextInt(2); // 0 or 1

        int attackPower = getAttackPower(userPokemon, enemyPokemon, chance);

        enemyPokemon.setHp((int) (enemyPokemon.getHp() - attackPower));

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());

        return chance;
    }

    private int getAttackPower(Pokemon userPokemon, Pokemon enemyPokemon, int chance) {
        int attackPower;

        if (chance == 0) {
            attackPower = (int) ((userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.3);
        } else {
            attackPower = (int) ((userPokemon.getAttackPoints() + this.attackPower + 8) - enemyPokemon.getDefencePoints() * 0.3);
        }
        return attackPower;
    }
}