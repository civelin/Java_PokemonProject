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

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the fight
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        int finalInflictedDmg = getFinalInflictedDmg(userPokemon, enemyPokemon);

        enemyPokemon.setHp((enemyPokemon.getHp() - finalInflictedDmg));

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());

        return finalInflictedDmg;
    }

    private int getFinalInflictedDmg(Pokemon userPokemon, Pokemon enemyPokemon) {
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.3;
        double finalInflictedDmg = (userPokemon.getAttackPoints() + (this.attackPower)) - dmgReductionAccordingToEnemyPokemonDefencePoints;
        return (int) finalInflictedDmg;
    }

}