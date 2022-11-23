package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class FirstImpression extends PokemonAttack {

    public FirstImpression() {
        this.name = "FirstImpression";
        this.type = "bug";
        this.description = "First Impression attack decreases enemy's hp.";
        this.attackPower = 1.4 * super.attackPower;
    }

    @Override
    public double attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the fight
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double finalInflictedDmg = (userPokemon.getAttackPoints() + (this.attackPower)) - dmgReductionAccordingToEnemyPokemonDefencePoints;

        enemyPokemon.setHp((enemyPokemon.getHp() - finalInflictedDmg));

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());

        return finalInflictedDmg;
    }

}