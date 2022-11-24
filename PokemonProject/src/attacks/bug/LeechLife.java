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
    private int sumFinalInflictedDmg(Pokemon pokemon1, Pokemon pokemon2) {
        double dmgReductionAccordingToEnemyPokemonDefencePoints = pokemon2.getDefencePoints() * 0.4;
        int finalInflictedDmg = (int) (1.6*(pokemon1.getAttackPoints() + (this.attackPower)) -(int) dmgReductionAccordingToEnemyPokemonDefencePoints);
        return finalInflictedDmg;
    }

    @Override
    public int attack(User user, User enemyUser) {
        // get only those pokemons that are currently in the battle
        Pokemon userPokemon = user.getCurrentPokemonForBattle();
        Pokemon enemyPokemon = enemyUser.getCurrentPokemonForBattle();

        int finalInflictedDmg = sumFinalInflictedDmg(userPokemon , enemyPokemon);

        if (finalInflictedDmg <= 0) {
            finalInflictedDmg =  this.attackPower;
        }
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
}