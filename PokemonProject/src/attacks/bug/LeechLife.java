package attacks.bug;

import attacks.PokemonAttack;
import pokemons.Pokemon;
import users.User;

public class LeechLife extends PokemonAttack {

    public LeechLife() {
        this.name = "LeechLife";
        this.type = "bug";
        this.description = "Leech Life attack recovers half the hp inflicted on opponent";
    }
    
    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        int finalInflictedDmg = getFinalInflictedDmg(userPokemon, enemyPokemon);

        enemyPokemon.setHp(enemyPokemon.getHp() - finalInflictedDmg);

        if (userPokemon.getHp() + finalInflictedDmg / 2 < userPokemon.returnInitialHP()) {
            userPokemon.setHp(userPokemon.getHp() + finalInflictedDmg / 2);
        } else {
            userPokemon.setHp(userPokemon.returnInitialHP());
        }

        System.out.println("\u2694 " + userPokemon.getName() + " has attacked " + enemyPokemon.getName());
        System.out.println("\u2694 " + enemyPokemon.getName() + " new hp ---> " + enemyPokemon.getHp());
        System.out.println("\u2694 " + userPokemon.getName() + " has recovered " + finalInflictedDmg / 2 + " hp! New hp ---> " + userPokemon.getHp());

        return finalInflictedDmg;
    }

    private int getFinalInflictedDmg(Pokemon userPokemon, Pokemon enemyPokemon) {
        double dmgReductionAccordingToEnemyPokemonDefencePoints = enemyPokemon.getDefencePoints() * 0.4;
        double finalInflictedDmg = 1.6 * (userPokemon.getAttackPoints() + this.attackPower) - dmgReductionAccordingToEnemyPokemonDefencePoints;
        if (finalInflictedDmg <= 0) {
            finalInflictedDmg =  this.attackPower;
        }
        return (int) finalInflictedDmg;
    }
}