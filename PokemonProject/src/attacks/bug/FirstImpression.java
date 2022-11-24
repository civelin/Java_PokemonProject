package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class FirstImpression extends PokemonAttack {

    public FirstImpression() {
        this.name = "FirstImpression";
        this.type = "bug";
        this.description = "First Impression attack decreases enemy's hp.";
        this.attackPower = (int) (1.4 * super.attackPower);
    }

    private int sumFinalInflictedDmg(Pokemon pokemon1, Pokemon pokemon2) {
        double dmgReductionAccordingToEnemyPokemonDefencePoints = pokemon2.getDefencePoints() * 0.3;
        int finalInflictedDmg = (pokemon1.getAttackPoints() + (this.attackPower)) - (int)dmgReductionAccordingToEnemyPokemonDefencePoints;
        return  finalInflictedDmg;
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the fight
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        int finalInflictedDmg = sumFinalInflictedDmg(userPokemon, enemyPokemon);

        enemyPokemon.setHp((enemyPokemon.getHp() - finalInflictedDmg));

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());

        return finalInflictedDmg;
    }

}