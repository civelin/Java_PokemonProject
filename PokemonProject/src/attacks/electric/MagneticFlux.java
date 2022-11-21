package attacks.electric;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

import java.util.List;

public class MagneticFlux extends PokemonAttack {

    public MagneticFlux() {
        this.name = "MagneticFlux";
        this.type = "electric";
        this.description = "Magnetic Flux attack decreases opponent's hp";
    }

    @Override
    public double attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        double finalAttackPower = (userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.4;

        if (finalAttackPower < 0) {
            finalAttackPower = 1.5 * this.attackPower;
        }

        enemyPokemon.setHp(enemyPokemon.getHp() - finalAttackPower);
        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp is ---> " + enemyPokemon.getHp());
        return finalAttackPower;
    }
}
