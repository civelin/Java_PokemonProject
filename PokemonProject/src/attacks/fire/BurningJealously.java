package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;

public class BurningJealously extends PokemonAttack {

    public BurningJealously() {
        this.name = "BurningJealously";
        this.type = "fire";
        this.attackPower = 0.5 * super.attackPower;
        this.description = "Burning jealously attack hits all opponents.";
    }

    //Hits all opponents

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        System.out.println(userPokemon.getName() + " has attacked all the enemy pokemons!");
        double attackPower = userPokemon.getAttackPoints() + this.attackPower;
        for (Pokemon enemyPokemon : enemyCurrentPokemons) {
            enemyPokemon.setHp(enemyPokemon.getHp() - (attackPower - enemyPokemon.getDefencePoints()));

            System.out.println(enemyPokemon.getName() + " new hp ----> " + enemyPokemon.getHp());
        }


        return attackPower;
    }


}
