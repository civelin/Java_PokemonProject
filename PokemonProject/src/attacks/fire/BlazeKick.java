package attacks.fire;

import attacks.PokemonAttack;
import pokemons.Pokemon;

import java.util.List;
import java.util.Random;

public class BlazeKick extends PokemonAttack {

    public BlazeKick() {
        this.name = "BlazeKick";
        this.type = "fire";
        this.attackPower = 1.1 * super.attackPower;
        this.description = "Blaze kick attack has a chance to burn the opponent for additional extra damage.";
    }

    public double attack(List<Pokemon> userCurrentPokemons, List<Pokemon> enemyCurrentPokemons) {
        Pokemon userPokemon = (Pokemon) userCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];
        Pokemon enemyPokemon = (Pokemon) enemyCurrentPokemons.stream().filter(Pokemon::isPokemonFighting).toArray()[0];

        Random chanceToBurnOpponentForExtraDmg = new Random();
        double attackPower;
        int chance = chanceToBurnOpponentForExtraDmg.nextInt(2);

        if (chance == 0) {
            attackPower = (userPokemon.getAttackPoints() + this.attackPower) - enemyPokemon.getDefencePoints() * 0.3;

        } else {
            attackPower = (userPokemon.getAttackPoints() + this.attackPower + 7) - enemyPokemon.getDefencePoints() * 0.3;

        }
        enemyPokemon.setHp(enemyPokemon.getHp() - attackPower);

        System.out.println(userPokemon.getName()+" has attacked "+enemyPokemon.getName());
        System.out.println(enemyPokemon.getName()+" new hp ----> "+enemyPokemon.getHp());
        return attackPower;
    }
}
