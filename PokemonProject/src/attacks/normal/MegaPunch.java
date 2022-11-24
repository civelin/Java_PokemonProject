package attacks.normal;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

import java.util.List;
import java.util.Random;

public class MegaPunch extends PokemonAttack {

    public MegaPunch() {
        this.name = "MegaPunch";
        this.type = "normal";
        this.attackPower = (int) (0.5 * super.attackPower);
        this.description = "Mega punch attack deals damage to the opponent's pokemon.";
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        // High critical hit ratio
        Random rnd = new Random();
        int critChance = rnd.nextInt(2) + 1;

        int finalInflictedDmg;
        int dmgReductionAccordingToEnemyPokemonDefencePoints = (int) (enemyPokemon.getDefencePoints() * 0.3);
        int pokemonAttackPower = userPokemon.getAttackPoints();

        finalInflictedDmg = (pokemonAttackPower + ((this.attackPower * critChance)) - dmgReductionAccordingToEnemyPokemonDefencePoints);
        enemyPokemon.setHp((int) (enemyPokemon.getHp() - finalInflictedDmg));

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());
        return critChance;
    }
}
